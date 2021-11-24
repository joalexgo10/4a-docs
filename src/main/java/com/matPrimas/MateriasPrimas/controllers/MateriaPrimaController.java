package com.matPrimas.MateriasPrimas.controllers;

import com.matPrimas.MateriasPrimas.exceptions.MateriaPrimaNotFoundException;
import com.matPrimas.MateriasPrimas.models.MateriaPrimaModel;
import com.matPrimas.MateriasPrimas.repositories.MateriaPrimaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class MateriaPrimaController {

    private final MateriaPrimaRepository materiaPrimaRepository;

    public MateriaPrimaController(MateriaPrimaRepository materiaPrimaRepository){
        this.materiaPrimaRepository=materiaPrimaRepository;
    }

    @GetMapping("/materiasPrimas/{materiaPrima_codigo}")
    MateriaPrimaModel getMateriaPrimaModel(@PathVariable Integer materiaPrima_codigo){ return materiaPrimaRepository.findById(materiaPrima_codigo).orElseThrow(()->new MateriaPrimaNotFoundException("Hola"));}

    @PostMapping("/materiasPrimas/")
    MateriaPrimaModel newMateriaPrimaModel(@RequestBody MateriaPrimaModel materiaPrimaModel){
        return materiaPrimaRepository.save(materiaPrimaModel);
    }
}
