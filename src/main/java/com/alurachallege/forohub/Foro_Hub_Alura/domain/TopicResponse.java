package com.alurachallege.forohub.Foro_Hub_Alura.domain;

import java.time.LocalDateTime;

public record TopicResponse(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String authorName,
        String courseName
) {
    public static TopicResponse fromEntity(Topico topico) {
        return new TopicResponse(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()

        );
    }
}

