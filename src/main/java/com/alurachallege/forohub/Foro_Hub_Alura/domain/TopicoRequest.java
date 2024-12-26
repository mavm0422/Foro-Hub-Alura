package com.alurachallege.forohub.Foro_Hub_Alura.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoRequest(
        @NotBlank(message = "El título es obligatorio")
        String titulo,

        @NotBlank(message = "El mensaje es obligatorio")
        String mensaje,

        @NotNull(message = "El ID del autor es obligatorio")
        Long autorId,

        @NotNull(message = "El ID del curso es obligatorio")
        Long cursoId

) {
}