package com.api.controller;

import com.api.model.ColaboradorModel;
import com.api.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Castro
 */
@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping("/salvar")
    public ResponseEntity<ColaboradorModel> salvar(@RequestBody ColaboradorModel colaboradorModel) {

        return new ResponseEntity<ColaboradorModel>(colaboradorService.salvar(colaboradorModel), HttpStatus.OK);
    }
}
