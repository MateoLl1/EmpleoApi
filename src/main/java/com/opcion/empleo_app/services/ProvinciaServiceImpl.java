package com.opcion.empleo_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opcion.empleo_app.domain.entities.Provincia;
import com.opcion.empleo_app.domain.repositories.ProvinciaRepository;
import com.opcion.empleo_app.domain.services.ProvinciaService;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinciaRepository repository;

    @Override
    public List<Provincia> findAll() {
        return (List<Provincia>) repository.findAll();
    }

    @Override
    public Optional<Provincia> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Provincia save(Provincia provincia) {
        return repository.save(provincia);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    


}
