package com.clinicaOdontologica.service;

import com.clinicaOdontologica.model.Turno;
import com.clinicaOdontologica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    public Turno asignarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    public Turno actualizarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    public void cancelarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    public List<Turno> obtenerTodosTurnos() {
        return turnoRepository.findAll();
    }

    public Turno obtenerTurnoPorId(Long id) {
        return turnoRepository.findById(id).orElse(null);
    }
}

