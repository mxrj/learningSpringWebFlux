package com.example.webfluxlaba.lvl_4.controller;

import com.example.webfluxlaba.lvl_3.cases.book.GetBooksUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetBooksController {
    private final GetBooksUseCase useCase;

    public Mono<ServerResponse> handle(ServerRequest req) {
        return useCase.get()
                .flatMap(list -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(list));
    }
}
