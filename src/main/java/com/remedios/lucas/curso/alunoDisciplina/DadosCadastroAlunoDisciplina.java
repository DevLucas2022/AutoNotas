package com.remedios.lucas.curso.alunoDisciplina;

public record DadosCadastroAlunoDisciplina(
        Long idAluno,
        Long idDisciplina,
        Long nota1,
        Long nota2,
        Long notaAtividade,
        Long media
) {
}
