package com.opcion.empleo_app.infrastructure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opcion.empleo_app.domain.entities.Empresa;
import com.opcion.empleo_app.domain.repositories.EmpresaRepository;
import com.opcion.empleo_app.domain.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Override
    public List<Empresa> findAll() {
        return (List<Empresa>) repository.findAll();
    }

    @Override
    public Empresa save(Empresa empresa) {
        return repository.save(empresa);
    }

    @Override
    public Optional<Empresa> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }



    

}
