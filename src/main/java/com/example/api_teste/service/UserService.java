package com.example.api_teste.service;


import com.example.api_teste.model.User;
import com.example.api_teste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void cadastrarUsuario(User userParam) throws Exception {
        var user =userRepository.findByNome(userParam.getNome());
        if(user != null){
            throw new Exception("Pessoa já cadastrada");
        }
        userRepository.save(userParam);
    }
    public int logar(User userParam) throws Exception {
        var user =userRepository.findByNome(userParam.getNome());
        if(user != null){
        if (user.getPassword().equals(userParam.getPassword())){
        return user.getId();}
        }
        throw new Exception("senha ou usuario incorreto");

    }


}
