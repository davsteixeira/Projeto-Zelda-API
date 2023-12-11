package com.github.userApi.controllers;

import com.github.userApi.infra.security.TokenService;
import com.github.userApi.dto.AuthDTO;
import com.github.userApi.dto.LoginResponseDTO;
import com.github.userApi.dto.RegisterDTO;
import com.github.userApi.dto.User;
import com.github.userApi.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//aqui estamos fazendo um endpoint para o usuário fazer o login.
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.nome(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.gerarToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if (this.repository.findByNome(data.nome()) != null) return ResponseEntity.badRequest().build();
        //aqui estamos transformando em hash
        String senhaCripto = new BCryptPasswordEncoder().encode(data.senha());
        User newUser = new User(data.nome(), senhaCripto, data.role());
        //salvando o usuario no banco de dados
        this.repository.save(newUser);

        return  ResponseEntity.ok().build();
    }
}
