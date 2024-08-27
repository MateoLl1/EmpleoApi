package com.opcion.empleo_app.domain.services;

import java.util.List;
import java.util.Optional;

import com.opcion.empleo_app.domain.entities.Empresa;

public interface EmpresaService {

    List<Empresa> findAll();

    Empresa save(Empresa empresa);

    Optional<Empresa> findById(Long id);
    
    void deleteById(Long id);

    Optional<Empresa> login(String email,String password);

    void updatePasswordByEmail(String email,String newPassword);

}
