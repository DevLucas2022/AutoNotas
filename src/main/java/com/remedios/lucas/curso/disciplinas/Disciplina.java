package com.remedios.lucas.curso.disciplinas;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.remedios.lucas.curso.professor.Professor;
import jakarta.persistence.*;
import jakarta.validation.Valid;

@Table(name="disciplinas")
@Entity(name="disciplinas")
public class Disciplina {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_disciplina;
    private String nome_disciplina;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_professor",updatable = false,insertable = false)
    private Professor id_professor;


    public Disciplina(DadosCadastroDisciplina dados){
        this.nome_disciplina = dados.nome_disciplina();
        this.id_professor = dados.id_professor();
    }

    public Disciplina(Long id_disciplina, String nome_disciplina, Professor id_professor) {
        this.id_disciplina = id_disciplina;
        this.nome_disciplina = nome_disciplina;
        this.id_professor = id_professor;
    }

    public Disciplina() {
    }

    public void atualizarInformacoes(@Valid DadosAtualizarDisciplina dados){
        if(dados.nome_disciplina()!=null){
            this.nome_disciplina = dados.nome_disciplina();
        }
        if(dados.id_professor()!=null){
            this.id_professor = dados.id_professor();
        }
    }

    public Long getId_disciplina() {
        return id_disciplina;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }

    public Professor getProfessor() {
        return id_professor;
    }

    public Professor getId_professor() {
        return id_professor;
    }

    public void setId_disciplina(Long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }

    public void setId_professor(Professor id_professor) {
        this.id_professor = id_professor;
    }
}
