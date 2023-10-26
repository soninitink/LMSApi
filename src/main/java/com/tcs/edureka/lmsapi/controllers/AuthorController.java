package com.tcs.edureka.lmsapi.controllers;

import com.tcs.edureka.lmsapi.models.Author;
import com.tcs.edureka.lmsapi.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }
    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable int id){
        return authorService.getAuthorById(id);
    }
    @PostMapping
    public Author addAuthor(@RequestBody Author author){
        return  authorService.addAuthor(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author){
        return authorService.updateAuthor(id, author);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        authorService.deleteAuthor(id);
    }
}
