package com.opcion.empleo_app.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.opcion.empleo_app.domain.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    
}
