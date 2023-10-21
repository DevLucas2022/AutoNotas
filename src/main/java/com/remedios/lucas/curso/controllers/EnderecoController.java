package com.remedios.lucas.curso.controllers;

import com.remedios.lucas.curso.Endereco.Endereco;
import com.remedios.lucas.curso.aluno.ViaCepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @GetMapping("/{cep}")
    public Endereco consultarEndereco(@PathVariable String cep) throws IOException {


        return ViaCepService.consultarCEP(cep);}
}
