package com.remedios.lucas.curso.alunoDisciplina;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAlunoDisciplina(
        @NotNull Long idAlunoDisciplina,
        Long idAluno,
        Long idDisciplina,
        Double nota1,
        Double nota2,
        Double notaAtividade,
        Double media
) {
}
