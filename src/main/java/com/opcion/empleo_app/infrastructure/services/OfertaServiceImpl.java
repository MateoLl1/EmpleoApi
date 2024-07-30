package com.opcion.empleo_app.infrastructure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.opcion.empleo_app.domain.entities.Empresa;
import com.opcion.empleo_app.domain.entities.Oferta;
import com.opcion.empleo_app.domain.repositories.OfertaRepository;
import com.opcion.empleo_app.domain.services.OfertaService;

@Service
@Primary
public class OfertaServiceImpl implements OfertaService {

    @Autowired
    private OfertaRepository repository;

    @Override
    public List<Oferta> findAll() {
        return (List<Oferta>) repository.findAll();
    }

    @Override
    public Optional<Oferta> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Oferta save(Oferta oferta) {
        return repository.save(oferta);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Oferta> findByEmpresa(Empresa empresa) {
        return repository.findByEmpresa(empresa);
    }
    
}
