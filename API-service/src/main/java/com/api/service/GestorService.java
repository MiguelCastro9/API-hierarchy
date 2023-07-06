package com.api.service;

import com.api.model.GestorModel;
import com.api.repository.GestorRepository;
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
public class GestorService {

    @Autowired
    private GestorRepository gestorRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;
    
        public List<GestorModel> listar() {
        
        return gestorRepository.findAll();
    }

    public GestorModel salvar(GestorModel gestorModel) {

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

        for (int i = 0; i < gestorModel.getSenha().length(); i++) {

            numeroCaracteres++;
            calculoNumeroCaracteres = numeroCaracteres * 4;

            if (Character.isUpperCase(gestorModel.getSenha().charAt(i))) {
                numeroCaracteresMaiusculas++;
                calculoNumeroCaracteresMaiusculas = (gestorModel.getSenha().length() - numeroCaracteresMaiusculas) * 2;
            }

            if (Character.isLowerCase(gestorModel.getSenha().charAt(i))) {
                numeroCaracteresMinusculas++;
                calculoNumeroCaracteresMinusculas = (gestorModel.getSenha().length() - numeroCaracteresMinusculas) * 2;
            }

            if (Character.isDigit(gestorModel.getSenha().charAt(i))) {
                totalNumeros++;
                calculoTotalNumeros = totalNumeros * 4;
            }

            if (simbolosPattern.matcher(Character.toString(gestorModel.getSenha().charAt(i))).matches()) {
                totalSimbolos++;
                calculoTotalSimbolos = totalSimbolos * 6;
            }

            if (i > 0 && i < gestorModel.getSenha().length() - 1) {
                if (Character.isDigit(gestorModel.getSenha().charAt(i))
                        || simbolosPattern.matcher(Character.toString(gestorModel.getSenha().charAt(i))).matches()) {
                    totalNumerosSimbolos++;
                    calculoTotalNumerosSimbolos = totalNumerosSimbolos * 2;
                }
            }
        }

        if (gestorModel.getSenha().matches("[A-Za-z]+")) {
            calculoSomenteLetras = gestorModel.getSenha().length();
        }

        if (gestorModel.getSenha().matches("[0-9]+")) {
            calculoSomenteNumeros = gestorModel.getSenha().length();
        }

        totalAditivos = (calculoNumeroCaracteres + calculoNumeroCaracteresMaiusculas
                + calculoNumeroCaracteresMinusculas + calculoTotalNumeros + calculoTotalSimbolos + calculoTotalNumerosSimbolos);

        String senhaCriptografada = encoder.encode(gestorModel.getSenha());
        gestorModel.setSenha(senhaCriptografada);

        totalDeducoes = (calculoSomenteLetras + calculoSomenteNumeros);
        gestorModel.setScore_senha((totalAditivos - totalDeducoes) + "%");

        return gestorRepository.save(gestorModel);
    }
}
