
// Aqui estamos apuntando un paquete 
package com.mycompany.casoexitojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// esta es la clase principal
public class CASOexitoJDBC {

  //se crea el metodo para conectarse al driver JDBC
    
    protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
    
    String dbDriver = "com.mysql.cj.jdbc.Driver";
    String dbURL = "jdbc:mysql://localhost:3306/";
    String dbName ="dbregistro";
    String dbUsername = "root";
    String dbPassword = "";
    
    //ejecuto el driver jdbc
    
    Class.forName(dbDriver);
    
    
    //retorno de instancia a JDBC
    
    return DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword);
}
  public static void main(String [] args){
      
      //usamos el bloque try cathc ára capturar errores
      
      try(
              Connection con = initializeDatabase();
              PreparedStatement st = con.prepareStatement("SELECT * FROM registro");
              ){
          
          //Aqui se ejecuta la consulta
          ResultSet rs = st.executeQuery();
          
          // mostramos los datos
        
          while(rs.next()){
              
              //creo las variables
              
              int id = rs.getInt("Identificacion");
              String nombre = rs.getString("Name");
              String direccion = rs.getString("Direccion");
              
              //mostramos por pantalla
              
              System.out.println("ID:"+id + "nombre:"+nombre + "direccion:"+direccion);
          
          }
          
      }catch(ClassNotFoundException | NumberFormatException | SQLException e){
      
          System.out.println("Error al mostrar datos"+ e.getMessage());
      }
  }
          }