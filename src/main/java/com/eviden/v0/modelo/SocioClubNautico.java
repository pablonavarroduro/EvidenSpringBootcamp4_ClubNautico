package com.eviden.v0.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Socios")
public class SocioClubNautico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")
	private Integer idSocio;
	
	@Column	
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	
	@OneToMany(mappedBy = "socio", cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Embarcacion> barcos_en_propiedad;
	
	public SocioClubNautico() {
		
	}
	
	public SocioClubNautico(Integer idSocio, String nombre, String primerApellido, String segundoApellido,
			List<Embarcacion> barcos_en_propiedad) {
		super();
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.barcos_en_propiedad = barcos_en_propiedad;
	}
	public Integer getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(Integer idSocio) {
		this.idSocio = idSocio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public List<Embarcacion> getBarcos_en_propiedad() {
		return barcos_en_propiedad;
	}
	public void setBarcos_en_propiedad(List<Embarcacion> barcos_en_propiedad) {
		this.barcos_en_propiedad = barcos_en_propiedad;
	}
	@Override
	public String toString() {
		return "SocioClubNautico [idSocio=" + idSocio + ", nombre=" + nombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", barcos_en_propiedad=" + barcos_en_propiedad.toString() + "]";
	}
	
}
