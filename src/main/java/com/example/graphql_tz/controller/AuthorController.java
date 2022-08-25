package com.example.graphql_tz.controller;

import com.example.graphql_tz.model.Author;
import com.example.graphql_tz.model.mutation.AuthorInput;
import com.example.graphql_tz.service.AuthorService;
import com.example.graphql_tz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {
    BookService bookService;
    AuthorService authorService;

    @Autowired
    public AuthorController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @QueryMapping
    public Author getAuthor(@Argument String name){
        return authorService.getAuthorByName(name);
    }

    @MutationMapping
    public Author saveAuthor(@Argument("input") AuthorInput input) {
        String name = input.getName();
        String[] books = input.getBooks();
        return authorService.save(new Author(name), books);
    }
}
