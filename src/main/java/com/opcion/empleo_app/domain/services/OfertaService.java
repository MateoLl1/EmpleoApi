package com.opcion.empleo_app.domain.services;

import java.util.List;
import java.util.Optional;

import com.opcion.empleo_app.domain.entities.Oferta;

public interface OfertaService {
    

    List<Oferta> findAll();

    Optional<Oferta> findById(Long id);

    Oferta save(Oferta oferta);

    void deleteById(Long id);

}
