package presentacion;
import complementos.Complementos;
import datos.ListaMiFraccion;
import entidades.MiFraccion;

public class PresentacionMiFraccion {
    public static final int maximo = 4;
    public static void main(String[] args) {
        int opcion;
        String menu = "\n1. Agregar fracciones. \n2. Operaciones con fracciones. \n3. Mostrar resultados.";
        do {
            opcion = Complementos.menu(menu, maximo);
            ejecutar(opcion);
        } while (opcion != maximo);
    }

    public static void ejecutar(int x){
        switch (x){
            case 1:
            int numerador = Complementos.validarInt(Integer.MAX_VALUE, Integer.MIN_VALUE, "Ingrese el numerador: ", "Error: Lo ingresado no es un entero valido para el numerador: ", "x");
            int denominador = Complementos.validarInt(Integer.MAX_VALUE, Integer.MIN_VALUE, "Ingrese el denominador: ", "Error: Lo ingresado no es un entero valido para el denominador: ", "x");
            MiFraccion fraccion = new MiFraccion(numerador, denominador);
            ListaMiFraccion.agregarFracciones(fraccion);
            break;
            case 2:
            System.out.println("\n1. Suma.\n2. Resta. \n3. Multiplicacion. \n4. Division.");
            int tipoDeOperacion = Complementos.validarInt(4, 1, "Ingrese la operacion que desea hacer.", "Error: No se ha ingresado una opcion", "El rango de opciones esta entre (1-4).");
            ListaMiFraccion.mostrarFracciones();
            int indice1 = Complementos.validarInt(ListaMiFraccion.getTamaño(), 1, "Ingrese el indice de la primera fracción: ", "Error: No se ha ingresado un indice valido.", "El rango de indices es de (1-"+ListaMiFraccion.getTamaño()+").");
            ListaMiFraccion.mostrarFracciones();
            int indice2 = Complementos.validarInt(ListaMiFraccion.getTamaño(), 1, "Ingrese el indice de la segunda fracción: ", "Error: No se ha ingresado un indice valido.", "El rango de indices es de (1-"+ListaMiFraccion.getTamaño()+").");
            ListaMiFraccion.operacionesFracciones(tipoDeOperacion, indice1-1, indice2-1);
            break;
            case 3:
            case 4:
        }
    }
}
