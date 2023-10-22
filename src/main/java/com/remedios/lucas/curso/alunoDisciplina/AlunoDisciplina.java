package com.remedios.lucas.curso.alunoDisciplina;


import com.remedios.lucas.curso.disciplinas.DadosCadastroDisciplina;
import jakarta.persistence.*;
import jakarta.validation.Valid;

@Table(name="alunoDisciplinas")
@Entity(name="alunoDisciplinas")
public class AlunoDisciplina {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlunoDisciplina;

    private Long idAluno;
    private String nomeAluno;
    private Long idDisciplina;
    private String nomeDisciplina;
    private Long idProfessor;
    private String nomeProfessor;
    private Long nota1;
    private Long nota2;
    private Long notaAtividade;
    private Long media;

    public AlunoDisciplina(Long idAlunoDisciplina, Long idAluno, String nomeAluno, Long idDisciplina, String nomeDisciplina, Long idProfessor, String nomeProfessor, Long nota1, Long nota2, Long notaAtividade, Long media) {
        this.idAlunoDisciplina = idAlunoDisciplina;
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.idProfessor = idProfessor;
        this.nomeProfessor = nomeProfessor;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notaAtividade = notaAtividade;
        this.media = media;
    }

    public AlunoDisciplina() {
    }

    public Long getIdAlunoDisciplina() {
        return idAlunoDisciplina;
    }

    public void setIdAlunoDisciplina(Long idAlunoDisciplina) {
        this.idAlunoDisciplina = idAlunoDisciplina;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
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

    public Long getNota1() {
        return nota1;
    }

    public void setNota1(Long nota1) {
        this.nota1 = nota1;
    }

    public Long getNota2() {
        return nota2;
    }

    public void setNota2(Long nota2) {
        this.nota2 = nota2;
    }

    public Long getNotaAtividade() {
        return notaAtividade;
    }

    public void setNotaAtividade(Long notaAtividade) {
        this.notaAtividade = notaAtividade;
    }

    public Long getMedia() {
        return media;
    }

    public void setMedia(Long media) {
        this.media = media;
    }
}
