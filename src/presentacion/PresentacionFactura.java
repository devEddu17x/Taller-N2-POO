package presentacion;

import java.util.Scanner;
import complementos.Complementos;
import entidades.Factura;
import datos.ListaFactura;

public class PresentacionFactura {

    static Scanner sc = new Scanner(System.in);
    static boolean existenFacturas;

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Complementos.menu("\n1. Agregar factura. \n2. Mostrar facturas.", 3);
            ejecutar(opcion);
        } while (opcion != 3);
    }

    public static void ejecutar(int x) {
        switch (x) {
            case 1:
                System.out.print("Ingrese el nombre del trabajador: ");
                String ciente = sc.next();
                int cantidadComprada = Complementos.validarInt(Integer.MAX_VALUE, 1, "Ingrese la cantidad comprada: ",
                        "Error: No se ha ingresado una cantidad valida.", "x");
                double precioDeVenta = Complementos.validarDouble(Double.MAX_VALUE, 1, "Ingrese el precio de venta: ",
                        "Error: No se ha ingresado un precio valido.", "x");
                Factura factura = new Factura(ciente, cantidadComprada, precioDeVenta);
                ListaFactura.agregarFactura(factura);
                existenFacturas = true;
                break;
            case 2:
            if (existenFacturas){
                ListaFactura.mostrarFacturas();
            } else {
                System.out.println("\nPrimero agregue facturas.");
            }
                break;
            case 3:
            System.out.println("\nAdios.");
                break;
        }
    }
}
