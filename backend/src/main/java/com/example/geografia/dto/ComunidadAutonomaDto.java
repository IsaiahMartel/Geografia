package com.example.geografia.dto;

import com.example.geografia.entities.Comunidadautonoma;

public class ComunidadAutonomaDto {
    private int idComunidad;
    private String nombre;


    public ComunidadAutonomaDto() {
    }

    public ComunidadAutonomaDto(Comunidadautonoma comunidadAutonoma) {
        this.idComunidad = comunidadAutonoma.getIdComunidad();
        this.nombre = comunidadAutonoma.getNombre();
    }

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
}
