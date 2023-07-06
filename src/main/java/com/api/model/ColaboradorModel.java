package com.api.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Miguel Castro
 */
@Entity
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
    private String score_senha;

    @ManyToOne
    private GestorModel gestor;

    public ColaboradorModel() {
    }

    public ColaboradorModel(Long id, String nome, String senha, String score_senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.score_senha = senha;
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

    public String getScore_senha() {
        return score_senha;
    }

    public void setScore_senha(String score_senha) {
        this.score_senha = score_senha;
    }

    public GestorModel getGestor() {
        return gestor;
    }

    public void setGestor(GestorModel gestor) {
        this.gestor = gestor;
    }
}
