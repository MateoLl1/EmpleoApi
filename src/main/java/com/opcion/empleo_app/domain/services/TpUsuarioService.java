package com.opcion.empleo_app.domain.services;

import java.util.List;
import java.util.Optional;

import com.opcion.empleo_app.domain.entities.TpUsuario;

public interface TpUsuarioService {
    
    List<TpUsuario> findAll();

    Optional<TpUsuario> findById(Long id);

    void deleteById(Long id);

    TpUsuario save(TpUsuario tpUsuario);

}
