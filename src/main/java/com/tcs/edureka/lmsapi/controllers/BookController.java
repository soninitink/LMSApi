package com.tcs.edureka.lmsapi.controllers;

import com.tcs.edureka.lmsapi.exceptions.NotFoundException;
import com.tcs.edureka.lmsapi.models.Book;
import com.tcs.edureka.lmsapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        try {
            return bookService.getBookById(id);
        }catch (NotFoundException notFoundException){
            //TODO - Use DTO / or log error
            return  null;
        }catch (Exception exception){
            return null;
        }
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        return bookService.updateBook(id, updatedBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/genre/{id}")
    public List<Book> getAllBooksByGenre(@PathVariable int id){
        try {
            return bookService.getAllBooksByGenre(id);
        }catch (NotFoundException notFoundException){
            //TODO - Use DTO / or log error
            return  null;
        }catch (Exception exception){
            return null;
        }
    }

    @GetMapping("/author/{id}")
    public List<Book> getAllBooksByAuthor(@PathVariable int id){
        try {
            return  bookService.getAllBooksByAuthor(id);
        }catch (NotFoundException notFoundException){
            //TODO - Use DTO / or log error
            return  null;
        }catch (Exception exception){
            return null;
        }
    }

    @GetMapping("/library-branch/{id}")
    public List<Book> getAllBooksByLibraryBranch(@PathVariable int id){
        try {
           return bookService.getAllBooksByLibraryBranch(id);
        }catch (NotFoundException notFoundException){
            //TODO - Use DTO / or log error
            return  null;
        }catch (Exception exception){
            return null;
        }
    }
    @GetMapping("/borrower/{id}")
    public List<Book> getAllBooksByBorrower(@PathVariable int id){
        try {
            return bookService.getAllBooksByBorrower(id);
        }catch (NotFoundException notFoundException){
            //TODO - Use DTO / or log error
            return  null;
        }catch (Exception exception){
            return null;
        }
    }
}
