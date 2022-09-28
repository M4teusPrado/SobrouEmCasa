package com.server.sobrouemcasa.repository;

import com.server.sobrouemcasa.model.Doacao;
import com.server.sobrouemcasa.model.Ong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OngRepository extends JpaRepository<Ong, Long> {

}
