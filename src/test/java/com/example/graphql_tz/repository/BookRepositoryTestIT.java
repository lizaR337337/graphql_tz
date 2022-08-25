package com.example.graphql_tz.repository;

import com.example.graphql_tz.IntegrationTestBase;
import com.example.graphql_tz.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BookRepositoryTestIT extends IntegrationTestBase {
    @Autowired
    private BookRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void shouldReturnBookByTitle() {
        // given
        String title = "BookTest";
        Book book = new Book(
                title
        );
        underTest.save(book);


        // when
        Book expected = underTest.getBookByTitle(title);

        // then
        assertThat(expected).isNotNull();
        assertThat(expected.getTitle()).isEqualTo(title);
    }

    @Test
    void shouldFindAllBooks() {
        //given
        Book book1 = new Book("BookTest1");
        Book book2 = new Book("BookTest1");
        underTest.save(book1);
        underTest.save(book2);

        //when
        List<Book> books = underTest.findAll();

        //then
        assertThat(books.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    void shouldSaveBook(){
        //given
        Book book = new Book("BookTest");

        //when
        underTest.save(book);

        //then
        assertThat(book.getId()).isNotNull();
    }
}