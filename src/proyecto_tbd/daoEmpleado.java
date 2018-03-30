
package proyecto_tbd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class daoEmpleado {
    Conect c;
    
    public daoEmpleado() {
        c = new Conect();
    }
    
    public boolean create(Empleados E) {
        try {
            
            String sql = "INSERT INTO empleados(idEmpleado,nombreEmpleado,apellidoEmpleado,usuario,salario) VALUES(?,?,?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, E.getIdEmpleado());
            ps.setString(2, E.getNombreEmpleado());
            ps.setString(3, E.getApellidoEmpleado());
            ps.setString(4, E.getUsuario());
            ps.setFloat(5, E.getSalario());
                                 
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
    
     public ArrayList<Empleados> read(){
        ArrayList<Empleados> lista = new ArrayList();
        try {
            
            String sql ="SELECT* FROM empleados";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Empleados e = new Empleados();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNombreEmpleado(rs.getString("nombreEmpleado"));
                e.setApellidoEmpleado(rs.getString("apellidoEmpleado"));
                e.setUsuario(rs.getString("usuario")); 
                e.setSalario(rs.getFloat("salario"));
                lista.add(e);
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
            String sql="DELETE FROM empleados WHERE idEmpleado=?";
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
     
    public boolean update(Empleados E) {
        try {
            String sql = "UPDATE empleados SET nombreEmpleado=?,apellidoEmpleado=?,usuario=?,salario=? WHERE idEmpleado=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);

            ps.setString(1, E.getNombreEmpleado());
            ps.setString(2, E.getApellidoEmpleado());
            ps.setString(3, E.getUsuario());
            ps.setFloat(4, E.getSalario());
            ps.setInt(5, E.getIdEmpleado());
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
