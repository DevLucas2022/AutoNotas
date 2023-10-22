package com.remedios.lucas.curso.alunoDisciplina;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAlunoDisciplina(
        @NotNull Long idAlunoDisciplina,
        Long idAluno,
        Long idDisciplina,
        Long nota1,
        Long nota2,
        Long notaAtividade,
        Long media
) {
}
