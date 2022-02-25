package com.example.geografia.dao;

import com.example.geografia.entities.Comunidadautonoma;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunidadAutonomaDao extends CrudRepository<Comunidadautonoma,Integer> {

}
