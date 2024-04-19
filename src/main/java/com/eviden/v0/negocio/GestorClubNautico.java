package com.eviden.v0.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eviden.v0.modelo.Embarcacion;
import com.eviden.v0.modelo.SalidaRealizada;
import com.eviden.v0.modelo.SocioClubNautico;
import com.eviden.v0.modelo.UsuarioClubNautico;
import com.eviden.v0.persistencia.RepositorioClubNauticoH2;

import jakarta.transaction.Transactional;

@Service
public class GestorClubNautico {
	@Autowired
	private RepositorioClubNauticoH2 repo;
	
	@Transactional
	public void createSocio(SocioClubNautico sc) {
		repo.save(sc);
	}
	
	@Transactional
	public SocioClubNautico findSocio(int id) {
		return repo.getReferenceById(id);
	}
	
	@Transactional
	public List<SocioClubNautico> findAllSocios(){
		return repo.findAll();
	}
	
	@Transactional
	public void updateSocio(int id, SocioClubNautico sc) {
		if(repo.findById(id) != null) {
			SocioClubNautico aux = repo.getReferenceById(id);
			aux.setNombre(sc.getNombre());
			aux.setPrimerApellido(sc.getPrimerApellido());
			aux.setSegundoApellido(sc.getSegundoApellido());
			aux.setBarcos_en_propiedad(sc.getBarcos_en_propiedad());
			
			repo.save(aux);
		}
	}
	
	@Transactional
	public void deleteSocio(SocioClubNautico sc) {
		repo.delete(sc);
	}
	
	// gestor de embarcaciones
	
	@Transactional
	public void createEmbarcacion(int idsocio, Embarcacion emb) {
		SocioClubNautico soc = findSocio(idsocio);
		List<Embarcacion> lista = soc.getBarcos_en_propiedad();
		lista.add(emb);
		soc.setBarcos_en_propiedad(lista);
		repo.save(soc);
	}
	
	@Transactional
	public Embarcacion findEmbarcacion(String matricula) {
		return repo.findEmbarcacionByMatricula(matricula);
	}
	
	@Transactional
	public List<Embarcacion> findAllEmbarcacion(int idsocio){
		SocioClubNautico soc = findSocio(idsocio);
		return soc.getBarcos_en_propiedad();
	}
	
	@Transactional
	public List<Embarcacion> findAllEmbarcacionxSocio(int idsocio){
		return repo.findAllEmbarcacionBySocio(idsocio);
	}
	
	@Transactional
	public void updateEmbarcacion(int idsocio, Embarcacion emb) {
		SocioClubNautico soc = findSocio(idsocio);
		List<Embarcacion> lista = soc.getBarcos_en_propiedad();
		for (Embarcacion embarcacion : lista) {
			if(embarcacion.getMatricula().equals(emb.getMatricula())) {
				embarcacion = emb;
			}
		}
	}
	
	@Transactional
	public void deleteEmbarcacion(int idsocio, Embarcacion emb) {
		SocioClubNautico soc = findSocio(idsocio);
		List<Embarcacion> lista = soc.getBarcos_en_propiedad();
		for (Embarcacion embarcacion : lista) {
			if(embarcacion.getMatricula().equals(emb.getMatricula())) {
				lista.remove(embarcacion);
			}
		}
		repo.save(soc);
	}
	
	//gestor de salidas
	@Transactional
	public void createSalida(String matricula, SalidaRealizada sr) {
		Embarcacion em = findEmbarcacion(matricula);
		List<SalidaRealizada> lista = em.getSalidas();
		lista.add(sr);
		em.setSalidas(lista);
		repo.save(em.getSocio());
	}
	
	@Transactional
	public SalidaRealizada findSalida(int id) {
		
		return repo.findSalidaById(id);
	}
	
	@Transactional
	public List<SalidaRealizada> findAllSalidas(){
		
		return repo.findAllSalidas();
	}
	
	@Transactional
	public List<SalidaRealizada> findAllSalidasxEmbarcacion(String matricula){
		
		return repo.findAllSalidasByEmbarcacion(matricula);
	}
	
	@Transactional
	public void updateSalida(int idsalida) {
		
	}
	
	@Transactional
	public void deleteSalida(int idsalida) {
		
	}
	//gestor de usuarios	
	
//	@Transactional
//	public UsuarioClubNautico findUsuario(String dni) {
//		SalidaRealizada s = repo.findUsuario(dni);
//		return s.getUsuario();
//	}
	
	@Transactional
	public void findAllUsuario() {
		
	}
	
	@Transactional
	public void updateUsuario(UsuarioClubNautico usr) {
		
	}
	
	
}
