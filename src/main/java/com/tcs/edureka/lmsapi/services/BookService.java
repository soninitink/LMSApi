package com.tcs.edureka.lmsapi.services;

import com.tcs.edureka.lmsapi.exceptions.NotFoundException;
import com.tcs.edureka.lmsapi.models.Book;
import com.tcs.edureka.lmsapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookGenreRepository bookGenreRepository;
    private final BookAuthorRepository bookAuthorRepository;
    private final LibraryBookRepository libraryBookRepository;
    private final BorrowerBookRepository borrowerBookRepository;
    @Autowired
    public BookService(BookRepository bookRepository, BookGenreRepository bookGenreRepository, BookAuthorRepository bookAuthorRepository, LibraryBookRepository libraryBookRepository, BorrowerBookRepository borrowerBookRepository){
        this.bookRepository = bookRepository;
        this.bookGenreRepository = bookGenreRepository;
        this.bookAuthorRepository = bookAuthorRepository;
        this.libraryBookRepository = libraryBookRepository;
        this.borrowerBookRepository = borrowerBookRepository;
    }
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) throws NotFoundException {
        Book book = bookRepository.findById(id).orElse(null);
        if(book == null)
            throw new NotFoundException("Book does not exist.");
        return book;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(int id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id).orElse(null);

        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setYear(updatedBook.getYear());
            existingBook.setPublishedDate(updatedBook.getPublishedDate());
            existingBook.setPrice(updatedBook.getPrice());
            return bookRepository.save(existingBook);
        }
        return null;
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getAllBooksByGenre(int genreId) throws NotFoundException {
        List<Book> books = bookGenreRepository.findBooksByGenre(genreId);
        if(books == null)
            throw new NotFoundException("Book are not available for this Genre.");
        return books;
    }
    public List<Book> getAllBooksByAuthor(int authorId) throws NotFoundException {
        List<Book> books = bookAuthorRepository.findAllBooksByAuthor(authorId);
        if(books == null)
            throw new NotFoundException("Books are not available from this Author.");
        return books;
    }
    public List<Book> getAllBooksByLibraryBranch(int libraryBranchId) throws NotFoundException {
        List<Book> books = libraryBookRepository.findAllBooksByLibraryBranch(libraryBranchId);
        if(books == null)
            throw new NotFoundException("Books are not available in this Library Branch.");
        return books;
    }

    public List<Book> getAllBooksByBorrower(int borrowerId) throws NotFoundException {
        List<Book> books = borrowerBookRepository.findAllBooksByBorrower(borrowerId);
        if(books == null)
            throw new NotFoundException("Books are not available for this Borrower.");
        return books;
    }
}
