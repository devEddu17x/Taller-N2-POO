package entidades;
import java.util.UUID;
import complementos.Complementos;

public class Producto {
    private String codigo;
    private String nombre;
    private int stock=0;

    public Producto(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
        generarCodigo();
    }

    public void generarCodigo(){
        UUID codigoUID = UUID.randomUUID();
        String fragmento = String.valueOf(codigoUID);
        this.codigo = fragmento.substring(0, 8);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setStock(int stock) {
        this.stock+= stock;
    }
    
    public static String generarProducto(int cantidad){
        String nombre = Complementos.validarString("Ingrese el nombre del producto: ", "No es un nombre valido: ");
        Producto producto = new Producto(nombre, cantidad);
        Almacen.agregarProducto(producto);
        return producto.getCodigo();
    }
    
    public String toString(){
        return codigo+"\t"+nombre+"\t\t"+stock;
    }
}
