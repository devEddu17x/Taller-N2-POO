package entidades;

public class Factura {
    private String cliente; 
    private int cantidadVendida;
    private double precioDeVenta;

    
    public Factura(String cliente, int cantidadVendida, double precioDeVenta) {
        this.cliente = cliente;
        this.cantidadVendida = cantidadVendida;
        this.precioDeVenta = precioDeVenta;
    }

    public double getVentaBruta(){
        return (double) cantidadVendida*precioDeVenta;
    }

    public double getIGV(){
        return 0.19*getVentaBruta();
    }

    public double getVentaLiquida(){
        return getVentaBruta()+getIGV();
    }

    public String getDatos() {
        return "Ciente: "+cliente+"\nCantidad comprada: "+cantidadVendida+"\nPrecio de Venta: "+precioDeVenta;
    }
}
