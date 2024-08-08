package com.librarymanager.BorrowingService.commands.apis.saga;

import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import com.librarymanager.BorrowingService.commands.apis.commands.DeleteBorrowingCommand;
import com.librarymanager.BorrowingService.commands.apis.events.CreateBorrowingEvent;
import com.librarymanager.BorrowingService.commands.apis.models.Borrowing;
import com.librarymanager.BorrowingService.exceptions.BookBorrowedException;
import com.librarymanager.BorrowingService.exceptions.EmployeeDisciplinedException;
import com.librarymanager.CommunicationStructure.commands.commands.UpdateBookCommand;
import com.librarymanager.CommunicationStructure.queries.queries.GetBookByIdQuery;
import com.librarymanager.CommunicationStructure.queries.queries.GetEmployeeByIdQuery;
import com.librarymanager.CommunicationStructure.queries.responses.BookResponse;
import com.librarymanager.CommunicationStructure.queries.responses.EmployeeResponse;

@Saga
public class BorrowingSaga {
    @Autowired
    private transient CommandGateway commandGateway;
    @Autowired
    private transient QueryGateway queryGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "aggregateIdentifier")
    private void handle(CreateBorrowingEvent event) {
        Borrowing borrowing = event.getBorrowing();
        CompletableFuture<BookResponse> getBook = queryGateway
                .query(new GetBookByIdQuery(borrowing.getBookId()), BookResponse.class);
        CompletableFuture<EmployeeResponse> getEmployee = queryGateway
                .query(new GetEmployeeByIdQuery(borrowing.getEmployeeId()), EmployeeResponse.class);
        CompletableFuture<Void> combinedGetBookAndGetEmployee = CompletableFuture.allOf(getBook, getEmployee);
        
        combinedGetBookAndGetEmployee.thenAccept(v -> {
            try {
                BookResponse bookResponse = getBook.get();
                EmployeeResponse employeeResponse = getEmployee.get();

                handleBorrowBook(bookResponse, employeeResponse);
            } catch (Exception e) {
                rollbackBorrowBook(borrowing.getId());
            }
        })
        .exceptionally(ex -> {
            ex.printStackTrace();
            rollbackBorrowBook(borrowing.getId());
            return null;
        });
    }

    private void rollbackBorrowBook(String id) {
        commandGateway.sendAndWait(new DeleteBorrowingCommand(id));
    }

    private void handleBorrowBook(BookResponse bookResponse,
            EmployeeResponse employeeResponse) throws EmployeeDisciplinedException, BookBorrowedException {
        if (employeeResponse.getIsDisciplined()) {
            throw new EmployeeDisciplinedException();
        }
        if (!bookResponse.getIsReady()) {
            throw new BookBorrowedException();
        }
        bookResponse.setIsReady(false);
        commandGateway.sendAndWait(new UpdateBookCommand(bookResponse));
    }
}
