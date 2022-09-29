package com.server.sobrouemcasa.service;

import com.server.sobrouemcasa.model.Ong;
import com.server.sobrouemcasa.model.Usuario;
import com.server.sobrouemcasa.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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

    public Ong updateOng(Long id, Ong ong) {
        Ong ongAntes = getOngById(id);
        ongAntes.setCnpj(ong.getCnpj());
        ongAntes.setDataConstitucional(ong.getDataConstitucional());
        ongAntes.setEmail(ong.getEmail());
        ongAntes.setFinalidadeInstitucional(ong.getFinalidadeInstitucional());
        ongAntes.setUsuario(ong.getUsuario());

        return ongRepository.save(ongAntes);
    }

    public Ong getOngById(Long id) {
        Optional<Ong> opOng = ongRepository.findById(id);
        return opOng.orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "ONG não encontradoa!"));
    }

}
