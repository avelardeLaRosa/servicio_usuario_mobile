package com.example.serviciobackend.controller;

import com.example.serviciobackend.dto.UsuarioDTO;
import com.example.serviciobackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
@CrossOrigin("*")
public class UsuarioRestController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar(){
        return new ResponseEntity<>(usuarioService.listaUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(
            @PathVariable(value = "id") int id
    ){
        return new ResponseEntity<>(usuarioService.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam(name = "usuario") String usuario,
            @RequestParam(name = "password") String password
    ){
        UsuarioDTO dto = usuarioService.validarLogin(usuario,password);
        if(dto==null){
            return new ResponseEntity<>("Usuario no encontrado",HttpStatus.OK);
        }
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> guardar(
            @RequestBody UsuarioDTO usuarioDTO
    ){
        return new ResponseEntity<>(usuarioService.guardar(usuarioDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> actualizar(
            @RequestBody UsuarioDTO usuarioDTO
    ){
        return new ResponseEntity<>(usuarioService.actualizar(usuarioDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizar(
            @PathVariable(value = "id") int id
    ){
        usuarioService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
