package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_materia")
    @SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
    @Column(name = "mate_id")
    private Integer id;
    @Column(name = "mate_nombre")
    private String nombre;
    @Column(name = "mate_codigo")
    private String codigo;
    @Column(name = "mate_num_creditos")
    private Integer numeroCreditos;
    @Column(name = "mate_cedula_profesor")
    private String cedulaProfesor;

    @OneToMany(mappedBy = "materia", fetch = FetchType.LAZY)
    private List<Matricula> matriculas;

    // SET Y GET


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public String getCedulaProfesor() {
        return cedulaProfesor;
    }

    public void setCedulaProfesor(String cedulaProfesor) {
        this.cedulaProfesor = cedulaProfesor;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
