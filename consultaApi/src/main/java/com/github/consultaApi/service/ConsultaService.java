package com.github.consultaApi.service;
import com.github.consultaApi.model.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ConsultaService {

    @Autowired
    private WebClient webClient;

    public Mono<GameResponse> getAllGames() {
        return webClient.get()
                .uri("/games")
                .retrieve()
                .bodyToMono(GameResponse.class);
    }

    public Mono<GameResponse> getGameById(String id) {
        return webClient.get()
                .uri("/games/" + id)
                .retrieve()
                .bodyToMono(GameResponse.class);
    }
}






