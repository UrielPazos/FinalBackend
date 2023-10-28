package com.clinicaOdontologica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        System.out.println("Accediendo a la página de login"); // Log message
        return "login";
    }
}


