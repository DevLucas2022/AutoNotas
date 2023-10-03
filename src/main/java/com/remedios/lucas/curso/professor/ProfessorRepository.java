package com.remedios.lucas.curso.professor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {
    List<Professor> findAll();
}
