package com.github.consultaApi.service;

import com.github.consultaApi.model.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class ConsultaService {

    private final String BASE_URL = "https://zelda.fanapis.com";

    private final RestTemplate restTemplate;

    @Autowired
    public ConsultaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Consulta> getAllGames() {
        String url = BASE_URL + "/api/games";

        ConsultaResponse response = restTemplate.getForObject(url, ConsultaResponse.class);
        if (response != null && response.isSuccess()) {
            return response.getConsultaList();
        } else {
            return null;
        }
    }

    public Consulta getGameById(String gameId) {
        String url = BASE_URL + "/api/games/" + gameId;

        ConsultaResponse response = restTemplate.getForObject(url, ConsultaResponse.class);
        if (response != null && response.isSuccess() && response.getConsultaList() != null && !response.getConsultaList().isEmpty()) {
            return response.getConsultaList().stream()
                    .filter(game -> gameId.equals(game.getId()))
                    .findFirst()
                    .orElse(null);
        } else {
            return null;
        }
    }
}



