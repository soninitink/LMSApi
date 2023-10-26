package com.tcs.edureka.lmsapi.repository;

import com.tcs.edureka.lmsapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
