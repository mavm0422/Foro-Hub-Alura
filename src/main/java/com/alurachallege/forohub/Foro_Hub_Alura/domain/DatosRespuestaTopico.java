package com.alurachallege.forohub.Foro_Hub_Alura.domain;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autorNombre,
        String cursoNombre
) {}
