/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_carnaval;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAW
 */
public class DatosAgrupaciones {

    Statement stmt = null;
    private int id;
    private String nombre;
    private int modalidad;
    private int numComponentes;
    private String autorLetra;
    private String autorMusica;
    private String director;
    private String localidad;
    private Blob imagenAgrupacion;

    public DatosAgrupaciones() {
    }

    public DatosAgrupaciones(int id, String nombre, int modalidad, int numComponentes, String autorLetra, String autorMusica, String director, String localidad, Blob imagenAgrupacion) {
        this.id = id;
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.numComponentes = numComponentes;
        this.autorLetra = autorLetra;
        this.autorMusica = autorMusica;
        this.director = director;
        this.localidad = localidad;
        this.imagenAgrupacion = imagenAgrupacion;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getModalidad() {
        return modalidad;
    }

    public void setModalidad(int modalidad) {
        this.modalidad = modalidad;
    }

    public int getNumComponentes() {
        return numComponentes;
    }

    public void setNumComponentes(int numComponentes) {
        this.numComponentes = numComponentes;
    }

    public String getAutorLetra() {
        return autorLetra;
    }

    public void setAutorLetra(String autorLetra) {
        this.autorLetra = autorLetra;
    }

    public String getAutorMusica() {
        return autorMusica;
    }

    public void setAutorMusica(String autorMusica) {
        this.autorMusica = autorMusica;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Blob getImagenAgrupacion() {
        return imagenAgrupacion;
    }

    public void setImagenAgrupacion(Blob imagenAgrupacion) {
        this.imagenAgrupacion = imagenAgrupacion;
    }

    public String dameModalidad(int idMod) {
        String nombreModalidad = null;
        

        String sql = "Select * from modalidades  where Modalidades.id= " + idMod;

        try {
            stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
           if (rs.next()) {
            nombreModalidad = rs.getString("modalidad");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionAgrupaciones.class.getName()).log(Level.SEVERE, null, ex);
        }


        return nombreModalidad;
    }
}
