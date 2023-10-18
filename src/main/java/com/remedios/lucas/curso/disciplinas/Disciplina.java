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

    @ManyToOne
    @JoinColumn(name="id_professor")
    private Professor professor;
    Long professor_id;

    public Disciplina(DadosCadastroDisciplina dados){
        this.nome_disciplina = dados.nome_disciplina();
        this.professor_id = dados.professor();
    }

    public Disciplina(Long id_disciplina, String nome_disciplina, Professor professor) {
        this.id_disciplina = id_disciplina;
        this.nome_disciplina = nome_disciplina;
        this.professor = professor;
    }

    public Disciplina() {
        super();
    }

    public void atualizarInformacoes(@Valid DadosAtualizarDisciplina dados){
        if(dados.nome_disciplina()!=null){
            this.nome_disciplina = dados.nome_disciplina();
        }
        if(dados.professor()!=null){
            this.professor = dados.professor();
        }
    }

    public Long getId_disciplina() {
        return id_disciplina;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }


    public Professor getProfessor(){
        return professor;
    }
    public void setProfessor(Professor professor){
        this.professor = professor;
    }

    public Long getProfessor_id() {
        return professor_id;
    }
}
