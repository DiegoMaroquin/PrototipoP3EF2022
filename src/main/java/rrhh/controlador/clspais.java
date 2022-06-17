package rrhh.controlador;

public class clspais {
    private int ID_PAIS;
    private String NOMBRE_PAIS;
    
    
    public clspais() {
    }

    public clspais(int idpais) {
        this.ID_PAIS = idpais;
    }
    
    public clspais(String snombre) {
        this.NOMBRE_PAIS = snombre;
       
    }
    
    public clspais(int codigodepa, String snombre, String sestado) {
        this.ID_PAIS = codigodepa;
        this.NOMBRE_PAIS = snombre;
        
    }
    

    public int getid_pais() {
        return ID_PAIS;
    }

    public void setid_pais(int idpais) {
        this.ID_PAIS = idpais;
    }

    public String getnombre_pais() {
        return NOMBRE_PAIS;
    }

    public void setnombre_pais(String snombre) {
        this.NOMBRE_PAIS = snombre;
    }

    @Override
    public String toString() {
        return "pais{" + "ID_PAIS=" + ID_PAIS + ", nombre_departamento="  +  NOMBRE_PAIS + "}";
    }
    
    
}
