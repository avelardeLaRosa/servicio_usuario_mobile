package com.example.serviciobackend.repository;

import com.example.serviciobackend.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Integer> {

    Optional<UsuarioEntity> findByUsuarioAndPassword(String usuario, String password);
}
