
package proyecto_carnaval;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    static Connection conexion = null;
    
    public static boolean conectar(String host, String usuario, String pass) {        
        try {
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://"+host+"/carnaval",
                    usuario, pass);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
