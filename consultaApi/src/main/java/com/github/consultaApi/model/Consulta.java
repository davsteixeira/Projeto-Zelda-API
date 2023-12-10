package com.github.consultaApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Consulta<GameData> {
    private boolean success;
    private int count;
    private GameData data;
}


