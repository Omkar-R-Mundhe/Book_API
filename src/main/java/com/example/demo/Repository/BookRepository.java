package com.example.demo.Repository;


import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // No need to add methods now — JpaRepository provides basic CRUD out of the box
}