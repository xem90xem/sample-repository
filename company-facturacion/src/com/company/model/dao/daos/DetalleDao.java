package com.company.model.dao.daos;

import java.util.List;

import com.company.model.business.Detalle;


/*
 * Autor: Juan Daniel S�nchez
 * Fecha: 22/11/2017
 * Descripci�n: 
 */
public interface DetalleDao {
	
	public void insertarDetalle(Detalle detalle);
	public List<Detalle> obtenerDetalle();
	public Detalle obtenerDetalle(int id);
	public void Detalle(Detalle detalle);
	public void eliminarDetalle(Detalle detalle);

}
