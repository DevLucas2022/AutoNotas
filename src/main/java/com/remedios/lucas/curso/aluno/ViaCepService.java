package com.remedios.lucas.curso.aluno;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.remedios.lucas.curso.Endereco.Endereco;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCepService {
    public static Endereco consultarCEP(String cep) throws IOException {
        URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(connection.getInputStream(), Endereco.class);
        }

        return null;
    }
}
