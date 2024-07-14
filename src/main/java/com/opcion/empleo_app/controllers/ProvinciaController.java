package com.opcion.empleo_app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opcion.empleo_app.domain.entities.Provincia;
import com.opcion.empleo_app.domain.services.ProvinciaService;

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


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/provincia")
public class ProvinciaController {
    
    @Autowired
    private ProvinciaService service;

    @GetMapping
    public List<Provincia> findAll() {
        return service.findAll();
    }
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Provincia provincia){
        Provincia provDB = service.save(provincia);
        if (provDB != null) {
            return ResponseEntity.ok(provDB);
        }
        return ResponseEntity.badRequest().body(false);
    }   

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Provincia> provDb = service.findById(id);
        if (provDb.isPresent()) {
            return ResponseEntity.ok(provDb);
        }
        return ResponseEntity.ok(false);
    }

    @DeleteMapping
    public boolean deleteById(@RequestParam Long id){
        Optional<Provincia> provDb = service.findById(id);
        if (provDb.isPresent()) {
            service.deleteById(id);
            return true;
        }
        return false;
    }

}
