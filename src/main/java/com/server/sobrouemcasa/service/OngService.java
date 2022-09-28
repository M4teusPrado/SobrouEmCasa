package com.server.sobrouemcasa.service;

import com.server.sobrouemcasa.model.Ong;
import com.server.sobrouemcasa.model.Usuario;
import com.server.sobrouemcasa.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OngService {


    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Ong cadastrarOng(Long idDoador, Ong ong) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(idDoador);

        usuario.ifPresent(ong::setUsuario);
        return ongRepository.save(ong);
    }
}
