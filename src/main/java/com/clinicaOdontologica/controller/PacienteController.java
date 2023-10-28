package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.model.Paciente;
import com.clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public Paciente agregarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.agregarPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> obtenerTodosPacientes() {
        return pacienteService.obtenerTodosPacientes();
    }

    @GetMapping("/{id}")
    public Paciente obtenerPacientePorId(@PathVariable Long id) {
        return pacienteService.obtenerPacientePorId(id);
    }

    @PutMapping("/{id}")
    public Paciente actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        paciente.setId(id);
        return pacienteService.actualizarPaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
    }
}

