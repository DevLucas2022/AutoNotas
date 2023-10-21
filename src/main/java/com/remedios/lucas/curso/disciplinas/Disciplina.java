package com.remedios.lucas.curso.disciplinas;


import jakarta.persistence.*;
import jakarta.validation.Valid;

@Table(name="disciplinas")
@Entity(name="disciplinas")
public class Disciplina {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisciplina;

    private String nomeDisciplina;

    Long idProfessor;

    String nomeProfessor;

    String telefone;

    public Disciplina(@Valid DadosCadastroDisciplina dados) {
        super();
    }

    public Disciplina(Long idDisciplina, String nomeDisciplina, Long idProfessor, String nomeProfessor) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.idProfessor = idProfessor;
        this.nomeProfessor = nomeProfessor;

    }

    public Disciplina() {
    }


    public void atualizarInformacoes(@Valid DadosAtualizarDisciplina dados){
        if(dados.nomeDisciplina()!=null){
            this.nomeDisciplina = dados.nomeDisciplina();
        }
        if(dados.idProfessor()!=null){
            this.idProfessor= dados.idProfessor();
        }
        if(dados.nomeProfessor()!=null){
            this.nomeProfessor = dados.nomeProfessor();
        }
    }

    public Long getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

}
