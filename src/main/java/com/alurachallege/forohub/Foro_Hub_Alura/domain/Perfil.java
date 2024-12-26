package com.alurachallege.forohub.Foro_Hub_Alura.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "perfil")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}
