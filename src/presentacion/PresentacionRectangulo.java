package presentacion;

import complementos.Complementos;
import datos.ListaRectangulo;
import entidades.Rectangulo;

public class PresentacionRectangulo {
    static boolean existenRectangulos;
    public static void main(String[] args) {
        String menu = "\n1.Agregar rectangulo. \n2. Mostrar rectangulos. ";
        int opcion;
        do{
            opcion = Complementos.menu(menu, 3);
            ejecutar(opcion);
        }while (opcion != 3);
    }

    public static void ejecutar(int opcion){

        switch (opcion){
            case 1:
            Rectangulo rectangulo = new Rectangulo() ;
            ListaRectangulo.agregarRectangulo(rectangulo);
            existenRectangulos = true;
            break;
            case 2:
            if (existenRectangulos){
            ListaRectangulo.mostrarRectangulos();
            } else {
                System.out.println("\nNo se han agregado rectangulos.");
            }
            break;
            case 3:
            System.out.println("Adios.");
            break;
        }
    }
}
