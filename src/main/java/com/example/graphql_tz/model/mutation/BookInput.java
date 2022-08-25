package com.example.graphql_tz.model.mutation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInput {

    private String title;

    private String[] authors;

}
