package com.opcion.empleo_app.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.opcion.empleo_app.domain.entities.TpUsuario;

public interface TpUsuarioRepository extends CrudRepository<TpUsuario,Long> {
    
}
