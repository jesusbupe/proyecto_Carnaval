/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_carnaval;

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

    public ArrayList<DatosAgrupaciones> list() {
        ArrayList<DatosAgrupaciones> informacionAgrupacion = new ArrayList();
        try {
            String sql = "Select * from agrupaciones";
            stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("Nombre");
                String modalidad = rs.getString("Modalidad");
                int numComponentes = rs.getInt("NumComponentes");
                String autorLetra = rs.getString("AutorLetra");
                String autorMusica = rs.getString("AutorMusica");
                String director = rs.getString("Director");
                String localidad = rs.getString("Localidad");

                DatosAgrupaciones agrupacion = new DatosAgrupaciones(id, nombre, modalidad, numComponentes, autorLetra, autorMusica, director, localidad, null);
                informacionAgrupacion.add(agrupacion);


            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
            ex.printStackTrace();
        }




        return informacionAgrupacion;
    }
}
