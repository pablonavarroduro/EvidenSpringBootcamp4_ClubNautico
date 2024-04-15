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
@Table(name = "Embarcaciones")
public class Embarcacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String matricula;
	@Column
	private String nombre;
	private Integer numero_amarre;
	private Double cuota;
	
	private List<SalidaRealizada> salidas;
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumero_amarre() {
		return numero_amarre;
	}

	public void setNumero_amarre(Integer numero_amarre) {
		this.numero_amarre = numero_amarre;
	}

	public Double getCuota() {
		return cuota;
	}

	public void setCuota(Double cuota) {
		this.cuota = cuota;
	}

	public List<SalidaRealizada> getSalidas() {
		return salidas;
	}

	public void setSalidas(List<SalidaRealizada> salidas) {
		this.salidas = salidas;
	}

	
}
