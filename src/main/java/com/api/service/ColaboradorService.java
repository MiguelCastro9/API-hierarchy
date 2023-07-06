package com.api.service;

import com.api.model.ColaboradorModel;
import com.api.repository.ColaboradorRepository;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;
    
    public List<ColaboradorModel> listar() {
        
        return colaboradorRepository.findAll();
    }

    public ColaboradorModel salvar(ColaboradorModel colaboradorModel) {

        Pattern simbolosPattern = Pattern.compile("[^a-zA-Z0-9_]");
        Integer totalAditivos = 0;
        Integer totalDeducoes = 0;

        Integer numeroCaracteres = 0;
        Integer calculoNumeroCaracteres = 0;

        Integer numeroCaracteresMaiusculas = 0;
        Integer calculoNumeroCaracteresMaiusculas = 0;

        Integer numeroCaracteresMinusculas = 0;
        Integer calculoNumeroCaracteresMinusculas = 0;

        Integer totalNumeros = 0;
        Integer calculoTotalNumeros = 0;

        Integer totalSimbolos = 0;
        Integer calculoTotalSimbolos = 0;

        Integer totalNumerosSimbolos = 0;
        Integer calculoTotalNumerosSimbolos = 0;

        Integer calculoSomenteLetras = 0;
        Integer calculoSomenteNumeros = 0;

        for (int i = 0; i < colaboradorModel.getSenha().length(); i++) {

            numeroCaracteres++;
            calculoNumeroCaracteres = numeroCaracteres * 4;

            if (Character.isUpperCase(colaboradorModel.getSenha().charAt(i))) {
                numeroCaracteresMaiusculas++;
                calculoNumeroCaracteresMaiusculas = (colaboradorModel.getSenha().length() - numeroCaracteresMaiusculas) * 2;
            }

            if (Character.isLowerCase(colaboradorModel.getSenha().charAt(i))) {
                numeroCaracteresMinusculas++;
                calculoNumeroCaracteresMinusculas = (colaboradorModel.getSenha().length() - numeroCaracteresMinusculas) * 2;
            }

            if (Character.isDigit(colaboradorModel.getSenha().charAt(i))) {
                totalNumeros++;
                calculoTotalNumeros = totalNumeros * 4;
            }

            if (simbolosPattern.matcher(Character.toString(colaboradorModel.getSenha().charAt(i))).matches()) {
                totalSimbolos++;
                calculoTotalSimbolos = totalSimbolos * 6;
            }

            if (i > 0 && i < colaboradorModel.getSenha().length() - 1) {
                if (Character.isDigit(colaboradorModel.getSenha().charAt(i)) || 
                        simbolosPattern.matcher(Character.toString(colaboradorModel.getSenha().charAt(i))).matches()) {
                    totalNumerosSimbolos++;
                    calculoTotalNumerosSimbolos = totalNumerosSimbolos * 2;
                }
            }
        }

        if (colaboradorModel.getSenha().matches("[A-Za-z]+")) {
            calculoSomenteLetras = colaboradorModel.getSenha().length();
        }

        if (colaboradorModel.getSenha().matches("[0-9]+")) {
            calculoSomenteNumeros = colaboradorModel.getSenha().length();
        }

        totalAditivos = (calculoNumeroCaracteres + calculoNumeroCaracteresMaiusculas
                + calculoNumeroCaracteresMinusculas + calculoTotalNumeros + calculoTotalSimbolos + calculoTotalNumerosSimbolos);

        String senhaCriptografada = encoder.encode(colaboradorModel.getSenha());
        colaboradorModel.setSenha(senhaCriptografada);

        totalDeducoes = (calculoSomenteLetras + calculoSomenteNumeros);
        colaboradorModel.setScore_senha((totalAditivos - totalDeducoes) + "%");

        return colaboradorRepository.save(colaboradorModel);
    }
}
