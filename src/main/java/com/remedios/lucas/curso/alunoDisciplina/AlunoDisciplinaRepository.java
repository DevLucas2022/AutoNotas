package com.remedios.lucas.curso.alunoDisciplina;

import com.remedios.lucas.curso.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoDisciplinaRepository extends JpaRepository<AlunoDisciplina,Long> {

    List<AlunoDisciplina> findAllByIdDisciplina(Long idDisciplina);
    List<AlunoDisciplina> findAllByIdAluno(Long idAluno);
}
