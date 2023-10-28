package com.clinicaOdontologica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String dni;
    private Date fechaAlta;

    // Getters y Setters

    public void setId(Long id) {
        this.id = id;
    }
}

