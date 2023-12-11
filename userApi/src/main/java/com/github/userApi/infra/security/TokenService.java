package com.github.userApi.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.github.userApi.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    //criando o método para gerar o token
    @Value("${api.security.token.secret}")
    private String secret;
    public String gerarToken(User user){
        //como usamos stateless, o token fica responsavel de guardar informações e transitar entre cliente e servidor
        try{
            //o secret é o parametro usado pra decodificar a senha criptografada.
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("userApi")
                    //aqui colocamos o usuario para sabermos quem é o usuario que esta fazendo a requisiçao
                    .withSubject(user.getUsername())
                    .withExpiresAt(gerarValidade())
                    .sign(algorithm);
            return token;
        }catch(JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token", exception);

        }
    }

    public String validarToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("userApi")
                    .build()
                    //aqui descriptografamos o token
                    .verify(token)
                    //e aqui pegamos o que tem dentro dele
                    .getSubject();
        }catch(JWTVerificationException execption){
            //Pegamos aqui o erro de verificaçao do JWT e retornamos uma string vazia pra que o spring security informe que é um erro de unauthorized
            return "";
        }
    }

    private Instant gerarValidade(){
        //aqui definimos o tempo de expiraçao do token para 2 horas e pegamos o tempo do nosso fuso
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
