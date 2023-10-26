package com.tcs.edureka.lmsapi.repository;

import com.tcs.edureka.lmsapi.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
