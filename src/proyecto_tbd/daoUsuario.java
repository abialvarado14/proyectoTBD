
package proyecto_tbd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoUsuario {
    Conect c;
    
    public daoUsuario() {
        c = new Conect();
    }
    
    public boolean create(Usuario u) {
        try {
            
            String sql = "INSERT INTO usuarios(usuario,contraseña) VALUES(?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getPassword());
                                 
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
    
    public ArrayList<Usuario> read(){
        ArrayList<Usuario> lista = new ArrayList();
        try {
            
            String sql ="SELECT* FROM usuarios";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Usuario u = new Usuario();
                u.setUsuario(rs.getString("usuario"));
                u.setPassword(rs.getString("contraseña"));                
                lista.add(u);
            }
            ps.close();
            ps=null;
            c.desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo read");
        }
        return lista;
    }
    public boolean delete(String id){
        try {
            String sql="DELETE FROM usuarios WHERE usuario=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, id);
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
    
    public boolean update(Usuario u) {
        try {
            String sql = "UPDATE empleados SET contraseña=? WHERE usuario=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            
            ps.setString(1, u.getPassword());
            ps.setString(2, u.getUsuario());
            
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
