package com.tcs.edureka.lmsapi.repository;

import com.tcs.edureka.lmsapi.models.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {
}
