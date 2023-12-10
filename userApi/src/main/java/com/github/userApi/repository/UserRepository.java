package com.github.userApi.repository;
import com.github.userApi.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//antes essa classe era um dos UserService, transformei no repository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

//Aqui tudo que precisou ser feito foi criar esse repository que a partir disso os métodos do repository já podem ser utilizados