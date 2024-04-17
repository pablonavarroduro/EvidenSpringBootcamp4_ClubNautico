package com.eviden.v0.modelo;

import jakarta.persistence.Embeddable;

@Embeddable
public class UsuarioClubNautico {
	private String DNI;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	
	public UsuarioClubNautico() {
		
	}
	
	public UsuarioClubNautico(String dNI, String nombre, String primerApellido, String segundoApellido) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
	}
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
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
	@Override
	public String toString() {
		return " Conductor [DNI=" + DNI + ", nombre=" + nombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + "]";
	}
	

}
