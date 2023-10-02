package presentacion;

import complementos.Complementos;
import datos.ListaEnteros;

public class PresentacionListaEnteros {
    public static int contadorEnteros = 0;

    public static void main(String[] args) {
        int opcion;
        String menu = "\n1. Agregar un número entero.\r\n" +
                "2. Mostrar números.\r\n" +
                "3. Eliminar un número, si ingresa su posición.\r\n" +
                "4. Obtener un entero dada su posición.\r\n" +
                "5. Dado un número entero cualquiera, verificar si se encuentra en el arreglo.\r\n" + //
                "6. Insertar un entero dada su posición.\r\n" +
                "7. Listar los números ordenados en forma descendente.";

        do {
            opcion = Complementos.menu(menu, 8);
            ejecutar(opcion);
        } while (opcion != 8);
    }

    public static void ejecutar(int x) {
        switch (x) {
            case 1:
                int entero = Complementos.validarInt(Integer.MAX_VALUE, Integer.MIN_VALUE, "Ingrese un entero: ",
                        "Error: No se ha ingresado un entero. ", "x");
                ListaEnteros.agregarNumero(entero);
                contadorEnteros++;
                break;
            case 2:
                if (contadorEnteros >= 1) {
                    ListaEnteros.mostrarNumeros();
                } else {
                    System.out.println("Primero ingrese numeros.");
                }

                break;
            case 3:
                if (contadorEnteros >= 1) {
                    int indice = Complementos.validarInt(Integer.MAX_VALUE, Integer.MIN_VALUE, "Ingrese su posicion: ",
                            "Error: No se ha ingresado un entero. ", "x");

                    ListaEnteros.eliminarNumeroEntero(indice - 1);
                    contadorEnteros--;
                } else {
                    System.out.println("No hay enteros que borrar.");
                }

                break;
            case 4:
                if (contadorEnteros >= 1) {
                    int posición = Complementos.validarInt(ListaEnteros.getUltimaPosicion(), 1, "Ingrese la posicion: ",
                            "Error: la posicion no es valida. ",
                            "La posicion solo puede estar entre (1-" + ListaEnteros.getUltimaPosicion()
                                    + ")");

                    System.out.println("El numero es " + ListaEnteros.getEntero(posición-1));
                } else {
                    System.out.println("Primero ingrese enteros.");
                }

                break;

            case 5:
                if (contadorEnteros >= 1) {
                    int numeroCualquiera = Complementos.validarInt(Integer.MAX_VALUE, Integer.MIN_VALUE,
                            "Ingrese un entero: ",
                            "Error: No se ha ingresado un entero. ", "x");
                    if (ListaEnteros.existe(numeroCualquiera)) {
                        System.out.println("El entero si se encuentra.");
                    } else {
                        System.out.println("No se ha encontrado el entero.");
                    }
                } else {
                    System.out.println("No hay enteros para buscar, ingrese uno.");
                }

                break;

            case 6:
                if (contadorEnteros >= 1) {
                    int position = Complementos.validarInt(ListaEnteros.getUltimaPosicion(), 1, "Ingrese la posicion: ",
                            "Error: la posicion no es valida. ",
                            "La posicion solo puede estar entre (1-" + ListaEnteros.getUltimaPosicion()
                                    + ")");

                    int enteroInsertar = Complementos.validarInt(Integer.MAX_VALUE, Integer.MIN_VALUE,
                            "Ingrese un entero: ",
                            "Error: No se ha ingresado un entero. ", "x");

                    ListaEnteros.insertarNumero(enteroInsertar, position);
                } else {
                    System.out.println("Primero ingrese numeros.");
                }

                break;

            case 7:
                if (contadorEnteros >= 1) {
                    ListaEnteros.ordenarNumerosDescendente();
                    ListaEnteros.mostrarNumeros();
                } else {
                    System.out.println("Ingrese por lo menos un entero.");
                }

                break;
            case 8:
                System.out.println("Adios.");
                break;
        }
    }
}
