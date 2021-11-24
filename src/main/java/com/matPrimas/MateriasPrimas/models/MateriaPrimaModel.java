package com.matPrimas.MateriasPrimas.models;

import org.springframework.data.annotation.Id;

public class MateriaPrimaModel {

    @Id
    private Integer materiaPrima_codigo;
    private String materiaPrima_categoria_id;
    private String materiaPrima_descripcion;
    private double materiaPrima_existencias;
    private String materiaPrima_unidad;
    private Integer[] proveedoresId;

    public MateriaPrimaModel(Integer materiaPrima_codigo, String materiaPrima_categoria_id, String materiaPrima_descripcion, double materiaPrima_existencias, String materiaPrima_unidad, Integer[] proveedoresId) {
        this.materiaPrima_codigo = materiaPrima_codigo;
        this.materiaPrima_categoria_id = materiaPrima_categoria_id;
        this.materiaPrima_descripcion = materiaPrima_descripcion;
        this.materiaPrima_existencias = materiaPrima_existencias;
        this.materiaPrima_unidad = materiaPrima_unidad;
        this.proveedoresId = proveedoresId;
    }

    public Integer getMateriaPrima_codigo() {
        return materiaPrima_codigo;
    }

    public void setMateriaPrima_codigo(Integer materiaPrima_codigo) {
        this.materiaPrima_codigo = materiaPrima_codigo;
    }

    public String getMateriaPrima_categoria_id() {
        return materiaPrima_categoria_id;
    }

    public void setMateriaPrima_categoria_id(String materiaPrima_categoria_id) {
        this.materiaPrima_categoria_id = materiaPrima_categoria_id;
    }

    public String getMateriaPrima_descripcion() {
        return materiaPrima_descripcion;
    }

    public void setMateriaPrima_descripcion(String materiaPrima_descripcion) {
        this.materiaPrima_descripcion = materiaPrima_descripcion;
    }

    public double getMateriaPrima_existencias() {
        return materiaPrima_existencias;
    }

    public void setMateriaPrima_existencias(double materiaPrima_existencias) {
        this.materiaPrima_existencias = materiaPrima_existencias;
    }

    public String getMateriaPrima_unidad() {
        return materiaPrima_unidad;
    }

    public void setMateriaPrima_unidad(String materiaPrima_unidad) {
        this.materiaPrima_unidad = materiaPrima_unidad;
    }

    public Integer[] getProveedoresId() {
        return proveedoresId;
    }

    public void setProveedoresId(Integer[] proveedoresId) {
        this.proveedoresId = proveedoresId;
    }
}
