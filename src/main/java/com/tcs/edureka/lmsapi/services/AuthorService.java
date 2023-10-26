package com.tcs.edureka.lmsapi.services;

import com.tcs.edureka.lmsapi.models.Author;
import com.tcs.edureka.lmsapi.models.Author;
import com.tcs.edureka.lmsapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author addAuthor(Author Author) {
        return authorRepository.save(Author);
    }

    public Author updateAuthor(int id, Author updatedAuthor) {
        Author existingAuthor = authorRepository.findById(id).orElse(null);

        if (existingAuthor != null) {
            existingAuthor.setName(updatedAuthor.getName());
            existingAuthor.setEmail(updatedAuthor.getEmail());
            return authorRepository.save(existingAuthor);
        }
        return null;
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
}
