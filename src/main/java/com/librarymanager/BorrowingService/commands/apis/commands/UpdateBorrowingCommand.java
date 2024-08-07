package com.librarymanager.BorrowingService.commands.apis.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import com.librarymanager.BorrowingService.commands.apis.events.IEvent;
import com.librarymanager.BorrowingService.commands.apis.events.UpdateBorrowingEvent;
import com.librarymanager.BorrowingService.commands.apis.models.Borrowing;

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
