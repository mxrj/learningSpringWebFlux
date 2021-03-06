package com.example.webfluxlaba.lvl_1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class BookFlat {
    private final long id;
    private final String title;
    private final int year;
    private final List<Long> authors;
}
