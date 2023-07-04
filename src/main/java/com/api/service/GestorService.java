package com.api.service;

import com.api.model.GestorModel;
import com.api.repository.GestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class GestorService {
    
    @Autowired
    private GestorRepository gestorRepository;
    
    public GestorModel salvar(GestorModel gestorModel) {
        
        return gestorRepository.save(gestorModel);
    }
}
