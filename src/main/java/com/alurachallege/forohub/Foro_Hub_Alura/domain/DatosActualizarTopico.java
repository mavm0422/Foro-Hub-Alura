package com.alurachallege.forohub.Foro_Hub_Alura.domain;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        Long cursoId


        ) {
}
