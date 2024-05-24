package com.opcion.empleo_app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opcion.empleo_app.entities.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

}
