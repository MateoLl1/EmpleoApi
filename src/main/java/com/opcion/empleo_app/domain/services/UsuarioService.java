package com.opcion.empleo_app.domain.services;

import java.util.List;
import java.util.Optional;

import com.opcion.empleo_app.domain.entities.Usuario;

public interface UsuarioService {
    
    List<Usuario> findAll();

    Usuario save(Usuario usuario);

    Optional<Usuario> findById(Long id);

    void deleteById(Long id);

    Optional<Usuario> login(String email,String password);

}
