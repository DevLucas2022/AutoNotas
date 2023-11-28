package com.remedios.lucas.curso.alunoDisciplina;

public record DadosCadastroAlunoDisciplina(
        Long idAluno,
        Long idDisciplina,

        Double nota1,
        Double nota2,
        Double notaAtividade,
        Double media,
        String feedback
) {
}
