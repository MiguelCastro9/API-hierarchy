package com.api.service;

import com.api.model.GestorModel;
import com.api.repository.GestorRepository;
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
    
    public GestorModel salvar(GestorModel gestorModel) {
        
        String senhaCriptografada = encoder.encode(gestorModel.getSenha());
        gestorModel.setSenha(senhaCriptografada);
        return gestorRepository.save(gestorModel);
    }
}
