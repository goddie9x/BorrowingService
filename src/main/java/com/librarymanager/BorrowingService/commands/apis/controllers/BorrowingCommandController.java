package com.librarymanager.BorrowingService.commands.apis.controllers;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.librarymanager.BorrowingService.commands.apis.commands.DeleteBorrowingCommand;
import com.librarymanager.BorrowingService.commands.apis.models.Borrowing;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/v1/borrowings")
public class BorrowingCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("add")
    public String addBorrowing(@RequestBody Borrowing entity) {
        commandGateway.sendAndWait(entity.genCreateBorrowingCommand());

        return "Created request borrowing book, please wait for minutes";
    }
    @PutMapping("update")
    public String updateBorrowing(@RequestBody Borrowing entity) {
        commandGateway.sendAndWait(entity.genUpdateBorrowingCommand());
        
        return "Updated";
    }
    @DeleteMapping("/{id}")
    public String deteteBorrowing(@PathVariable String id){
        commandGateway.sendAndWait(new DeleteBorrowingCommand(id));

        return "Deleted";
    }   
}
