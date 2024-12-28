package com.alurachallege.forohub.Foro_Hub_Alura.repository;

import com.alurachallege.forohub.Foro_Hub_Alura.domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);

    // Para listar los primeros 10 resultados ordenados por fecha
    List<Topico> findTop10ByOrderByFechaCreacionAsc();

    // Para buscar por nombre de curso y año
    @Query("SELECT t FROM Topico t WHERE t.curso.nombre = :courseName AND EXTRACT(YEAR FROM t.fechaCreacion) = :year")
    List<Topico> findByCourseNameAndYear(@Param("courseName") String courseName, @Param("year") int year);

    List<Topico> findAllByActivoTrue();




}
