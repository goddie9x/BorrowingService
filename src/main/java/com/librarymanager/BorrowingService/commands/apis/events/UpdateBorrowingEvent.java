package com.librarymanager.BorrowingService.commands.apis.events;

import com.librarymanager.BorrowingService.commands.apis.models.Borrowing;
import com.librarymanager.CommunicationStructure.commands.events.IEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateBorrowingEvent implements IEvent{
    private String aggregateIdentifier;
    private Borrowing borrowing;
}
