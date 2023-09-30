package entidades;

public class ListaNombre {
    
    private static String[] listaNombres = new String[20];
    private static int ultimaPosicion = 0;

    public static void agregarNombre(String nombre) {
        if (ultimaPosicion < 20) {
            listaNombres[ultimaPosicion] = nombre.toLowerCase();
            ultimaPosicion++;
        } else {
            System.out.println("\nCapacidad máxima.");
        }

    }

    public static void mostrarNombres() {
        System.out.println("INDICE\t\tNOMBRES");
        for (int i = 0; i < ultimaPosicion; i++) {
            System.out.println((i + 1) + "\t\t" + listaNombres[i]);
        }
    }

    public static void eliminarNombre(int indice) {
        String aux = listaNombres[ultimaPosicion - 1];
        listaNombres[indice] = aux;
        ultimaPosicion--;
    }

    public static String getNombre(int indice) {
        return listaNombres[indice];
    }

    public static int getUltimaPosicion(){
        return ultimaPosicion;
    }

    public static boolean existe(String nombre) {
        int i = 0;
        do {
            if (listaNombres[i].equals(nombre)) {
                return true;
            }
            i++;
        } while (i < 20);

        return false;

    }

    public static void insertarNombre(String nombre, int indice) {
        listaNombres[indice] = nombre;
    }

    public static void ordenarNombresAscendente() {
        quicksort(listaNombres, 0, ultimaPosicion - 1);
    }
    
    private static void quicksort(String arreglo[], int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indicePivote = particion(arreglo, izquierda, derecha);
            quicksort(arreglo, izquierda, indicePivote - 1);
            quicksort(arreglo, indicePivote + 1, derecha);
        }
    }
    
    private static int particion(String arreglo[], int izquierda, int derecha) {
        String pivote = arreglo[izquierda];
        int i = izquierda + 1;
    
        for (int j = i; j <= derecha; j++) {
            if (arreglo[j].compareTo(pivote) < 0) {
                String temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
                i++;
            }
        }
    
        String temp = arreglo[izquierda];
        arreglo[izquierda] = arreglo[i - 1];
        arreglo[i - 1] = temp;
    
        return i - 1;
    }    

}
