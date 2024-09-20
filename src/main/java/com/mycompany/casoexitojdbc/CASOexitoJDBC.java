 // Aqui estamos apuntando un paquete 
package com.mycompany.casoexitojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
              PreparedStatement st = con.prepareStatement("INSERT INTO registro(Identificacion,Name,Direccion) VALUES(?,?,?)");
              ){
          
          
          //Hacer las inserciones}
           st.setString(1, "235");
          st.setString(2, "Clau G");
           st.setString(3, "Calle 4");
           
           
           //ejecutamos la insercion
           
           st.executeUpdate();
           
           //mostramos mensaje
           
           System.out.println("Registro Agregado");
           
      }catch(ClassNotFoundException | NumberFormatException | SQLException e){
      
          System.out.println("Error al insertar datos"+ e.getMessage());
      }
  }
          }
