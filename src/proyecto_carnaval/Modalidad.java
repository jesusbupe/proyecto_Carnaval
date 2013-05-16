/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_carnaval;

/**
 *
 * @author DAW
 */
public class Modalidad {
   private int idModalidad;
    private String modalidad;
    
    public Modalidad (int idModalidad,String Modalidad){
    this.idModalidad=idModalidad;
    this.modalidad=modalidad;
    
    }
    public int getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(int idModalidad) {
        this.idModalidad = idModalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
 
    public String toString(){
    return modalidad;
    }
    
    
}
