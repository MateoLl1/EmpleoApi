package com.opcion.empleo_app.controllers;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opcion.empleo_app.domain.services.EmpresaService;
import com.opcion.empleo_app.domain.services.UsuarioService;
import com.opcion.empleo_app.infrastructure.services.EmailService;


@RestController
@RequestMapping("/api/security")
public class EmailController {

    private static final SecureRandom random = new SecureRandom();

    
    public static String generatePin() {
        int pin = 100000 + random.nextInt(900000);
        return String.valueOf(pin);
    }

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{email}/{tipo}")
    public String sendPin(@PathVariable String email,@PathVariable Long tipo) {
        try {
            String pin = generatePin();
            emailService.sendPin(email, pin);
            if (tipo == 0) { //EMPRESA
                empresaService.updatePasswordByEmail(email, pin);
                return "Contraseña de empresa actualizada, revice su correo" + email;
            }else if(tipo==1){  //USUARIO
                usuarioService.updatePasswordByEmail(email, pin);
                return "Contraseña usuario actualizada, revice su correo" + email;
            }else{
                return "El tipo es invalido";
            }
        } catch (Exception e) {
            return "Error al enviar codigo, verifica el correo";
        }
    }

    


}
