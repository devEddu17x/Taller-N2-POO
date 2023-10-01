package presentacion;

import complementos.Complementos;
import entidades.ListaNombre;
public class PresentacionListaNombres {
    public static int contadorEnteros = 0;

    public static void main(String[] args) {
        int opcion;
        String menu = "\n1. Agregar un nombre.\r\n" +
                "2. Mostrar nombres.\r\n" +
                "3. Eliminar un nombre, si ingresa su posición.\r\n" +
                "4. Obtener un nombre dada su posición.\r\n" +
                "5. Dado un número nombre cualquiera, verificar si se encuentra en el arreglo.\r\n" + //
                "6. Insertar un nombre dada su posición.\r\n" +
                "7. Listar los nombres ordenados en forma descendente.";

        do {
            opcion = Complementos.menu(menu, 8);
            ejecutar(opcion);
        } while (opcion != 8);
    }

    public static void ejecutar(int x) {
        switch (x) {
            case 1:
                String nombre = Complementos.validarString("\nIngrese un nombre: ", "No se ha ingresado un nombre.");
                ListaNombre.agregarNombre(nombre);
                contadorEnteros++;
                break;
            case 2:
                if (contadorEnteros >= 1) {
                    ListaNombre.mostrarNombres();
                } else {
                    System.out.println("Primero ingrese nombres.");
                }

                break;
            case 3:
                if (contadorEnteros >= 1) {
                    int indice = Complementos.validarInt(ListaNombre.getUltimaPosicion(), 1, "Ingrese su posicion: ",
                            "Error: No se ha ingresado un entero. ", "Solo hay posiciones de (1-"+ListaNombre.getUltimaPosicion()+")");

                    ListaNombre.eliminarNombre(indice - 1);
                    contadorEnteros--;
                } else {
                    System.out.println("No hay nombres que borrar.");
                }

                break;
            case 4:
                if (contadorEnteros >= 1) {
                    int posición = Complementos.validarInt(ListaNombre.getUltimaPosicion(), 1, "Ingrese la posicion: ",
                            "Error: la posicion no es valida. ",
                            "La posicion solo puede estar entre (1-" + ListaNombre.getUltimaPosicion()
                                    + ")");
                    System.out.println("El nombre es " + ListaNombre.getNombre(posición - 1));
                } else {
                    System.out.println("Primero ingrese nombres.");
                }

                break;

            case 5:
                if (contadorEnteros >= 1) {
                    String nombreCualquiera = Complementos.validarString("\nIngrese un nombre: ",
                            "No se ha ingresado un nombre.");
                    if (ListaNombre.existe(nombreCualquiera)) {
                        System.out.println("El nombre si se encuentra.");
                    } else {
                        System.out.println("No se ha encontrado el nombre.");
                    }
                } else {
                    System.out.println("No hay nombres para buscar, ingrese uno.");
                }

                break;

            case 6:
                if (contadorEnteros >= 1) {
                    int position = Complementos.validarInt(ListaNombre.getUltimaPosicion(), 1, "Ingrese la posicion: ",
                            "Error: la posicion no es valida. ",
                            "La posicion solo puede estar entre (1-" + ListaNombre.getUltimaPosicion()
                                    + ")");

                    String nombreInsertar = Complementos.validarString("\nIngrese un nombre: ",
                            "No se ha ingresado un nombre.");

                    ListaNombre.insertarNombre(nombreInsertar, position-1);
                } else {
                    System.out.println("Primero ingrese nombres.");
                }

                break;

            case 7:
                if (contadorEnteros >= 1) {
                    ListaNombre.ordenarNombresAscendente();;
                    ListaNombre.mostrarNombres();
                } else {
                    System.out.println("Ingrese por lo menos un nombre.");
                }

                break;
            case 8:
                System.out.println("Adios.");
                break;
        }
    }
}
