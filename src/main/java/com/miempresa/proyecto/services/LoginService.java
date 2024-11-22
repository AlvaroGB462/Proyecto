package com.miempresa.proyecto.services;

import com.miempresa.proyecto.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    private final RestTemplate restTemplate;

    @Autowired
    public LoginService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User login(String usernameOrEmail, String password) {
        // URL temporal para simular la autenticación
        String url = "http://api.example.com/login?usernameOrEmail=" + usernameOrEmail + "&password=" + password;

        // Realiza una llamada a la API (usar RestTemplate)
        User user = restTemplate.postForObject(url, null, User.class);

        return user;
    }
}
