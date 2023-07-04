package com.api.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Miguel Castro
 */
@Entity
public class GestorModel implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "gestor", cascade = CascadeType.ALL)
    @Column(nullable = false)
    private List<ColaboradorModel> colaboradores;

    public GestorModel() {
    }

    public GestorModel(Long id, String nome, String senha, List<ColaboradorModel> colaboradores) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.colaboradores = colaboradores;
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

    public List<ColaboradorModel> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<ColaboradorModel> colaboradores) {
        this.colaboradores = colaboradores;
    }
}
