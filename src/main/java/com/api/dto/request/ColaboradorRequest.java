package com.api.dto.request;

import com.api.model.ColaboradorModel;
import com.api.model.GestorModel;

/**
 *
 * @author Miguel Castro
 */
public class ColaboradorRequest {

    private String nome;

    private String senha;

    private String score_senha;
    
    private GestorModel gestor;

    public ColaboradorModel converterColaboradorRequestParaEntidade() {
        return new ColaboradorModel(nome, senha, score_senha, gestor);
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
