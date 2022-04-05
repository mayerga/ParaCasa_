package com.manuel_paracasa.paracasa.repository;

import com.manuel_paracasa.paracasa.model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interfaz con todos los métodos CRUD
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
}
