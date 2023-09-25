package datos;
import entidades.Rectangulo;
import java.util.ArrayList;
public class ListaRectangulo {

    private static ArrayList <Rectangulo> listaRectangulo = new ArrayList<>();
    
    public static void agregarRectangulo(Rectangulo rectangulo){
        listaRectangulo.add(rectangulo);
    }

    public static void mostrarRectangulos(){

        System.out.println("LONGITUD       ANCHO       PERIMETRO       AREA");
        
        for (Rectangulo rec: listaRectangulo){
            System.out.println(rec.getLongitud()+"\t\t"+rec.getAncho()+"\t\t"+rec.getPerimetro()+"\t\t"+rec.getArea());
        }
    }

}
