package com.example.graphql_tz.service;

import com.example.graphql_tz.model.Author;
import com.example.graphql_tz.model.Book;

import java.util.List;

public interface AuthorService {
    Author getAuthorByName(String name);

    List<Book> getBooksByAuthor(Author author);

    Author save(Author author, String[] books);
}
