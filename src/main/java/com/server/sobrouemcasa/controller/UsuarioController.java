package com.server.sobrouemcasa.controller;

import com.server.sobrouemcasa.model.Usuario;
import com.server.sobrouemcasa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<Usuario> saveUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioAux = usuarioService.saveUsuario(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioAux.getId()).toUri();
        return ResponseEntity.created(uri).body(usuarioAux);
    }
}
