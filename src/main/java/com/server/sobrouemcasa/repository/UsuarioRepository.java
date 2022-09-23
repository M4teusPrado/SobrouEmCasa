package com.server.sobrouemcasa.repository;

import com.server.sobrouemcasa.model.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findOneByEmailIgnoreCaseAndSenha(String email, String senha);

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByCpf(String cpf);
}