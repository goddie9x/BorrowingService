package com.librarymanager.BorrowingService.commands.apis.commands;

import lombok.Getter;
import lombok.Setter;

import com.librarymanager.BorrowingService.commands.apis.events.UpdateBorrowingEvent;
import com.librarymanager.BorrowingService.commands.apis.models.Borrowing;
import com.librarymanager.CommunicationStructure.commands.commands.CommandAbstract;

@Getter
@Setter
public class UpdateBorrowingCommand extends CommandAbstract {
    private Borrowing borrowing;

    public UpdateBorrowingCommand(Borrowing borrowing) {
        super();
        this.borrowing = borrowing;
    }

    @Override
    public UpdateBorrowingEvent genEvent() {
        return new UpdateBorrowingEvent(aggregateIdentifier, borrowing);
    }
}
