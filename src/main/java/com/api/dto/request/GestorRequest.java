package com.api.dto.request;

import com.api.model.ColaboradorModel;
import com.api.model.GestorModel;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Miguel Castro
 */
public class GestorRequest {

    @NotBlank(message = "Nome é obrigatório.")
    @Length(min = 3, max = 20, message = "Nome requer no mínimo {min} e no máximo {max} caracteres.")
    private String nome;

    @NotBlank(message = "Senha é obrigatório.")
    @Length(min = 3, max = 20, message = "Senha requer no mínimo {min} e no máximo {max} caracteres.")
    private String senha;

    private String score_senha;

    private List<ColaboradorModel> colaboradores;

    public GestorModel converterGestorRequestParaEntidade() {
        return new GestorModel(nome, senha, score_senha, colaboradores);
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

    public List<ColaboradorModel> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<ColaboradorModel> colaboradores) {
        this.colaboradores = colaboradores;
    }
}
