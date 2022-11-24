package com.server.sobrouemcasa.service;

import com.server.sobrouemcasa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.server.sobrouemcasa.model.Usuario;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(String email, String senha) {
        Optional<Usuario> opUsuario = usuarioRepository.findOneByEmailIgnoreCaseAndSenha(email, senha);
        return opUsuario.orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Usuário ou senha incorretos"));
    }
}
