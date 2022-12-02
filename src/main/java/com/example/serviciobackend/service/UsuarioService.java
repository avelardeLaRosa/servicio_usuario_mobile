package com.example.serviciobackend.service;

import com.example.serviciobackend.dto.UsuarioDTO;
import com.example.serviciobackend.entities.UsuarioEntity;
import com.example.serviciobackend.util.IGenericCrud;

import java.util.Optional;

public interface UsuarioService extends IGenericCrud<UsuarioDTO> {

    UsuarioDTO validarLogin(String usuario, String password);

}
