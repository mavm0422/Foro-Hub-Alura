package com.alurachallege.forohub.Foro_Hub_Alura.repository;

import com.alurachallege.forohub.Foro_Hub_Alura.domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);

}
