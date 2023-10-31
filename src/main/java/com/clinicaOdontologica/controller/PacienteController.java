package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.model.Paciente;
import com.clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/add")
    public String agregarPaciente (Model model) {
        model.addAttribute("paciente", new Paciente());
        return "agregarPacientes";
    }
    @PostMapping("/add")
    public String guardarPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.agregarPaciente(paciente);
        return "redirect:/pacientes"; // o redirige a donde prefieras
    }



    @GetMapping
    public String obtenerTodosPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.obtenerTodosPacientes();
        model.addAttribute("pacientes", pacientes);
        return "paciente.html";
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

