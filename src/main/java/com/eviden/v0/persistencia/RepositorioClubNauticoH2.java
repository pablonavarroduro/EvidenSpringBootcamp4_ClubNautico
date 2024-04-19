package com.eviden.v0.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eviden.v0.modelo.Embarcacion;
import com.eviden.v0.modelo.SalidaRealizada;
import com.eviden.v0.modelo.SocioClubNautico;

@Repository
public interface RepositorioClubNauticoH2 extends JpaRepository<SocioClubNautico, Integer> {
	@Query("select e from Embarcacion e where e.matricula = :eMatricula")
	public Embarcacion findEmbarcacionByMatricula(@Param("eMatricula") String matricula);

	@Query(value = "SELECT * FROM EMBARCACIONES WHERE FK_ID_SOCIO = :idsocio", nativeQuery = true)
	public List<Embarcacion> findAllEmbarcacionBySocio(@Param("idsocio") int idsocio);

	@Query("select s from SalidaRealizada s where s.idSalida = :idsalida")
	public SalidaRealizada findSalidaById(@Param("idsalida") int id);

	@Query(value = "SELECT * FROM SALIDAS", nativeQuery = true)
	public List<SalidaRealizada> findAllSalidas();

	@Query(value = "SELECT * FROM SALIDAS WHERE FK_MATRICULA_EMBARCACION = :matricula", nativeQuery = true)
	public List<SalidaRealizada> findAllSalidasByEmbarcacion(@Param("matricula") String matricula);
	
//	@Query(value = "select * FROM SALIDAS WHERE DNI = :idusuario", nativeQuery = true)
//	public SalidaRealizada findUsuario(@Param("idusuario") String dni);

}
