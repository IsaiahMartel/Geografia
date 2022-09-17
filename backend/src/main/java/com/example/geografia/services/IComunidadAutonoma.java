package com.example.geografia.services;

import com.example.geografia.entities.Comunidadautonoma;

import java.util.List;
import java.util.Optional;

public interface IComunidadAutonoma {
    List<Comunidadautonoma> getAll();
    Optional<Comunidadautonoma> getById(int id);
    void update(Comunidadautonoma comunidadAutonoma);
    void delete(int id);
    Comunidadautonoma add(Comunidadautonoma comunidadAutonoma);
}
