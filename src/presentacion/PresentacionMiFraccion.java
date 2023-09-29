package presentacion;

import complementos.Complementos;
import datos.ListaMiFraccion;
import entidades.MiFraccion;

public class PresentacionMiFraccion {
    public static final int maximo = 6;
    public static byte contadorFracciones = 0;

    public static void main(String[] args) {
        int opcion;
        String menu = "\n1. Agregar fracciones.\n2. Mostrar fracciones. \n3. Operaciones con fracciones. \n4. Mostrar resultados.\n5. Mostrar fracciones en forma de punto flotante.";
        do {
            opcion = Complementos.menu(menu, maximo);
            ejecutar(opcion);
        } while (opcion != maximo);
    }

    public static void ejecutar(int x) {
        switch (x) {
            case 1:
                int numerador = Complementos.validarInt(Integer.MAX_VALUE, Integer.MIN_VALUE, "Ingrese el numerador: ",
                        "Error: Lo ingresado no es un entero valido para el numerador: ", "x");
                int denominador = Complementos.validarInt(Integer.MAX_VALUE, Integer.MIN_VALUE,
                        "Ingrese el denominador: ", "Error: Lo ingresado no es un entero valido para el denominador: ",
                        "x");
                MiFraccion fraccion = new MiFraccion(numerador, denominador);
                ListaMiFraccion.agregarFracciones(fraccion);
                contadorFracciones++;
                break;
            case 2:
                if (contadorFracciones > 0) {
                    ListaMiFraccion.mostrarFracciones();
                } else {
                    System.out.println("No hay fracciones para mostrar.");
                }

                break;
            case 3:

                if (contadorFracciones > 1) {
                    System.out.println("\n1. Suma.\n2. Resta. \n3. Multiplicacion. \n4. Division.");
                    int tipoDeOperacion = Complementos.validarInt(4, 1, "\nIngrese la operacion que desea hacer: ",
                            "Error: No se ha ingresado una opcion", "El rango de opciones esta entre (1-4).");
                    ListaMiFraccion.mostrarFracciones();
                    int indice1 = Complementos.validarInt(ListaMiFraccion.getTamaño(), 1,
                            "\nIngrese el indice de la primera fracción: ", "Error: No se ha ingresado un indice valido.",
                            "El rango de indices es de (1-" + ListaMiFraccion.getTamaño() + ").");
                    ListaMiFraccion.mostrarFracciones();
                    int indice2 = Complementos.validarInt(ListaMiFraccion.getTamaño(), 1,
                            "\nIngrese el indice de la segunda fracción: ", "Error: No se ha ingresado un indice valido.",
                            "El rango de indices es de (1-" + ListaMiFraccion.getTamaño() + ").");
                    ListaMiFraccion.operacionesFracciones(tipoDeOperacion, indice1 - 1, indice2 - 1);
                } else {
                    System.out.println("No hay suficientes fracciones para realizar operaciones.");
                }

                break;
            case 4:
                if (ListaMiFraccion.getTamañoResultados() > 0) {
                    ListaMiFraccion.mostrarResultados();
                } else {
                    System.out.println("No se han realizado operaciones. ");
                }

                break;

            case 5:
                if (contadorFracciones > 0) {
                    ListaMiFraccion.reportarPuntoFlotante();
                } else {
                    System.out.println("No hay fracciones para mostrar. ");
                }

                break;

            case 6:
                System.out.println("Adios.");
                break;
        }
    }
}
