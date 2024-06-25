package com.opcion.empleo_app.infrastructure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.opcion.empleo_app.domain.entities.TpUsuario;
import com.opcion.empleo_app.domain.repositories.TpUsuarioRepository;
import com.opcion.empleo_app.domain.services.TpUsuarioService;

@Service
@Primary
public class TpUsuarioServiceImpl implements TpUsuarioService {

    @Autowired
    private TpUsuarioRepository repository;

    @Override
    public List<TpUsuario> findAll() {
        return (List<TpUsuario>) repository.findAll();
    }

    @Override
    public Optional<TpUsuario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public TpUsuario save(TpUsuario tpUsuario) {
        return repository.save(tpUsuario);
    }
    
}
