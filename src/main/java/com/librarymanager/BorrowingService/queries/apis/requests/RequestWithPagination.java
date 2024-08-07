package com.librarymanager.BorrowingService.queries.apis.requests;

import com.librarymanager.BorrowingService.queries.apis.queries.GetAllBorrowingWithPaginationQuery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestWithPagination {
    private int page = 0;
    private int size = 10;

    public GetAllBorrowingWithPaginationQuery genQuery() {
        return new GetAllBorrowingWithPaginationQuery(page, size);
    }
}
