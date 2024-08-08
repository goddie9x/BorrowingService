package com.librarymanager.BorrowingService.exceptions;

public class BookBorrowedException extends Exception {
    public BookBorrowedException() {
        super("The book already borrowed");
    }
}
