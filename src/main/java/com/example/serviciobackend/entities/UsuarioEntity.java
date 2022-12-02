package com.example.serviciobackend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;
    @Column(name = "tx_nombre")
    private String nombre;
    @Column(name = "tx_apellido")
    private String apellido;
    @Column(name = "tx_edad")
    private int edad;
    @Column(name = "tx_usuario")
    private String usuario;
    @Column(name = "tx_password")
    private String password;
    @Column(name = "tx_img_url")
    private String img_url;

}
