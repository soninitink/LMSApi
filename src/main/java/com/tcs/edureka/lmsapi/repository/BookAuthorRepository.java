package com.tcs.edureka.lmsapi.repository;

import com.tcs.edureka.lmsapi.models.Book;
import com.tcs.edureka.lmsapi.models.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {

    List<Book> findAllBooksByAuthorId(int authorId);
}
