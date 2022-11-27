/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Vehiculo;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author SrLob
 */
public class daoVehiculo {
    
    Conexion c;

    public daoVehiculo() {
        c = new Conexion();
    }
    
      public boolean create(Vehiculo v){
    
        String sql = "INSERT INTO vehiculo (placa,fecha,modelo,tipo) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) c.obtener().prepareStatement(sql);
            ps.setString(1, v.getPlaca());
            ps.setString(2, v.getFecha());
            ps.setInt(3, v.getModelo());
            ps.setString(4, v.getTipo());
            ps.execute();
            ps.close();
            ps = null;
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
            
    
    }
    
    
}
