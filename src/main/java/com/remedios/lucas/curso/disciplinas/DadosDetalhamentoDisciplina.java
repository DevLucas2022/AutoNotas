package com.remedios.lucas.curso.disciplinas;


public record DadosDetalhamentoDisciplina(
         Long idDisciplina,
         String nomeDisciplina,
         Long idProfessor,
         String nomeProfessor
) {
    public DadosDetalhamentoDisciplina(Disciplina disciplina){
        this(disciplina.getIdDisciplina(),
                disciplina.getNomeDisciplina(),
                disciplina.getIdProfessor(),
                disciplina.getNomeProfessor());
    }
}
