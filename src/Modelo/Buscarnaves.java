/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 *
 */
public class Buscarnaves extends Conexion {
//metodo para ingresar naves
    public boolean ingresar(Naves n) {
        PreparedStatement p = null;
        Connection c = getConexion();
        String sql = ("INSERT INTO nave(nombre_nave,pasajeros,datos) VALUES(?,?,?)");
        try {
            p = c.prepareStatement(sql);
            p.setString(1, n.getNombre_nave());
            p.setInt(2, n.getPasajeros());
            p.setString(3, n.getDatos());
            p.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {

            try {

                c.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
 //--------------------------------------------------------------------------------------------------
 //metodo para actualizara las variables
    
      public boolean actualizar(Naves n) {
        PreparedStatement p = null;
        Connection c = getConexion();
        String sql = ("UPDATE nave SET  nombre_nave=? , pasajeros=?, datos=? WHERE id=?" );

        try {
            p = c.prepareStatement(sql);
            p.setString(1, n.getNombre_nave());
            p.setInt(2, n.getPasajeros());
            p.setString(3, n.getDatos());
            p.setInt(4,n.getId());
            p.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {

            try {

                c.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    //-----------------------------------------------------------------------------------
      public boolean eliminar(Naves n) {
        PreparedStatement p = null;
        Connection c = getConexion();
        String sql = ("DELATE FROM nave WHERE id=?" );
        try {
            p = c.prepareStatement(sql);
            p.setInt(1,n.getId());
            p.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {

            try {

                c.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
     //------------------------------------------------------------------------------------------------------
      public boolean buscar(Naves n) {
        PreparedStatement p = null;
        ResultSet r=null;
        Connection c = getConexion();
        String sql = ("SELECT * FROM nave WHERE id=?" );
        try {
            p = c.prepareStatement(sql);
            p.setInt(1, n.getId());
            r= p.executeQuery();
            
           if(r.next())
           
           {
                  n.setId(Integer.parseInt(r.getString("id")));
                  n.setNombre_nave(r.getString("nombre_nave"));
                  n.setPasajeros(Integer.parseInt(r.getString("pasajeros")));
                  n.setDatos(r.getString("datos"));
                  return  true;       
           }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {

            try {

                c.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
