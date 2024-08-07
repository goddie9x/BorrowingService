package com.librarymanager.BorrowingService.commands.apis.eventhandlers;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.librarymanager.BorrowingService.commands.apis.data.BorrowingRepository;
import com.librarymanager.BorrowingService.commands.apis.events.UpdateBorrowingEvent;
import com.librarymanager.BorrowingService.commands.apis.models.Borrowing;

@Component
public class UpdateBorrowingEventHandler {
    @Autowired
    private BorrowingRepository borrowingRepository;

    @EventHandler
    private void on(UpdateBorrowingEvent borrowingEvent) {
        Borrowing borrowingUpdateData = borrowingEvent.getBorrowing();
        Borrowing borrowingTarget = borrowingRepository.findById(borrowingUpdateData.getBookId()).orElseThrow();

        borrowingTarget.copyAttributesIfValid(borrowingUpdateData);
        borrowingRepository.save(borrowingTarget);
    }
}
