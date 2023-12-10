package com.github.consultaApi.controller;
import com.github.consultaApi.model.GameResponse;
import com.github.consultaApi.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ConsultaController {

    private final ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping("/games")
    public Mono<GameResponse> getAllGames() {
        return consultaService.getAllGames();
    }

    @GetMapping("/games/{id}")
    public Mono<GameResponse> getGameById(@PathVariable String id) {
        return consultaService.getGameById(id);
    }

}

