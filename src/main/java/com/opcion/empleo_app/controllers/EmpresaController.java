package com.opcion.empleo_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.opcion.empleo_app.entities.Empresa;
import com.opcion.empleo_app.services.EmpresaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @GetMapping
    public List<Empresa> getAll() {
        return service.findAll();
    }

    // @GetMapping("/${id}")
    // public String findByID(@PathVariable Long id) {
    // return "Valor id : " + id;
    // }

    // @PostMapping
    // public boolean save(@RequestBody Empresa empresa) {

    // return false;
    // }

}
