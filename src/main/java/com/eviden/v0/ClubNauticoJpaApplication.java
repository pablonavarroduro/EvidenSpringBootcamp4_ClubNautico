package com.eviden.v0;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eviden.v0.modelo.Embarcacion;
import com.eviden.v0.modelo.SalidaRealizada;
import com.eviden.v0.modelo.SocioClubNautico;
import com.eviden.v0.modelo.UsuarioClubNautico;
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
		
		SalidaRealizada sal1 = new SalidaRealizada();
		SalidaRealizada sal2 = new SalidaRealizada();
		SalidaRealizada sal3 = new SalidaRealizada();
		SalidaRealizada sal4 = new SalidaRealizada();
		sal1.setUsuario(new UsuarioClubNautico("0000000X", "Pepe", "Palotes", "Rubio"));
		sal1.setDestino("Malaga");
		sal1.setFecha_salida(new Date());
		sal2.setUsuario(new UsuarioClubNautico("0000010J", "Paco", "Pil", "Gomez"));
		sal2.setDestino("Mojacar");
		sal2.setFecha_salida(new Date());
		sal3.setUsuario(new UsuarioClubNautico("0000450U", "Pablo", "Navarro", "Duro"));
		sal3.setDestino("Valencia");
		sal3.setFecha_salida(new Date());
		sal4.setUsuario(new UsuarioClubNautico("0030510P", "Maria", "J.", "Gomez"));
		sal4.setDestino("Barcelona");
		sal4.setFecha_salida(new Date());
		
		List<SalidaRealizada> listasal1 = new ArrayList<>();
		List<SalidaRealizada> listasal2 = new ArrayList<>();
		
		listasal1.add(sal4);
		listasal1.add(sal2);
		listasal2.add(sal3);
		listasal2.add(sal1);
		
		Embarcacion emb1 = new Embarcacion();
		emb1.setMatricula("HR9787F");emb1.setNombre("Pescaito");emb1.setCuota(340.45);emb1.setNumero_amarre(23);
		emb1.setSalidas(listasal1);
		
		Embarcacion emb2 = new Embarcacion();
		emb2.setMatricula("FG8763T");emb2.setNombre("Colombiano");emb2.setCuota(230.34);emb2.setNumero_amarre(12);
		emb2.setSalidas(listasal2);
		
		for (SalidaRealizada salidaRealizada : listasal2) {
			salidaRealizada.setEmbarcacion(emb2);
		}
		
		for (SalidaRealizada salidaRealizada : listasal1) {
			salidaRealizada.setEmbarcacion(emb1);
		}
		
				
		List<Embarcacion> listaEmb = new ArrayList<>();
		listaEmb.add(emb1);
		listaEmb.add(emb2);
		
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
