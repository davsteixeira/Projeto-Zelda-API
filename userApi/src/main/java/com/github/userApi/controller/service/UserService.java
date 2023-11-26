package com.github.userApi.service;
import  java.util.List;

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

    public UserService(UserRepository userRepository){
        this.UserRepository = userRepository;
    }

    public List<User> listar(){
        return UserRepository.FindAll();
    }

    public User getUser(Long id){
        return userRepository.findById(id)
                //.orElseThrow(() -> new UserNotFoundException("User não localizado" + id));
    }

    public User incluir(IncluirUserRequest userRequest) {
        var data = Instant.now();

        var User = new User();
        BeanUtils.copyProperties(userRequest, user);
        user.setDataCadastro(data);
        user.setUltimaAtualizacao(data);
        userRepository.save(user);

        return user;
    }

    public User atualizar(AtualizarUserRequest atualizarUserRequest) {
        var user = UserRepository.findById(atualizarUserRequest.getId()).get();

        BeanUtils.copyProperties(atualizarUserRequest, cliente);
        user.setUltimaAtualizacao(Instant.now());
        userRepository.save(cliente);
        return cliente;
    }

    public void deletar(Long id) {
        userRepository.deleteById(id);
    }




}
