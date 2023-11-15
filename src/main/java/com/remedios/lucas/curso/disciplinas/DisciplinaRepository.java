package com.remedios.lucas.curso.disciplinas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<Disciplina,Long> {

    List<Disciplina> findAll();
    List<Disciplina> findAllByIdProfessor(Long idProfessor);
}
