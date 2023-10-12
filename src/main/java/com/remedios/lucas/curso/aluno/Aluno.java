package com.remedios.lucas.curso.aluno;


import jakarta.persistence.*;
import jakarta.validation.Valid;

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

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso(){
        return curso;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRa() {
        return ra;
    }
}
