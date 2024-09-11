package com.opcion.empleo_app.controllers;

import com.opcion.empleo_app.domain.entities.Postulacion;
import com.opcion.empleo_app.domain.repositories.PostulacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/postulacion")
public class PostulacionController {

    @Autowired
    private PostulacionRepository postulacionRepository;

   

    // Encontrar una postulación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Postulacion> getPostulacionById(@PathVariable Long id) {
        Optional<Postulacion> postulacion = postulacionRepository.findById(id);
        return postulacion.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener todas las postulaciones
    @GetMapping
    public List<Postulacion> getAllPostulaciones() {
        return postulacionRepository.findAll();
    }

    // Guardar una nueva postulación
    @PostMapping
    public ResponseEntity<Boolean> createPostulacion(@RequestParam Long ofertaId, @RequestParam Long usuarioId) {
        postulacionRepository.savePostulacion(ofertaId, usuarioId);
        return ResponseEntity.ok(true);
    }


    // Eliminar una postulación por ID de oferta y usuario
    @DeleteMapping
    public ResponseEntity<Boolean> deletePostulacion(@RequestParam Long ofertaId, @RequestParam Long usuarioId) {
        postulacionRepository.deleteByOfertaIdAndUsuarioId(ofertaId, usuarioId);
        return ResponseEntity.ok(true);
    }

    // Llamar al procedimiento almacenado
    @GetMapping("/usuariosPorOferta/{ofertaId}")
    public ResponseEntity<List<Object[]>> getUsuariosByOferta(@PathVariable Long ofertaId) {
        List<Object[]> usuarios = postulacionRepository.getUsuariosByOferta(ofertaId);
        return ResponseEntity.ok(usuarios);
    }

    
    // Llamar al procedimiento almacenado
    @GetMapping("/OfertasPorUsuario/{ofertaId}")
    public ResponseEntity<List<Object[]>> getOfertasPorUsuario(@PathVariable Long ofertaId) {
        List<Object[]> usuarios = postulacionRepository.getOfertasPorUsuario(ofertaId);
        return ResponseEntity.ok(usuarios);
    }


}
