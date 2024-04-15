package com.eviden.v0.modelo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Scope(value="prototype")
@Entity
@Table(name = "Socios")
public class SocioClubNautico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSocio;
	@Column
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	//ver el mapeo
	private List<Embarcacion> barcos_en_propiedad;
	
	
	public int getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(int idSocio) {
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
	
}
