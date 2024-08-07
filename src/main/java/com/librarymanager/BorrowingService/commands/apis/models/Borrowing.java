package com.librarymanager.BorrowingService.commands.apis.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.librarymanager.BorrowingService.commands.apis.commands.CreateBorrowingCommand;
import com.librarymanager.BorrowingService.commands.apis.commands.UpdateBorrowingCommand;

@Entity
@Table(name = "Borrowings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrowing {
    @Id
    private String id;
    private String bookId;
    private String employeeId;
    private Date borrowingDate;
    private Date returnDate;

    public CreateBorrowingCommand genCreateBorrowingCommand() {
        return new CreateBorrowingCommand(this);
    }

    public UpdateBorrowingCommand genUpdateBorrowingCommand() {
        return new UpdateBorrowingCommand(this);
    }

    public void copyAttributesIfValid(Borrowing borrowing) {
        if (borrowing.getBookId() != null) {
            this.bookId = borrowing.getBookId();
        }
        if (borrowing.getEmployeeId() != null) {
            this.employeeId = borrowing.getEmployeeId();
        }
        if (borrowing.getBorrowingDate() != null) {
            this.borrowingDate = borrowing.getBorrowingDate();
        }
        if (borrowing.getReturnDate() != null) {
            this.returnDate = borrowing.getReturnDate();
        }
    }
}
