package proyecto_tbd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class daoProducto {

    Conect c;

    public daoProducto() {
        c = new Conect();
    }

    public boolean create(Producto p) {
        try {

            String sql = "INSERT INTO productos(codigoProducto,codigoProveedor,categoria,costo,descripcion,fechaExpiracion,precioventa,Cantidad) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, p.getCodigoProducto());
            ps.setInt(2, p.getCodigoProveedor());
            ps.setString(3, p.getCategoria());
            ps.setFloat(4, p.getCosto());
            ps.setString(5, p.getDescripcion());
            ps.setString(6, p.getFechaExpiracion());
            ps.setFloat(7, p.getPrecioVenta());
            ps.setInt(8, p.getCantidad());
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

    public ArrayList<Producto> read() {
        ArrayList<Producto> lista = new ArrayList();
        try {

            String sql = "SELECT* FROM productos";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigoProducto(rs.getInt("codigoProducto"));
                p.setCodigoProveedor(rs.getInt("codigoProveedor"));
                p.setCategoria(rs.getString("categoria"));
                p.setCosto(rs.getFloat("costo"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setFechaExpiracion(rs.getString("fechaExpiracion"));
                p.setPrecioVenta(rs.getFloat("precioVenta"));
                p.setCantidad(rs.getInt("Cantidad"));
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
            String sql = "DELETE FROM productos WHERE codigoProducto=?";
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

    public boolean update(Producto p) {
        try {
            String sql = "UPDATE productos SET codigoProveedor=?,categoria=?,costo=?,descripcion=?,fechaExpiracion=?,precioventa=?,Cantidad=? WHERE codigoProducto=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);

            ps.setInt(1, p.getCodigoProveedor());
            ps.setString(2, p.getCategoria());
            ps.setFloat(3, p.getCosto());
            ps.setString(4, p.getDescripcion());
            ps.setString(5, p.getFechaExpiracion());
            ps.setFloat(6, p.getPrecioVenta());
            ps.setInt(7, p.getCodigoProducto());
            ps.setInt(8, p.getCantidad());
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
