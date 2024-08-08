package com.librarymanager.BorrowingService.commands.apis.aggregates;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;

import com.librarymanager.CommunicationStructure.commands.commands.ICommand;
import com.librarymanager.CommunicationStructure.commands.events.IEvent;


public abstract class AggregateAbstract {
    @AggregateIdentifier
    private String aggregateIdentifier;

    @EventSourcingHandler
    public void on(IEvent event) {
        this.aggregateIdentifier = event.getAggregateIdentifier();
    }

    protected void applyEventToAggregateLifecycleFromCommand(ICommand command) {
        AggregateLifecycle.apply(command.genEvent());
    }
}
