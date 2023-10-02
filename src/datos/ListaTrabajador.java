package datos;

import java.util.ArrayList;

import entidades.Trabajador;

public class ListaTrabajador {

    private static int posicion = 0;
    private static ArrayList<Trabajador> listaTrabajadores = new ArrayList<>();

    public static void agregarTrabajador(Trabajador trabajador) {
        listaTrabajadores.add(trabajador);
        posicion++;
    }

    public static int getUltimaPosicion(){
        return posicion;
    }

    public static void mostrarTrabajadores() {
        System.out.println("\nINDICE\t\tNOMBRE\t\tSUELDO BRUTO\t\tDESCUENTO\t\tSUELDO NETO"); int i=1;
        for (Trabajador chambeador : listaTrabajadores) {
            System.out.println(i+"\t\t"+chambeador.toString()); i++;
        }
    }

    public static void eliminarTrabajador(int indice) {
        listaTrabajadores.remove(indice);
        posicion--;
    }

    public static void mostrarTrabajadorIndice(int indice) {
        System.out.println("\nNOMBRE\t\tSUELDO BRUTO\t\tDESCUENTO\t\tSUELDO NETO");
        System.out.println(listaTrabajadores.get(indice).toString());
        ;
    }

    public static void buscarPorNombre(String nombre) {
        boolean encontrado = false;
        int i = -1;
        while (!encontrado){
            i++;
            encontrado = (listaTrabajadores.get(i).getNombre().equals(nombre)) ? true: false;
        } if (encontrado) System.out.println(listaTrabajadores.get(i).toString());
    }

    public static void ordenarNombresAscendente() {
        quicksortNombres(listaTrabajadores, 0, posicion - 1);
    }

    private static void quicksortNombres(ArrayList <Trabajador> listaTrabajadores, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indicePivote = particionNombres(listaTrabajadores, izquierda, derecha);
            quicksortNombres(listaTrabajadores, izquierda, indicePivote - 1);
            quicksortNombres(listaTrabajadores, indicePivote + 1, derecha);
        }
    }
    
    private static int particionNombres(ArrayList <Trabajador> listaTrabajadores, int izquierda, int derecha) {
        String pivote = listaTrabajadores.get(izquierda).getNombre();
        int i = izquierda + 1;
    
        for (int j = i; j <= derecha; j++) {
            if (listaTrabajadores.get(j).getNombre().compareTo(pivote) < 0) {
                Trabajador temp = listaTrabajadores.get(i);
                listaTrabajadores.set(i, listaTrabajadores.get(j));
                listaTrabajadores.set(j, temp);
                i++;
            }
        }
    
        Trabajador temp = listaTrabajadores.get(izquierda);
        listaTrabajadores.set(izquierda, listaTrabajadores.get(i-1));
        listaTrabajadores.set(i-1, temp);
    
        return i - 1;
    } 

    public static void ordenarSueldoNetoDescendentemente() {
        quicksortSueldos(listaTrabajadores, 0, posicion - 1);
    }
    
    private static void quicksortSueldos(ArrayList <Trabajador> listaTrabajadores, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indicePivote = particionInt(listaTrabajadores, izquierda, derecha);
            quicksortSueldos(listaTrabajadores, izquierda, indicePivote - 1);
            quicksortSueldos(listaTrabajadores, indicePivote + 1, derecha);
        }
    }
    
    private static int particionInt(ArrayList <Trabajador> listaTrabajadores, int izquierda, int derecha) {
        double pivote = listaTrabajadores.get(izquierda).getSueldoNeto();
        int i = izquierda + 1;
    
        for (int j = i; j <= derecha; j++) {
            if (listaTrabajadores.get(j).getSueldoNeto() > pivote) {
                Trabajador temp = listaTrabajadores.get(i);
                listaTrabajadores.set(i, listaTrabajadores.get(j));
                listaTrabajadores.set(j, temp);
                i++;
            }
        }
    
        Trabajador temp = listaTrabajadores.get(izquierda);
        listaTrabajadores.set(izquierda, listaTrabajadores.get(i-1));
        listaTrabajadores.set(i-1, temp);
    
        return i - 1;
    }
}
