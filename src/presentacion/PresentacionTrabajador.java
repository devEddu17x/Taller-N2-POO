package presentacion;
import java.util.Scanner;

import complementos.Complementos;
import datos.ListaTrabajador;
import entidades.Trabajador;

public class PresentacionTrabajador {
    static Scanner sc = new Scanner(System.in);
    static boolean existenTrabajadores = false;

    public static void main(String[] args) {
        int opcion;
        String menu = "1. Agregar trabajador\n2. Mostrar datos trabajadores";
        do {
            opcion = Complementos.menu(menu, 3);
            ejecutar(opcion);
        } while (opcion != 3);

    }

    public static void ejecutar(int x) {
        switch (x) {
            case 1:
                // Recolectando datos para un nuevo objeto Trabajador
                System.out.print("\nIngrese el nombre del trabajador: ");
                String nombre = sc.next();
                sc.nextLine();
                double pagoPorHora = Complementos.validarDouble(150, 1, "\nIngrese el pago por hora: ", "El monto no es válido: ","El monto debe estar en el rango adecuado (1-150)");
                int cantidadHorasTrabajadas = Complementos.validarInt(288, 96, "\nIngrese el la cantidad de horas trabajadas: ",
                        "La cantidad de horas no es valida", "No esta dentro del rango adecuado horas/mes (96-288)");

                // Agregando objeto
                Trabajador trabajador = new Trabajador(nombre, pagoPorHora, cantidadHorasTrabajadas);
                ListaTrabajador.agregarTrabajador(trabajador);
                existenTrabajadores = true;
                break;
            case 2:
                if (existenTrabajadores) {
                    ListaTrabajador.mostrarTrabajdores();
                } else {
                    System.out.println("No hay datos para mostrar.");
                }
                break;
            case 3:
            System.out.println("Adios.");
                break;
        }
    }
}