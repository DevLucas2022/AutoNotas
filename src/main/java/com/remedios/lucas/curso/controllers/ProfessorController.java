package com.remedios.lucas.curso.controllers;

import com.remedios.lucas.curso.professor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;
    @Autowired
    private ProfessorService professorService;

    @CrossOrigin
    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoProfessor> cadastrar(@RequestBody @Valid DadosCadastroProfessor dados, UriComponentsBuilder uriBuilder){
        var professor = new Professor(dados);
        repository.save(professor);

        var uri = uriBuilder.path("/professores/{id}").buildAndExpand(professor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoProfessor(professor));
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<DadosListagemProfessor>> listar(){
        var lista = repository.findAll().stream().map(DadosListagemProfessor::new).toList();
        return ResponseEntity.ok(lista);
    }

    @CrossOrigin
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoProfessor> atualizar(@RequestBody @Valid DadosAtualizarProfessor dados){
        var professor = repository.getReferenceById(dados.id());
        professor.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<Long> logar(@RequestBody Professor loginProfessor){
        String email = loginProfessor.getEmail();
        String senha = loginProfessor.getSenha();

        Professor professor = professorService.authenticate(email, senha);

        if(professor != null){
            return new ResponseEntity<>(professor.getIdProfessor(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoProfessor> detalhar(@PathVariable Long id){
        var professor = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
    }

}
