package com.remedios.lucas.curso.aluno;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno,Long>{
    List<Aluno> findAll();
}
