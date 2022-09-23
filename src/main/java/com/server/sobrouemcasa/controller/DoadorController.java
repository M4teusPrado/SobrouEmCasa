package com.server.sobrouemcasa.controller;

import com.server.sobrouemcasa.service.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doador")
public class DoadorController {

    @Autowired
    private DoadorService doadorService;

    @Autowired
    private DoacaoService doacaoService;


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDoador(@PathVariable Long id) {
        doadorService.deleteDoador(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("{id}/doacao")
    public ResponseEntity<Doacao> cadastroDoacao(@PathVariable Long id, @RequestBody Doacao doacao) {
        return ResponseEntity.ok().body(doacaoService.cadastrarDoacao(id,doacao));
    }

}
