package com.api.controller;

import com.api.dto.request.ColaboradorRequest;
import com.api.dto.response.ColaboradorResponse;
import com.api.model.ColaboradorModel;
import com.api.service.ColaboradorService;
import java.util.List;
import java.util.stream.Collectors;
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
@RequestMapping("/colaborador")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping("/listar")
    public ResponseEntity<List<ColaboradorResponse>> listar() {

        return new ResponseEntity<List<ColaboradorResponse>>(
                colaboradorService.listar().stream().map(colaborador
                        -> ColaboradorResponse.converterEntidadeParaColaboradorResponse(colaborador))
                        .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public ResponseEntity<ColaboradorResponse> salvar(@RequestBody ColaboradorRequest colaboradorRequest) {

        ColaboradorModel colaboradorModel = colaboradorService.salvar(colaboradorRequest.converterColaboradorRequestParaEntidade());
        return new ResponseEntity<ColaboradorResponse>(ColaboradorResponse.converterEntidadeParaColaboradorResponse(colaboradorModel), HttpStatus.OK);
    }
}
