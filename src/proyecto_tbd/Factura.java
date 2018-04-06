package proyecto_tbd;

import java.sql.Date;

public class Factura {

    int codigoFactura;
    String usuario;
    int rtnCliente;
    String nombreCliente;
    String apellidoCliente;
    int cantidadProductos;
    String fecha;
    double total;

    public Factura() {
    }

    public Factura(int codigoFactura, String usuario, int rtnCliente, String nombreCliente, String apellidoCliente, int cantidadProductos, String fecha, double total) {
        this.codigoFactura = codigoFactura;
        this.usuario = usuario;
        this.rtnCliente = rtnCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.cantidadProductos = cantidadProductos;
        this.fecha = fecha;
        this.total = total;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getRtnCliente() {
        return rtnCliente;
    }

    public void setRtnCliente(int rtnCliente) {
        this.rtnCliente = rtnCliente;
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

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
