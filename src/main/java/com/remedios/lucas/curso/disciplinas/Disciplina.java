package com.remedios.lucas.curso.disciplinas;


import jakarta.persistence.*;
import jakarta.validation.Valid;

@Table(name="disciplinas")
@Entity(name="disciplinas")
public class Disciplina {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_disciplina;

    private String nome_disciplina;

    Long id_professor;

    String nome_professor;

    String telefone;

    public Disciplina(@Valid DadosCadastroDisciplina dados) {
        super();
    }

    public Disciplina(Long id_disciplina, String nome_disciplina, Long id_professor, String nome_professor,String telefone) {
        this.id_disciplina = id_disciplina;
        this.nome_disciplina = nome_disciplina;
        this.id_professor = id_professor;
        this.nome_professor = nome_professor;

    }

    public Disciplina() {
    }


    public void atualizarInformacoes(@Valid DadosAtualizarDisciplina dados){
        if(dados.nome_disciplina()!=null){
            this.nome_disciplina = dados.nome_disciplina();
        }
        if(dados.id_professor()!=null){
            this.id_professor= dados.id_professor();
        }
        if(dados.nome_professor()!=null){
            this.nome_professor = dados.nome_professor();
        }
    }

    public Long getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(Long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }

    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }

    public Long getId_professor() {
        return id_professor;
    }

    public void setId_professor(Long id_professor) {
        this.id_professor = id_professor;
    }

    public String getNome_professor() {
        return nome_professor;
    }

    public void setNome_professor(String nome_professor) {
        this.nome_professor = nome_professor;
    }

}
