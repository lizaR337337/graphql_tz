package com.example.graphql_tz.repository;

import com.example.graphql_tz.model.Author;
import com.example.graphql_tz.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book getBookByTitle(String title);
}
