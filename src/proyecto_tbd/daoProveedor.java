package proyecto_tbd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoProveedor {

    Conect c;

    public daoProveedor() {
        c = new Conect();
    }

    public boolean create(Proveedor p) {
        try {

            String sql = "INSERT INTO proveedores(codigoProveedor,nombreProveedor,apellidoProveedor,rtnProveedor,telefonoProveedor,direccionProveedor) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            System.out.println("HOLA CONECTO");
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

    public ArrayList<Proveedor> read() {
        ArrayList<Proveedor> lista = new ArrayList();
        try {

            String sql = "SELECT* FROM proveedores";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setCodigoProveedor(rs.getInt("codigoProveedor"));
                p.setNombreProveedor(rs.getString("nombreProveedor"));
                p.setApellidoProveedor(rs.getString("apellidoProveedor"));
                p.setRtnProveedor(rs.getInt("rtnProveedor"));
                p.setTelefonoProveedor(rs.getInt("telefonoProveedor"));
                p.setDireccionProveedor(rs.getString("direccionProveedor"));
                lista.add(p);
            }
            ps.close();
            ps = null;
            c.desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo read");
        }
        return lista;
    }

    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM proveedores WHERE codigoProveedor=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            System.out.println("SE ELIMINO");
            return true;
        } catch (SQLException ex) {
            System.out.println("NO SE ELIMINO");
            return false;
        }
    }

    public boolean update(Proveedor p) {
        try {
            String sql = "UPDATE proveedores SET nombreProveedor=?,apellidoProveedor=?,rtnProveedor=?,telefonoProveedor=?,direccionProveedor=? WHERE codigoProveedor=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombreProveedor());
            ps.setString(2, p.getApellidoProveedor());
            ps.setInt(3, p.getRtnProveedor());
            ps.setInt(4, p.getTelefonoProveedor());
            ps.setString(5, p.getDireccionProveedor());
            ps.setInt(6,p.getCodigoProveedor());
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("NO SE ACTUALIZO");
            return false;
        }
    }

}
