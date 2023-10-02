package datos;

public class ListaEnteros {
    private static int[] listaNumeros = new int[20];
    private static int ultimaPosicion = 0;

    public static void agregarNumero(int numero) {
        if (ultimaPosicion < 20) {
            listaNumeros[ultimaPosicion] = numero;
            ultimaPosicion++;
        } else {
            System.out.println("\nCapacidad máxima.");
        }

    }

    public static void mostrarNumeros() {
        System.out.println("INDICE\t\tNUMERO");
        for (int i = 0; i < ultimaPosicion; i++) {
            System.out.println((i + 1) + "\t\t" + listaNumeros[i]);
        }
    }

    public static void eliminarNumeroEntero(int indice) {
        int aux = listaNumeros[ultimaPosicion - 1];
        listaNumeros[indice] = aux;
        ultimaPosicion--;
    }

    public static int getEntero(int indice) {
        return listaNumeros[indice];
    }

    public static int getUltimaPosicion(){
        return ultimaPosicion;
    }

    public static boolean existe(int numero) {
        int i = 0;
        do {
            if (listaNumeros[i] == numero) {
                return true;
            }
            i++;
        } while (i < 20);

        return false;

    }

    public static void insertarNumero(int numero, int indice) {
        listaNumeros[indice] = numero;
    }

    public static void ordenarNumerosDescendente() {
        quicksort(listaNumeros, 0, ultimaPosicion - 1);
    }
    
    private static void quicksort(int arreglo[], int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indicePivote = particion(arreglo, izquierda, derecha);
            quicksort(arreglo, izquierda, indicePivote - 1);
            quicksort(arreglo, indicePivote + 1, derecha);
        }
    }
    
    private static int particion(int arreglo[], int izquierda, int derecha) {
        int pivote = arreglo[izquierda];
        int i = izquierda + 1;
    
        for (int j = i; j <= derecha; j++) {
            if (arreglo[j] > pivote) {
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
                i++;
            }
        }
    
        int temp = arreglo[izquierda];
        arreglo[izquierda] = arreglo[i - 1];
        arreglo[i - 1] = temp;
    
        return i - 1;
    }    

}
