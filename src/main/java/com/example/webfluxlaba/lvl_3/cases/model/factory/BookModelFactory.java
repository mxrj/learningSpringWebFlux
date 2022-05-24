package com.example.webfluxlaba.lvl_3.cases.model.factory;

import com.example.webfluxlaba.lvl_1.domain.Book;
import com.example.webfluxlaba.lvl_3.cases.model.BookModel;
import org.springframework.stereotype.Component;


@Component
public class BookModelFactory {
    public BookModel get(Book book) {
        return new BookModel(
                book.getId(),
                book.getTitle(),
                book.getYear(),
                book.getAuthors()
        );
    }
}