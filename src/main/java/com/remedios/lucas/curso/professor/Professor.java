package com.remedios.lucas.curso.professor;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.time.LocalDate;


@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "professores")
@Entity(name = "professores")
public class Professor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfessor;


    private String nome;

    @JsonIgnore
    private LocalDate dataNascimento;



    @Column(unique = true)
    private String telefone;

    @Column(unique = true)
    private String email;

    private String senha;

    public Professor(DadosCadastroProfessor dados){
        this.idProfessor = dados.idProfessor();
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.senha = dados.senha();
    }

    public Professor(Long idProfessor, String nome, LocalDate dataNascimento, String telefone, String email, String senha) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Professor() {
    }

    public void atualizarInformacoes(@Valid DadosAtualizarProfessor dados){
        if(dados.nome()!= null){
            this.nome = dados.nome();
        }
        if(dados.telefone()!=null){
            this.telefone = dados.telefone();
        }
        if(dados.email()!=null){
            this.email = dados.email();
        }
        if(dados.senha()!=null){
            this.senha = dados.senha();
        }
    }
    public Long getId() {
        return idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public String getSenha(){return senha;}

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
