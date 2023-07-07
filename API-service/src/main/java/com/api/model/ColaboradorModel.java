package com.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Miguel Castro
 */
@Entity
@Schema(name = "Colaborador - model")
public class ColaboradorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Integer score_senha;

    @ManyToOne
    @JoinColumn(name = "gestor_id", nullable = false)
    private GestorModel gestor;

    public ColaboradorModel() {
    }

    public ColaboradorModel(Long id, String nome, String senha, Integer score_senha, GestorModel gestor) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.score_senha = score_senha;
        this.gestor = gestor;
    }

    public ColaboradorModel(String nome, String senha, Integer score_senha, GestorModel gestor) {
        this.nome = nome;
        this.senha = senha;
        this.score_senha = score_senha;
        this.gestor = gestor;
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getScore_senha() {
        return score_senha;
    }

    public void setScore_senha(Integer score_senha) {
        this.score_senha = score_senha;
    }

    public GestorModel getGestor() {
        return gestor;
    }

    public void setGestor(GestorModel gestor) {
        this.gestor = gestor;
    }
}
