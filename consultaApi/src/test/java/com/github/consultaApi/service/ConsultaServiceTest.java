package com.github.consultaApi.service;
import com.github.consultaApi.model.Consulta;
import com.github.consultaApi.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

class ConsultaServiceTest {

    @Mock
    private WebClient webClient;

    @Mock
    private RequestHeadersUriSpec uriSpec;

    @Mock
    private ResponseSpec responseSpec;

    @InjectMocks
    private ConsultaService consultaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllGames() {

        Game gameMock = new Game(
                "1",
                "Mocked Game",
                "Mocked Description",
                "Mocked Developer",
                "Mocked Publisher",
                "2022-01-01"
        );


        Consulta<Game> consultaMock = new Consulta<>(true, 3, gameMock);

        when(webClient.get()).thenReturn(uriSpec);
        when(uriSpec.uri("/games")).thenReturn(uriSpec);
        when(uriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(Consulta.class)).thenReturn(Mono.just(consultaMock));


        consultaService.getAllGames().subscribe(consulta -> {
            assert consulta.isSuccess();
            assert consulta.getCount() == 3;
            assert consulta.getData().equals(gameMock);
        });
    }

    @Test
    void testGetGameById() {
        String gameId = "1";

        Game gameMock = new Game(
                gameId,
                "Mocked Game",
                "Mocked Description",
                "Mocked Developer",
                "Mocked Publisher",
                "2022-01-01"
        );

        Consulta<Game> consultaMock = new Consulta<>(true, 1, gameMock);

        when(webClient.get()).thenReturn(uriSpec);
        when(uriSpec.uri("/games/" + gameId)).thenReturn(uriSpec);
        when(uriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(Consulta.class)).thenReturn(Mono.just(consultaMock));

        consultaService.getGameById(gameId).subscribe(consulta -> {
            assert consulta.isSuccess();
            assert consulta.getCount() == 1;
            assert consulta.getData().equals(gameMock);
        });
    }
}
