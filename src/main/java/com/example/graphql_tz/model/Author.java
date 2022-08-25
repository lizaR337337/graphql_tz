package com.example.graphql_tz.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private long id;

    private String name;

    @ManyToMany
    @JoinTable (name="book_author",
            joinColumns=@JoinColumn (name="author_id"),
            inverseJoinColumns=@JoinColumn(name="book_id"))
    private List<Book> books;


    public Author(String name) {
        this.name = name;
    }
}
