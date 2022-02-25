package com.example.geografia.dao;

import com.example.geografia.entities.Provincia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaDao extends CrudRepository<Provincia, Integer> {
}
