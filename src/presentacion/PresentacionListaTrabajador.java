package presentacion;

import java.util.Scanner;

import complementos.Complementos;
import entidades.ListaTrabajador;
import entidades.Trabajador;

public class PresentacionListaTrabajador {
    static Scanner sc = new Scanner(System.in);
    static int existenTrabajadores = 0;
    static String mensajito = "Primero ingrese nombres.";

    public static void main(String[] args) {
        int opcion;
        String menu = "1. Ingresar un trabajador dado.\r\n" +
                "2. Mostrar trabajadores. \r\n" +
                "3. Eliminar un trabajador dada su posición.\r\n" + //
                "4. Obtener el trabajador dada su posición.\r\n" + //
                "5. Buscar si un trabajador existe dado su nombre.\r\n" + //
                "6. Reportar la relación de trabajadores ordenados en forma ascendente por el nombre.\r\n" + //
                "7. Reportar la relación de trabajadores ordenados en forma descendente por el sueldo neto.";
        do {
            opcion = Complementos.menu(menu, 8);
            ejecutar(opcion);
        } while (opcion != 8);

    }

    public static void ejecutar(int x) {
        switch (x) {
            case 1:
                String nombre = Complementos.validarString("\nIngrese el nombre del trajador: ",
                        "El nombre no es valido.");
                double pagoPorHora = Complementos.validarDouble(200, 1, "\nIngrese el pago por hora: ",
                        "El monto no es válido: ", "El monto debe estar en el rango adecuado (1-200)");
                int cantidadHorasTrabajadas = Complementos.validarInt(288, 1,
                        "\nIngrese el la cantidad de horas trabajadas: ",
                        "La cantidad de horas no es valida", "No esta dentro del rango adecuado horas/mes (1-288)");
                Trabajador trabajador = new Trabajador(nombre, pagoPorHora, cantidadHorasTrabajadas);
                ListaTrabajador.agregarTrabajador(trabajador);
                existenTrabajadores++;
                break;
            case 2:
                if (existenTrabajadores > 0) {
                    ListaTrabajador.mostrarTrabajadores();
                } else {
                    System.out.println("No hay datos para mostrar.");
                }
                break;
            case 3:
                if (existenTrabajadores > 0) {
                    int indice = Complementos.validarInt(ListaTrabajador.getUltimaPosicion(), 1,
                            "Ingrese su posicion: ",
                            "Error: No se ha ingresado un entero. ",
                            "EL rango de posiciones es de (1-" + ListaTrabajador.getUltimaPosicion() + ")");

                    ListaTrabajador.eliminarTrabajador(indice - 1);
                    existenTrabajadores--;
                } else {
                    System.out.println("No hay nombres que borrar.");
                }
                break;
            case 4:
                if (existenTrabajadores > 0) {
                    int indice = Complementos.validarInt(ListaTrabajador.getUltimaPosicion(), 1,
                            "Ingrese su posicion: ",
                            "Error: No se ha ingresado un entero. ",
                            "EL rango de posiciones es de (1-" + ListaTrabajador.getUltimaPosicion() + ")");
                    ListaTrabajador.mostrarTrabajadorIndice(indice - 1);
                } else {
                    System.out.println(mensajito);
                }

                break;
            case 5:
                if (existenTrabajadores > 0) {
                    String nombreBuscar = Complementos.validarString("\nIngrese el nombre del trajador: ",
                            "El nombre no es valido.");
                    ListaTrabajador.buscarPorNombre(nombreBuscar);
                } else {
                    System.out.println(mensajito);
                }

                break;
            case 6:
                if (existenTrabajadores > 0) {
                    ListaTrabajador.ordenarNombresAscendente();
                    ListaTrabajador.mostrarTrabajadores();
                } else {
                    System.out.println(mensajito);
                }

                break;
            case 7:
                if (existenTrabajadores > 0) {
                    ListaTrabajador.ordenarSueldoNetoDescendentemente();
                    ListaTrabajador.mostrarTrabajadores();
                } else {
                    System.out.println(mensajito);
                }

                break;
            case 8:
                System.out.println("Adios.");
                break;

        }
    }
}