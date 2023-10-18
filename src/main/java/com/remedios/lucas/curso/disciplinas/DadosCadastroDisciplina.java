package com.remedios.lucas.curso.disciplinas;

import com.remedios.lucas.curso.professor.Professor;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroDisciplina(
        @NotBlank String nome_disciplina,
        Long professor

) {
}
