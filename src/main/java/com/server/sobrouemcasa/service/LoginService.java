package com.server.sobrouemcasa.service;

import com.server.sobrouemcasa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.server.sobrouemcasa.model.Usuario;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    public Usuario login(String email, String senha) {
        Optional<Usuario> opUsuario = usuarioRepository.findOneByEmailIgnoreCase(email);
        opUsuario.orElseThrow( () -> new ResponseStatusException( HttpStatus.UNAUTHORIZED, "E-mail não localizado"));
        return validarSenha(opUsuario.get(), senha);
    }

    private Usuario validarSenha(Usuario usuario, String senha){
        if (encoder.matches(senha, usuario.getSenha())) return usuario;
        throw new ResponseStatusException( HttpStatus.UNAUTHORIZED, "Senha não correspondente");
    }
}
