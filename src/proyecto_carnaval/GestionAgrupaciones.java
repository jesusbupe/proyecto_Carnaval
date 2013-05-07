/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_carnaval;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class GestionAgrupaciones {

    Statement stmt = null;
    int autoincrementoID;
    private int id;
    private String nombre;
    private String modalidad;
    private int numComponentes;
    private String autorLetra;
    private String autorMusica;
    private String director;
    private String localidad;
    private Blob imagenAgrupacion;

   public ArrayList<DatosAgrupaciones> list() {
        ArrayList<DatosAgrupaciones> informacionAgrupacion = new ArrayList();
        try {
            String sql = "Select * from agrupacion";
            stmt = Conexion.conexion.createStatement();
           
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("ID");
                nombre = rs.getString("Nombre");
                modalidad = rs.getString("Modalidad");
                numComponentes = rs.getInt("NumComponentes");
                autorLetra = rs.getString("AutorLetra");
                autorMusica = rs.getString("AutorMusica");
                director = rs.getString("Director");
                localidad = rs.getString("Localidad");

                DatosAgrupaciones agrupacion = new DatosAgrupaciones(id, nombre, modalidad, numComponentes, autorLetra, autorMusica, director, localidad, null);
                informacionAgrupacion.add(agrupacion);


            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
            ex.printStackTrace();
        }

        return informacionAgrupacion;
    }

    int Insert(DatosAgrupaciones agrupacion) {
        id = agrupacion.getId();
        nombre = agrupacion.getNombre();
        modalidad = agrupacion.getModalidad();
        numComponentes = agrupacion.getNumComponentes();
        autorLetra = agrupacion.getAutorLetra();
        autorMusica = agrupacion.getAutorMusica();
        director = agrupacion.getDirector();
        localidad = agrupacion.getLocalidad();
        imagenAgrupacion = agrupacion.getImagenAgrupacion();

        String sql = "INSERT INTO agrupacion (ID,nombre,modalidad,numComponentes,autorLetra,autorMusica,director,localidad,imagenAgrupacion) VALUES "
                + "('"+id+ "','" + nombre + "','"  + modalidad + "','" + numComponentes + "','" + autorLetra + "','" + autorMusica + "','" + director + "','" + localidad + "','" + imagenAgrupacion + "')";



        try {
            Statement sentenciaSQL = Conexion.conexion.createStatement();
            sentenciaSQL.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultado = sentenciaSQL.getGeneratedKeys();

            if (resultado.next()) {
                autoincrementoID = resultado.getInt(1);
            } else {
                System.out.print("Error al Sacar el Id de la Agrupacion");


            }

        } catch (Exception e) {
            System.out.print("Error en la sentencia sql: ");
            System.out.print(sql);
            e.printStackTrace();

        }

        return autoincrementoID;

    }

    public boolean update(DatosAgrupaciones agrupacion) {
        id = agrupacion.getId();
        nombre = agrupacion.getNombre();
        modalidad = agrupacion.getModalidad();
        numComponentes = agrupacion.getNumComponentes();
        autorLetra = agrupacion.getAutorLetra();
        autorMusica = agrupacion.getAutorMusica();
        director = agrupacion.getDirector();
        localidad = agrupacion.getLocalidad();
        imagenAgrupacion = agrupacion.getImagenAgrupacion();
        try {

            stmt = Conexion.conexion.createStatement();
            String sql = "Update agrupacion set nombre =" + nombre
                    + ", modalidad =" + modalidad
                    + ", numComponentes =" + numComponentes
                    + ",autorLetra =" + autorLetra
                    + ", autorMusica =" + autorMusica
                    + ", director =" + director
                    + ", localidad =" + localidad
                    + ", imagenAgrupacion =" + imagenAgrupacion
                    + "where id =" + id;
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("Error al actualizar la base de datos");
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(DatosAgrupaciones agrupacion) {

        try {

            stmt = Conexion.conexion.createStatement();
            String sql = "Delete from agrupacion where id =" + agrupacion.getId();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
