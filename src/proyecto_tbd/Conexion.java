package proyecto_tbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    Connection cx;
    String bd = "super";
    String url = "jdbc:mysql://localhost:3306/" + bd;
    String user = "root";
    String pass = "wilmer12";

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cx = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("SE CONECTO!!");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("NO SE CONECTO!");
        }
        return cx;

    }

    public void desconectar() {
        try {
            cx.close();
            System.out.println("Se desconecto");
        } catch (SQLException ex) {
            System.out.println("No se pudo cerrar conexión");
        }
    }

    
}
