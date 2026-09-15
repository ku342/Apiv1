package com.base.apiv1.controller;
import com.base.apiv1.model.Estudiante;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
public List<Estudiante> getEstudiantes() {
    return estudiantes;
}




}
