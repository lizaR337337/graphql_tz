package com.example.graphql_tz.repository;

import com.example.graphql_tz.model.Author;
import com.example.graphql_tz.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author getAuthorByName(String name);

}
