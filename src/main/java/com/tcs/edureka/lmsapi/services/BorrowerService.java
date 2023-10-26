package com.tcs.edureka.lmsapi.services;

import com.tcs.edureka.lmsapi.models.Borrower;
import com.tcs.edureka.lmsapi.repository.BorrowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerService {
    private final BorrowerRepository borrowerRepository;
    
    public BorrowerService(BorrowerRepository borrowerRepository){
        this.borrowerRepository = borrowerRepository;
    }
    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    public Borrower getBorrowerById(int id) {
        return borrowerRepository.findById(id).orElse(null);
    }

    public Borrower addBorrower(Borrower Borrower) {
        return borrowerRepository.save(Borrower);
    }

    public Borrower updateBorrower(int id, Borrower updatedBorrower) {
        Borrower existingBorrower = borrowerRepository.findById(id).orElse(null);

        if (existingBorrower != null) {
            existingBorrower.setName(updatedBorrower.getName());
            existingBorrower.setEmail(updatedBorrower.getEmail());
            existingBorrower.setPhoneNumber(updatedBorrower.getPhoneNumber());
            return borrowerRepository.save(existingBorrower);
        }
        return null;
    }

    public void deleteBorrower(int id) {
        borrowerRepository.deleteById(id);
    }
}
