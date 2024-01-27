package com.example.picpaysimplificado.Services;

import com.example.picpaysimplificado.domain.User;
import org.springframework.stereotype.Service;

@Service
public class Notification {
    public void sendNot(User user, String message){
    String email = user.getEmail();
        System.out.println(email + message);
    }
}
