/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;

import rrhh.controlador.clspais;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daopais {

    private static final String SQL_SELECT = "SELECT ID_PAIS, NOMBRE_PAIS FROM pais";
    private static final String SQL_INSERT = "INSERT INTO pais(NOMBRE_PAIS) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE pais SET NOMBRE_PAIS=? WHERE ID_PAIS= ?";
    private static final String SQL_DELETE = "DELETE FROM pais WHERE ID_PAIS=?";
    private static final String SQL_QUERY = "SELECT  ID_PAIS,  NOMBRE_PAIS FROM pais WHERE ID_PAIS= ?";

    public List<clspais> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clspais usuario = null;
        List<clspais> usuarios = new ArrayList<clspais>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_PAIS");
                String nombre = rs.getString("NOMBRE_PAIS");
                

                usuario = new clspais();
                usuario.setid_pais(id);
                usuario.setnombre_pais(nombre);
                

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return usuarios;
    }

    public int insert(clspais perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfil.getnombre_pais());
            

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clspais perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
             
             stmt.setString(1, perfil.getnombre_pais());
            
            stmt.setInt(3, perfil.getid_pais());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clspais perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getid_pais());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public clspais query(clspais perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
           stmt.setInt(1, perfil.getid_pais());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("ID_PAIS");
                String nombre = rs.getString("NOMBRE_PAIS");
                

                perfil = new clspais();
                perfil.setid_pais(codigo);
                perfil.setnombre_pais(nombre);
               
                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return perfil;
    }
}
