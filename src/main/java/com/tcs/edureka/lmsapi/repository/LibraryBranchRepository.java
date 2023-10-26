package com.tcs.edureka.lmsapi.repository;

import com.tcs.edureka.lmsapi.models.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryBranchRepository extends JpaRepository<LibraryBranch, Integer> {
}
