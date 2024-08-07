package com.librarymanager.BorrowingService.queries.apis.controllers;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.librarymanager.BorrowingService.commands.apis.models.Borrowing;
import com.librarymanager.BorrowingService.queries.apis.queries.GetBorrowingByIdQuery;
import com.librarymanager.BorrowingService.queries.apis.requests.RequestWithPagination;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/v1/borrowings")
public class BorrowingQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping()
    List<Borrowing> getAllBorrowingWithPagination(RequestWithPagination request) {
        List<Borrowing> result = queryGateway.query(request.genQuery(),
                ResponseTypes.multipleInstancesOf(Borrowing.class)).join();

        return result;
    }

    @GetMapping("{id}")
    public Borrowing getMethodName(@PathVariable String id) {
        Borrowing result = queryGateway.query(new GetBorrowingByIdQuery(id), Borrowing.class).join();

        return result;
    }
}
