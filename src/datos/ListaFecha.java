package datos;

import java.util.ArrayList;
import entidades.MiFecha;

public class ListaFecha {
    private static ArrayList<MiFecha> listaFechas = new ArrayList<>();

    public static void agregarFecha(MiFecha fecha) {
        listaFechas.add(fecha);
    }

    public static void mostrarFechas() {

        System.out.println("FORMATO     1\t\t  FORMATO 2\t\t   FORMATO 3\t\t  FORMATO 4\n");
        for (MiFecha fecha : listaFechas){
            System.out.println(fecha.getFormatoFecha());
        }
    }
}
