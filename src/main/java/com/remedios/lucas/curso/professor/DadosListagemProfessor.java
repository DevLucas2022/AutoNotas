package com.remedios.lucas.curso.professor;

import com.remedios.lucas.curso.aluno.Aluno;

import java.time.LocalDate;

public record DadosListagemProfessor(Long id, String nome, LocalDate dataNascimento, String telefone, String email) {

    public DadosListagemProfessor(Professor professor){
        this(professor.getId(), professor.getNome(),professor.getDataNascimento(), professor.getTelefone(), professor.getEmail());
    }

}
