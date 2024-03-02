package com.uce.edu.controller;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/materias")
public class MateriaController {
    @Autowired
    private IMateriaService iMateriaService;

    @GetMapping(value = "/nuevaMateria")
    public String nuevoEstudiante(Model model) {
        model.addAttribute("materia", new Materia());
        return "vistaNuevaMateria";
    }

    @PostMapping(value = "/guardar")
    public String guardar(Materia materia) {
        this.iMateriaService.guardar(materia);
        return "redirect:/materias/nuevaMateria";
    }

}
