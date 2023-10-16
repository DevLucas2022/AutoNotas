package com.remedios.lucas.curso.aluno;

public record DadosDetalhamentoAluno (
    Long id,
    String nome,
    String ra,
    String curso,
    String email,
    String cep,
    String logradouro,
    String complemento,
    String bairro,
    String localidade,
    String uf,
    String ibge,

    String gia,
    String ddd,
    String siafi
){
    public DadosDetalhamentoAluno(Aluno aluno){
        this(aluno.getId(),
                aluno.getNome(),
                aluno.getRa(),
                aluno.getCurso(),
                aluno.getEmail(),
                aluno.getCep(),
                aluno.getLogradouro(),
                aluno.getBairro(),
                aluno.getLocalidade(),
                aluno.getDdd(),
                aluno.getGia(),
                aluno.getIbge(),
                aluno.getComplemento(),
                aluno.getUf(),
                aluno.getSiafi());
    }

}

