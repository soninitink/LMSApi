package com.tcs.edureka.lmsapi.services;

import com.tcs.edureka.lmsapi.models.LibraryBranch;
import com.tcs.edureka.lmsapi.repository.LibraryBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryBranchService {
    private final LibraryBranchRepository libraryBranchRepository;
    @Autowired
    public LibraryBranchService(LibraryBranchRepository libraryBranchRepository){
        this.libraryBranchRepository = libraryBranchRepository;
    }
    public List<LibraryBranch> getAllLibraryBranches() {
        return libraryBranchRepository.findAll();
    }

    public LibraryBranch getLibraryBranchById(int id) {
        return libraryBranchRepository.findById(id).orElse(null);
    }

    public LibraryBranch addLibraryBranch(LibraryBranch LibraryBranch) {
        return libraryBranchRepository.save(LibraryBranch);
    }

    public LibraryBranch updateLibraryBranch(int id, LibraryBranch updatedLibraryBranch) {
        LibraryBranch existingLibraryBranch = libraryBranchRepository.findById(id).orElse(null);

        if (existingLibraryBranch != null) {
            existingLibraryBranch.setLibraryName(updatedLibraryBranch.getLibraryName());
            existingLibraryBranch.setAddress(updatedLibraryBranch.getAddress());
            existingLibraryBranch.setEmail(updatedLibraryBranch.getEmail());
            existingLibraryBranch.setPhoneNumber(updatedLibraryBranch.getPhoneNumber());
            return libraryBranchRepository.save(existingLibraryBranch);
        }
        return null;
    }

    public void deleteLibraryBranch(int id) {
        libraryBranchRepository.deleteById(id);
    }
}
