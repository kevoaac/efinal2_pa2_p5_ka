package com.uce.edu.controller;

import com.uce.edu.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.service.IMatriculaService;
import com.uce.edu.service.to.MatriculaTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/matriculas")
public class MatriculaController {
    @Autowired
    private IMatriculaService iMatriculaService;

    @GetMapping(value = "/nuevaMatricula")
    public String nuevoEstudiante(Model model) {
        model.addAttribute("matriculaTO", new MatriculaTO());
        return "vistaNuevaMatricula";
    }

    @GetMapping(value = "/buscarTodas")
    public String mostrarTodas(Model model) {
        List<MatriculaDTO> lista = this.iMatriculaService.buscarTodasDTO();
        model.addAttribute("matriculasDTO", lista);
        return "vistaListaMatriculas";
    }

    @PutMapping(value = "/guardar")
    public String guardar(MatriculaTO matriculaTO) {
        this.iMatriculaService.generarMatriculas(matriculaTO);
        return "redirect:/matriculas/nuevaMatricula";
    }


}
