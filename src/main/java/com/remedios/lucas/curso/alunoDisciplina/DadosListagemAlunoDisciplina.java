package com.remedios.lucas.curso.alunoDisciplina;

public record DadosListagemAlunoDisciplina(Long idAlunoDisciplina, String nomeDisciplina, String nomeProfessor, String nomeAluno, Double nota1, Double nota2, Double notaAtividade, Double media) {
    public DadosListagemAlunoDisciplina(AlunoDisciplina alunoDisciplina){
        this(alunoDisciplina.getIdAlunoDisciplina(),alunoDisciplina.getNomeDisciplina(),alunoDisciplina.getNomeProfessor(), alunoDisciplina.getNomeAluno(), alunoDisciplina.getNota1(), alunoDisciplina.getNota2(), alunoDisciplina.getNotaAtividade(), alunoDisciplina.getMedia());
    }
    }
