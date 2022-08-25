package com.example.graphql_tz.model.mutation;

import com.example.graphql_tz.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorInput {

    private String name;

    private String[] books;

}
