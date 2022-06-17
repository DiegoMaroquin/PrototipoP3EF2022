package rrhh.controlador;

public class clsTIpo_jugador {
    private int ID_TIPO_JUGADOR;
    private String NOMBRE_POSICION;
   

    public clsTIpo_jugador() {
    }

    public clsTIpo_jugador(int carid) {
        this.ID_TIPO_JUGADOR = carid;
    }
    
    public clsTIpo_jugador(String snombre) {
        this.NOMBRE_POSICION = snombre;
       
    }
    
    public clsTIpo_jugador(int carid, String snombre) {
        this.ID_TIPO_JUGADOR = carid;
        this.NOMBRE_POSICION = snombre;
        
    }
    

    public int getid_tipo() {
        return ID_TIPO_JUGADOR;
    }

    public void setid_tipo(int carid) {
        this.ID_TIPO_JUGADOR = carid;
    }

    public String getnombre_pos() {
        return NOMBRE_POSICION;
    }

    public void setnombre_pos(String snombre) {
        this.NOMBRE_POSICION = snombre;
    }


    @Override
    public String toString() {
        return "tipo_jugador" + "ID_TIPO_JUGADOR=" + ID_TIPO_JUGADOR + ", NOMBRE_POSICION="  +  NOMBRE_POSICION +"}";
    }
    
    
}
