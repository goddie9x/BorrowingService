package com.librarymanager.BorrowingService.commands.apis.commands;

import com.librarymanager.BorrowingService.commands.apis.events.IEvent;

public interface ICommand {
    public String getAggregateIdentifier();
    public IEvent genEvent();
}
