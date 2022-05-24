package com.example.webfluxlaba.lvl_1.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Author {
    private final long id;
    private final String name;
    private final List<BookFlat> books;
}
