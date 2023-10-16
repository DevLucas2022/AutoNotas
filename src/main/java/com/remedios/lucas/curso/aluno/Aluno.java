package com.remedios.lucas.curso.aluno;


import com.remedios.lucas.curso.professor.DadosAtualizarProfessor;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "alunos")
@Entity(name = "alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class  Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String curso;

    @Column(unique = true)
    private String ra;

    @Column(unique = true)
    private String email;

    private String cep;
    private String senha;
    private String logradouro;
    private String bairro;
    private String localidade;
    public Aluno(DadosCadastroAluno dados){
        this.nome = dados.nome();
        this.curso = dados.curso();
        this.email = dados.email();
        this.ra = dados.ra();
        this.senha = dados.senha();
        this.cep = dados.cep();
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

    public String getRa() { return ra; }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }
    @Override
    public String toString() {
        return "Endereco{" + "logradouro=" + logradouro + ", bairro=" + bairro + ", localidade=" + localidade + '}';
    }

    public String getCep() {
        return cep;
    }
}
