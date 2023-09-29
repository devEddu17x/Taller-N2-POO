package datos;

import java.util.ArrayList;

import complementos.Complementos;
import entidades.MiFraccion;

public class ListaMiFraccion {
    private static ArrayList<MiFraccion> listaFracciones = new ArrayList<>();
    private static ArrayList<String> listaMostrarResultados = new ArrayList<>();

    public static void agregarFracciones(MiFraccion fraccion) {
        listaFracciones.add(fraccion);
    }

    public static void mostrarFracciones() {
        System.out.println("INDICE\t\t\t FRACCIÓN\n");
        int indice = 1;
        for (MiFraccion fraccion : listaFracciones) {
            System.out.println("\t" + indice + "\t\t" + fraccion.toString());
            indice++;
        }
    }

    public static void mostrarResultados(){
        for (String resultado : listaMostrarResultados){
            System.out.println(resultado);
        }
    }

    public static int getTamaño() {
        return listaFracciones.size();
    }

    public static int getTamañoResultados(){
        return listaMostrarResultados.size();
    }

    public static void operacionesFracciones(int tipoDeOperacion, int indice1, int indice2) {
        switch (tipoDeOperacion) {
            case 1:
                MiFraccion resultadoSuma = MiFraccion.sumarFracciones(listaFracciones.get(indice1),
                        listaFracciones.get(indice2));
                listaMostrarResultados.add("EL resultado de " + listaFracciones.get(indice1).toString() + " + "
                        + listaFracciones.get(indice2).toString() + " es: " + resultadoSuma.toString());
                break;
            case 2:
                MiFraccion resultadoResta = MiFraccion.restarFracciones(listaFracciones.get(indice1),
                        listaFracciones.get(indice2));
                listaMostrarResultados.add("EL resultado de " + listaFracciones.get(indice1).toString() + " - "
                        + listaFracciones.get(indice2).toString() + " es: " + resultadoResta.toString());
                break;
            case 3:
                MiFraccion resultadoMultiplicar = MiFraccion.multiplicarFracciones(listaFracciones.get(indice1),
                        listaFracciones.get(indice2));
                listaMostrarResultados.add("EL resultado de " + listaFracciones.get(indice1).toString() + " * "
                        + listaFracciones.get(indice2).toString() + " es: " + resultadoMultiplicar.toString());
                break;
            case 4:
                MiFraccion resultadoDividir = MiFraccion.dividirFracciones(listaFracciones.get(indice1),
                        listaFracciones.get(indice2));
                listaMostrarResultados.add("EL resultado de (" + listaFracciones.get(indice1).toString() + ") / ("
                        + listaFracciones.get(indice2).toString() + ") es: " + resultadoDividir.toString());
                break;
        }
    }

    public static void reportarPuntoFlotante() {
        int numeroDecimales = Complementos.validarInt(10, 1, "\nIngrese el numero de decimales para mostrar fracciones: ", "Error: Lo ingresado no es un número valido.", "El número de decimales solo puede estar en el rango (1-10).");
        System.out.println("\nINDICE\t\tFRACCIÓN\n");
        int indice = 1;
        for (MiFraccion fraccion : listaFracciones){
            System.out.println("\t"+indice+"\t\t"+fraccion.devolverEnDecimales(numeroDecimales));
        }
    }

}
