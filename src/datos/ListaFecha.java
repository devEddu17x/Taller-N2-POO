package datos;

import java.util.ArrayList;
import entidades.MiFecha;

public class ListaFecha {
    private static ArrayList<MiFecha> listaFechas = new ArrayList<>();

    public static void agregarFecha(MiFecha fecha) {
        listaFechas.add(fecha);
    }

    public static void mostrarFechas() {

        System.out.println("INDICE \t\tFORMATO     1\t\t  FORMATO 2\t\t   FORMATO 3\t\t  FORMATO 4\n");
        int i=1;
        for (MiFecha fecha : listaFechas) {
            System.out.println(i+"\t\t"+fecha.getFormatoFecha());
            i++;
        }
    }

    public static int getTamaño(){
        return listaFechas.size();
    }

    public static void modificarFechas(int parametroDeAumento, int indice, int aumento){
        System.out.println("La fecha a modifica es: "+listaFechas.get(indice).getFormatoFecha());
        MiFecha nuevaFecha = listaFechas.get(indice).aumentarFecha(parametroDeAumento, aumento);
        System.out.println(nuevaFecha.getFormatoFecha());
        listaFechas.set(indice, nuevaFecha);
    }
}
