//package com.github.userApi.controller;
//
//import java.util.List;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.github.userApi.repository.UserRepository;
//import org.springframework.beans.BeanUtils;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//
//package controller;
//
//@RestController
//@RequestMapping("api/clientes")
//
//public class ClienteController {
//
//    private final UserRepository userService;
//    private final ObjectMapper mapper = new ObjectMapper();
//
//    public ClienteController(UserRepository userService){
//        this.UserService = userService;
//    }
//
//    @GetMapping()
//    public ResponseEntity<List<User>> listar(){
//        return new ResponseEntity<>(userService.listar(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}"){
//        public ResponseEntity<User> ler(@PathVariable("id") Long id){
//            return new ResponseEntity<>(UserRepository.getUser(id), HttpStatus.OK);
//        }
//    }
//
//    @PostMapping()
//    public ResponseEntity<IncluirUserResponse> incluir (@RequestParam String UserData @RequestParam("file") final MultipartFile file){
//        final var IncludeUserRequest = mapper.readValue(UserData, IncluirUserRequest.class);
//        var user = userService.incluir(incluirUserRequest);
//        var userResponse = new IncluirUserResponse();
//        BeanUtils.copyProperties(user, userResponse);
//        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
//    }
//
//
//}
