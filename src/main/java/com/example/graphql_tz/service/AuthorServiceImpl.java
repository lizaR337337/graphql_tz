package com.example.graphql_tz.service;

import com.example.graphql_tz.model.Author;
import com.example.graphql_tz.model.Book;
import com.example.graphql_tz.repository.AuthorRepository;
import com.example.graphql_tz.repository.BookRepository;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository;
    BookRepository bookRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author getAuthorByName(String name) {
        return authorRepository.getAuthorByName(name);
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return getAuthorByName(author.getName()).getBooks();
    }

    @Override
    public Author save(Author author, String[] books) {

        author.setBooks(Arrays.stream(books)
                .map(title -> {
                    Book book = bookRepository.getBookByTitle(title);
                    if (book == null) {
                        book = bookRepository.save(new Book(title));
                    }
                    return book;
                })
                .collect(Collectors.toList()));
        return authorRepository.save(author);
    }

}
