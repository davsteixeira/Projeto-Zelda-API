package userApi.src.main.java.com.github.userApi.controller;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.userApi.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("api/clientes")

public class UserController {

    private final UserService userService;
    private final ObjectMapper mapper = new ObjectMapper();

    public UserController(UserService userService){
        this.UserService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> listar(){
        return new ResponseEntity<>(userService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}"){
        public ResponseEntity<User> ler(@PathVariable("id") Long id){
            return new ResponseEntity<>(UserService.getUser(id), HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<IncluirUserResponse> incluir (@RequestParam String UserData @RequestParam("file") final MultipartFile file){
        final var IncludeUserRequest = mapper.readValue(UserData, IncluirUserRequest.class);
        var user = userService.incluir(incluirUserRequest);
        var userResponse = new IncluirUserResponse();
        BeanUtils.copyProperties(user, userResponse);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<User> atualizar(@RequestParam String userData, @RequestParam(value = "file", required = false) final MultipartFile file ) throws IOException {
        final var atualizarUserRequest = mapper.readValue(userData, AtualizarUserRequest.class);

        var user = UserService.atualizar(atualizarUserRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        userService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


}
