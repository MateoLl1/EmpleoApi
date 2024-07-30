package com.opcion.empleo_app.domain.repositories;



import org.springframework.data.repository.CrudRepository;

import com.opcion.empleo_app.domain.entities.Empresa;
import com.opcion.empleo_app.domain.entities.Oferta;
import java.util.List;




public interface OfertaRepository extends CrudRepository<Oferta,Long> {
 
    List<Oferta> findByEmpresa(Empresa empresa);

}
