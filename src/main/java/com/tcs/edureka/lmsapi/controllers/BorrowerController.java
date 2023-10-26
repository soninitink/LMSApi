package com.tcs.edureka.lmsapi.controllers;

import com.tcs.edureka.lmsapi.models.Borrower;
import com.tcs.edureka.lmsapi.services.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {
    private final BorrowerService borrowerService;
    @Autowired
    public BorrowerController(BorrowerService borrowerService){
        this.borrowerService = borrowerService;
    }
    @GetMapping
    public List<Borrower> getAllBorrowers(){
        return borrowerService.getAllBorrowers();
    }
    @GetMapping("/{id}")
    public Borrower getBorrowerById(@PathVariable int id){
        return borrowerService.getBorrowerById(id);
    }
    @PostMapping
    public Borrower addBorrower(@RequestBody Borrower borrower){
        return  borrowerService.addBorrower(borrower);
    }

    @PutMapping("/{id}")
    public Borrower updateBorrower(@PathVariable int id, @RequestBody Borrower borrower){
        return borrowerService.updateBorrower(id, borrower);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        borrowerService.deleteBorrower(id);
    }
}
