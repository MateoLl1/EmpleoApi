package com.opcion.empleo_app.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.opcion.empleo_app.domain.entities.Postulacion;

import jakarta.transaction.Transactional;

@Repository
public interface PostulacionRepository extends CrudRepository<Postulacion,Long> {
    

    // Encontrar una postulación por ID
    @Query(value = "SELECT * FROM tbl_postulaciones WHERE id = ?1", nativeQuery = true)
    Optional<Postulacion> findById(Long id);

    // Obtener todas las postulaciones
    @Query(value = "SELECT * FROM tbl_postulaciones", nativeQuery = true)
    List<Postulacion> findAll();

    // Guardar una nueva postulación
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tbl_postulaciones (ofe_id, usu_id) VALUES (?1, ?2)", nativeQuery = true)
    void savePostulacion(Long ofertaId, Long usuarioId);

    // Actualizar una postulación por ID
    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_postulaciones SET ofe_id = ?2, usu_id = ?3 WHERE id = ?1", nativeQuery = true)
    void updatePostulacion(Long id, Long ofertaId, Long usuarioId);

     // Eliminar una postulación por ID de oferta y usuario
     @Modifying
     @Transactional
     @Query(value = "DELETE FROM tbl_postulaciones WHERE ofe_id = ?1 AND usu_id = ?2", nativeQuery = true)
     void deleteByOfertaIdAndUsuarioId(Long ofertaId, Long usuarioId);


    // Llamar al procedimiento almacenado
    @Query(value = "CALL GetUsuariosByOferta(?1)", nativeQuery = true)
    List<Object[]> getUsuariosByOferta(Long ofertaId);

    
    @Query(value = "CALL ObtenerOfertasPorUsuario(:usuId)", nativeQuery = true)
    List<Object[]> getOfertasPorUsuario(@Param("usuId") Long usuarioId);

    
}
