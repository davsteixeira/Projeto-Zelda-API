package com.github.userApi.repository;

import com.github.userApi.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

//Nos parâmetros do jparepository temos a nossa classe User e a nossa chave primária da tabela, que no caso seria o ID
public interface UserRepository extends JpaRepository<User, Long> {
    //aqui temos um método que filtra os usuários pelo nome;
    UserDetails findByNome(String nome);
}
