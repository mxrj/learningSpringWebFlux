package com.example.webfluxlaba.lvl_4.service.repo;

import com.example.webfluxlaba.lvl_4.service.repo.raw.AuthorRaw;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AuthorRepository extends R2dbcRepository<AuthorRaw, Long> {

}