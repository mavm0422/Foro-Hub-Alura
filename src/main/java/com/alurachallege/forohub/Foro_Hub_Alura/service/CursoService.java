package com.alurachallege.forohub.Foro_Hub_Alura.service;

import com.alurachallege.forohub.Foro_Hub_Alura.domain.Curso;

import java.util.Optional;

public interface CursoService {
    Optional<Curso> findById(Long id);
}
