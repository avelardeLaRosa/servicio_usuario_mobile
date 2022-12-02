package com.example.serviciobackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String usuario;
    private String password;
    private String img_url;


}
