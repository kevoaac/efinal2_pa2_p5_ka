package com.uce.edu.controller;

import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/estudiantes")
public class EstudianteController {
    @Autowired
    private IEstudianteService iEstudianteService;

    @GetMapping(value = "/nuevoEstudiante")
    public String nuevoEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "vistaNuevoEstudiante";
    }

    @PostMapping(value = "/guardar")
    public String guardar(Estudiante estudiante) {
        this.iEstudianteService.guardar(estudiante);
        return "redirect:/estudiantes/nuevoEstudiante";
    }

}
