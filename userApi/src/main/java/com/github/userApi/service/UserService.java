package com.github.userApi.service;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class UserService {
    private final UserRepository userRepository;

    public ClienteService(UserRepository clienteRepository){
        this.UserRepository = clienteRepository;
    }

    public List<User> listar(){
        return UserRepository.FindAll();
    }

    public User getUser(Long id){
        return userRepository.findById(id)
                //.orElseThrow(() -> new UserNotFoundException("User não localizado" + id));
    }



}
