package com.remedios.lucas.curso.controllers;


import com.remedios.lucas.curso.aluno.Aluno;
import com.remedios.lucas.curso.alunoDisciplina.*;
import com.remedios.lucas.curso.disciplinas.Disciplina;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/alunosDisciplinas")
public class AlunoDisciplinaController {
    @Autowired
    private AlunoDisciplinaRepository repository;


    @CrossOrigin
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAlunoDisciplina> atualizar(@RequestBody @Valid DadosAtualizarAlunoDisciplina dados){
        var alunoDisciplina = repository.getReferenceById(dados.idAlunoDisciplina());
        alunoDisciplina.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAlunoDisciplina(alunoDisciplina));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<DadosDetalhamentoAlunoDisciplina> cadastrar(@RequestBody @Valid DadosCadastroAlunoDisciplina dados, UriComponentsBuilder uriBuilder) throws IOException, IllegalAccessException {
        var alunoDisciplina = new AlunoDisciplina(dados);

        Aluno aluno = AlunoDisciplinaService.consultarAluno(dados.idAluno());
        Disciplina disciplina = AlunoDisciplinaService.consultarDisciplinaProfessor(dados.idDisciplina());

       if(aluno==null){
            throw new IllegalAccessException("Aluno não cadastrada ou ID incorreto");
        }else if(disciplina==null){
            throw new IllegalAccessException("Disciplina não cadastrada ou ID incorreto ");
        }else {
            alunoDisciplina.setNomeAluno(aluno.getNome());
            alunoDisciplina.setNomeDisciplina(disciplina.getNomeDisciplina());
            alunoDisciplina.setNomeProfessor(disciplina.getNomeProfessor());}

        alunoDisciplina.setNota1(dados.nota1());
        alunoDisciplina.setNota2(dados.nota2());
        alunoDisciplina.setNotaAtividade(dados.notaAtividade());
        alunoDisciplina.setMedia(dados.media());

        repository.save(alunoDisciplina);
        var uri = uriBuilder.path("alunosDisciplinas/{id_alunodisciplina}").buildAndExpand(alunoDisciplina.getIdAlunoDisciplina()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAlunoDisciplina(alunoDisciplina));
        }


    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<DadosListagemAlunoDisciplina>> listar(){
        var lista = repository.findAll().stream().map(DadosListagemAlunoDisciplina::new).toList();
        return ResponseEntity.ok(lista);
    }
    @CrossOrigin
    @DeleteMapping("/{id_alunodisciplina}")
    public ResponseEntity<Void> excluir(@PathVariable Long id_alunodisciplina)
    {
        repository.deleteById(id_alunodisciplina);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @GetMapping("/{id_alunodisciplina}")
    public  ResponseEntity<DadosDetalhamentoAlunoDisciplina> detalhar(@PathVariable Long id_alunodisciplina){
        var alunoDisciplina = repository.getReferenceById(id_alunodisciplina);
        return ResponseEntity.ok(new DadosDetalhamentoAlunoDisciplina(alunoDisciplina));
    }
}
