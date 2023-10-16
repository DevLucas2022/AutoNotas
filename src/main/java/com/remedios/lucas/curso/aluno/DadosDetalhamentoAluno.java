package com.remedios.lucas.curso.aluno;

public record DadosDetalhamentoAluno (
    Long id,
    String nome,
    String ra,
    String curso,
    String email,
    String logradouro,
    String bairro,
    String localidade,
    String cep
){
    public DadosDetalhamentoAluno(Aluno aluno){
        this(aluno.getId(),
                aluno.getNome(),
                aluno.getRa(),
                aluno.getCurso(),
                aluno.getEmail(),
                aluno.getLogradouro(),
                aluno.getBairro(),
                aluno.getLocalidade(),
                aluno.getCep());
    }

}

