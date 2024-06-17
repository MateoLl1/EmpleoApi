package com.opcion.empleo_app.domain.services;

import java.util.List;
import java.util.Optional;

import com.opcion.empleo_app.domain.entities.Provincia;

public interface ProvinciaService {
    
    List<Provincia> findAll();

    Optional<Provincia> findById(Long id);

    Provincia save(Provincia provincia);

    void deleteById(Long id);
}
