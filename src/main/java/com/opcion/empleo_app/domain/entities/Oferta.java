package com.opcion.empleo_app.domain.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_oferta")
public class Oferta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ofe_id")
    private Long id;

    @Column(name = "ofe_titulo")
    private String titulo;

    @Column(name = "ofe_subtitulo")
    private String subTitulo;

    @Column(name = "ofe_descripcion")
    private String descripcion;
    
    @Column(name = "ofe_modalidad")
    private String modalidad;
    
    @Column(name = "ofe_ubicacion")
    private String ubicacion;
    
    @Column(name = "ofe_area")
    private String area;
    
    @Column(name = "ofe_tiempo")
    private String tiempo;
    
    @Column(name = "ofe_vacantes")
    private int vacantes;
    
    @Column(name = "ofe_experiencia")
    private String experiencia;
    
    @Column(name = "ofe_salario")
    private Float salario;
    
    @Column(name = "ofe_fe_registro")
    private Date fechaRegistro;
    
    @Column(name = "ofe_estado")
    private char estado;
    
    @ManyToOne
    @JoinColumn(name = "em_id")
    private Empresa empresa;

    @ManyToMany
    private List<Usuario> usuarios;

    public Oferta() {
        usuarios = new ArrayList<>();
    }



    public Oferta(Long id, String titulo, String subTitulo, String descripcion, String modalidad, String ubicacion,
            String area, String tiempo, int vacantes, String experiencia, Float salario, Date fechaRegistro,
            char estado, Empresa empresa) {
        this();
        this.id = id;
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
        this.ubicacion = ubicacion;
        this.area = area;
        this.tiempo = tiempo;
        this.vacantes = vacantes;
        this.experiencia = experiencia;
        this.salario = salario;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.empresa = empresa;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getTitulo() {
        return titulo;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public String getSubTitulo() {
        return subTitulo;
    }



    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public String getModalidad() {
        return modalidad;
    }



    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }



    public String getUbicacion() {
        return ubicacion;
    }



    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }



    public String getArea() {
        return area;
    }



    public void setArea(String area) {
        this.area = area;
    }



    public String getTiempo() {
        return tiempo;
    }



    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }



    public int getVacantes() {
        return vacantes;
    }



    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }



    public String getExperiencia() {
        return experiencia;
    }



    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }



    public Float getSalario() {
        return salario;
    }



    public void setSalario(Float salario) {
        this.salario = salario;
    }



    public Date getFechaRegistro() {
        return fechaRegistro;
    }



    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }



    public char getEstado() {
        return estado;
    }



    public void setEstado(char estado) {
        this.estado = estado;
    }



    public Empresa getEmpresa() {
        return empresa;
    }



    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }



    public List<Usuario> getUsuarios() {
        return usuarios;
    }



    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

// {
//     "id": 1,
//     "titulo": "Título de Ejemplo",
//     "subTitulo": "Subtítulo de Ejemplo",
//     "descripcion": "Descripción de Ejemplo",
//     "modalidad": "Modalidad de Ejemplo",
//     "ubicacion": "Ubicación de Ejemplo",
//     "area": "Área de Ejemplo",
//     "tiempo": "Tiempo de Ejemplo",
//     "vacantes": 5,
//     "experiencia": "Experiencia de Ejemplo",
//     "salario": 35000.00,
//     "fechaRegistro": "2023-06-25T00:00:00",
//     "estado": "A",
//     "empresa": {
//       "em_id": 1
//       // "nombre": "Empresa de Ejemplo"
//     }
//   }
  
