package com.github.consultaApi.service;

import com.github.consultaApi.model.Consulta;
import com.github.consultaApi.model.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    private WebClient webClient;



    public Mono<GameResponse> getAllGames() {
        return webClient.get().uri("/games")
                .retrieve().bodyToMono(GameResponse.class);
    }

    public Mono<Consulta> getGameById(String specificId) {
        return getAllGames()
                .map(gameResponse -> findConsultaById(gameResponse, specificId))
                .flatMap(gameResponse -> Mono.justOrEmpty(gameResponse.getData().get(0)));
    }

    private GameResponse findConsultaById(GameResponse gameResponse, String specificId) {
        if (gameResponse != null && gameResponse.getData() != null) {
            gameResponse.setData(gameResponse.getData()
                    .stream()
                    .filter(consulta -> specificId.equals(consulta.getId()))
                    .collect(Collectors.toList()));
            gameResponse.setCount(gameResponse.getData().size());
        }
        return gameResponse;
    }
}






