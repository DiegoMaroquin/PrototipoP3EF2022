/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.controlador;


/**
 *
 * @author visitante
 */
public class clsequipo {
    private int ID_EQUIPO;
    private String  NOMBRE_EQUIPO;
    private String TORNEOS_GANADOS; 
    
    

    public clsequipo() {
    }

    public clsequipo(int id_equipo) {
        this.ID_EQUIPO= id_equipo;
    }

    public clsequipo(String nombre, String estado) {
        this. NOMBRE_EQUIPO = nombre;
        this.TORNEOS_GANADOS = estado;
        
    }
     public clsequipo(String nombre, String estado, String efecto, String valor) {
        this. NOMBRE_EQUIPO = nombre;
        this.TORNEOS_GANADOS = estado;
        
    }

    public int getid_equipo() {
        return ID_EQUIPO;
    }

    public void setid_equipo(int id_equipo) {
        this.ID_EQUIPO = id_equipo;
    }

    public String getnombre_equipo() {
        return NOMBRE_EQUIPO;
    }

    public void setnombre_equipo(String nombre) {
        this.NOMBRE_EQUIPO = nombre;
    }

    public String gettorneo_ganado() {
        return TORNEOS_GANADOS;
    }

    public void settorneo_ganado(String estado) {
        this.TORNEOS_GANADOS = estado;
    }
   

    @Override
    public String toString() {
        return "equipo{" + "ID_EQUIPO=" + ID_EQUIPO + ", NOMBRE_EQUIPO=" + NOMBRE_EQUIPO + ", TORNEOS_GANADOS=" + TORNEOS_GANADOS + "}";
    }
    
     }

