package com.example.geografia.services;

import com.example.geografia.dao.ProvinciaDao;
import com.example.geografia.entities.Provincia;
import com.example.geografia.entities.Provincia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaImpl implements IProvincia {
    @Autowired
    ProvinciaDao provinciaDao;

    @Override
    public List<Provincia> getAll() {
        return (List<Provincia>) provinciaDao.findAll();
    }

    @Override
    public Optional<Provincia> getById(int id) {
        return provinciaDao.findById(id);
    }

    @Override
    public void update(Provincia provincia) {
        if (provinciaDao.existsById(provincia.getCodPostal())) {
            Provincia oldProvincia = provinciaDao.findById(provincia.getCodPostal()).get();
            oldProvincia.setNombre(provincia.getNombre());
            oldProvincia.setPoblacion(provincia.getPoblacion());

            oldProvincia.setFkLocalidad(provincia.getFkLocalidad());
            oldProvincia.setSuperficie(provincia.getSuperficie());

            provinciaDao.save(oldProvincia);
        }
    }

    @Override
    public void delete(int id) {
        if (provinciaDao.existsById(id)) {
            provinciaDao.deleteById(id);
        }
    }

    @Override
    public Provincia add(Provincia provincia) {
        return provinciaDao.save(provincia);
    }

}