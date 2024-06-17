package com.opcion.empleo_app.domain.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;


@Entity
@Valid
@Table(name = "tbl_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long em_id;

    
    @Column(name = "em_nombre")
    private String name;

    
    @Column(name = "em_ruc")
    private String ruc;

    
    
    @Column(name = "em_owner")
    private String owner;

    
    @Column(name = "em_descripcion")
    private String descripcion;

    @Column(name = "em_logo")
    private String logo;


    @Column(name = "em_eslogan")
    private String eslogan;

    @Column(name = "em_email")
    private String email;

    
    @Column(name = "em_password")
    private String password;

    
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinTable(
        name = "tbl_empresa_provincia",
        joinColumns = @JoinColumn(name="em_id"),
        inverseJoinColumns = @JoinColumn(name="prov_id")
    )
    private List<Provincia> provincias;

    public Empresa(Long em_id, String name, String ruc, String owner, String descripcion, String logo, String eslogan,
            String email, String password) {
        this();
        this.em_id = em_id;
        this.name = name;
        this.ruc = ruc;
        this.owner = owner;
        this.descripcion = descripcion;
        this.logo = logo;
        this.eslogan = eslogan;
        this.email = email;
        this.password = password;
    }

    public Empresa() {
        provincias = new ArrayList<>();
    }

    public Long getEm_id() {
        return em_id;
    }

    public void setEm_id(Long em_id) {
        this.em_id = em_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getEslogan() {
        return eslogan;
    }

    public void setEslogan(String eslogan) {
        this.eslogan = eslogan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }
}


// {
//     "name": "Nombre de la Empresa",
//     "ruc": "1234567890123",
//     "owner": "Nombre del Propietario",
//     "descripcion": "Descripción de la empresa",
//     "logo": "URL del logo",
//     "eslogan": "Eslogan de la empresa",
//     "email": "email@empresa.com",
//     "password": "contraseña",
//     "provincias": []
//   }
  
