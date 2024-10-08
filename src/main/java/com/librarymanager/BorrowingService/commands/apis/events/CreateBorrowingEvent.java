package com.librarymanager.BorrowingService.commands.apis.events;

import com.librarymanager.BorrowingService.commands.apis.models.Borrowing;
import com.librarymanager.CommunicationStructure.commands.events.IEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateBorrowingEvent implements IEvent{
    private String aggregateIdentifier;
    private Borrowing borrowing;
}
