package com.company.model.dao.data_source_conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConexion implements Conexion {
	static final String URL = "jdbc:mysql://localhost/";   //jdbc:tipobasedatos://nombreservidor
	private Connection conn = null;
	
	public MySqlConexion() {}
	
	@Override
	public String descripcion() {
		return "Conexi�n a MySQL";
	}
	@Override
	public void conectar(String bd, String usuario, String pwd){
		try{
		     Class.forName("com.mysql.jdbc.Driver");							//Nos conectamos atrav�s de la clase driver. La clase Class permite crear y manipular objetos sin el operador new
		     this.conn = DriverManager.getConnection(URL + bd, usuario, pwd);	//Obtenemos una conexi�n a partir de la URL, bd, usuario y contrase�a
		     if(conn != null)													//Si la conexi�n no ha sido nula (se ha podido realizar)
		     {
		       System.out.println("Conexi�n a la base de datos " + URL + bd + " OK");
		     }
		   }
		   catch(SQLException ex)
		   {
		      System.out.println("No se pudo conectar a la base de datos" + URL+bd);
		      ex.getMessage();
		      ex.getErrorCode();
		      ex.getSQLState();
		   }
		   catch(ClassNotFoundException ex)
		   {
		      System.out.println(ex);
		   }
		 }
	// Consultas (executeQuery())
	 public ResultSet getQuery(String query){   			//ResulSet recoge lo que devuelve la consulta en mysql; El query es la sentencia que escribiriamos en el programa
	    Statement sentenciaSql = null;
	    ResultSet datos = null;
	    
	    try{
	      sentenciaSql = conn.createStatement();			//Creamos la sentencia para conectarmos mediante el obj conn
	      datos = sentenciaSql.executeQuery(query);			//Almacenamos en el objeto resultSet lo que devuelve al ejecutar el query (executeQuery sirve para consultas)
	    }
	    catch(SQLException e)								//Cogemos cualquier tipo de error con SQL. Por ejemplo, que la tabla est� mal escrita, que falte una coma....
	    {
	      e.printStackTrace();
	    }
	    return datos;
	 }
	 
	 // Insertar, Modificar, Borrar (executeUpdate())
	 public boolean setQuery(String query){
	    Statement sentenciaSql = null;
	    boolean resultado = false;
	    try{   
	      sentenciaSql = conn.createStatement();				//Creamos la sentencia para conectarmos mediante el obj conn
	      int filas = sentenciaSql.executeUpdate(query);		//executeUpdate sirve para realizar alguna actualizaci�n. Devuelve el numero de filas afectadas
	      if(filas == 1) resultado = true; 						// Encontr� una fila
	    }
	    catch (SQLException e){
	      e.printStackTrace();
	    }
	    return resultado;
	 }
	 
	 public void cerrarConexion(){
		 try {
			conn.close();									//Hay que cerrar la conexi�n
			System.out.println("Conexi�n cerrada con �xito");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	}


