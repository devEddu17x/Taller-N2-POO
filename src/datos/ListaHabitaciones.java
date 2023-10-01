package datos;

import java.util.ArrayList;

import entidades.Habitacion;

public class ListaHabitaciones {
    private static ArrayList <Habitacion> listaHabitaciones = new ArrayList<>();

    public static void agregarHabitacion(Habitacion habitacion){
        if (listaHabitaciones.size() < 31){
            listaHabitaciones.add(habitacion);
        } else {
            System.out.println("Capacidad al maximo");
        }
    }

    public static void reportarHabitaciones(){
            System.out.println("\nNUMERO\t DISPONIBLE/NOMBRE HUESPED");
        for (Habitacion habitacion : listaHabitaciones){
            System.out.println(habitacion.toString());
        }
    }

    public static int getTamaño(){
        return listaHabitaciones.size();
    }

    public static void insertarHuesped(String nombre, int indice){
        
        if (!listaHabitaciones.get(indice).getDisponibilidad()){
            listaHabitaciones.get(indice).setNombreDueño(nombre);
            listaHabitaciones.get(indice).setDisponibilidad(true);
        } else {
            System.out.println("La habitacion ya esta ocupada por "+listaHabitaciones.get(indice).getNombre()+".");
        }
    }
}
