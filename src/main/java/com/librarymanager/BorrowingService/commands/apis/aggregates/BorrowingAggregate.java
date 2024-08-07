package com.librarymanager.BorrowingService.commands.apis.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.librarymanager.BorrowingService.commands.apis.commands.CreateBorrowingCommand;
import com.librarymanager.BorrowingService.commands.apis.commands.DeleteBorrowingCommand;
import com.librarymanager.BorrowingService.commands.apis.commands.UpdateBorrowingCommand;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class BorrowingAggregate extends AggregateAbstract{
    @CommandHandler
    public BorrowingAggregate(CreateBorrowingCommand createBorrowingCommand){
        applyEventToAggregateLifecycleFromCommand(createBorrowingCommand);
    }
    @CommandHandler
    public BorrowingAggregate(UpdateBorrowingCommand updateBorrowingCommand){
        applyEventToAggregateLifecycleFromCommand(updateBorrowingCommand);
    }   
    @CommandHandler
    public BorrowingAggregate(DeleteBorrowingCommand deleteBorrowingCommand){
        applyEventToAggregateLifecycleFromCommand(deleteBorrowingCommand);
    }
}
