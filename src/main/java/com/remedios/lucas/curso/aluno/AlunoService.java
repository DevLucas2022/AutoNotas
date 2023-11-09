package com.remedios.lucas.curso.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno authenticate(String email, String senha){
        Aluno aluno = alunoRepository.findByEmail(email);
        if(aluno != null && aluno.getSenha().equals(senha)){
            return aluno;
        }
        return null;
    }
}