package com.server.sobrouemcasa.service;

import com.server.sobrouemcasa.dto.RetFiltroDoacaoDTO;
import com.server.sobrouemcasa.model.Doacao;
import com.server.sobrouemcasa.model.Ong;
import com.server.sobrouemcasa.repository.OngRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
public class OngService {

    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DoacaoService doacaoService;


    public Ong saveOng(Ong ong) {
        return ongRepository.save(ong);
    }

    public Ong cadastroOng(Ong ong) {
        return saveOng(ong);
    }

    public void deleteOng(Long id) {
        getOngById(id);
        ongRepository.deleteById(id);
    }
    
    public Ong getOngById(Long id) {
        Optional<Ong> opOng = ongRepository.findById(id);
        return opOng.orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "ONG  não encontrada"));
    }

    public Ong updateOng(Long id, Ong ong) {
        Ong ongAntes = getOngById(id);
        ongAntes.setCnpj(ong.getCnpj());
        ongAntes.setDataConstituicao(ong.getDataConstituicao());
        ongAntes.setEmail(ong.getEmail());
        ongAntes.setFinalidadeInstitucional(ong.getFinalidadeInstitucional());

        return ongRepository.save(ongAntes);
    }

    public List<RetFiltroDoacaoDTO> buscaDoacaoPorDistancia(Long idOng, int filtroKM){
        
        //Ong que será considerada no filtro
        Ong ong = getOngById(idOng);
        //Variavel auxiliar para armazenar o resultado do calculo da distancia ONG->Doação
        Float distancia;
        //Lista de doações armazenadas
        List<Doacao> doacoes = doacaoService.getAllDoacoes();

        for(Doacao doacao : doacoes){
            
        }

        return null;
    }
}
