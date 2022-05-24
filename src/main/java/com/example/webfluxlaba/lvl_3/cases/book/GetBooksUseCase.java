package com.example.webfluxlaba.lvl_3.cases.book;

import com.example.webfluxlaba.lvl_2.service.BookService;
import com.example.webfluxlaba.lvl_3.cases.model.factory.BookModelFactory;
import com.example.webfluxlaba.lvl_3.cases.model.BookModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetBooksUseCase {
    private final BookService bookService;
    private final BookModelFactory responseFactory;

    public Mono<List<BookModel>> get() {
        return bookService.findAll()
                .map(responseFactory::get)
                .collectList();
    }
}
