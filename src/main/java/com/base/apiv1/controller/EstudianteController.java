package com.base.apiv1.controller;
import com.base.apiv1.model.Estudiante;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.ArrayList;



@RestController
@RequestMapping("/apiv1/estudiantes")
public class EstudianteController {
    private List<Estudiante> estudiantes = new ArrayList<>();
    public EstudianteController() {
        estudiantes.add(new Estudiante(1, "Juan", "Perez","Ingenieria",20));
        estudiantes.add(new Estudiante(2, "Maria", "Gomez","Medicina", 22));
        estudiantes.add(new Estudiante(3, "Carlos", "Lopez", "Biologia", 21));
    }

@GetMapping
public List<Estudiante> getEstudiantes() 
    {
        return estudiantes;
    }

@GetMapping("/{id}")
public Estudiante obtenerPorId(@PathVariable int id) 
    {
        for (Estudiante e : estudiantes)
            {
            if ( e.getId() == id)
                {
                    return e;
                }
            }
        return null;
    }

@PostMapping 
public Estudiante agregarEstudiante(@RequestBody Estudiante estudiante)
    {   
        int nuevoId = (estudiantes.size() + 1);
        estudiante.setId(nuevoId);
        estudiantes.add(estudiante);

        return estudiante;
    }

@PutMapping("/{id}")
public Estudiante actualizarEstudiante(
    @PathVariable int id,
    @RequestBody Estudiante nuevoestudiantes
){
    for ( Estudiante e : estudiantes ) 
    {
        if ( e.getId() == id ) {
        e.setNombre(nuevoestudiantes.getNombre());
        e.setApellido(nuevoestudiantes.getApellido());
        e.setCarrera(nuevoestudiantes.getCarrera());
        }
    }

    return null;
}
    
@PatchMapping("/{id}")
public Estudiante actualizarParcial( 
    @PathVariable int id,
    @RequestBody Map<String, Object> cambios
){
    for (Estudiante e : estudiantes )
        {
            if ( e.getId() == id )
                {                
                    if (cambios.containsKey("nombre")) 
                        {
                            e.setNombre((String) cambios.get("nombre") );
                        }
                        if ( cambios.containsKey("apellido") ) {
                            e.setApellido((String) cambios.get("apellido"));
                        }
                        if (cambios.containsKey("Carrera")){
                            e.setCarrera((String) cambios.get("carrera"));
                        }
                        if (cambios.containsKey("edad")){
                            e.setEdad((int) cambios.get ("edad"));
                        }
                return e;                          
                }
        }
    return null;
}

@DeleteMapping("/{id}")
public Estudiante eliminarEstudiante(@PathVariable int id){
    for (Estudiante e : estudiantes) 
    {
        if ( e.getId() == id ) {
            estudiantes.remove(e);
            System.out.println("Estudiante eliminado");
            return null;
        }
    }
    return null; 
}


} // final de la clase 
