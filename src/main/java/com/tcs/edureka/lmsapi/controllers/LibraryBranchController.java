package com.tcs.edureka.lmsapi.controllers;

import com.tcs.edureka.lmsapi.models.LibraryBranch;
import com.tcs.edureka.lmsapi.services.LibraryBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library-branches")
public class LibraryBranchController {
    private final LibraryBranchService libraryBranchService;
    @Autowired
    public LibraryBranchController(LibraryBranchService libraryBranchService){
        this.libraryBranchService = libraryBranchService;
    }
    @GetMapping
    public List<LibraryBranch> getAllLibraryBranches(){
        return libraryBranchService.getAllLibraryBranches();
    }
    @GetMapping("/{id}")
    public LibraryBranch getLibraryBranchById(@PathVariable int id){
        return libraryBranchService.getLibraryBranchById(id);
    }
    @PostMapping
    public LibraryBranch addLibraryBranch(@RequestBody LibraryBranch libraryBranch){
        return  libraryBranchService.addLibraryBranch(libraryBranch);
    }

    @PutMapping("/{id}")
    public LibraryBranch updateLibraryBranch(@PathVariable int id, @RequestBody LibraryBranch libraryBranch){
        return libraryBranchService.updateLibraryBranch(id, libraryBranch);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        libraryBranchService.deleteLibraryBranch(id);
    }
}
