package com.example.geografia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Localidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idlocalidad", nullable = false)
    private int idLocalidad;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "poblacion", nullable = false)
    private int poblacion;
    @JsonIgnore
    @OneToMany(mappedBy = "localidadByFkLocalidad")
    private Collection<Provincia> provinciasByIdLocalidad;

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localidad localidad = (Localidad) o;
        return idLocalidad == localidad.idLocalidad && poblacion == localidad.poblacion && Objects.equals(nombre, localidad.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLocalidad, nombre, poblacion);
    }

    public Collection<Provincia> getProvinciasByIdLocalidad() {
        return provinciasByIdLocalidad;
    }

    public void setProvinciasByIdLocalidad(Collection<Provincia> provinciasByIdLocalidad) {
        this.provinciasByIdLocalidad = provinciasByIdLocalidad;
    }
}
