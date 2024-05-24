package com.opcion.empleo_app.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Entity
@Valid
@Table(name = "tbl_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long em_id;

    @NotBlank
    @Length(max = 100)
    @Column(name = "em_nombre")
    private String name;

    @NotBlank
    @Length(max = 13)
    @Column(name = "em_ruc")
    private String ruc;

    @NotBlank
    @Length(max = 100, message = "La cadena Owner solo hasta 100 caracteres")
    @Column(name = "em_owner")
    private String owner;

    @NotBlank
    @Column(name = "em_descripcion")
    private String descripcion;

    @Column(name = "em_logo")
    private String logo;

    @NotBlank
    @Column(name = "em_eslogan")
    private String eslogan;

    @NotBlank
    @Column(name = "em_email")
    private String email;

    @NotBlank
    @Column(name = "em_password")
    private String password;

}
