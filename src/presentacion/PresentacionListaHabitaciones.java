package presentacion;

import complementos.Complementos;
import entidades.Habitacion;
import datos.ListaHabitaciones;

public class PresentacionListaHabitaciones {
    public static boolean existenHabitaciones = false;

    public static void main(String[] args) {
        int opcion;

        String menu = "\n1. Agregar habitacion.\n2. Reportar habitaciones.\n3. Ingresar huesped a habitacion.";
        do {
            opcion = Complementos.menu(menu, 4);
            ejecutar(opcion);
        } while (opcion != 4);
    }

    public static void ejecutar(int opcion) {
        switch (opcion) {
            case 1:
                if (ListaHabitaciones.getTamaño() < 31) {
                    Habitacion habitacion = new Habitacion();
                    ListaHabitaciones.agregarHabitacion(habitacion);
                    System.out.println("¡Se ha creado una nueva habitación!");
                    existenHabitaciones = true;
                } else {
                    System.out.println("\nYa no se puede crear más habitaciones. Capacidad al máximo.");
                }
                break;
            case 2:
                if (existenHabitaciones)
                    ListaHabitaciones.reportarHabitaciones();
                else
                    System.out.println("Primero ingrese habitaciones");
                break;
            case 3:
                if (existenHabitaciones) {
                    String nombre = Complementos.validarString("\nIngrese el nombre del huesped: ",
                            "No se ha ingresado un nombre.");
                    ListaHabitaciones.reportarHabitaciones();
                    int indice = Complementos.validarInt(ListaHabitaciones.getTamaño(), 1,
                            "\nIngrese el indice del producto: ",
                            "El indice ingresado no es valido.",
                            "El rango de los indices esta entre (1-" + ListaHabitaciones.getTamaño() + ")");
                    ListaHabitaciones.insertarHuesped(nombre, indice-1);
                } else {
                    System.out.println("Primero ingrese habitaciones.");
                }

                break;
            case 4:
                System.out.println("Adios.");
                break;
        }
    }
}
