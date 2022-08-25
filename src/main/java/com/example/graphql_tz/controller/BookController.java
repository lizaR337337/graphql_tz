package com.example.graphql_tz.controller;

import com.example.graphql_tz.model.Author;
import com.example.graphql_tz.model.Book;
import com.example.graphql_tz.model.mutation.AuthorInput;
import com.example.graphql_tz.model.mutation.BookInput;
import com.example.graphql_tz.service.AuthorService;
import com.example.graphql_tz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import java.util.List;

@Controller
public class BookController {

    public final BookService bookService;
    public final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @QueryMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @SchemaMapping(typeName = "Query")
    public List<Book> getBooksByAuthor(@Argument Author author) {
        return authorService.getBooksByAuthor(author);
    }

    @MutationMapping
    public Book saveBook(@Argument("input") BookInput input) {
        String title = input.getTitle();
        String[] authors = input.getAuthors();
        return bookService.save(new Book(title), authors);
    }

}
