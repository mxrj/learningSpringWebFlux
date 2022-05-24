package com.example.webfluxlaba.lvl_2.service;

import com.example.webfluxlaba.lvl_1.domain.Book;
import com.example.webfluxlaba.lvl_1.domain.BookFlat;
import reactor.core.publisher.Flux;

public interface BookService {
    Flux<BookFlat> findFlatAll();
    Flux<Book> findAll();
}
