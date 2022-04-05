package com.manuel_paracasa.paracasa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Para mapearse en una BBDD
@Entity
//Le dice al Framework que a mi modelo le llamo productos en la tabla de la BBDD
@Table(name="productos")

public class Producto{

    //Va a ser un Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private Double precio;

    
    
    public Producto() {
        super();
    }

    public Producto(Integer id, String nombre, String descripcion, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Producto [descripcion=" + descripcion + ", id=" + id + ", nombre=" + nombre + ", precio=" + precio
                + "]";
    }
    

}