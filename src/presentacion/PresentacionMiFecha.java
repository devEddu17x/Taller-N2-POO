package presentacion;

import java.util.Scanner;
import complementos.Complementos;
import entidades.MiFecha;
import datos.ListaFecha;

public class PresentacionMiFecha {

    static int existenFechas = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        String menu = "\n1. Agregar fecha.\n2. Mostrar fechas en diferentes formatos.";
        do {
            opcion = Complementos.menu(menu, 3);
            ejecutar(opcion);
        } while (opcion != 3);
    }

    public static void ejecutar(int x) {
        switch (x) {
            case 1:
                System.out.println("\n¿En que formato vas a ingresar la fecha?");
                String miniMenu = "\n1. Valores enteros (dd/mm/aa)\n2. Mes cadena de texto, año y dia como enteros (mes/dd/aa).\n3. Solo mes y año.";
                int opcion = Complementos.menu(miniMenu, 4);
                miniEjecutar(opcion);
                break;
            case 2:
                if (existenFechas > 0) {
                    ListaFecha.mostrarFechas();
                } else {
                    System.out.println("Primero agregue fechas.");
                }
                break;
            case 3:
                System.out.println("Adios");
        }
    }

    public static void miniEjecutar(int x) {
        MiFecha fecha;
        int dia;
        int mes;
        int año;
        switch (x) {
            case 1: // /dia/mes/año
                dia = Complementos.validarInt(31, 1, "Ingrese el dia: ", "Error: El dia no es valido.",
                        "El dia debe estar dentro del rango [1-30]");
                mes = Complementos.validarInt(12, 1, "Ingrese el mes: ", "Error: El mes no es valido.",
                        "El mes debe estar dentro del rango [1-12]");
                año = Complementos.validarInt(99, 1, "Ingrese el año: ", "Error: El año no es valido",
                        "El año debe estar en el rango [1-99]");

                fecha = new MiFecha(dia, mes, año);
                ListaFecha.agregarFecha(fecha);
                existenFechas++;
                return;
            case 2: // mes dia año
                String mesString = Complementos.validarMes("Ingrese el mes: ");
                dia = Complementos.validarInt(31, 1, "Ingrese el dia: ", "Error: El dia no es valido.",
                        "El dia debe estar dentro del rango [1-30]");
                año = Complementos.validarInt(99, 1, "Ingrese el año: ", "Error: El año no es valido",
                        "El año debe estar en el rango [1-99]");
                existenFechas++;
                fecha = new MiFecha(mesString, dia, año);
                ListaFecha.agregarFecha(fecha);
                return;
            case 3:
                mesString = Complementos.validarMes("Ingrese el mes: ");
                año = Complementos.validarInt(99, 1, "Ingrese el año: ", "Error: El año no es valido",
                        "El año debe estar en el rango [1-99]");

                fecha = new MiFecha(mesString, año);
                ListaFecha.agregarFecha(fecha);
                existenFechas++;
                return;
            default:
                System.out.println("Operacion cancelada...");
                return;
        }
    }
}
