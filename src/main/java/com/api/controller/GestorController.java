package com.api.controller;

import com.api.model.GestorModel;
import com.api.service.GestorService;
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
@RequestMapping("/gestor")
public class GestorController {
    
    
    @Autowired
    private GestorService gestorService;
    
    @PostMapping("/salvar")
    public ResponseEntity<GestorModel> salvar(@RequestBody GestorModel gestorModel) {
        
        return new ResponseEntity<GestorModel>(gestorService.salvar(gestorModel), HttpStatus.OK);
    }
}
