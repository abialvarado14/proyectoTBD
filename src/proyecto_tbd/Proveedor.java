
package proyecto_tbd;


public class Proveedor {
    int codigoProveedor;
    String nombreProveedor;
    String apellidoProveedor;
    int rtnProveedor;
    int telefonoProveedor;
    String direccionProveedor;

    public Proveedor() {
    }

    public Proveedor(int codigoProveedor, String nombreProveedor, String apellidoProveedor, int rtnProveedor, int telefonoProveedor, String direccionProveedor) {
        this.codigoProveedor = codigoProveedor;
        this.nombreProveedor = nombreProveedor;
        this.apellidoProveedor = apellidoProveedor;
        this.rtnProveedor = rtnProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.direccionProveedor = direccionProveedor;
    }
    
    

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getApellidoProveedor() {
        return apellidoProveedor;
    }

    public void setApellidoProveedor(String apellidoProveedor) {
        this.apellidoProveedor = apellidoProveedor;
    }

    public int getRtnProveedor() {
        return rtnProveedor;
    }

    public void setRtnProveedor(int rtnProveedor) {
        this.rtnProveedor = rtnProveedor;
    }

    public int getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(int telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }
    
    
    
           
}
