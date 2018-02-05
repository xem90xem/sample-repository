package com.company.model.dao.daos;

import java.util.List;

import com.company.model.business.Factura;

/*
 * Autor: Juan Daniel S�nchez
 * Fecha: 22/11/2017
 * Descripci�n: 
 */
public interface FacturaDao {
	
	public void insertarFactura(Factura factura);
	public List<Factura> obtenerFactura();
	public Factura obtenerFactura(int id);
	public void actualizarFactura(Factura factura);
	public void eliminarFactura(Factura factura);

}
