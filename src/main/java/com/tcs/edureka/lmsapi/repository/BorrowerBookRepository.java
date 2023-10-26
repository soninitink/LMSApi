package com.tcs.edureka.lmsapi.repository;

import com.tcs.edureka.lmsapi.models.Book;
import com.tcs.edureka.lmsapi.models.BorrowerBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface BorrowerBookRepository extends JpaRepository<BorrowerBook, Integer> {
    List<Book> findAllBooksByBorrower(int borrowerId);
}
