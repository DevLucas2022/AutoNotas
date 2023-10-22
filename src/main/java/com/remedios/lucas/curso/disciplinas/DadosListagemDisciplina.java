package com.remedios.lucas.curso.disciplinas;


public record DadosListagemDisciplina(Long id_disciplina, String nome_disciplina, String nome_professor) {

    public DadosListagemDisciplina(Disciplina disciplina){
        this(disciplina.getIdDisciplina(), disciplina.getNomeDisciplina(), disciplina.getNomeProfessor());
    }
}
