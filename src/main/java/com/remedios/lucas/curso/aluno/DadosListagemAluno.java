package com.remedios.lucas.curso.aluno;

import com.remedios.lucas.curso.professor.DadosListagemProfessor;

public record DadosListagemAluno(Long id, String nome, String curso, String email) {


    public DadosListagemAluno(Aluno aluno){
        this(aluno.getId(),aluno.getNome(),aluno.getCurso(),aluno.getEmail());
    }
}
