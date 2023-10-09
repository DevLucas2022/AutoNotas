package com.remedios.lucas.curso.disciplinas;

import jakarta.persistence.OneToMany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<Disciplina,Long> {

    List<Disciplina> findAll();
}
