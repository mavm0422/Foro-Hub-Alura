package com.alurachallege.forohub.Foro_Hub_Alura.service;

import com.alurachallege.forohub.Foro_Hub_Alura.domain.DatosRegistroTopico;
import com.alurachallege.forohub.Foro_Hub_Alura.domain.DatosRespuestaTopico;
import com.alurachallege.forohub.Foro_Hub_Alura.domain.TopicResponse;

import java.util.List;

public interface TopicoService {

    DatosRespuestaTopico crearTopico(DatosRegistroTopico datosRegistroTopico);
    List<TopicResponse> listarTodos();
    List<TopicResponse> listarTop10PorFecha();
    TopicResponse getTopicById(Long id);

}
