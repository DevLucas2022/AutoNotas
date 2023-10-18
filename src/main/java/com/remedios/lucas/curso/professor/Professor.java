package com.remedios.lucas.curso.professor;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.remedios.lucas.curso.disciplinas.Disciplina;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Table(name = "professores")
@Entity(name = "professores")
public class Professor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professor;


    private String nome;
    private LocalDate dataNascimento;

    @OneToMany( mappedBy = "professor", fetch = FetchType.LAZY)
    private List<Disciplina> disciplinas;

    @Column(unique = true)
    private String telefone;

    @Column(unique = true)
    private String email;

    private String senha;

    public Professor(DadosCadastroProfessor dados){
        this.id_professor = dados.id_professor();
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.senha = dados.senha();
    }

    public Professor(Long id_professor, String nome, LocalDate dataNascimento, String telefone, String email, String senha) {
        this.id_professor = id_professor;
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
        return id_professor;
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

    public Long getId_professor() {
        return id_professor;
    }

    public void setId_professor(Long id_professor) {
        this.id_professor = id_professor;
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
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
