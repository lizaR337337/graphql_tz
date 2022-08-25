package com.example.graphql_tz.service;

import com.example.graphql_tz.model.Author;
import com.example.graphql_tz.model.Book;
import com.example.graphql_tz.repository.AuthorRepository;
import com.example.graphql_tz.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    @Override
    public Book save(Book book, String[] authorsArray) {
        book.setAuthors(Arrays.stream(authorsArray)
                .map(name -> {
                    Author author = authorRepository.getAuthorByName(name);
                    if(author==null){
                        author = authorRepository.save(new Author(name));
                    }
                    return author;
                })
                .collect(Collectors.toList()));
        return bookRepository.save(book);
    }


}
