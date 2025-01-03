package com.alurachallege.forohub.Foro_Hub_Alura.infra.security;

import com.alurachallege.forohub.Foro_Hub_Alura.domain.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String secret;

    public String generateToken(Usuario user) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("ForoHub")
                    .withSubject(user.getCorreoElectronico())
                    .withClaim("id", user.getId())
                    .withExpiresAt(fechaExpiracion())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("error al generar token jwt", exception);
        }
    }

    public String getSubject(String token) {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token no puede ser nulo o vacío");
        }

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret); // Validando firma
            DecodedJWT decodedJWT = JWT.require(algorithm)
                    .withIssuer("ForoHub")
                    .build()
                    .verify(token);

            String subject = decodedJWT.getSubject();
            if (subject == null || subject.isEmpty()) {
                throw new RuntimeException("El token no contiene un sujeto válido");
            }
            return subject;
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Error al verificar el token JWT: " + exception.getMessage(), exception);
        }
    }


    private Instant fechaExpiracion() {
        return LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.of("-05:00"));
    }

}