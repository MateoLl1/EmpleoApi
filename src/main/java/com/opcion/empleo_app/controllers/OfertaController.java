package com.opcion.empleo_app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opcion.empleo_app.domain.entities.Oferta;
import com.opcion.empleo_app.domain.services.OfertaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/oferta")
public class OfertaController {
    
    @Autowired
    private OfertaService service;

    @GetMapping
    public List<Oferta> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Oferta> ofertaDb = service.findById(id);
        if (ofertaDb.isPresent()) {
            return ResponseEntity.ok(ofertaDb);
        }
        return ResponseEntity.badRequest().body(null);
    }


    @PostMapping
    public Oferta save(@RequestBody Oferta oferta){
        return service.save(oferta);
    }

    @DeleteMapping
    public boolean deleteById(@RequestParam Long id){
        Optional<Oferta> ofertaDb = service.findById(id);
        if (ofertaDb.isPresent()) {
            service.deleteById(id);
            return true;
        }
        return false;
    }
    

}
