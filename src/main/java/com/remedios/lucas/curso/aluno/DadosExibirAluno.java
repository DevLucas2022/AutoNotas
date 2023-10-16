package com.remedios.lucas.curso.aluno;

import com.remedios.lucas.curso.Endereco.Endereco;

public record DadosExibirAluno(
            Long id,
            String nome,
            String ra,
            String curso,
            String email,
            String cep
    ){
        public DadosExibirAluno(Aluno aluno){
            this(aluno.getId(),
                    aluno.getNome(),
                    aluno.getRa(),
                    aluno.getCurso(),
                    aluno.getEmail(),
                    aluno.getCep());
        }

    }

