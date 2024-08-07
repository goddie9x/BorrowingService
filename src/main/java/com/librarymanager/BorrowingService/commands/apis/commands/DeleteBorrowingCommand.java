package com.librarymanager.BorrowingService.commands.apis.commands;

import com.librarymanager.BorrowingService.commands.apis.events.DeleteBorrowingEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteBorrowingCommand extends CommandAbstract{
    private String borrowingId;

    public DeleteBorrowingCommand(String borrowingId){
        super();
        this.borrowingId = borrowingId;
    }

    @Override
    public DeleteBorrowingEvent genEvent() {
        return new DeleteBorrowingEvent(aggregateIdentifier, borrowingId);
    }

}
