package com.example.webfluxlaba.lvl_4.service;

import com.example.webfluxlaba.lvl_1.domain.Book;
import com.example.webfluxlaba.lvl_1.domain.BookFlat;
import com.example.webfluxlaba.lvl_2.service.AuthorService;
import com.example.webfluxlaba.lvl_2.service.BookService;
import com.example.webfluxlaba.lvl_4.service.repo.BookRepository;
import com.example.webfluxlaba.lvl_4.service.repo.raw.BookRaw;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Override
    @Transactional(readOnly = true)
    public Flux<BookFlat> findFlatAll() {
        return bookRepository.findAll()
                .map(BookRaw::toBookFlat);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<Book> findAll() {
        return findFlatAll()
                .flatMap(this::toDomain);
    }

    private Mono<Book> toDomain(BookFlat flat) {
        return Flux.fromIterable(flat.getAuthors())
                .flatMap(authorService::findFlatById)
                .collectList()
                .map(authors -> new Book(
                        flat.getId(),
                        flat.getTitle(),
                        flat.getYear(),
                        authors
                ));
    }
}