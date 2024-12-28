package com.alurachallege.forohub.Foro_Hub_Alura.service;

import com.alurachallege.forohub.Foro_Hub_Alura.domain.*;
import com.alurachallege.forohub.Foro_Hub_Alura.repository.CursoRepository;
import com.alurachallege.forohub.Foro_Hub_Alura.repository.TopicoRepository;
import com.alurachallege.forohub.Foro_Hub_Alura.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoServiceImpl implements TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    @Autowired
    public TopicoServiceImpl(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public DatosRespuestaTopico crearTopico(DatosRegistroTopico datosRegistroTopico) {
        Usuario autor = usuarioRepository.findById(datosRegistroTopico.autorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor no encontrado"));

        Curso curso = cursoRepository.findById(datosRegistroTopico.cursoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado"));

        Topico topico = new Topico(datosRegistroTopico, autor, curso);
        topicoRepository.save(topico);

        return new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );
    }



    @Override
    public List<TopicResponse> listarTodos() {
        return topicoRepository.findAllByActivoTrue()
                .stream()
                .map(TopicResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TopicResponse> listarTop10PorFecha() {
        return topicoRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "fechaCreacion")))
                .getContent()
                .stream()
                .map(TopicResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TopicResponse getTopicById(Long id) {
        return topicoRepository.findById(id)
                .map(TopicResponse::fromEntity)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));

    }
}
