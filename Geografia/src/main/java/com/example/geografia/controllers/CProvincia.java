package com.example.geografia.controllers;

import com.example.geografia.dto.ComunidadAutonomaDto;
import com.example.geografia.entities.Comunidadautonoma;
import com.example.geografia.entities.Provincia;
import com.example.geografia.services.ComunidadAutonomaImpl;
import com.example.geografia.services.ProvinciaImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class CProvincia {
    @Autowired
    ProvinciaImpl provinciaImpl;

    @GetMapping("/provincia")
    public ResponseEntity<?> getAll(){
        try{
            return new ResponseEntity<>(provinciaImpl.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }
    @GetMapping("/provincia/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        try{
            if(provinciaImpl.getById(id).isPresent()){
                return new ResponseEntity<>(provinciaImpl.getById(id).get(), HttpStatus.OK);
            }
            return null;

        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping(value="/provincia", consumes="application/json")
    public ResponseEntity<?> add(@RequestBody String jsonProvincia) throws JsonProcessingException {
        try{
            ObjectMapper om=new ObjectMapper();
            Provincia provincia=om.readValue(jsonProvincia,Provincia.class);
            return new ResponseEntity<>(provinciaImpl.add(provincia), HttpStatus.CREATED);
        }catch (JsonProcessingException e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }

    }

    @DeleteMapping("/provincia/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id){
        try{
            provinciaImpl.delete(id);
            return new ResponseEntity<>( HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping(value="/provincia", consumes="application/json")
    public ResponseEntity<?> update(@RequestBody String jsonProvincia) throws JsonProcessingException {
        try{
            ObjectMapper om=new ObjectMapper();
            Provincia provincia=om.readValue(jsonProvincia,Provincia.class);
            provinciaImpl.update(provincia);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (JsonProcessingException e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }

    }
}