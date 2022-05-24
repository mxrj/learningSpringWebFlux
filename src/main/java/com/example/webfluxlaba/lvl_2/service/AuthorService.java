package com.example.webfluxlaba.lvl_2.service;

import com.example.webfluxlaba.lvl_1.domain.AuthorFlat;
import reactor.core.publisher.Mono;

public interface AuthorService {
    Mono<AuthorFlat> findFlatById(long id);

    Mono<AuthorFlat> save(AuthorFlat author);
}
