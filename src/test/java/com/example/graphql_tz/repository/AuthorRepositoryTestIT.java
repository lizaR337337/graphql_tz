package com.example.graphql_tz.repository;

import com.example.graphql_tz.IntegrationTestBase;
import com.example.graphql_tz.model.Author;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AuthorRepositoryTestIT extends IntegrationTestBase {
    @Autowired
    private AuthorRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void shouldReturnAuthorByName() {
        // given
        String name = "AuthorTest";
        Author author = new Author(
                name
        );
        underTest.save(author);


        // when
        Author authorExpected = underTest.getAuthorByName(name);

        // then
        assertThat(authorExpected).isNotNull();
        assertThat(authorExpected.getName()).isEqualTo(name);

    }

    @Test
    void shouldCheckIfAuthorExistsByName() {
        // given
        String name = "AuthorTest";
        Author author = new Author(
                name
        );
        underTest.save(author);

        // when
        boolean exists = underTest.existsAuthorByName(name);

        // then
        assertThat(exists).isTrue();
    }

    @Test
    void shouldCheckIfAuthorDoesntExistByName() {
        // given
        String name = "AuthorTest";

        // when
        boolean exists = underTest.existsAuthorByName(name);

        // then
        assertThat(exists).isFalse();
    }

    @Test
    void shouldSaveAuthor(){
        //given
        Author author = new Author("AuthorTest");

        //when
        underTest.save(author);

        //then
        assertThat(author.getId()).isNotNull();
    }
}