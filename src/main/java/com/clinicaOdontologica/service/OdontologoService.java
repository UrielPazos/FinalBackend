package com.clinicaOdontologica.service;

import com.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;

    public Odontologo agregarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    public List<Odontologo> obtenerTodosOdontologos() {
        return odontologoRepository.findAll();
    }

    public Odontologo obtenerOdontologoPorId(Long id) {
        return odontologoRepository.findById(id).orElse(null);
    }
}

