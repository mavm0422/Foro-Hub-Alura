package com.alurachallege.forohub.Foro_Hub_Alura.repository;



    import com.alurachallege.forohub.Foro_Hub_Alura.domain.Usuario;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.security.core.userdetails.UserDetails;

    import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
        Optional<Usuario> findByNombre(String nombre);
    UserDetails findByCorreoElectronico(String username);
    }

