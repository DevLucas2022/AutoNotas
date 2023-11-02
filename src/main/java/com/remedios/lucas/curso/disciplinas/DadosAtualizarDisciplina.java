package com.remedios.lucas.curso.disciplinas;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarDisciplina(
        @NotNull Long idDisciplina,
        String nomeDisciplina,
        Long idProfessor
) {
}
