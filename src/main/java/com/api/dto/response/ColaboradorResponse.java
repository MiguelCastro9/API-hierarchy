package com.api.dto.response;

import com.api.model.ColaboradorModel;
import com.api.model.GestorModel;

/**
 *
 * @author Miguel Castro
 */
public class ColaboradorResponse {

    private Long id;

    private String nome;

    private String senha;

    private String score_senha;
    
    private GestorModel gestor;

    public ColaboradorResponse() {
    }

    public ColaboradorResponse(Long id, String nome, String senha, String score_senha, GestorModel gestor) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.score_senha = score_senha;
        this.gestor = gestor;
    }

    public static ColaboradorResponse converterEntidadeParaColaboradorResponse(ColaboradorModel colaboradorModel) {
        return new ColaboradorResponse(colaboradorModel.getId(), colaboradorModel.getNome(), 
                colaboradorModel.getSenha(), colaboradorModel.getScore_senha(), colaboradorModel.getGestor());
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
