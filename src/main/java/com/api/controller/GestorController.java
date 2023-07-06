package com.api.controller;

import com.api.dto.request.GestorRequest;
import com.api.dto.response.GestorResponse;
import com.api.model.GestorModel;
import com.api.service.GestorService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/listar")
    public ResponseEntity<List<GestorResponse>> listar() {

        return new ResponseEntity<List<GestorResponse>>(
                gestorService.listar().stream().map(gestor
                        -> GestorResponse.converterEntidadeParaGestorResponse(gestor))
                        .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public ResponseEntity<GestorResponse> salvar(@Valid @RequestBody GestorRequest gestorRequest) {

        GestorModel gestorModel = gestorService.salvar(gestorRequest.converterGestorRequestParaEntidade());
        return new ResponseEntity<GestorResponse>(GestorResponse.converterEntidadeParaGestorResponse(gestorModel), HttpStatus.OK);
    }
}
