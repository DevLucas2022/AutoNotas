package com.remedios.lucas.curso.remedio;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.time.LocalDate;

@Table(name = "remedios")
@Entity(name = "remedios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Via via;

    private String lote;
    private int quantidade;
    private LocalDate validade;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    public Remedio(DadosCadastroRemedio dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();


        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();
    }

    public void atualizarInformacoes(@Valid DadosAtualizarRemedio dados){
        if(dados.nome()!= null){
            this.nome = dados.nome();
        }
        if(dados.via()!=null){
            this.via = dados.via();
        }
        if(dados.laboratorio()!=null){
            this.laboratorio = dados.laboratorio();
        }

    }

    public void inativar(){
        this.ativo = false;
    }

    public void ativar(){
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Via getVia() {
        return via;
    }

    public String getLote() {
        return lote;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }
}
