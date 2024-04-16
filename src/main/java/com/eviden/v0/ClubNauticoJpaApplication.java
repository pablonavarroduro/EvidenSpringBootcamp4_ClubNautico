package com.eviden.v0;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eviden.v0.modelo.Embarcacion;
import com.eviden.v0.modelo.SocioClubNautico;
import com.eviden.v0.negocio.GestorClubNautico;

@SpringBootApplication
public class ClubNauticoJpaApplication implements CommandLineRunner {
	
	@Autowired
	private GestorClubNautico gestor;
	
	public static void main(String[] args) {
		SpringApplication.run(ClubNauticoJpaApplication.class, args);		
		
	}

	@Override
	public void run(String... args) throws Exception {
		Embarcacion emb1 = new Embarcacion();
		emb1.setMatricula(null);emb1.setNombre(null);emb1.setCuota(null);emb1.setNumero_amarre(null);
		emb1.setSalidas(null);
				
		List<Embarcacion> listaEmb = new ArrayList<>();
		listaEmb.add(emb1);
		
		SocioClubNautico socio1 = new SocioClubNautico();
		socio1.setNombre("Pablo");
		socio1.setPrimerApellido("Navarro");
		socio1.setSegundoApellido("Duro");
		socio1.setBarcos_en_propiedad(listaEmb);
		
		gestor.createSocio(socio1);
		
		List<SocioClubNautico> lista_socios = gestor.findAllSocios();
		
		for (SocioClubNautico socioClubNautico : lista_socios) {
			System.out.println(socioClubNautico.toString());
		}
		
	}

	
	
	

}
