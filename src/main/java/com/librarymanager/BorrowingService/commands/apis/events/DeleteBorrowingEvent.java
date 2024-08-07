package com.librarymanager.BorrowingService.commands.apis.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DeleteBorrowingEvent implements IEvent{
    private String aggregateIdentifier;
    private String borrowingId;
}
