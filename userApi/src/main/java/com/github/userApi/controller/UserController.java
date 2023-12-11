package com.github.userApi.controller;
import java.util.List;
import com.github.userApi.dto.User;
import com.github.userApi.repository.UserRepository;
import com.github.userApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class
UserController {

    // Aqui estou instanciando o repository e o service
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    //Aqui estou chamando os métodos da service e colocando os endpoints
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getNinjaPorId(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok("Usuário cadastrado!");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok("Usuário atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("Usuário deletado com sucesso");
    }
}
