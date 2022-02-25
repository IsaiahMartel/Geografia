package com.example.geografia.services;

import com.example.geografia.dao.ComunidadAutonomaDao;
import com.example.geografia.dao.LocalidadDao;
import com.example.geografia.entities.Comunidadautonoma;
import com.example.geografia.entities.Localidad;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadImpl implements ILocalidad {
    @Autowired
    LocalidadDao localidadDao;

    @Override
    public List<Localidad> getAll() {
        return (List<Localidad>) localidadDao.findAll();
    }

    @Override
    public Optional<Localidad> getById(int id) {
        return localidadDao.findById(id);
    }

    @Override
    public void update(Localidad localidad) {
        if (localidadDao.existsById(localidad.getIdLocalidad())) {
            Localidad oldLocalidad = localidadDao.findById(localidad.getIdLocalidad()).get();
            oldLocalidad.setNombre(localidad.getNombre());
            oldLocalidad.setPoblacion(localidad.getPoblacion());

            localidadDao.save(oldLocalidad);
        }
    }

    @Override
    public void delete(int id) {
        if (localidadDao.existsById(id)) {
            localidadDao.deleteById(id);
        }
    }

    @Override
    public Localidad add(Localidad localidad) {
        return localidadDao.save(localidad);
    }

}

