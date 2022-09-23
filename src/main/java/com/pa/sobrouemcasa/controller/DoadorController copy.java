package com.pa.sobrouemcasa.controller;

import com.pa.sobrouemcasa.dto.DoadorDTO;
import com.pa.sobrouemcasa.model.Doacao;
import com.pa.sobrouemcasa.model.Doador;

import com.pa.sobrouemcasa.service.DoacaoService;
import com.pa.sobrouemcasa.service.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doador")
public class DoadorController {

    @Autowired
    private DoadorService doadorService;

    @Autowired
    private DoacaoService doacaoService;

    @GetMapping("{id}")
    public ResponseEntity<Doador> getDoadorById(@PathVariable Long id){
        return ResponseEntity.ok().body(doadorService.getDoadorById(id));
    }


}
