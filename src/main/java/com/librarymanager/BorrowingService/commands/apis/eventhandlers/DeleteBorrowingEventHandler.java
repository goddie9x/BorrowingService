package com.librarymanager.BorrowingService.commands.apis.eventhandlers;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.librarymanager.BorrowingService.commands.apis.data.BorrowingRepository;
import com.librarymanager.BorrowingService.commands.apis.events.DeleteBorrowingEvent;
import com.librarymanager.BorrowingService.commands.apis.models.Borrowing;

@Component
public class DeleteBorrowingEventHandler {
    @Autowired
    private BorrowingRepository borrowingRepository;

    @EventHandler
    public void on(DeleteBorrowingEvent event){
        Borrowing target = borrowingRepository.findById(event.getBorrowingId()).orElseThrow();

        borrowingRepository.delete(target);
    }
}
