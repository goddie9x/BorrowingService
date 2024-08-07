package com.librarymanager.BorrowingService.queries.apis.projections;

import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.librarymanager.BorrowingService.commands.apis.data.BorrowingRepository;
import com.librarymanager.BorrowingService.commands.apis.models.Borrowing;
import com.librarymanager.BorrowingService.queries.apis.queries.GetAllBorrowingWithPaginationQuery;
import com.librarymanager.BorrowingService.queries.apis.queries.GetBorrowingByIdQuery;

@Component
public class BorrowingProjection {
    @Autowired
    private BorrowingRepository borrowingRepository;

    @QueryHandler
    public Borrowing handle(GetBorrowingByIdQuery query) {
        Borrowing result = borrowingRepository.findById(query.getId()).orElse(null);

        return result;
    }

    @QueryHandler
    public List<Borrowing> handle(GetAllBorrowingWithPaginationQuery query) {
        List<Borrowing> result = borrowingRepository.findAll(query.toPageable()).toList();

        return result;
    }
}
