package com.github.userApi.dto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

import java.util.Collection;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
// aqui estou dando um implements na classe UserDetails da dependencia que possibilida adicionarmos alguns comandos de hierarquia
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    //adicionei aqui uma string senha pra que possamos fazer uma autenticação
    private String senha;
    //aqui adicionei uma "role" que basicamente seria o "cargo" digamos assim do usuário da tabela, seja admin ou user, que vem de um enum aqui do package model chamado UserRole
    private UserRole role;
    private int idade;

    public User(String nome, String senha, UserRole role){
        this.nome = nome;
        this.senha = senha;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
