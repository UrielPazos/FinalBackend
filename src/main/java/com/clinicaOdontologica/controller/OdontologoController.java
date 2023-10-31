package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("/add")
    public String mostrarFormularioAgregarOdontologo(Model model) {
        model.addAttribute("odontologo", new Odontologo());
        return "agregarodontologo.html";
    }

    @PostMapping("/add")
    public String agregarOdontologo(@ModelAttribute Odontologo odontologo, Model model) {
        odontologoService.agregarOdontologo(odontologo);
        return "redirect:/odontologos"; // Redirige a la lista de odontólogos después de agregar uno nuevo
    }


    @GetMapping
    public String obtenerTodosOdontologos(Model model) {
        List<Odontologo> odontologos = odontologoService.obtenerTodosOdontologos();
        model.addAttribute("odontologos", odontologos);
        return "odontologos.html";
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

