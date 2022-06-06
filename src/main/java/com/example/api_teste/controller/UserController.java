package com.example.api_teste.controller;

import com.example.api_teste.dto.UserDto;
import com.example.api_teste.model.User;
import com.example.api_teste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/cadastro")
    public void cadastro(@RequestBody UserDto userDto) throws Exception {
         var user = new User();
         user.setNome(userDto.getName());
         user.setPassword(userDto.getPassword());

         userService.cadastrarUsuario(user);

    }

    @PostMapping("/login")
    public int login(@RequestBody UserDto userDto) throws Exception {
        var user = new User();
        user.setNome(userDto.getName());
        user.setPassword(userDto.getPassword());

        return userService.logar(user);

    }
}
