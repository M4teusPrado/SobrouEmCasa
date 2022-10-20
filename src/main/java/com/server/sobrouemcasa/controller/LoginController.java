package com.server.sobrouemcasa.controller;

import com.server.sobrouemcasa.model.Doador;
import com.server.sobrouemcasa.model.Ong;
import com.server.sobrouemcasa.model.Usuario;
import com.server.sobrouemcasa.service.DoadorService;
import com.server.sobrouemcasa.service.LoginService;
import com.server.sobrouemcasa.service.OngService;
import com.server.sobrouemcasa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LoginService loginService;

    @GetMapping
    public  ResponseEntity<Usuario> login(Usuario usuario){
        return ResponseEntity.ok().body(loginService.loginUsuario(usuario.getEmail(), usuario.getSenha()));
    }

    @Autowired
    private DoadorService doadorService;

    @Autowired
    private OngService ongService;

    @PostMapping("/cadastrar/pf")
    public ResponseEntity<Doador> cadastrar(@Valid @RequestBody Doador doador) {
        return ResponseEntity.ok().body(doadorService.cadastrarDoador(doador));
    }

    @PostMapping("/cadastrar/pj")
    public ResponseEntity<Ong> cadastrar(@Valid @RequestBody Ong ong) {
        return ResponseEntity.ok().body(ongService.cadastroOng(ong));
    }
}