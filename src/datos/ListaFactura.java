package datos;
import entidades.Factura;
import java.util.ArrayList;

public class ListaFactura {
    private static ArrayList <Factura> listaFacturas = new ArrayList<>();

    public static void agregarFactura(Factura factura){
        listaFacturas.add(factura);
    }

    public static void mostrarFacturas(){
        int i = 1;
        System.out.println("\n\t\tMOSTRANDO FACTURAS");
        for (Factura factura: listaFacturas){
            System.out.println("\n\n---------- Factura "+i+": ----------");
            System.out.println(factura.getDatos()+"\nVenta bruta: "+factura.getVentaBruta()+"\nIGV: "+factura.getIGV()+"\nVenta liquida: "+factura.getVentaLiquida());
            i++;
        }
    }
}
