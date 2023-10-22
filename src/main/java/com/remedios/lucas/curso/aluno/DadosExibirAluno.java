package com.remedios.lucas.curso.aluno;


public record DadosExibirAluno(
            Long id,
            String nome,
            String ra,
            String curso,
            String email,
            String cep,
            String logradouro,
            String bairro,
            String localidade,
            String uf
    ){
        public DadosExibirAluno(Aluno aluno){
            this(aluno.getId(),
                    aluno.getNome(),
                    aluno.getRa(),
                    aluno.getCurso(),
                    aluno.getEmail(),
                    aluno.getCep(),
                    aluno.getLogradouro(),
                    aluno.getBairro(),
                    aluno.getLocalidade(),
                    aluno.getUf()
            );
        }

    }

