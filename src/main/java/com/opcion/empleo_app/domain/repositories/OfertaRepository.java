package com.opcion.empleo_app.domain.repositories;


import org.springframework.data.repository.CrudRepository;

import com.opcion.empleo_app.domain.entities.Oferta;

public interface OfertaRepository extends CrudRepository<Oferta,Long> {
    
}
