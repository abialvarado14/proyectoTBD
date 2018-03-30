
package proyecto_tbd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoCliente {
    
    Conect c;

    public daoCliente() {
        c = new Conect();
    }
    
    public boolean create(Cliente C) {
        try {
            
            String sql = "INSERT INTO clientes(idCliente,nombreCliente,apellidoCliente,rtnCliente,telefonoCliente) VALUES(?,?,?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, C.getIdCliente());
            ps.setString(2, C.getNombreCliente());
            ps.setString(3, C.getApellidoCliente());
            ps.setInt(4, C.getRtnCliente());
            ps.setInt(5, C.getTelefonoCliente());                       
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
    
    public ArrayList<Cliente> read(){
        ArrayList<Cliente> lista = new ArrayList();
        try {
            
            String sql ="SELECT* FROM clientes";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNombreCliente(rs.getString("nombreCliente"));
                c.setApellidoCliente(rs.getString("apellidoCliente"));
                c.setRtnCliente(rs.getInt("rtnCliente"));
                c.setTelefonoCliente(rs.getInt("telefonoCliente"));
                lista.add(c);
            }
            ps.close();
            ps=null;
            c.desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo read");
        }
        return lista;
    }
    
    public boolean delete(int id){
        try {
            String sql="DELETE FROM clientes WHERE idCliente=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            ps=null;
            c.desconectar();
            System.out.println("SE ELIMINO");
            return true;
        } catch (SQLException ex) {
            System.out.println("NO SE ELIMINO");
            return false;
        }
    }
    
    public boolean update(Cliente C) {
        try {
            String sql = "UPDATE clientes SET nombreCliente=?,apellidoCliente=?,rtnCliente=?,telefonoCliente=? WHERE idCliente=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, C.getNombreCliente());
            ps.setString(2, C.getApellidoCliente());
            ps.setInt(3, C.getRtnCliente());
            ps.setInt(4, C.getTelefonoCliente()); 
            ps.setInt(5, C.getIdCliente());
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
