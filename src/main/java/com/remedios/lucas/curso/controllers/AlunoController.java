package com.remedios.lucas.curso.controllers;

import com.remedios.lucas.curso.aluno.AlunoRepository;
import com.remedios.lucas.curso.aluno.DadosListagemAluno;
import com.remedios.lucas.curso.professor.DadosListagemProfessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<DadosListagemAluno>> listar(){
        var lista = repository.findAll().stream().map(DadosListagemAluno::new).toList();
        return ResponseEntity.ok(lista);
    }

}
