package com.example.webfluxlaba.lvl_4.service.repo;

import com.example.webfluxlaba.lvl_4.service.repo.raw.BookRaw;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface BookRepository extends R2dbcRepository<BookRaw, Long> {
}