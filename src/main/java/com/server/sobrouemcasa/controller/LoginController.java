package com.server.sobrouemcasa.controller;

import com.google.gson.Gson;
import com.server.sobrouemcasa.model.Doador;
import com.server.sobrouemcasa.model.Endereco;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
    public ResponseEntity<Doador> cadastrar(@Valid @RequestBody Doador doador) throws IOException {
        integracaoViaCep(doador);
        return ResponseEntity.ok().body(doadorService.cadastrarDoador(doador));
    }

    @PostMapping("/cadastrar/pj")
    public ResponseEntity<Ong> cadastrar(@Valid @RequestBody Ong ong) throws IOException {
        integracaoViaCep(ong);
        return ResponseEntity.ok().body(ongService.cadastroOng(ong));
    }

    private void integracaoViaCep(Usuario usuario) throws IOException {

        URL url = new URL("https://viacep.com.br/ws/" + usuario.getEndereco().getCep() + "/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        StringBuilder jsonCep = new StringBuilder();
        String buffer = "";
        while ((buffer = br.readLine()) != null)
            jsonCep.append(buffer);
        usuario.setEndereco(new Gson().fromJson(String.valueOf(jsonCep), Endereco.class));
    }
}