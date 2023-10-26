package com.tcs.edureka.lmsapi.repository;

import com.tcs.edureka.lmsapi.models.Book;
import com.tcs.edureka.lmsapi.models.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookGenreRepository extends JpaRepository<BookGenre, Integer> {
    List<Book> findBooksByGenreId(int genreId);
}
