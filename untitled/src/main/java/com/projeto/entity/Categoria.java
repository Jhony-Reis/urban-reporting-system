package com.projeto.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")

public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer gravidade;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Denuncia> denuncias;

    // CONSTRUTOR VAZIO
    public Categoria() {
    }

    // CONSTRUTOR COMPLETO
    public Categoria(Long id,
                     String nome,
                     Integer gravidade,
                     List<Denuncia> denuncias) {

        this.id = id;
        this.nome = nome;
        this.gravidade = gravidade;
        this.denuncias = denuncias;
    }

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getGravidade() {
        return gravidade;
    }

    public void setGravidade(Integer gravidade) {
        this.gravidade = gravidade;
    }

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }
}