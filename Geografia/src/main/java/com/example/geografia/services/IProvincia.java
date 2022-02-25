package com.example.geografia.services;

import com.example.geografia.entities.Provincia;

import java.util.List;
import java.util.Optional;

public interface IProvincia {
    List<Provincia> getAll();
    Optional<Provincia> getById(int id);
    void update(Provincia provincia);
    void delete(int id);
    Provincia add(Provincia provincia);
}
