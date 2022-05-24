package com.example.webfluxlaba.lvl_4.service.cache;

import com.example.webfluxlaba.lvl_1.domain.AuthorFlat;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Signal;

@Service
@Data
public class AuthorsCache {
    private final Cache<Long, Signal<? extends AuthorFlat>> cache;

    public AuthorsCache() {
        this.cache = Caffeine.newBuilder()
                .maximumSize(100)
                .build();
    }

    public AuthorFlat evict(AuthorFlat value) {
        cache.invalidate(value.getId());
        return value;
    }
}