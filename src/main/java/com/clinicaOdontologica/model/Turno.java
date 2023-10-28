package com.clinicaOdontologica.model;

import com.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.model.Paciente;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Odontologo odontologo;

    private Date fechaHora;

    // Getters y Setters

    public void setId(Long id) {
        this.id = id;
    }
}

