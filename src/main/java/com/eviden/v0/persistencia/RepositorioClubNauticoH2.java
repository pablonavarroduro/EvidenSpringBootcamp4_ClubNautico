package com.eviden.v0.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eviden.v0.modelo.SocioClubNautico;

@Repository
public interface RepositorioClubNauticoH2 extends JpaRepository<SocioClubNautico, Integer> {

}
