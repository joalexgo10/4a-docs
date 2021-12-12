package com.matPrimas.MateriasPrimas.controllers;

import com.matPrimas.MateriasPrimas.exceptions.MateriaPrimaNotFoundException;
import com.matPrimas.MateriasPrimas.models.MateriaPrimaModel;
import com.matPrimas.MateriasPrimas.repositories.MateriaPrimaRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/materiaPrimas")
public class MateriaPrimaController {

    private final MateriaPrimaRepository materiaPrimaRepository;

    public MateriaPrimaController(MateriaPrimaRepository materiaPrimaRepository){
        this.materiaPrimaRepository=materiaPrimaRepository;
    }
    
    /*Request para obtener todos los registros de la base de datos*/
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listAll(){
        return ResponseEntity.ok(materiaPrimaRepository.findAll());
    }

    /*Request para buscar un registro por ID en la base de datos*/
    @GetMapping(value = "/by/{materiaPrima_codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MateriaPrimaModel getMateriaPrimaModel(@PathVariable Integer materiaPrima_codigo){ 
        return materiaPrimaRepository.findById(materiaPrima_codigo).orElseThrow(()->new MateriaPrimaNotFoundException("Registro no encontrado"));
    }

    /*Request para guardar un registro en la base de datos*/
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> newMateriaPrimaModel(@RequestBody MateriaPrimaModel materiaPrimaModel){
        
        materiaPrimaRepository.save(materiaPrimaModel);
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
    /*Request para actualizar un registro en la base de datos*/
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@RequestBody MateriaPrimaModel materiaPrima){
        materiaPrimaRepository.save(materiaPrima);
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
    /*Request para eliminar un registro por ID a la base de datos*/
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        
        materiaPrimaRepository.deleteById(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
