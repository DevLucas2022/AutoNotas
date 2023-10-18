package com.remedios.lucas.curso.professor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record DadosCadastroProfessor (
        Long id_professor,
    @NotBlank String nome,
    @Past  LocalDate dataNascimento,
    @NotBlank String telefone,
    @NotBlank String email,
    @NotBlank String senha)
{


}