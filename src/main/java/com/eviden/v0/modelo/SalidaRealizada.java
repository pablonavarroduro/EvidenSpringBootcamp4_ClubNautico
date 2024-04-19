package com.eviden.v0.modelo;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "Salidas")
public class SalidaRealizada {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_salida")
	private Integer idSalida;
	@Column
	private String destino;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_salida;
	
	@Nonnull
	@Embedded
	private UsuarioClubNautico usuario;
	@Nonnull
	@ManyToOne
	@JoinColumn(name = "fk_matricula_embarcacion", referencedColumnName = "matricula")
	private Embarcacion embarcacion;
	
	public SalidaRealizada() {
		
	}
	
	public SalidaRealizada(Integer idSalida, String destino, Date fecha_salida, UsuarioClubNautico usuario,
			Embarcacion embarcacion) {
		super();
		this.idSalida = idSalida;
		this.destino = destino;
		this.fecha_salida = fecha_salida;
		this.usuario = usuario;
		this.embarcacion = embarcacion;
	}

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
	

	public Embarcacion getEmbarcacion() {
		return embarcacion;
	}

	public void setEmbarcacion(Embarcacion embarcacion) {
		this.embarcacion = embarcacion;
	}

	@Override
	public String toString() {
		return "SalidaRealizada [idSalida=" + idSalida + ", destino=" + destino + ", fecha_salida=" + fecha_salida
				+ ", usuario=" + usuario.toString() + "]";
	}	

}
