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

    @GetMapping("/")
    @ResponseBody
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping
    @ResponseBody
    public Book getBookById(@RequestParam int id) {
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
    @ResponseBody
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping
    @ResponseBody
    public Book updateBook(@RequestParam int id, @RequestBody Book updatedBook) {
        return bookService.updateBook(id, updatedBook);
    }

    @DeleteMapping
    @ResponseBody
    public void deleteBook(@RequestParam int id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/genre")
    @ResponseBody
    public List<Book> getAllBooksByGenre(@RequestParam int id){
        try {
            return bookService.getAllBooksByGenre(id);
        }catch (NotFoundException notFoundException){
            //TODO - Use DTO / or log error
            return  null;
        }catch (Exception exception){
            return null;
        }
    }

    @GetMapping("/author")
    @ResponseBody
    public List<Book> getAllBooksByAuthor(@RequestParam int id){
        try {
            return  bookService.getAllBooksByAuthor(id);
        }catch (NotFoundException notFoundException){
            //TODO - Use DTO / or log error
            return  null;
        }catch (Exception exception){
            return null;
        }
    }

    @GetMapping("/library-branch")
    @ResponseBody
    public List<Book> getAllBooksByLibraryBranch(@RequestParam int id){
        try {
           return bookService.getAllBooksByLibraryBranch(id);
        }catch (NotFoundException notFoundException){
            //TODO - Use DTO / or log error
            return  null;
        }catch (Exception exception){
            return null;
        }
    }
    @GetMapping("/borrower")
    @ResponseBody
    public List<Book> getAllBooksByBorrower(@RequestParam int id){
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
