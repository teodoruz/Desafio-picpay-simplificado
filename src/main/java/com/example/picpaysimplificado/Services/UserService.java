package com.example.picpaysimplificado.Services;

import com.example.picpaysimplificado.domain.User;
import com.example.picpaysimplificado.domain.UserDTO;
import com.example.picpaysimplificado.domain.UserType;
import com.example.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        this.userRepository.save(user);
    }


    public User postUser(UserDTO userdto){
        User user = new User(userdto);
        return userRepository.save(user);
    }

    public List<User> ListAllUsers() {
        return userRepository.findAll();

    }


    public User findById(Long Id) throws Exception {
        var userid = userRepository.findById(Id).orElseThrow(()-> new Exception("id nao encontrado"));
        return userid;
    }

    public Boolean validateUser(User user, BigDecimal amaunt) throws Exception {
        if(user.getUserType() == UserType.MERCHANT){
            throw new Exception("mercante nao faz transaçao");
        }
        if(user.getUserType() == UserType.COMMON && user.getBalance().compareTo(amaunt) < 0){
        throw new Exception("saldo insuficiente");
        }
        return true;
    }
}
