package proyecto_tbd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class daoFactura {

    Conect c;

    public daoFactura() {
        c = new Conect();
    }

    public boolean create(Factura f) {
        try {

            String sql = "INSERT INTO productos(codigoFacuta,usuario,rtnCliente,nombreCliente,apellidoCliente,cantidadProductos,fecha,total) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, f.getCodigoFactura());
            ps.setString(2, f.getUsuario());
            ps.setInt(3, f.getRtnCliente());
            ps.setString(4, f.getNombreCliente());
            ps.setString(5, f.getApellidoCliente());
            ps.setInt(6, f.getCantidadProductos());
            ps.setDate(7, f.getFecha());
            ps.setDouble(8, f.getTotal());
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

    public ArrayList<Factura> read() {
        ArrayList<Factura> lista = new ArrayList();
        try {

            String sql = "SELECT* FROM facturas";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Factura f = new Factura();
                f.setCodigoFactura(rs.getInt("codigoFactura"));
                f.setUsuario(rs.getString("usuario"));
                f.setRtnCliente(rs.getInt("rtnCliente"));
                f.setNombreCliente(rs.getString("nombreCliente"));
                f.setApellidoCliente(rs.getString("apellidoCliente"));
                f.setCantidadProductos(rs.getInt("cantidadProductos"));
                f.setFecha(rs.getDate("fecha"));
                f.setTotal(rs.getDouble("total"));
                lista.add(f);
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
            String sql = "DELETE FROM facturas WHERE codigoFactura=?";
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
    
    public boolean update(Factura f) {
        try {
            String sql = "UPDATE facturas SET usuario=?,rtnCliente=?,nombreCliente=?,apellidoCliente=?,cantidadProductos=?,fecha=?,total=? WHERE codigoFactura=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);

            ps.setString(1, f.getUsuario());
            ps.setInt(2, f.getRtnCliente());
            ps.setString(3, f.getNombreCliente());
            ps.setString(4, f.getApellidoCliente());
            ps.setInt(5, f.getCantidadProductos());
            ps.setDate(6, f.getFecha());
            ps.setDouble(7, f.getTotal());
            ps.setInt(8, f.getCodigoFactura());
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
