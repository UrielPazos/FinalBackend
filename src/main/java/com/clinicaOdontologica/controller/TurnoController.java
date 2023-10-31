package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.model.Turno;
import com.clinicaOdontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public String asignarTurno(Turno turno, Model model) {
        turnoService.asignarTurno(turno);
        return "redirect:/turno"; //
    }
    @GetMapping("/add")
    public String agregarTurno(Model model) {
        model.addAttribute("turno", new Turno());
        return "agregarTurno";
    }

    @GetMapping
    public String obtenerTodosTurnos(Model model) {  //
        List<Turno> turnos = turnoService.obtenerTodosTurnos();
        model.addAttribute("turnos", turnos);
        return "turno";
    }

    @GetMapping("/{id}")
    public Turno obtenerTurnoPorId(@PathVariable Long id) {
        return turnoService.obtenerTurnoPorId(id);
    }

    @PutMapping("/{id}")
    public Turno actualizarTurno(@PathVariable Long id, @RequestBody Turno turno) {
        turno.setId(id);
        return turnoService.actualizarTurno(turno);
    }

    @DeleteMapping("/{id}")
    public void cancelarTurno(@PathVariable Long id) {
        turnoService.cancelarTurno(id);
    }
}

