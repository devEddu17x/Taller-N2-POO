package datos;
import java.util.ArrayList;
import entidades.MiTiempo;

public class ListaMiTiempo {
    private static ArrayList <MiTiempo> listaMiTiempo = new ArrayList<>();

    public static void agregarMiTiempo(MiTiempo tiempo){
        listaMiTiempo.add(tiempo);
    }
    public static void mostrarMisTiempos(){
        System.out.println("INDICE\t\tHORAS");
        int i = 1;
        for (MiTiempo tiempo : listaMiTiempo){
            System.out.println(i+"\t\t"+tiempo.toString());
            i++;
        }
    }
    public static void aumentarTiempo(int parametroDeAumento, int indice, int aumento){

        switch (parametroDeAumento){
            case 1:
            listaMiTiempo.set(indice,listaMiTiempo.get(indice).incrementarHora(aumento));
            case 2:
            listaMiTiempo.set(indice,listaMiTiempo.get(indice).incrementarMinuto(aumento));
            case 3:
            listaMiTiempo.set(indice, listaMiTiempo.get(indice).incrementarSegundo(aumento));
        }
    }

    public static int getTamaño(){
        return listaMiTiempo.size();
    }
}
