package com.example.graphql_tz.service;

import com.example.graphql_tz.model.Author;
import com.example.graphql_tz.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book save(Book book, String[] authorsArray);

}
