package com.example.webfluxlaba.lvl_4.service.repo.raw;

import com.example.webfluxlaba.lvl_1.domain.BookFlat;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("books_with_authors_id")
public class BookRaw {
    @Id
    private long id;
    private String title;
    private int publishYear;
    private List<Long> authors;

    public BookFlat toBookFlat() {
        return new BookFlat(id, title, publishYear, authors);
    }
}
