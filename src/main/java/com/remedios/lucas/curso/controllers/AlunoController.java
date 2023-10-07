package com.remedios.lucas.curso.controllers;

import com.remedios.lucas.curso.aluno.*;
import com.remedios.lucas.curso.professor.DadosDetalhamentoProfessor;
import com.remedios.lucas.curso.professor.DadosListagemProfessor;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;


    @CrossOrigin
    @PostMapping
    public ResponseEntity<DadosDetalhamentoAluno> cadastrar(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uribuilder){
        var aluno = new Aluno(dados);
        repository.save(aluno);

        var uri = uribuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAluno(aluno));
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<DadosListagemAluno>> listar(){
        var lista = repository.findAll().stream().map(DadosListagemAluno::new).toList();
        return ResponseEntity.ok(lista);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<DadosExibirAluno> detalhar(@PathVariable Long id){
        var aluno = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosExibirAluno(aluno));
    }
}
