package com.alurachallege.forohub.Foro_Hub_Alura.repository;

import com.alurachallege.forohub.Foro_Hub_Alura.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findByNombre(String nombre);
}
