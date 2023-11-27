package com.github.consultaApi.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.consultaApi.model.Consulta;
import lombok.Data;

import java.util.List;

@Data
public class ConsultaResponse {
    private boolean success;
    private int count;

    @JsonProperty("data")
    private List<Consulta> consultaList;
}


