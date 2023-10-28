package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.model.Turno;
import com.clinicaOdontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public Turno asignarTurno(@RequestBody Turno turno) {
        return turnoService.asignarTurno(turno);
    }

    @GetMapping
    public List<Turno> obtenerTodosTurnos() {
        return turnoService.obtenerTodosTurnos();
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

