package com.github.consultaApi.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {
    private String id;
    private String name;
    private String description;
    private String developer;
    private String publisher;
    private String released_date;
}



