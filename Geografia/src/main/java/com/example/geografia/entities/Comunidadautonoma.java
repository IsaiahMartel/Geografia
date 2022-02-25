package com.example.geografia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="comunidadautonoma")
public class Comunidadautonoma {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcomunidad", nullable = false)
    private int idComunidad;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "poblacion", nullable = false)
    private int poblacion;
    @Basic
    @Column(name = "superficie", nullable = false)
    private int superficie;
    @Basic
    @Column(name = "fkpostal", nullable = false)
    private int fkPostal;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fkpostal", referencedColumnName = "codpostal", nullable = false, insertable = false, updatable = false)
    private Provincia provinciaByFkPostal;

    public int getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(int idComunidad) {
        this.idComunidad = idComunidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getFkPostal() {
        return fkPostal;
    }

    public void setFkPostal(int fkPostal) {
        this.fkPostal = fkPostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comunidadautonoma that = (Comunidadautonoma) o;
        return idComunidad == that.idComunidad && poblacion == that.poblacion && superficie == that.superficie && fkPostal == that.fkPostal && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComunidad, nombre, poblacion, superficie, fkPostal);
    }

    public Provincia getProvinciaByFkPostal() {
        return provinciaByFkPostal;
    }

    public void setProvinciaByFkPostal(Provincia provinciaByFkPostal) {
        this.provinciaByFkPostal = provinciaByFkPostal;
    }
}
