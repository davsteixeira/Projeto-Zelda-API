package com.github.userApi.dto;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
}

// Deixei apenas 1 model/dto para simplificar o projeto
