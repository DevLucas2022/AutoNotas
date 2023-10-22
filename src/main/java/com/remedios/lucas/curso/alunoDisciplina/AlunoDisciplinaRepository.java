package com.remedios.lucas.curso.alunoDisciplina;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoDisciplinaRepository extends JpaRepository<AlunoDisciplina,Long> {
    List<AlunoDisciplina> findAll();
}
