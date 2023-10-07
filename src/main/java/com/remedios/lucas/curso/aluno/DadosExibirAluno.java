package com.remedios.lucas.curso.aluno;

public record DadosExibirAluno(
            Long id,
            String nome,
            String ra,
            String curso,
            String email

    ){
        public DadosExibirAluno(Aluno aluno){
            this(aluno.getId(),
                    aluno.getNome(),
                    aluno.getRa(),
                    aluno.getCurso(),
                    aluno.getEmail());
        }

    }

