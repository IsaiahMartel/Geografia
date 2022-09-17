package com.example.geografia.controllers;

import com.example.geografia.dto.ComunidadAutonomaDto;
import com.example.geografia.entities.Comunidadautonoma;
import com.example.geografia.entities.Localidad;
import com.example.geografia.services.ComunidadAutonomaImpl;
import com.example.geografia.services.LocalidadImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class CLocalidad {
    @Autowired
    LocalidadImpl localidadImpl;

    @GetMapping("/localidad")
    public ResponseEntity<?> getAll(){
        try{
            return new ResponseEntity<>(localidadImpl.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }
    @GetMapping("/localidad/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        try{
            if(localidadImpl.getById(id).isPresent()){
                return new ResponseEntity<>(localidadImpl.getById(id).get(), HttpStatus.OK);
            }
            return null;

        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping(value="/localidad", consumes="application/json")
    public ResponseEntity<?> add(@RequestBody String jsonLocalidad) throws JsonProcessingException {
        try{
            ObjectMapper om=new ObjectMapper();
            Localidad localidad=om.readValue(jsonLocalidad,Localidad.class);
            return new ResponseEntity<>(localidadImpl.add(localidad), HttpStatus.CREATED);
        }catch (JsonProcessingException e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }

    }

    @DeleteMapping("/localidad/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id){
        try{
            localidadImpl.delete(id);
            return new ResponseEntity<>( HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping(value="/localidad", consumes="application/json")
    public ResponseEntity<?> update(@RequestBody String jsonLocalidad) throws JsonProcessingException {
        try{
            ObjectMapper om=new ObjectMapper();
            Localidad localidad=om.readValue(jsonLocalidad,Localidad.class);
            localidadImpl.update(localidad);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (JsonProcessingException e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }

    }
}