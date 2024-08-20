package com.opcion.empleo_app.controllers;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opcion.empleo_app.infrastructure.services.EmailService;

@RestController
@RequestMapping("/api/security/email")
public class EmailController {

    private static final SecureRandom random = new SecureRandom();

    
    public static String generatePin() {
        int pin = 100000 + random.nextInt(900000);
        return String.valueOf(pin);
    }

    @Autowired
    private EmailService emailService;

    @GetMapping("/{email}")
    public String sendPin(@PathVariable String email) {
        try {
            String pin = generatePin();
            emailService.sendPin(email, pin);
            return "Pin enviado a " + email;
        } catch (Exception e) {
            return "Error al enviar codigo, verifica el correo";
        }
    }


}
