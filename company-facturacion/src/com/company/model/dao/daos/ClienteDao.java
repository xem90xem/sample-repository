package com.company.model.dao.daos;
/*
 * Autor: Juan Daniel S�nchez
 * Fecha: 22/11/2017
 * Descripci�n: 
 */
import java.util.List;   //.UTIL SIEMPRE!!!!!

import com.company.model.business.Cliente;

public interface ClienteDao {
	//Declaraci�n de m�todos para acceder a la base de datos
	public void insertarCliente(Cliente cliente);
	public List<Cliente> obtenerClientes();
	public Cliente obtenerCliente(int id);
	public void actualizarCliente(Cliente cliente);
	public void eliminarCliente(Cliente cliente);
}
