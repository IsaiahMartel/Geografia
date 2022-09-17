package com.example.geografia.controllers;

import com.example.geografia.dto.ComunidadAutonomaDto;
import com.example.geografia.entities.Comunidadautonoma;
import com.example.geografia.services.ComunidadAutonomaImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class CAutonomaController {
    @Autowired
    ComunidadAutonomaImpl comunidadAutonomaImpl;

    @GetMapping("/comunidad-autonoma")
    public ResponseEntity<?> getAll(){
        try{
            return new ResponseEntity<>(comunidadAutonomaImpl.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }
    @GetMapping("/comunidad-autonoma/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        try{
            if(comunidadAutonomaImpl.getById(id).isPresent()){
                return new ResponseEntity<>(comunidadAutonomaImpl.getById(id).get(), HttpStatus.OK);
            }
            return null;
            // return new ResponseEntity<>(new ComunidadAutonomaDto(),HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping(value="/comunidad-autonoma", consumes="application/json")
    public ResponseEntity<?> add(@RequestBody String jsonComunidadAutonoma) throws JsonProcessingException {
       try{
           ObjectMapper om=new ObjectMapper();
           Comunidadautonoma comunidadAutonoma=om.readValue(jsonComunidadAutonoma,Comunidadautonoma.class);
           return new ResponseEntity<>(comunidadAutonomaImpl.add(comunidadAutonoma), HttpStatus.CREATED);
       }catch (JsonProcessingException e){
           return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
       }catch (Exception e){
           return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
       }

    }

    @DeleteMapping("/comunidad-autonoma/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id){
        try{
            comunidadAutonomaImpl.delete(id);
            return new ResponseEntity<>( HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping(value="/comunidad-autonoma", consumes="application/json")
    public ResponseEntity<?> update(@RequestBody String jsonComunidadAutonoma) throws JsonProcessingException {
        try{
            ObjectMapper om=new ObjectMapper();
            Comunidadautonoma comunidadAutonoma=om.readValue(jsonComunidadAutonoma,Comunidadautonoma.class);
            comunidadAutonomaImpl.update(comunidadAutonoma);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (JsonProcessingException e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }catch (Exception e){
            return new ResponseEntity<>(new String(e.getMessage()),HttpStatus.FORBIDDEN);
        }

    }
}
