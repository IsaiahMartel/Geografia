package com.example.geografia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity

public class Provincia {

    @Id
    @Column(name = "codpostal", nullable = false)
    private int codPostal;
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
    @Column(name = "fklocalidad", nullable = false)
    private int fkLocalidad;
    @JsonIgnore
    @OneToMany(mappedBy = "provinciaByFkPostal")
    private Collection<Comunidadautonoma> comunidadautonomasByCodPostal;
    @ManyToOne
    @JoinColumn(name = "fklocalidad", referencedColumnName = "idlocalidad", nullable = false, insertable = false, updatable = false)
    private Localidad localidadByFkLocalidad;

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
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

    public int getFkLocalidad() {
        return fkLocalidad;
    }

    public void setFkLocalidad(int fkLocalidad) {
        this.fkLocalidad = fkLocalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return codPostal == provincia.codPostal && poblacion == provincia.poblacion && superficie == provincia.superficie && fkLocalidad == provincia.fkLocalidad && Objects.equals(nombre, provincia.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPostal, nombre, poblacion, superficie, fkLocalidad);
    }

    public Collection<Comunidadautonoma> getComunidadautonomasByCodPostal() {
        return comunidadautonomasByCodPostal;
    }

    public void setComunidadautonomasByCodPostal(Collection<Comunidadautonoma> comunidadautonomasByCodPostal) {
        this.comunidadautonomasByCodPostal = comunidadautonomasByCodPostal;
    }

    public Localidad getLocalidadByFkLocalidad() {
        return localidadByFkLocalidad;
    }

    public void setLocalidadByFkLocalidad(Localidad localidadByFkLocalidad) {
        this.localidadByFkLocalidad = localidadByFkLocalidad;
    }
}
