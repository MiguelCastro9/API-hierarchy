package com.api.service;

import com.api.model.ColaboradorModel;
import com.api.repository.ColaboradorRepository;
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

    public ColaboradorModel salvar(ColaboradorModel colaboradorModel) {
        
        String senhaCriptografada = encoder.encode(colaboradorModel.getSenha());
        colaboradorModel.setSenha(senhaCriptografada);
        return colaboradorRepository.save(colaboradorModel);
    }
}
