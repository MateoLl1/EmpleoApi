package com.opcion.empleo_app.infrastructure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.opcion.empleo_app.domain.entities.Usuario;
import com.opcion.empleo_app.domain.repositories.UsuarioRepository;
import com.opcion.empleo_app.domain.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) repository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    public Page<Usuario> findAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Usuario> login(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    @Override
    public void updatePasswordByEmail(String email, String newPassword) {
        repository.updatePasswordByEmail(email, newPassword);
    }

    
    
}
