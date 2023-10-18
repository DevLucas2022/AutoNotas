package com.remedios.lucas.curso.aluno;

public record DadosListagemAluno(Long id, String nome, String curso, String email, String cep,String ra, String logradouro) {


    public DadosListagemAluno(Aluno aluno){
        this(aluno.getId(),aluno.getNome(),aluno.getCurso(),aluno.getEmail(),aluno.getRa(), aluno.getCep(), aluno.getLogradouro());
    }
}
