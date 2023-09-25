package datos;

import entidades.Trabajador;

public class ListaTrabajador {
    private static int posicion = 0;
    private static int tamaño = 10;
    private static Trabajador listaTrabajadores[] = new Trabajador [tamaño];

    public static void agregarTrabajador(Trabajador trabajador){
        listaTrabajadores[posicion] = trabajador;
        posicion++;
    }

    public static void mostrarTrabajdores(){
        System.out.println("\nNOMBRE\t\tSUELDO BRUTO\t\tDESCUENTO\t\tSUELDO NETO");
        for (int i = 0; i<posicion; i++){
            System.out.println(listaTrabajadores[i].getNombre()+"\t\t"+listaTrabajadores[i].getSueldoBruto()+"\t\t\t"+listaTrabajadores[i].getDescuento()+"\t\t\t"+listaTrabajadores[i].getSueldoNeto());
        }
    }
    
}
