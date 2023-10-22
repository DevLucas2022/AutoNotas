package com.remedios.lucas.curso.alunoDisciplina;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAlunoDisciplina(
        @NotBlank Long idAluno,
        @NotBlank Long idDisciplina,
        @NotBlank Long idProfessor,
        Long nota1,
        Long nota2,
        Long notaAtividade,
        Long media
) {
}
