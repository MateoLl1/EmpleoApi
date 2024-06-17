package com.opcion.empleo_app.domain.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opcion.empleo_app.domain.entities.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

    


}
