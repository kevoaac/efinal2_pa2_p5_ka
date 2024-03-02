package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_matricula")
    @SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
    @Column(name = "matr_id")
    private Integer id;
    @Column(name = "matr_fecha_matricula")
    private LocalDateTime fechaMatricula;
    @Column(name = "matr_nombre_hilo")
    private String nombreHilo;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "matr_id_estudiante")
    private Estudiante estudiante;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "matr_id_materia")
    private Materia materia;

    // SET Y GET


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}