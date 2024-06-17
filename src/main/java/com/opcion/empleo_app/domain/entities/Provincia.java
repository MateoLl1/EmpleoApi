package com.opcion.empleo_app.domain.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tbl_provincia")
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prov_id")
    private Long id;

    @Column(name = "prov_nombre")
    private String nombre;


    public Provincia() {
    }

    public Provincia(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
