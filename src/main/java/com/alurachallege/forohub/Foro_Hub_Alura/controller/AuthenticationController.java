package com.alurachallege.forohub.Foro_Hub_Alura.controller;

import com.alurachallege.forohub.Foro_Hub_Alura.domain.DatosAutenticacionUsuario;
import com.alurachallege.forohub.Foro_Hub_Alura.domain.Usuario;
import com.alurachallege.forohub.Foro_Hub_Alura.infra.security.DatosJWTToken;
import com.alurachallege.forohub.Foro_Hub_Alura.infra.security.TokenService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity userauthentication(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        Authentication authtoken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.correoElectronico(),
                datosAutenticacionUsuario.password());
      var userAuthentication =  authenticationManager.authenticate(authtoken);
        var jwttoken = tokenService.generateToken((Usuario) userAuthentication.getPrincipal());
        return  ResponseEntity.ok(new DatosJWTToken(jwttoken) );


    }

}
