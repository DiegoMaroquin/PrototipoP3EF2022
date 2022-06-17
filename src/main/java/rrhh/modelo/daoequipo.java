/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;
//inport
import rrhh.controlador.clsequipo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class daoequipo {
    
    private static final String SQL_SELECT = "SELECT ID_EQUIPO, NOMBRE_EQUIPO, TORNEOS_GANADOS FROM equipo";
    private static final String SQL_INSERT = "INSERT INTO equipo(NOMBRE_EQUIPO, TORNEOS_GANADOS) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE equipo SET NOMBRE_EQUIPO=?, TORNEOS_GANADOS=? WHERE ID_EQUIPO = ?";
    private static final String SQL_DELETE = "DELETE FROM equipo WHERE ID_EQUIPO=?";
    private static final String SQL_QUERY = "SELECT ID_EQUIPO, NOMBRE_EQUIPO, TORNEOS_GANADOS FROM equipo WHERE  ID_EQUIPO=?";
    private static final String SQL_QUERY2 = "SELECT ID_EQUIPO, NOMBRE_EQUIPO, TORNEOS_GANADOS WHERE NOMBRE_EQUIPO=?";
  

    public List<clsequipo> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsequipo concepto = null;
        List<clsequipo> conceptos = new ArrayList<clsequipo>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_EQUIPO");
                String nombre = rs.getString("NOMBRE_EQUIPO");
                String estado = rs.getString("TORNEOS_GANADOS");
                
         
               

                concepto = new clsequipo();
                concepto.setid_equipo(id);
                concepto.setnombre_equipo(nombre);
                concepto.settorneo_ganado(estado);
               
                
               
                conceptos.add(concepto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return conceptos;
    }

    public int insert(clsequipo concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, concepto.getnombre_equipo());
            stmt.setString(3, concepto.gettorneo_ganado());
             
           
                  
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

    public int update(clsequipo concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, concepto.getnombre_equipo());
            
            stmt.setString(3, concepto.gettorneo_ganado());
            
            stmt.setInt(5, concepto.getid_equipo());

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

    public int delete(clsequipo concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, concepto.getid_equipo());
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

    public clsequipo query(clsequipo concepto) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, concepto.getid_equipo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_EQUIPO");
                String nombre = rs.getString("NOMBRE_EQUIP");
                
                String estado = rs.getString("TORNEOS_GANADOS");
                
               
                

                concepto = new clsequipo();
                concepto.setid_equipo(id);
                concepto.setnombre_equipo(nombre);
                
                concepto.settorneo_ganado(estado);
                
                 
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
        return concepto;
    }
    
    public clsequipo query2(clsequipo concepto) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, concepto.getnombre_equipo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_EQUIPO");
                String nombre = rs.getString("NOMBRE_EQUIPO");
                
                String estado = rs.getString("TORNEOS_GANADOS");
                
               
                

                concepto = new clsequipo();
                concepto.setid_equipo(id);
                concepto.setnombre_equipo(nombre);
                 concepto.settorneo_ganado(estado);
                
                 
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
        return concepto;
    }
    
}
