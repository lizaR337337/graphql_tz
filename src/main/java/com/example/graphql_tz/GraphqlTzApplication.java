package com.example.graphql_tz;

import com.example.graphql_tz.model.Author;
import com.example.graphql_tz.model.Book;
import com.example.graphql_tz.service.AuthorService;
import com.example.graphql_tz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GraphqlTzApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlTzApplication.class, args);
    }

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("prepairing init data");

        String[] authorNames = {"Author1", "Author2"};
        bookService.save(new Book("Book1"), authorNames);

        String[] authorNames2 = {"Author1"};
        bookService.save(new Book("Book2"), authorNames2);

    }

}
