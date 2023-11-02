package com.remedios.lucas.curso.controllers;

import com.remedios.lucas.curso.professor.*;
import com.remedios.lucas.curso.usuarios.Usuario;
import com.remedios.lucas.curso.usuarios.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @CrossOrigin
    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoProfessor> cadastrar(@RequestBody @Valid DadosCadastroProfessor dados, UriComponentsBuilder uriBuilder){
        var professor = new Professor(dados);
        Usuario usuario = new Usuario();
        usuario.setLogin(dados.email());
        usuario.setSenha(passwordEncoder.encode(dados.senha()));
        usuario.setFuncao("Professor");
        repository.save(professor);
        usuarioRepository.save(usuario);
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
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoProfessor> detalhar(@PathVariable Long id){
        var professor = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
    }

}
