package com.api.dto.response;

import com.api.model.ColaboradorModel;
import com.api.model.GestorModel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

/**
 *
 * @author Miguel Castro
 */
@Schema(name = "Gestor - response")
public class GestorResponse {

    private Long id;

    private String nome;

    private String senha;

    private String score_senha;

    public GestorResponse() {
    }

    public GestorResponse(Long id, String nome, String senha, String score_senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.score_senha = score_senha;
    }

    public static GestorResponse converterEntidadeParaGestorResponse(GestorModel gestorModel) {
        return new GestorResponse(gestorModel.getId(), gestorModel.getNome(),
                gestorModel.getSenha(), gestorModel.getScore_senha());
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
}
