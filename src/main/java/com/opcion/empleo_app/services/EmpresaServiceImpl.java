package com.opcion.empleo_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opcion.empleo_app.entities.Empresa;
import com.opcion.empleo_app.repositories.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Override
    public List<Empresa> findAll() {
        return (List<Empresa>) repository.findAll();
    }

}
