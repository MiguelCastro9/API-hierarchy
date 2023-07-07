package com.api.dto.request;

import com.api.model.GestorModel;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Miguel Castro
 */
@Schema(name = "Gestor - request")
public class GestorRequest {

    @NotBlank(message = "Nome é obrigatório.")
    @Length(min = 3, max = 20, message = "Nome requer no mínimo {min} e no máximo {max} caracteres.")
    private String nome;

    @NotBlank(message = "Senha é obrigatório.")
    @Length(min = 3, max = 20, message = "Senha requer no mínimo {min} e no máximo {max} caracteres.")
    private String senha;

    private Integer score_senha;

    public GestorModel converterGestorRequestParaEntidade() {
        return new GestorModel(nome, senha, score_senha);
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
}
