package com.remedios.lucas.curso.aluno;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAluno (

    @NotBlank String nome,
    @NotBlank String curso,
    @NotBlank String email,
    @NotBlank String senha,
    @NotBlank String ra,
    @NotBlank String cep

    )

{}
