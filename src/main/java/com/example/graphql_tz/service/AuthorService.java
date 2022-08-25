package com.example.graphql_tz.service;

import com.example.graphql_tz.model.Author;
import com.example.graphql_tz.model.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author getAuthorByName(String name);

    List<Book> getBooksByAuthor(Author author);

    Author save(Author author, String[] books);
}
