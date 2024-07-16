package com.opcion.empleo_app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opcion.empleo_app.domain.entities.Usuario;
import com.opcion.empleo_app.domain.services.UsuarioService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario user){
        return service.save(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Usuario> userDb = service.findById(id);
        if (userDb.isPresent()) {
            return ResponseEntity.ok(userDb);
        }
        return ResponseEntity.ok(null);
    }


    @DeleteMapping
    public boolean deleteById(@RequestParam Long id){
        Optional<Usuario> userDb = service.findById(id);
        if (userDb.isPresent()) {
            service.deleteById(id);
            return true;
        }
        return false;
    }


    @GetMapping("/login")
    public Optional<Usuario> login(@RequestParam String email,@RequestParam String password){
        Optional<Usuario> usuDb = service.login(email, password);
        if (usuDb.isPresent()) {
            return usuDb;
        }
        return null;
    }


}
