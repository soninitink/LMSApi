package com.tcs.edureka.lmsapi.repository;

import com.tcs.edureka.lmsapi.models.Book;
import com.tcs.edureka.lmsapi.models.LibraryBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LibraryBookRepository extends JpaRepository<LibraryBook, Integer> {
    List<Book> findAllBooksByLibraryBranch(int libraryBranchId);
}
