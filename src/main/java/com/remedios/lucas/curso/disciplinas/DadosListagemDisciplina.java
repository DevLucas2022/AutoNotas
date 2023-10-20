package com.remedios.lucas.curso.disciplinas;

import com.remedios.lucas.curso.professor.Professor;

public record DadosListagemDisciplina(Long id_disciplina, String nome_disciplina, String nome_professor) {

    public DadosListagemDisciplina(Disciplina disciplina){
        this(disciplina.getId_disciplina(), disciplina.getNome_disciplina(), disciplina.getNome_professor());
    }
}
