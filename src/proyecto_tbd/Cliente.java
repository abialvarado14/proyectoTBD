
package proyecto_tbd;


public class Cliente {
    int idCliente;
    String nombreCliente;
    String apellidoCliente;
    int rtnCliente;
    int telefonoCliente;

    public Cliente(int idCliente, String nombreCliente, String apellidoCliente, int rtnCliente, int telefonoCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.rtnCliente = rtnCliente;
        this.telefonoCliente = telefonoCliente;
    }

    public Cliente() {
    }
    
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public int getRtnCliente() {
        return rtnCliente;
    }

    public void setRtnCliente(int rtnCliente) {
        this.rtnCliente = rtnCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    
    
    
}
