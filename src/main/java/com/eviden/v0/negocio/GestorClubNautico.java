package com.eviden.v0.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eviden.v0.modelo.SocioClubNautico;
import com.eviden.v0.persistencia.RepositorioClubNauticoH2;

@Service
public class GestorClubNautico {
	@Autowired
	private RepositorioClubNauticoH2 repo;
	
	public void createSocio(SocioClubNautico sc) {
		repo.save(sc);
	}
	
	public SocioClubNautico findSocio(int id) {
		return repo.getReferenceById(id);
	}
	
	public List<SocioClubNautico> findAllSocios(){
		return repo.findAll();
	}
	
	public void updateSocio(SocioClubNautico sc) {
		
	}
	
	public void deleteSocio(SocioClubNautico sc) {
		repo.delete(sc);
	}
}
