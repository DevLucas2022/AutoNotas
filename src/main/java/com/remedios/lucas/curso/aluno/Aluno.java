package com.remedios.lucas.curso.aluno;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.remedios.lucas.curso.Endereco.Endereco;
import com.remedios.lucas.curso.professor.DadosAtualizarProfessor;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Table(name = "alunos")
@Entity(name = "alunos")
public class  Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String curso;

    @Column(unique = true)
    private String ra;

    @Column(unique = true)
    private String email;

    private String senha;
    private String cep;


    public Aluno(Long id, String nome, String curso, String ra, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.ra = ra;
        this.email = email;
        this.senha = senha;
    }

    public Aluno(DadosCadastroAluno dados){
        this.nome = dados.nome();
        this.curso = dados.curso();
        this.email = dados.email();
        this.ra = dados.ra();
        this.senha = dados.senha();
        this.cep = dados.cep();
    }

    public Aluno() {
    }

    public void atualizarInformacoes(@Valid DadosAtualizarAluno dados){
        if(dados.nome()!=null){
            this.nome = dados.nome();
        }
        if(dados.email()!=null){
            this.email = dados.email();
        }
        if(dados.curso()!=null){
            this.curso = dados.curso();
        }
        if(dados.ra()!=null){
            this.ra = dados.ra();
        }
    }
    public static Aluno consultarCEP(String cep) throws IOException {
        URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(connection.getInputStream(), Aluno.class);
        }

        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
