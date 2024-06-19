package com.opcion.empleo_app.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opcion.empleo_app.domain.entities.TpUsuario;
import com.opcion.empleo_app.domain.services.TpUsuarioService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/tp-usuario")
public class TpUsuarioController {
    
    @Autowired
    private TpUsuarioService service;

    @GetMapping
    public List<TpUsuario> findAll(){
        return service.findAll();
    }

    @PostMapping
    public TpUsuario save(@RequestBody TpUsuario tpUsuario){
        return service.save(tpUsuario);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<TpUsuario> tpUsuDb = service.findById(id);
        if (tpUsuDb.isPresent()) {
            return ResponseEntity.ok(tpUsuDb);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @DeleteMapping
    public boolean deleteById(@RequestParam Long id){
        Optional<TpUsuario> tpUsuDb = service.findById(id);
        if (tpUsuDb.isPresent()) {
            service.deleteById(id);
            return true;
        }
        return false;
    }

}
