package com.example.webfluxlaba.lvl_4.service;

import com.example.webfluxlaba.lvl_1.domain.AuthorFlat;
import com.example.webfluxlaba.lvl_2.service.AuthorService;
import com.example.webfluxlaba.lvl_4.service.cache.AuthorsCache;
import com.example.webfluxlaba.lvl_4.service.repo.AuthorRepository;
import com.example.webfluxlaba.lvl_4.service.repo.raw.AuthorRaw;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.cache.CacheMono;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthorServiceImplementation implements AuthorService {
    private final AuthorRepository authorRepository;
    private final TransactionOperations transactionOperations;
    private final AuthorsCache cache;

    @Override
    public Mono<AuthorFlat> findFlatById(long id) {
        return CacheMono.lookup(cache.getCache().asMap(), id)
                .onCacheMissResume(transactionOperations.findFlatById(id));
    }

    @Override
    public Mono<AuthorFlat> save(AuthorFlat author) {
        return findFlatById(author.getId()).map(cache::evict)

                .flatMap(a -> Mono.just(AuthorRaw.from(a))
                        .flatMap(authorRepository::save)
                        .map(AuthorRaw::toAuthorFlat))

                .map(cache::evict);
    }

    @Service
    @RequiredArgsConstructor
    public static class TransactionOperations {
        private final AuthorRepository authorRepository;

        @Transactional(readOnly = true)
        public Mono<AuthorFlat> findFlatById(long id) {
            return authorRepository.findById(id)
                    .map(AuthorRaw::toAuthorFlat)
                    .doOnNext(a -> System.out.println("FROM DB: " + a));
        }
    }
}
