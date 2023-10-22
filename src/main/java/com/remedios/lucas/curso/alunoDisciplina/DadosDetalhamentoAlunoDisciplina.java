package com.remedios.lucas.curso.alunoDisciplina;

public record DadosDetalhamentoAlunoDisciplina(
        Long idAlunoDisciplina,
        String nomeDisciplina,
        String nomeProfessor,
        String nomeAluno,
        Long nota1,
        Long nota2,
        Long notaAtividade,
        Long media
) {
}
