package com.remedios.lucas.curso.professor;

import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record DadosCadastroProfessor (
        Long idProfessor,
     String nome,
    @Past  LocalDate dataNascimento,
     String telefone,
     String email,
     String senha)
{


}