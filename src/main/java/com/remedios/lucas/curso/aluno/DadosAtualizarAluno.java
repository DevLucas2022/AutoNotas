package com.remedios.lucas.curso.aluno;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAluno(
        @NotNull Long id,
        String nome,
        String email,
        String curso,
        String senha,
        String ra,
        String cep,
        String logradouro
        ){
}
