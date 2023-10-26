package com.tcs.edureka.lmsapi.repository;

import com.tcs.edureka.lmsapi.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
