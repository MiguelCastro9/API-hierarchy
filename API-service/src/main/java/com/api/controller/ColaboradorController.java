package com.api.controller;

import com.api.dto.request.ColaboradorRequest;
import com.api.dto.response.ColaboradorResponse;
import com.api.model.ColaboradorModel;
import com.api.service.ColaboradorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@Tag(name = "Colaborador")
@CrossOrigin("*")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping("/listar")
    @Operation(description = "Listar colaborador")
    public ResponseEntity<List<ColaboradorResponse>> listar() {

        return new ResponseEntity<List<ColaboradorResponse>>(
                colaboradorService.listar().stream().map(colaborador
                        -> ColaboradorResponse.converterEntidadeParaColaboradorResponse(colaborador))
                        .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("/salvar")
    @Operation(description = "Salvar colaborador")
    public ResponseEntity<ColaboradorResponse> salvar(@Valid @RequestBody ColaboradorRequest colaboradorRequest) {

        ColaboradorModel colaboradorModel = colaboradorService.salvar(colaboradorRequest.converterColaboradorRequestParaEntidade());
        return new ResponseEntity<ColaboradorResponse>(ColaboradorResponse.converterEntidadeParaColaboradorResponse(colaboradorModel), HttpStatus.OK);
    }
}
