package com.librarymanager.BorrowingService.commands.apis.commands;

import com.librarymanager.BorrowingService.commands.apis.events.CreateBorrowingEvent;
import com.librarymanager.BorrowingService.commands.apis.models.Borrowing;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBorrowingCommand extends CommandAbstract {
    private Borrowing borrowing;

    public CreateBorrowingCommand(Borrowing borrowing){
        super();
        this.borrowing = borrowing;
    }
    @Override
    public CreateBorrowingEvent genEvent() {
        return new CreateBorrowingEvent(aggregateIdentifier, borrowing);
    }

}
