package com.remedios.lucas.curso.professor;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizarProfessor(
        @NotNull Long id,
        String nome,
        String telefone,
        LocalDate dataNascimento,
        String email
) {
}
