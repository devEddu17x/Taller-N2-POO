package entidades;

import java.util.ArrayList;

public class Almacen {
    private static ArrayList <Producto> listaProductos = new ArrayList<>();
    private static int ultimaPosicion=0;

    public static void agregarProducto(Producto producto){
        listaProductos.add(producto);
        ultimaPosicion++;
    }

    public static void mostrarProductos(){
        System.out.println("\nINDICE\t\tCODIGO\t\tNOMBRE\t\tSTOCK\n"); int i = 1;
        for (Producto producto : listaProductos){
            System.out.println(i+"\t"+producto.toString());
        }
    }

    public static String getCodigo(int indice){
        return listaProductos.get(indice).getCodigo();
    }

    public static void modificarStockProducto(int indice, int aumento){
        listaProductos.get(indice).setStock(aumento);;
    }

    public static int buscarProducto(String nombre){
        for (Producto producto : listaProductos ) {
            if (producto.getNombre().equals(nombre)){
                return listaProductos.indexOf(producto);
            }
        }

        return -1;
    }
    public static int getStockProducto(int indice){
        return listaProductos.get(indice).getStock();
    }

    public static void ordenarProductosDescendente() {
        quicksort(listaProductos, 0, ultimaPosicion - 1);
    }
    
    private static void quicksort(ArrayList<Producto> lista, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indicePivote = particion(lista, izquierda, derecha);
            quicksort(lista, izquierda, indicePivote - 1);
            quicksort(lista, indicePivote + 1, derecha);
        }
    }
    
    private static int particion(ArrayList<Producto> lista, int izquierda, int derecha) {

        int pivote = lista.get(izquierda).getStock();
        int i = izquierda + 1;
    
        for (int j = i; j <= derecha; j++) {
            if (lista.get(j).getStock() > pivote) {
                Producto temp = listaProductos.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
                i++;
            }
        }
    
        Producto temp = lista.get(izquierda);
        arreglo[izquierda] = arreglo[i - 1];
        lista.set(izquierda, lista.get(i-1));
        arreglo[i - 1] = temp;
        lista.set(i-1, temp);
    
        return i - 1;
    }
}
