package com.alurachallege.forohub.Foro_Hub_Alura.service;

import com.alurachallege.forohub.Foro_Hub_Alura.domain.Usuario;
import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> findById(Long id);
}
