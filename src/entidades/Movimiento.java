package entidades;

public class Movimiento {
    private int cantidad;
    private int tipo;
    private String codigoProducto;

    public Movimiento(int cantidad, int tipo, int indice) {
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.codigoProducto = Almacen.getCodigo(indice);
        aplicarMovimiento(indice);
    }

    public Movimiento(int cantidad, int tipo) {
        this.cantidad = cantidad;
        this.codigoProducto = Producto.generarProducto(cantidad);
        setTipo(0);
    }

    public void aplicarMovimiento(int indice) {
        switch (tipo) {
            case 2:
                aplicarEntrada(indice);
                setTipo(0);
                break;
            case 3:
                aplicarSalida(indice);
                setTipo(1);
                break;
        }
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public void aplicarEntrada(int indice) {
        Almacen.modificarStockProducto(indice, cantidad);
    }

    public void aplicarSalida(int indice) {
        if (Almacen.getStockProducto(indice)<cantidad){
            int aux = cantidad - Almacen.getStockProducto(indice);
            cantidad -= aux;
            System.out.println("Solo se ha podido sacar "+cantidad+" debido a que ya no queda stock");
        }
        Almacen.modificarStockProducto(indice, -cantidad);
    }

    public String toString() {
        return codigoProducto + "\t\t" + cantidad + "\t\t" + tipo;
    }

}
