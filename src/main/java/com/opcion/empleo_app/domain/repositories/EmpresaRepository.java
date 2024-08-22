package com.opcion.empleo_app.domain.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opcion.empleo_app.domain.entities.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

    @Query(value = "SELECT * FROM tbl_empresa WHERE em_email = ?1 AND em_password = ?2", nativeQuery = true)
    Optional<Empresa> findByEmailAndPassword(String email, String password);


}
