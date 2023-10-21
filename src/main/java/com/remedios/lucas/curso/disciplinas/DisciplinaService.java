package com.remedios.lucas.curso.disciplinas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.remedios.lucas.curso.professor.Professor;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DisciplinaService {
    RestTemplate template = new RestTemplate();
    public static Professor consultarProfessor(Long id) throws IOException {
        URL url = new URL("http://localhost:8080/professores/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");



        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(connection.getInputStream(), Professor.class);
        }

        return null;
    }
}
