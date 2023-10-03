package com.remedios.lucas.curso.professor;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;

@Table(name = "professores")
@Entity(name = "professores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Professor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;

    public Professor(DadosCadastroProfessor dados){
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.telefone = dados.telefone();
        this.email = dados.email();
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
    }
    public Long getId() {
        return id;
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
}
