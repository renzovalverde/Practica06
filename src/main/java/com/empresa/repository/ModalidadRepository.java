package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.empresa.entity.FiltroModalidad;
import com.empresa.entity.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Integer>  {

	
	@Query("select d from Modalidad d where "
			+ "( :m_sede is '' or d.sede = :m_sede ) and "
			+ "( :m_nom is '' or d.nombre like :m_nom )")
public abstract List<Modalidad> listaDocentePorSedeNombre(
							 	@Param("m_sede") String sede, 
							 	@Param("m_nom") String nombre);
	
	
	@Query("select d from Modalidad d where "
			+ "( :#{#fil.sede} is '' or d.sede = :#{#fil.sede} ) and "
			+ "( :#{#fil.nombre} is '' or d.nombre like :#{#fil.nombre} )  ")
	public abstract List<Modalidad> listaPorFiltro(@Param("fil")FiltroModalidad filtro);
}
