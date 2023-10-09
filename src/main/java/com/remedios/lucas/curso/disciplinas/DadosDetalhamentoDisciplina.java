package com.remedios.lucas.curso.disciplinas;

import com.remedios.lucas.curso.professor.Professor;
import jakarta.validation.constraints.NotBlank;

public record DadosDetalhamentoDisciplina(
         Long id_disciplina,
         String nome_disciplina,
         Professor id_professor
) {
    public DadosDetalhamentoDisciplina(Disciplina disciplina){
        this(disciplina.getId_disciplina(),
                disciplina.getNome_disciplina(),
                disciplina.getId_professor());
    }
}
