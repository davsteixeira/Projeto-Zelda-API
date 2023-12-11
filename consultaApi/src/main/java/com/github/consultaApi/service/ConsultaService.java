package com.github.consultaApi.service;
import com.github.consultaApi.model.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ConsultaService {

    @Autowired
    private WebClient webClient;

    public Mono<Consulta> getAllGames() {
        return webClient.get()
                .uri("/games")
                .retrieve()
                .bodyToMono(Consulta.class);
    }

    public Mono<Consulta> getGameById(String id) {
        return webClient.get()
                .uri("/games/" + id)
                .retrieve()
                .bodyToMono(Consulta.class);
    }
}






