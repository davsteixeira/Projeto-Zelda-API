package com.github.consultaApi.controller;

import com.github.consultaApi.model.Consulta;
import com.github.consultaApi.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zelda-consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping("/games")
    public List<Consulta> getAllGames() {
        return consultaService.getAllGames();
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<Consulta> getGameById(@PathVariable("id") String id) {
        Consulta jogo = consultaService.getGameById(id);

        if (jogo != null) {
            return ResponseEntity.ok(jogo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}