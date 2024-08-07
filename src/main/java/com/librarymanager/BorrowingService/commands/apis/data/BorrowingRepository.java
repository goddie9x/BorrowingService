package com.librarymanager.BorrowingService.commands.apis.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymanager.BorrowingService.commands.apis.models.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing,String>{

}
