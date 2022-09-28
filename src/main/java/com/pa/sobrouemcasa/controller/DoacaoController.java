package com.pa.sobrouemcasa.controller;

import com.pa.sobrouemcasa.model.Doacao;
import com.pa.sobrouemcasa.service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doacao")
public class DoacaoController {


    @Autowired
    private DoacaoService doacaoService;


    @GetMapping("{id}")
    public ResponseEntity<Doacao> getDoacaoById(@PathVariable Long id){
        return ResponseEntity.ok().body(doacaoService.getDoacaoById(id));
    }

}
