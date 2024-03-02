package com.uce.edu.repository.modelo.dto;

import java.time.LocalDateTime;

public class MatriculaDTO {
    private String cedulaEstudiante;
    private String codigoMateria;
    private LocalDateTime fechaMatricula;
    private String nombreHilo;

    public MatriculaDTO() {
    }

    public MatriculaDTO(String cedulaEstudiante, String codigoMateria, LocalDateTime fechaMatricula, String nombreHilo) {
        this.cedulaEstudiante = cedulaEstudiante;
        this.codigoMateria = codigoMateria;
        this.fechaMatricula = fechaMatricula;
        this.nombreHilo = nombreHilo;
    }

    // SET Y GET
    public String getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(String cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public LocalDateTime getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDateTime fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getNombreHilo() {
        return nombreHilo;
    }

    public void setNombreHilo(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }
}
