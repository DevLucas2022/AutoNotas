package com.remedios.lucas.curso.professor;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.remedios.lucas.curso.disciplinas.Disciplina;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Table(name = "professores")
@Entity(name = "professores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_professor")

public class Professor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professor;

    @JsonIgnore
    @OneToMany(mappedBy = "id_professor", fetch = FetchType.EAGER)
    private List<Disciplina>disciplinas;


    private String nome;
    private LocalDate dataNascimento;

    @Column(unique = true)
    private String telefone;

    @Column(unique = true)
    private String email;

    private String senha;


    public Professor(Long id_professor) {
        this.id_professor = id_professor;
    }

    public Professor(DadosCadastroProfessor dados){
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.senha = dados.senha();
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

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
