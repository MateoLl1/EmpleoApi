package com.opcion.empleo_app.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.opcion.empleo_app.domain.entities.Empresa;
import com.opcion.empleo_app.domain.entities.Usuario;
import com.opcion.empleo_app.domain.services.EmpresaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {



    @Autowired
    private EmpresaService service;

    @GetMapping
    public List<Empresa> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Empresa> empDb = service.findById(id);
        if (empDb.isPresent()) {
            return ResponseEntity.ok(empDb);
        }
        return ResponseEntity.ok(false);
    }

    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Empresa empresa) {
        Empresa empDb = service.save(empresa);
        if (empDb != null) {
            return ResponseEntity.ok(empDb) ;
        } else {
            return ResponseEntity.status(500).body(false);
        }
    }

    @DeleteMapping
    public boolean deleteById(@RequestParam Long id){
        Optional<Empresa> empDb = service.findById(id);
        if (empDb.isPresent()) {
            service.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping("/login")
    public Optional<Empresa> login(@RequestParam String email,@RequestParam String password){
        Optional<Empresa> empDb = service.login(email, password);
        if (empDb.isPresent()) {
            return empDb;
        }
        return null;
    }

}
