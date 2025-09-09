package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Save a new book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Update an existing book
    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setPrice(updatedBook.getPrice());
                    return bookRepository.save(book);
                })
                .orElse(null);
    }

    // Delete a book by ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
