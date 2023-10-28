package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public Odontologo agregarOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.agregarOdontologo(odontologo);
    }

    @GetMapping
    public List<Odontologo> obtenerTodosOdontologos() {
        return odontologoService.obtenerTodosOdontologos();
    }

    @GetMapping("/{id}")
    public Odontologo obtenerOdontologoPorId(@PathVariable Long id) {
        return odontologoService.obtenerOdontologoPorId(id);
    }

    @PutMapping("/{id}")
    public Odontologo actualizarOdontologo(@PathVariable Long id, @RequestBody Odontologo odontologo) {
        odontologo.setId(id);
        return odontologoService.actualizarOdontologo(odontologo);
    }

    @DeleteMapping("/{id}")
    public void eliminarOdontologo(@PathVariable Long id) {
        odontologoService.eliminarOdontologo(id);
    }
}

