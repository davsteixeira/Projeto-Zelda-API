package com.github.userApi.controller.dto;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.userApi.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.IOException;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncluirUserRequest {
    private Long id;
    private String name;
    private int age;
}
