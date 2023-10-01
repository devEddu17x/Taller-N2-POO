package datos;

import java.util.ArrayList;

import entidades.Movimiento;

public class ListaMovimientoDeProductos {
    private static ArrayList<Movimiento> listaMovimientos = new ArrayList<>();

    public static void agregarMovimiento(Movimiento movimiento){
        listaMovimientos.add(movimiento);
    }

    public static void mostrarMovimientos(){
        System.out.println("CODIGO\t\tCANTIDAD\t\tTIPO");
        for (Movimiento movimiento : listaMovimientos){
            System.out.println(movimiento.toString());
        }
    }
}
