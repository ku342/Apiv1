package com.base.apiv1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.base.apiv1.model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiv1/producto")    

public class ProductoController {
    private List<Producto> productos = new ArrayList<>();
    public ProductoController(){
        productos.add(new Producto(1,"Mouse", 20.0,"Accesorios"));
        productos.add(new Producto(2, "Teclado", 250, "Tecnologia"));
        productos.add(new Producto(3, "Monitor", 350, "Tecnologia"));        
    }

@GetMapping
public List<Producto> getProductos(){
    return productos;
}
@GetMapping ("/{id}") 
public Producto obtenerPorId(@PathVariable int id){
    for (Producto p : productos){
        if(p.getId() == id) {
            return p;
        }
    }
    return null;
}
@PostMapping 
public Producto agregarProducto(@RequestBody Producto producto){
    productos.add(producto);
    return producto;
    
}
@PutMapping("/{id}")
public Producto actualizarProducto(
    @PathVariable int id,
    @RequestBody Producto nuevoProducto
){
    for (Producto p : productos){
        if(p.getId() == id){
            p.setNombre(nuevoProducto.getNombre());
            p.setPrecio(nuevoProducto.getPrecio());
            p.setCategoria(nuevoProducto.getCategoria());
        }
    }
    return null;
}

@PatchMapping("/{id}")
public Producto actualizarParcial(
    @PathVariable int id,
    @RequestBody Map<String, Object > cambios)
    {
        for (Producto p : productos)
            {
                if (p.getId() == id)
                {
                if (cambios.containsKey("nombre")) {
                    p.setNombre((String) cambios.get("nombre"));
                }
                if (cambios.containsKey("precio")) {
                    p.setPrecio((double) cambios.get("precio"));
                }
                if (cambios.containsKey("categoria")){
                    p.setCategoria((String) cambios.get("categoria"));
                }
                                return p;
                }
            }
            return null;
    }

@DeleteMapping("/{id}")
public String eliminarProducto(@PathVariable int id){
    for (Producto p : productos){
        if (p.getId() == id){
            productos.remove(p);
            return "Producto eliminado";
        }
    }
    return null;
}







}

