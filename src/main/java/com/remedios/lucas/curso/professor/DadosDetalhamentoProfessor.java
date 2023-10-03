package com.remedios.lucas.curso.professor;

import java.time.LocalDate;

public record DadosDetalhamentoProfessor (
        Long id,
        String nome,
        LocalDate dataNascimento,
        String telefone,
        String email){
  public DadosDetalhamentoProfessor(Professor professor){
      this(professor.getId(),
              professor.getNome(),
              professor.getDataNascimento(),
              professor.getTelefone(),
              professor.getEmail());
  }
}
