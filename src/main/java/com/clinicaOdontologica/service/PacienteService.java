package com.clinicaOdontologica.service;

import com.clinicaOdontologica.model.Paciente;
import com.clinicaOdontologica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente agregarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente actualizarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> obtenerTodosPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente obtenerPacientePorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }
}

