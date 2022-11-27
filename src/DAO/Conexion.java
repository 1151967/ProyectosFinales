/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SrLob
 */
public class Conexion {
       private static Connection cnx = null;
   public static Connection obtener()  {
      if (cnx == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/parqueadero", "root", "");
             System.out.println("Se conecto");
         } catch (SQLException ex) {
             System.out.println(ex);
         } catch (ClassNotFoundException ex) {
             System.out.println(ex);
         }
      }
      return cnx;
   }
   public static void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }

}
