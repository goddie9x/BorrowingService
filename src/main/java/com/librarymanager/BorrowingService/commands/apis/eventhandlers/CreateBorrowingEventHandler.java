package com.librarymanager.BorrowingService.commands.apis.eventhandlers;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.librarymanager.BorrowingService.commands.apis.data.BorrowingRepository;
import com.librarymanager.BorrowingService.commands.apis.events.CreateBorrowingEvent;
import com.librarymanager.BorrowingService.commands.apis.models.Borrowing;

@Component
public class CreateBorrowingEventHandler {
    @Autowired
    private BorrowingRepository borrowingRepository;

    @EventHandler
    public void on(CreateBorrowingEvent event) {
        Borrowing target = event.getBorrowing();

        target.setId(event.getAggregateIdentifier());
        borrowingRepository.save(target);
    }
}
