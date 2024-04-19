package com.eviden.v0.modelo;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name = "Embarcaciones", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class Embarcacion {
	@Id	
	private String matricula;
	@Column
	private String nombre;
	private Integer numero_amarre;
	private Double cuota;
	
	@OneToMany(mappedBy = "embarcacion", cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<SalidaRealizada> salidas;
	@Nonnull
	@ManyToOne
	@JoinColumn(name = "fk_id_socio", referencedColumnName = "id")
	private SocioClubNautico socio;
	
	public Embarcacion() {
		
	}
	
	public Embarcacion(String matricula, String nombre, Integer numero_amarre, Double cuota,
			List<SalidaRealizada> salidas, SocioClubNautico socio) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.numero_amarre = numero_amarre;
		this.cuota = cuota;
		this.salidas = salidas;
		this.socio = socio;
	}

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
	
	public SocioClubNautico getSocio() {
		return socio;
	}

	public void setSocio(SocioClubNautico socio) {
		this.socio = socio;
	}

	@Override
	public String toString() {
		return "Embarcacion [matricula=" + matricula + ", nombre=" + nombre + ", numero_amarre=" + numero_amarre
				+ ", cuota=" + cuota + ", salidas=" + salidas.toString() + "]";
	}
	
	

	
}
