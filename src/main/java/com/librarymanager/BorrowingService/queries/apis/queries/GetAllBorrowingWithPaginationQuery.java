package com.librarymanager.BorrowingService.queries.apis.queries;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetAllBorrowingWithPaginationQuery {
    private int page;
    private int size;

    public Pageable toPageable(){
        return PageRequest.of(page, size);
    }
}
