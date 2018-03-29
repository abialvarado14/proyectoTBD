
package proyecto_tbd;

import java.util.Date;


public class Producto {
    int codigoProducto;
    int codigoProveedor;
    String categoria;
    float costo;
    String descripcion;
    Date fechaExpiracion;
    float precioVenta;

    public Producto() {
    }

    public Producto(int codigoProducto, int codigoProveedor, String categoria, float costo, String descripcion, Date fechaExpiracion, float precioVenta) {
        this.codigoProducto = codigoProducto;
        this.codigoProveedor = codigoProveedor;
        this.categoria = categoria;
        this.costo = costo;
        this.descripcion = descripcion;
        this.fechaExpiracion = fechaExpiracion;
        this.precioVenta = precioVenta;
    }
    
    

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    
}
