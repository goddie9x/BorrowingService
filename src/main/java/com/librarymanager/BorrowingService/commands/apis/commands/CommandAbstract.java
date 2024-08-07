package com.librarymanager.BorrowingService.commands.apis.commands;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CommandAbstract implements ICommand {
    @TargetAggregateIdentifier
    protected String aggregateIdentifier;

    public CommandAbstract() {
        aggregateIdentifier = UUID.randomUUID().toString();
    }
}
