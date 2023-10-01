package entidades;

public class Habitacion {
    private static int contadorHabitaciones;
    private int numero;
    private String nombreDueño;
    private boolean disponible;

    public Habitacion() {
        contadorHabitaciones++;
        this.numero = contadorHabitaciones;
    }

    public String toString(){
        String disponibilidad = (disponible) ? nombreDueño : "Disponible";
        return numero+"\t\t   "+disponibilidad; 
    }

    public boolean getDisponibilidad(){
        return disponible;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public void setDisponibilidad(boolean disponibilidad){
        this.disponible = disponibilidad;
    }

    public String getNombre(){
        return nombreDueño;
    }
    
}
