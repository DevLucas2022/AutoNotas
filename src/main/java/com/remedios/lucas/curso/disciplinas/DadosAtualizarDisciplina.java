package com.remedios.lucas.curso.disciplinas;

import com.remedios.lucas.curso.professor.Professor;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarDisciplina(
        @NotNull Long id_disciplina,
        String nome_disciplina,
        Long id_professor,
        String nome_professor
) {
}
