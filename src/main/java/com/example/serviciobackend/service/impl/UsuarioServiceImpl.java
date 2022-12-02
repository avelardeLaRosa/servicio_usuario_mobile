package com.example.serviciobackend.service.impl;

import com.example.serviciobackend.dto.UsuarioDTO;
import com.example.serviciobackend.entities.UsuarioEntity;
import com.example.serviciobackend.repository.UsuarioRepository;
import com.example.serviciobackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioDTO> listaUsuarios() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOS = usuarios.stream()
                .map(u->{
                    UsuarioDTO usuarioDTO=new UsuarioDTO();
                    usuarioDTO.setId(u.getId());
                    usuarioDTO.setNombre(u.getNombre());
                    usuarioDTO.setApellido(u.getApellido());
                    usuarioDTO.setEdad(u.getEdad());
                    usuarioDTO.setUsuario(u.getUsuario());
                    usuarioDTO.setPassword(u.getPassword());
                    usuarioDTO.setImg_url(u.getImg_url());
                    return usuarioDTO;
                }).collect(Collectors.toList());
        return usuarioDTOS;
    }

    @Override
    public UsuarioDTO guardar(UsuarioDTO usuarioDTO) {

        UsuarioEntity u = new UsuarioEntity();
        u.setNombre(usuarioDTO.getNombre());
        u.setApellido(usuarioDTO.getApellido());
        u.setEdad(usuarioDTO.getEdad());
        u.setUsuario(usuarioDTO.getUsuario());
        u.setPassword(usuarioDTO.getPassword());
        u.setImg_url(usuarioDTO.getImg_url());

        UsuarioEntity nuevoUser = usuarioRepository.save(u);

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(nuevoUser.getId());
        dto.setNombre(nuevoUser.getNombre());
        dto.setApellido(nuevoUser.getApellido());
        dto.setEdad(nuevoUser.getEdad());
        dto.setUsuario(nuevoUser.getUsuario());
        dto.setPassword(nuevoUser.getPassword());
        dto.setImg_url(nuevoUser.getImg_url());
        return dto;
    }

    @Override
    public UsuarioDTO actualizar(UsuarioDTO usuarioDTO) {

        UsuarioEntity user = usuarioRepository.findById(usuarioDTO.getId()).get();

        user.setNombre(usuarioDTO.getNombre());
        user.setApellido(usuarioDTO.getApellido());
        user.setEdad(usuarioDTO.getEdad());
        user.setUsuario(usuarioDTO.getUsuario());
        user.setPassword(usuarioDTO.getPassword());
        user.setImg_url(usuarioDTO.getImg_url());

        UsuarioEntity nuevoUser = usuarioRepository.save(user);

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(nuevoUser.getId());
        dto.setNombre(nuevoUser.getNombre());
        dto.setApellido(nuevoUser.getApellido());
        dto.setEdad(nuevoUser.getEdad());
        dto.setUsuario(nuevoUser.getUsuario());
        dto.setPassword(nuevoUser.getPassword());
        dto.setImg_url(nuevoUser.getImg_url());
        return dto;
    }

    @Override
    public UsuarioDTO buscarPorId(int id) {
        UsuarioEntity user = usuarioRepository.findById(id).get();
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(user.getId());
        dto.setNombre(user.getNombre());
        dto.setApellido(user.getApellido());
        dto.setEdad(user.getEdad());
        dto.setUsuario(user.getUsuario());
        dto.setPassword(user.getPassword());
        dto.setImg_url(user.getImg_url());
        return dto;
    }

    @Override
    public void eliminar(int id) {
        usuarioRepository.deleteById(id);
    }


    @Override
    public UsuarioDTO validarLogin(String usuario, String password) {
        Optional<UsuarioEntity> u = usuarioRepository.findByUsuarioAndPassword(usuario,password);
        if(u.isEmpty()){
            return null;
        }
        UsuarioEntity usuarioEntity = u.get();
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuarioEntity.getId());
        dto.setNombre(usuarioEntity.getNombre());
        dto.setApellido(usuarioEntity.getApellido());
        dto.setEdad(usuarioEntity.getEdad());
        dto.setUsuario(usuarioEntity.getUsuario());
        dto.setPassword(usuarioEntity.getPassword());
        dto.setImg_url(usuarioEntity.getImg_url());
        return dto;
    }
}
