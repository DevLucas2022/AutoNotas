package com.remedios.lucas.curso.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor authenticate(String email, String senha){
        Professor professor = professorRepository.findByEmail(email);
        if( professor != null && professor.getSenha().equals(senha)){
            return professor;
        }
        return null;
    }
}
