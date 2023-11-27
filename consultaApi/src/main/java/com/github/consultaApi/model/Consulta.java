package com.github.consultaApi.model;

import lombok.Data;

@Data
public class Consulta {
    private String name;
    private String description;
    private String developer;
    private String publisher;
    private String releasedDate;
    private String id;

    // Construtor vazio
    public Consulta() {
    }

    // Getters e Setters
    // ...
}
