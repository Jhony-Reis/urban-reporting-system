package com.projeto.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime dataCadastro;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Denuncia> denuncias;

    // CONSTRUTOR VAZIO
    public Usuario() {
    }

    // CONSTRUTOR COMPLETO
    public Usuario(Long id,
                   String nome,
                   String email,
                   String senha,
                   Role role,
                   LocalDateTime dataCadastro,
                   List<Denuncia> denuncias) {

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.dataCadastro = dataCadastro;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }
}