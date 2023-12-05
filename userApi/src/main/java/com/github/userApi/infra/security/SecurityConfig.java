package com.github.userApi.infra.security;

import jakarta.security.auth.message.config.AuthConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    //aqui vou fazer uma série de filtros para ver se o usuário é apto para fazer tal ação
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                //o padrão aqui é autenticação stateless ja que estamos usando rest.
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //aqui declaramos quais são as requisições http que queremos que sejam autorizadas.
                .authorizeHttpRequests(authorize -> authorize
                        //basicamente aqui eu digo que qualquer um que não for o http /product será autenticado como usuário, restringindo o acesso para só ser acessado quando autenticado
                        .requestMatchers(HttpMethod.POST, "/product").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        //O ideal aqui é bloquear o registro apenas para admins para que não tenha o problema de qualquer pessoa registrar um usuário admin.
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .anyRequest().authenticated()
                )
                .build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //Precisamos salvar a senha criptografada, e comparar com o hash no banco de dados por isso:
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
