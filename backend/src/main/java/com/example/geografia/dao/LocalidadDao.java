package com.example.geografia.dao;

import com.example.geografia.entities.Localidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadDao extends CrudRepository<Localidad, Integer> {
}
