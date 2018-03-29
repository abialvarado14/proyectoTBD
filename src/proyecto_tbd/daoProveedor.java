package proyecto_tbd;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoProveedor {

    Conexion c;

    public daoProveedor() {
        c = new Conexion();
    }

    public boolean create(Proveedor p) {
        try {

            String sql = "INSERT INTO proveedores(codigoProveedor,nombreProveedor,apellidoProveedor,rtnProveedor,telefonoProveedor,direccionProveedor) VALUES(?,?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, p.getCodigoProveedor());
            ps.setString(2, p.getNombreProveedor());
            ps.setString(3, p.getApellidoProveedor());
            ps.setInt(4, p.getRtnProveedor());
            ps.setInt(5, p.getTelefonoProveedor());
            ps.setString(6, p.getDireccionProveedor());
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;

        } catch (SQLException ex) {
            System.out.println("NO SE INSERTO!");
            return false;
        }
    }




}
