package complementos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Complementos {

    static Scanner sc = new Scanner(System.in);

    public static double validarDouble(double maximo, double minimo, String solicitud, String error,
            String rangoError) {
        Boolean numeroValido;
        double numero = 0;
        do {
            numeroValido = false;
            while (!numeroValido) {
                try {
                    System.out.print(solicitud);
                    numero = sc.nextDouble();
                    numeroValido = true;
                } catch (InputMismatchException errrorDouble) {
                    System.err.println(error);
                    sc.nextLine();
                }
            }
            if (numero < minimo || numero > maximo) {
                System.err.println(rangoError);
                sc.nextLine();
            }
        } while (numero < minimo || numero > maximo);
        return numero;
    }

    public static int validarInt(int maximo, int minimo, String solicitud, String error, String rangoError) {

        int numero = 0;
        boolean numeroValido;
        do {
            numeroValido = false;
            while (!numeroValido) {
                try {
                    System.out.print(solicitud);
                    numero = sc.nextInt();
                    numeroValido = true;
                } catch (InputMismatchException errorInt) {
                    System.err.println(error);
                    sc.nextLine();
                }
            }

            if (numero < minimo || numero > maximo) {
                System.err.println(rangoError);
                sc.nextLine();
            }
        } while (numero < minimo || numero > maximo);

        return numero;
    }

    public static String validarString(String solicitud, String error) {
        String string = "";
        boolean stringValido = false;

        while (!stringValido) {
            System.out.print(solicitud);
            if (sc.hasNextInt() || sc.hasNextDouble()) {
                System.out.println("Solo numeros no es un nombre.");
                sc.nextLine();
                sc.nextLine();
            } else {
                try {

                    string = sc.next();
                    if (!string.isEmpty()) {
                        stringValido = true;
                    } else {
                        System.out.println("La cadena ingresada está vacía");
                    }
                } catch (InputMismatchException errorString) {
                    System.out.println(error);
                    sc.nextLine();
                }
            }

        }

        return string;

    }

    public static int menu(String menu, int maximo) {
        System.err.println("\n\t\tMENU");
        System.err.println(menu);
        System.err.println(maximo + ". Salir.");
        return validarInt(maximo, 1, "\nIngrese la opcion: ", "No se ha ingresado un formato valido.",
                "La opcion debe estar en el rango de [1-" + maximo + "]");
    }

    public static String validarMes(String solicitud) {
        String mes;
        do {
            System.out.print(solicitud);
            mes = sc.next();
            if (!mes.isEmpty()) {
                mes = mes.substring(0, 1).toUpperCase() + mes.substring(1);
            } else {
                System.err.println("El mes es invalido.");
            }
        } while (!mes.equals("Enero") && !mes.equals("Febrero") && !mes.equals("Marzo") && !mes.equals("Abril")
                && !mes.equals("Mayo") && !mes.equals("Junio") && !mes.equals("Julio") && !mes.equals("Agosto")
                && !mes.equals("Septiembre") && !mes.equals("Octubre") && !mes.equals("Noviembre")
                && !mes.equals("Diciembre"));
        return mes;
    }

    public static int generarMCD(int numerador, int denominador) {
        numerador = Math.abs(numerador);
        denominador = Math.abs(denominador);
        int aux = 1;
        while (denominador != 0) {
            aux = denominador;
            denominador = numerador % denominador;
            numerador = aux;
        }
        return aux;
    }
}
