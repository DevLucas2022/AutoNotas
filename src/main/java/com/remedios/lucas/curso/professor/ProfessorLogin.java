package com.remedios.lucas.curso.professor;
import java.time.LocalDate;
public record ProfessorLogin ( String email, String senha, Long id){
    public ProfessorLogin(Professor professor){
        this(professor.getEmail(), professor.getSenha(), professor.getIdProfessor());
    }
}
