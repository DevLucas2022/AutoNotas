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
    public ResponseEntity<DadosDetalhamentoAlunoDisciplina> atualizar(@RequestBody @Valid DadosAtualizarAlunoDisciplina dados) throws IOException, IllegalAccessException {
        var alunoDisciplina = repository.getReferenceById(dados.idAlunoDisciplina());
        Aluno aluno = AlunoDisciplinaService.consultarAluno(dados.idAluno());
        Disciplina disciplina = AlunoDisciplinaService.consultarDisciplinaProfessor(dados.idDisciplina());
        if(aluno==null){
            throw new IllegalAccessException("Aluno não cadastrado ou ID incorreto");
        }else if(disciplina==null){
            throw new IllegalAccessException("Disciplina não cadastrada ou ID incorreto ");
        }else {
            alunoDisciplina.setNomeAluno(aluno.getNome());
            alunoDisciplina.setNomeDisciplina(disciplina.getNomeDisciplina());
            alunoDisciplina.setNomeProfessor(disciplina.getNomeProfessor());}

        alunoDisciplina.setIdAluno(dados.idAluno());
        alunoDisciplina.setIdDisciplina(dados.idDisciplina());
        alunoDisciplina.setNota1(dados.nota1());
        alunoDisciplina.setNota2(dados.nota2());
        alunoDisciplina.setNotaAtividade(dados.notaAtividade());
        alunoDisciplina.setMedia(dados.media());
        alunoDisciplina.setFeedback(dados.feedback());

        repository.save(alunoDisciplina);
        return ResponseEntity.ok(new DadosDetalhamentoAlunoDisciplina(alunoDisciplina));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<DadosDetalhamentoAlunoDisciplina> cadastrar(@RequestBody @Valid DadosCadastroAlunoDisciplina dados, UriComponentsBuilder uriBuilder) throws IOException, IllegalAccessException {
        var alunoDisciplina = new AlunoDisciplina(dados);

        Aluno aluno = AlunoDisciplinaService.consultarAluno(dados.idAluno());
        Disciplina disciplina = AlunoDisciplinaService.consultarDisciplinaProfessor(dados.idDisciplina());
        var calcMedia = AlunoDisciplinaService.calcularMedia(dados.nota1(),dados.nota2(),dados.notaAtividade());

       if(aluno==null){
            throw new IllegalAccessException("Aluno não cadastrado ou ID incorreto");
        }else if(disciplina==null){
            throw new IllegalAccessException("Disciplina não cadastrada ou ID incorreto ");
        }else {
            alunoDisciplina.setNomeAluno(aluno.getNome());
            alunoDisciplina.setNomeDisciplina(disciplina.getNomeDisciplina());
            alunoDisciplina.setNomeProfessor(disciplina.getNomeProfessor());}

        alunoDisciplina.setIdAluno(dados.idAluno());
        alunoDisciplina.setIdDisciplina(dados.idDisciplina());
        alunoDisciplina.setNota1(dados.nota1());
        alunoDisciplina.setNota2(dados.nota2());
        alunoDisciplina.setNotaAtividade(dados.notaAtividade());
        alunoDisciplina.setFeedback(dados.feedback());

        alunoDisciplina.setMedia(calcMedia);

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
    public ResponseEntity<Void> excluir(@PathVariable Long idAlunodisciplina)
    {
        repository.deleteById(idAlunodisciplina);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @GetMapping("/aluno/disciplina/{idAlunodisciplina}")
    public  ResponseEntity<List<DadosDetalhamentoAlunoDisciplina>> detalharIdAluno(@PathVariable Long idAlunodisciplina){
        var alunoDisciplina = repository.findAllByIdAluno(idAlunodisciplina).stream().map(DadosDetalhamentoAlunoDisciplina::new).toList();
        return ResponseEntity.ok(alunoDisciplina);
    }
    @CrossOrigin
    @GetMapping("/professor/disciplina/{idDisciplina}")
    public  ResponseEntity<List<DadosDetalhamentoAlunoDisciplina>> detalharIdDisciplina(@PathVariable Long idDisciplina){
        var alunoDisciplina = repository.findAllByIdDisciplina(idDisciplina).stream().map(DadosDetalhamentoAlunoDisciplina::new).toList();
        return ResponseEntity.ok(alunoDisciplina);
    }
}
