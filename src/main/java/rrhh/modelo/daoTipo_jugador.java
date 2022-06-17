/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;

import rrhh.controlador.clsTIpo_jugador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoTipo_jugador {

    private static final String SQL_SELECT = "SELECT ID_TIPO_JUGADOR, NOMBRE_POSICION FROM tipo_jugador";
    private static final String SQL_INSERT = "INSERT INTO tipo_jugador(NOMBRE_POSICION) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE tipo_jugador SET NOMBRE_POSICION=? WHERE ID_TIPO_JUGADOR = ?";
    private static final String SQL_DELETE = "DELETE FROM tipo_jugador WHERE ID_TIPO_JUGADOR=?";
    private static final String SQL_QUERY = "SELECT  ID_TIPO_JUGADOR, NOMBRE_POSICION FROM tipo_jugador WHERE ID_TIPO_JUGADOR = ?";

    public List<clsTIpo_jugador> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsTIpo_jugador cargo = null;
        List<clsTIpo_jugador> cargos = new ArrayList<clsTIpo_jugador>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_TIPO_JUGADOR");
                String nombre = rs.getString("NOMBRE_POSICION");
                

                cargo = new clsTIpo_jugador();
                cargo.setid_tipo(id);
                cargo.setnombre_pos(nombre);
                

                cargos.add(cargo);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return cargos;
    }

    public int insert(clsTIpo_jugador cargo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cargo.getnombre_pos());
            

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

    public int update(clsTIpo_jugador cargo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
         
            stmt.setString(1, cargo.getnombre_pos());
            
            stmt.setInt(2, cargo.getid_tipo());
            
            
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

    public int delete(clsTIpo_jugador cargo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cargo.getid_tipo());
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

    public clsTIpo_jugador query(clsTIpo_jugador cargo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cargo.getid_tipo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_TIPO_JUGADOR");
                String nombre = rs.getString("NOMBRE_POSICION");
               

                cargo = new clsTIpo_jugador();
                cargo.setid_tipo(id);
                cargo.setnombre_pos(nombre);
                
                
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
        return cargo;
    }
}
