package com.github.userApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncluirUserRequest {
    private Long id;
    private String name;
    private int age;
}
