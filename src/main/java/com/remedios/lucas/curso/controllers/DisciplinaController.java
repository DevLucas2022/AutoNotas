package com.remedios.lucas.curso.controllers;



import com.remedios.lucas.curso.alunoDisciplina.DadosDetalhamentoAlunoDisciplina;
import com.remedios.lucas.curso.disciplinas.*;
import com.remedios.lucas.curso.professor.Professor;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository repository;

    @CrossOrigin
    @PutMapping
    public ResponseEntity<DadosDetalhamentoDisciplina>atualizar(@RequestBody @Valid DadosAtualizarDisciplina dados) throws IOException {
        var disciplina = repository.getReferenceById(dados.idDisciplina());
        Professor professorConsulta = DisciplinaService.consultarProfessor(dados.idProfessor());
        disciplina.setIdProfessor(dados.idProfessor());
        disciplina.setNomeProfessor(professorConsulta.getNome());
        disciplina.setNomeDisciplina(dados.nomeDisciplina());
        repository.save(disciplina);
        return ResponseEntity.ok(new DadosDetalhamentoDisciplina(disciplina));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<DadosDetalhamentoDisciplina> cadastrar(@RequestBody @Valid DadosCadastroDisciplina dados, UriComponentsBuilder uriBuilder) throws IOException {
       var disciplina = new Disciplina(dados);
       Professor professorConsulta = DisciplinaService.consultarProfessor(dados.idProfessor());
       disciplina.setNomeProfessor(professorConsulta.getNome());
       disciplina.setNomeDisciplina(dados.nomeDisciplina());
       disciplina.setIdProfessor(dados.idProfessor());
       repository.save(disciplina);

       var uri = uriBuilder.path("/disciplinas/{id_disciplina}").buildAndExpand(disciplina.getIdDisciplina()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoDisciplina(disciplina));
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<DadosListagemDisciplina>>listar(){
        var lista = repository.findAll().stream().map(DadosListagemDisciplina::new).toList();
        return ResponseEntity.ok(lista);
    }
    @CrossOrigin
    @DeleteMapping("/{id_disciplina}")
    public ResponseEntity<Void> excluir(@PathVariable Long id_disciplina){
        repository.deleteById(id_disciplina);

        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoDisciplina> detalhar(@PathVariable Long id){
        var disciplina = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoDisciplina(disciplina));
    }

    @CrossOrigin
    @GetMapping("/professor/disciplina/{idProfessor}")
    public  ResponseEntity<List<DadosDetalhamentoDisciplina>> detalharIdDisciplina(@PathVariable Long idProfessor){
        var alunoDisciplina = repository.findAllByIdProfessor(idProfessor).stream().map(DadosDetalhamentoDisciplina::new).toList();
        return ResponseEntity.ok(alunoDisciplina);
    }

}
