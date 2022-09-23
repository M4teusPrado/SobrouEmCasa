package com.server.sobrouemcasa.controller;

import com.server.sobrouemcasa.dto.DoadorDTO;
import com.server.sobrouemcasa.model.Doador;
import com.server.sobrouemcasa.service.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doador")
public class DoadorController {

    @Autowired
    private DoadorService doadorService;

    @PutMapping("{id}")
    public ResponseEntity<Doador> updateDoador(@PathVariable Long id, @RequestBody DoadorDTO doador) {
        return ResponseEntity.ok().body(doadorService.updateDoador(id,doador));
    }


}
