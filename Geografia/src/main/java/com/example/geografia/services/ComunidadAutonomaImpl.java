package com.example.geografia.services;

import com.example.geografia.dao.ComunidadAutonomaDao;
import com.example.geografia.entities.Comunidadautonoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ComunidadAutonomaImpl implements IComunidadAutonoma{
    @Autowired
    ComunidadAutonomaDao comunidadAutonomaDao;
    @Override
    public List<Comunidadautonoma> getAll() {
        return (List<Comunidadautonoma>) comunidadAutonomaDao.findAll();
    }

    @Override
    public Optional<Comunidadautonoma> getById(int id) {
        return comunidadAutonomaDao.findById(id);
    }

    @Override
    public void update(Comunidadautonoma comunidadAutonoma) {
        if(comunidadAutonomaDao.existsById(comunidadAutonoma.getIdComunidad())){
            Comunidadautonoma oldComunidadautonoma=comunidadAutonomaDao.findById(comunidadAutonoma.getIdComunidad()).get();
            oldComunidadautonoma.setFkPostal(comunidadAutonoma.getFkPostal());
            oldComunidadautonoma.setNombre(comunidadAutonoma.getNombre());
            oldComunidadautonoma.setPoblacion(comunidadAutonoma.getPoblacion());
            oldComunidadautonoma.setSuperficie(comunidadAutonoma.getSuperficie());
            comunidadAutonomaDao.save(oldComunidadautonoma);
        }
    }

    @Override
    public void delete(int id) {
        if(comunidadAutonomaDao.existsById(id)){
         comunidadAutonomaDao.deleteById(id);
        }
    }

    @Override
    public Comunidadautonoma add(Comunidadautonoma comunidadAutonoma) {
        return comunidadAutonomaDao.save(comunidadAutonoma);
    }
}
