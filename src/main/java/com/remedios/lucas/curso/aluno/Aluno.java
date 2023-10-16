package com.remedios.lucas.curso.aluno;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.remedios.lucas.curso.Endereco.Endereco;
import com.remedios.lucas.curso.professor.DadosAtualizarProfessor;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Table(name = "alunos")
@Entity(name = "alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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


    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;

    private String gia;
    private String ddd;
    private String siafi;
    public Aluno(DadosCadastroAluno dados){
        this.nome = dados.nome();
        this.curso = dados.curso();
        this.email = dados.email();
        this.ra = dados.ra();
        this.senha = dados.senha();
        this.cep = dados.cep();
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }
}
