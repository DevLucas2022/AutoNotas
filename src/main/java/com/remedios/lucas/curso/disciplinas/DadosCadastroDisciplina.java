package com.remedios.lucas.curso.disciplinas;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroDisciplina(
        @NotBlank String nomeDisciplina,
        Long idProfessor,
        String nomeProfessor) {
}
