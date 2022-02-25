package com.example.geografia.services;

import com.example.geografia.entities.Comunidadautonoma;
import com.example.geografia.entities.Localidad;
import org.apache.tomcat.jni.Local;

import java.util.List;
import java.util.Optional;

public interface ILocalidad {
    List<Localidad> getAll();
    Optional<Localidad> getById(int id);
    void update(Localidad localidad);
    void delete(int id);
    Localidad add(Localidad localidad);
}
