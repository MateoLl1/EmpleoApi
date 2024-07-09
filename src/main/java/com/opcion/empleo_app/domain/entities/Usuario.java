package com.opcion.empleo_app.domain.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long id;

    @Column(name = "usu_nombre")
    private String nombre;

    @Column(name = "usu_email")
    private String email;

    @Column(name = "usu_password")
    private String password;

    @Column(name = "usu_cedula")
    private String cedula;

    @Column(name = "usu_imagen")
    private String imagen;

    @Column(name = "usu_fe_nacimiento")
    private Date feNacimiento;
    
    @Column(name = "usu_fe_registro")
    private Date feRegistro;
    
    @Column(name = "usu_sexo")
    private char sexo;
    
    @Column(name = "usu_estado")
    private char estado;

    @ManyToOne
    @JoinColumn(name = "tp_us_id")
    private TpUsuario tpUsuario;
    
    @ManyToOne
    @JoinColumn(name = "prov_id")
    private Provincia provincia;

    @ManyToMany
    @JoinTable(
        name = "tbl_postulaciones",
        joinColumns = @JoinColumn(name = "usu_id"),
        inverseJoinColumns = @JoinColumn(name = "ofe_id")
    )
    private List<Oferta> ofertas;

    public Usuario() {
        ofertas = new ArrayList<>();
    }
    
    public Usuario(Long id, String nombre, String email, String password, String cedula, String imagen,
            Date feNacimiento, Date feRegistro, char sexo, char estado) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.cedula = cedula;
        this.imagen = imagen;
        this.feNacimiento = feNacimiento;
        this.feRegistro = feRegistro;
        this.sexo = sexo;
        this.estado = estado;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFeNacimiento() {
        return feNacimiento;
    }

    public void setFeNacimiento(Date feNacimiento) {
        this.feNacimiento = feNacimiento;
    }

    public Date getFeRegistro() {
        return feRegistro;
    }

    public void setFeRegistro(Date feRegistro) {
        this.feRegistro = feRegistro;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public TpUsuario getTpUsuario() {
        return tpUsuario;
    }

    public void setTpUsuario(TpUsuario tpUsuario) {
        this.tpUsuario = tpUsuario;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }



    public List<Oferta> getOfertas() {
        return ofertas;
    }



    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    


}
