package com.eviden.v0.modelo;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Scope(value="prototype")
@Entity
@Table(name = "Salidas")
public class SalidaRealizada {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSalida;
	@Column
	private Date fecha_salida;
	private String destino;
	@Embedded
	private UsuarioClubNautico usuario;

	public Integer getIdSalida() {
		return idSalida;
	}

	public void setIdSalida(Integer idSalida) {
		this.idSalida = idSalida;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public UsuarioClubNautico getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioClubNautico usuario) {
		this.usuario = usuario;
	}

}
