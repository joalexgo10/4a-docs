package com.matPrimas.MateriasPrimas.repositories;

import com.matPrimas.MateriasPrimas.models.MateriaPrimaModel;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MateriaPrimaRepository extends MongoRepository<MateriaPrimaModel, Integer> {
}
