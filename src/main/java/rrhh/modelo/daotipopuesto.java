/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;
//inport
import rrhh.controlador.clstipopuesto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class daotipopuesto {
    
    private static final String SQL_SELECT = "SELECT ID_TIPO_PUESTO, NOMBRE_PUESTO, SALARIO FROM tipo_puesto";
    private static final String SQL_INSERT = "INSERT INTO tipo_puesto(NOMBRE_PUESTO, SALARIO ) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tipo_puesto SET NOMBRE_PUESTO=?, SALARIO=? WHERE ID_TIPO_PUESTO = ?";
    private static final String SQL_DELETE = "DELETE FROM tipo_puesto WHERE ID_TIPO_PUESTO=?";
    private static final String SQL_QUERY = "SELECT ID_TIPO_PUESTO, NOMBRE_PUESTO, SALARIO FROM equipo WHERE ID_TIPO_PUESTO=?";
    private static final String SQL_QUERY2 = "SELECT ID_TIPO_PUESTO, NOMBRE_PUESTO, SALARIO WHERE NOMBRE_PUESTO=?";
  

    public List<clstipopuesto> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clstipopuesto concepto = null;
        List<clstipopuesto> conceptos = new ArrayList<clstipopuesto>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_EQUIPO");
                String nombre = rs.getString("NOMBRE_EQUIPO");
                String estado = rs.getString("TORNEOS_GANADOS");
                
         
               

                concepto = new clstipopuesto();
                concepto.setid_puesto(id);
                concepto.setnombre_puesto(nombre);
                concepto.setsalario(estado);
               
                
               
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

    public int insert(clstipopuesto concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, concepto.getnombre_puesto());
            stmt.setString(3, concepto.getsalario());
             
           
                  
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

    public int update(clstipopuesto concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, concepto.getnombre_puesto());
            
            stmt.setString(3, concepto.getsalario());
            
            stmt.setInt(5, concepto.getid_puesto());

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

    public int delete(clstipopuesto concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, concepto.getid_puesto());
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

    public clstipopuesto query(clstipopuesto concepto) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, concepto.getid_puesto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_EQUIPO");
                String nombre = rs.getString("NOMBRE_EQUIP");
                
                String estado = rs.getString("TORNEOS_GANADOS");
                
               
                

                concepto = new clstipopuesto();
                concepto.setid_puesto(id);
                concepto.setnombre_puesto(nombre);
                
                concepto.setsalario(estado);
                
                 
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
    
    public clstipopuesto query2(clstipopuesto concepto) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, concepto.getnombre_puesto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_EQUIPO");
                String nombre = rs.getString("NOMBRE_EQUIPO");
                
                String estado = rs.getString("TORNEOS_GANADOS");
                
               
                

                concepto = new clstipopuesto();
                concepto.setid_puesto(id);
                concepto.setnombre_puesto(nombre);
                 concepto.setsalario(estado);
                
                 
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
