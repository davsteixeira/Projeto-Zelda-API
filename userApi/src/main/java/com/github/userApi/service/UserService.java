package com.github.userApi.service;
import java.util.ArrayList;
import  java.util.List;
import com.github.userApi.dto.User;
import com.github.userApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private List<User> listaDeUsuarios = new ArrayList<>();
    @Autowired
    UserRepository userRepository;

    //A lógica aqui nesses métodos é bem simples graças ao repository do projeto, que dá acesso a métodos como o findAll ou findById
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.save(user);
        }
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
