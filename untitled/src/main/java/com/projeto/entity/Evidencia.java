package com.projeto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "evidencias")

public class Evidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlImagem;

    @ManyToOne
    @JoinColumn(name = "denuncia_id")
    private Denuncia denuncia;

    // CONSTRUTOR VAZIO
    public Evidencia() {
    }

    // CONSTRUTOR COMPLETO
    public Evidencia(Long id,
                     String urlImagem,
                     Denuncia denuncia) {

        this.id = id;
        this.urlImagem = urlImagem;
        this.denuncia = denuncia;
    }

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }
}