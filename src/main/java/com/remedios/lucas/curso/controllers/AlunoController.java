package com.remedios.lucas.curso.controllers;

import com.remedios.lucas.curso.Endereco.Endereco;
import com.remedios.lucas.curso.aluno.*;
import com.remedios.lucas.curso.aluno.ViaCepService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;
    @Autowired
    private AlunoService alunoService;


    @CrossOrigin
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAluno> atualizar(@RequestBody @Valid DadosAtualizarAluno dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<DadosDetalhamentoAluno> cadastrar(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uribuilder) throws IOException, IllegalAccessException {
        var aluno = new Aluno(dados);

        Endereco viacep = ViaCepService.consultarCEP(dados.cep());
        if(viacep==null){
            throw new IllegalAccessException("CEP Não Cadastrado");}else{
        aluno.setLogradouro(viacep.getLogradouro());
        aluno.setBairro(viacep.getBairro());
        aluno.setLogradouro(viacep.getLogradouro());
        aluno.setLocalidade(viacep.getLocalidade());
        aluno.setUf(viacep.getUf());}

        repository.save(aluno);

        var uri = uribuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAluno(aluno));
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<DadosListagemAluno>> listar(){
        var lista = repository.findAll().stream().map(DadosListagemAluno::new).toList();

        return ResponseEntity.ok(lista);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<Long> logar(@RequestBody Aluno loginAluno){
        String email = loginAluno.getEmail();
        String senha = loginAluno.getSenha();

        Aluno aluno = alunoService.authenticate(email, senha);

        if(aluno != null){
            return new ResponseEntity<>(aluno.getId(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<DadosExibirAluno> detalhar(@PathVariable Long id){
        var aluno = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosExibirAluno(aluno));
    }

}
