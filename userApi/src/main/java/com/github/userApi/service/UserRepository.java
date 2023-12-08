package com.github.userApi.service;
import com.github.userApi.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//antes essa classe era um dos UserService, transformei no repository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository){
//        this.UserRepository = userRepository;
//    }
//
//    public List<User> listar(){
//        return UserRepository.FindAll();
//    }
//
//    public User getUser(Long id){
//        return userRepository.findById(id)
//                //.orElseThrow(() -> new UserNotFoundException("User não localizado" + id));
//    }
//
//    public User incluir(IncluirUserRequest userRequest) {
//        var data = Instant.now();
//
//        var User = new User();
//        BeanUtils.copyProperties(userRequest, user);
//        user.setDataCadastro(data);
//        user.setUltimaAtualizacao(data);
//        userRepository.save(user);
//
//        return user;
//    }
//
//    public User atualizar(AtualizarUserRequest atualizarUserRequest) {
//        var user = UserRepository.findById(atualizarUserRequest.getId()).get();
//
//        BeanUtils.copyProperties(atualizarUserRequest, cliente);
//        user.setUltimaAtualizacao(Instant.now());
//        userRepository.save(cliente);
//        return cliente;
//    }
//
//    public void deletar(Long id) {
//        userRepository.deleteById(id);
//    }

}
