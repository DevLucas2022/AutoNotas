package com.remedios.lucas.curso.alunoDisciplina;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.remedios.lucas.curso.aluno.Aluno;
import com.remedios.lucas.curso.disciplinas.Disciplina;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class AlunoDisciplinaService {

    public static Aluno consultarAluno(Long id) throws IOException{
        URL url = new URL("http://localhost:8080/alunos/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if(responseCode==200){
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(connection.getInputStream(),Aluno.class);
        }
        return null;
    }

    public static Disciplina consultarDisciplinaProfessor(Long id) throws  IOException{
        URL url = new URL("http://localhost:8080/disciplinas/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if(responseCode==200){
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(connection.getInputStream(),Disciplina.class);
        }
        return null;
    }
}
