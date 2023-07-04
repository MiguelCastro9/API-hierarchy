package com.api.service;

import com.api.model.ColaboradorModel;
import com.api.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public ColaboradorModel salvar(ColaboradorModel colaboradorModel) {

        return colaboradorRepository.save(colaboradorModel);
    }
}
