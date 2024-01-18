package com.example.springbootbookstore.service;

import com.example.springbootbookstore.model.Book;
import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();
}
