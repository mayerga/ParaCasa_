package com.manuel_paracasa.paracasa.controller;

import com.manuel_paracasa.paracasa.model.Producto;
import com.manuel_paracasa.paracasa.repository.ProductoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos") //Definir un paths al cual vamos a apuntar después de la url para acceder a este controlador--> http:localhost:8080/productos
public class ProductoController {

    //Para ver qué es lo que hace el log y no usar el típito Syout.
    private final Logger logg= LoggerFactory.getLogger(Producto.class);

    //Definición del objeto. A través de este objeto tendremos alcance a los métodos CRUD
    @Autowired
    private ProductoRepository productoRepository;
    
    //Método principal que retorna un String.
    @GetMapping("")
    public String home(Model model){
        //A través del repository, traigo todos los productos de la BBDD.
        model.addAttribute("productos", productoRepository.findAll());
        return "home";
    }

    //Método que nos lleve hasta la vista
    @GetMapping("/create") //http:localhost:8080/productos/create
    public String create(){
        return "create";
    }

    //Método que recibe un objeto de tipo Producto
    @PostMapping("/save")
    public String save(Producto producto){
        logg.info("Información del objeto producto, {}", producto);
        //variable utilizando el método save pasándole la entidad objeto
        productoRepository.save(producto);

        return "redirect:/productos";
    }

    //Método que redireccione a la vista
    @GetMapping("/edit/{id}")
    public String edit( @PathVariable Integer id, Model model){
        Producto p = productoRepository.getById(id);
        logg.info("Objeto recuperado {}", p);
        model.addAttribute("producto", p);
        return "edit";
    }

    //Método que nos permita eliminar
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Producto p=productoRepository.getById(id);
        logg.info("Ovjeto eliminado {}", p);
        productoRepository.delete(p);

        return "redirect:/productos";
    }
}
