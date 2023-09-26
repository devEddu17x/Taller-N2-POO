package presentacion;

import complementos.Complementos;
import datos.ListaMiTiempo;
import entidades.MiTiempo;

public class PresentacionMiTiempo {
    public static void main(String[] args) {
        int opcion;
        String menu = "1. Agregar horas. \n2. Mostrar horas.\n3. Modificar horas.";

        do {
            opcion = Complementos.menu(menu, 4);
            ejecutar(opcion);
        } while (opcion != 4);
    }

    public static void ejecutar(int x) {
        switch (x) {
            case 1:
                ListaMiTiempo.agregarMiTiempo(new MiTiempo());
                return;
            case 2:
                ListaMiTiempo.mostrarMisTiempos();
                return;
            case 3:
                System.out.println("\n1. Modificar hora. \n2. Modificar minuto.\n3. Modificar segundos.");
                int parametroDeAumento = Complementos.validarInt(3, 1, "Ingrese el valor que quiere modificar: ",
                        "La opcion no es valida.", "La opcion debe estar en el rango (1-3).");
                ListaMiTiempo.mostrarMisTiempos();
                int indice = Complementos.validarInt(ListaMiTiempo.getTamaño(), 1,
                        "Ingrese el indice de la horaa modificar: ", "Error: No se ha ingresado un indice valido.",
                        "El indice debe estar en el rango (1-" + ListaMiTiempo.getTamaño() + ")");
                indice--;
                int aumento = Complementos.validarInt(150, 1, "Ingrese el aumnento: ",
                        "Error: El aumento debe ser un numero entero.", "El rango de aumento es de (1-150)");
                ListaMiTiempo.aumentarTiempo(parametroDeAumento, indice, aumento);
                return;
            case 4:
                System.out.println("Adios.");
                return;
        }
    }
}