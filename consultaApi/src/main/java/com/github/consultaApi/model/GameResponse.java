package com.github.consultaApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class GameResponse {
    private boolean success;
    private int count;
    private List<Consulta> data;
}