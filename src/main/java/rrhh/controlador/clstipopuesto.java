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
public class clstipopuesto {
    private int ID_TIPO_PUESTO;
    private String  NOMBRE_PUESTO;
    private String SALARIO; 
    
    

    public clstipopuesto() {
    }

    public clstipopuesto(int id_Concepto) {
        this.ID_TIPO_PUESTO= id_Concepto;
    }

    public clstipopuesto(String nombre, String estado) {
        this. NOMBRE_PUESTO = nombre;
        this.SALARIO = estado;
        
    }
     public clstipopuesto(String nombre, String estado, String efecto, String valor) {
        this.NOMBRE_PUESTO = nombre;
        this.SALARIO = estado;
        
    }

    public int getid_puesto() {
        return ID_TIPO_PUESTO;
    }

    public void setid_puesto(int id_Concepto) {
        this.ID_TIPO_PUESTO = id_Concepto;
    }

    public String getnombre_puesto() {
        return NOMBRE_PUESTO;
    }

    public void setnombre_puesto(String nombre) {
        this.NOMBRE_PUESTO = nombre;
    }

    public String getsalario() {
        return SALARIO;
    }

    public void setsalario(String estado) {
        this.SALARIO = estado;
    }
   

    @Override
    public String toString() {
        return "tipo_puesto{" + "ID_TIPO_PUESTO=" + ID_TIPO_PUESTO + ", NOMBRE_PUESTO=" + NOMBRE_PUESTO + ", SALARIO=" + SALARIO + '}';
    }
    
     }

