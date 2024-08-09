package com.opcion.empleo_app.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.opcion.empleo_app.domain.entities.Usuario;
import java.util.Optional;




public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
       
    @Query(value = "SELECT * FROM tbl_usuarios WHERE usu_email = ?1 AND usu_password = ?2", nativeQuery = true)
    Optional<Usuario> findByEmailAndPassword(String email, String password);



}
