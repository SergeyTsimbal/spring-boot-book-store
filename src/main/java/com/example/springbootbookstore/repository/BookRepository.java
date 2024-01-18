package com.example.springbootbookstore.repository;

import com.example.springbootbookstore.model.Book;
import java.util.List;

public interface BookRepository {

    Book save(Book book);

    List<Book> findAll();
}
