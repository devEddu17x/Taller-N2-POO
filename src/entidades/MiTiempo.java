package entidades;

import java.time.LocalTime;
import complementos.Complementos;

public class MiTiempo {
    private LocalTime hora;

    public MiTiempo() {
        int hora = setHora();
        int minuto = setMinuto();
        int segundo = setSegundo();

        this.hora = LocalTime.of(hora, minuto, segundo);
    }

    public MiTiempo(LocalTime hora){
        this.hora = hora;
    }

    public int setHora() {
        return Complementos.validarInt(23, 0, "Ingrese la hora: ", "Error: No es una hora valida.",
                "La hora debe estar demtro del rango [0-23]");
    }

    public int setMinuto() {
        return Complementos.validarInt(59, 0, "Ingrese la el minuto: ", "Error: No es un minuto valido.",
                "La hora debe estar demtro del rango [0-59].");

    }

    public int setSegundo() {
        return Complementos.validarInt(59, 0, "Ingrese la segundo: ", "Error: No es un segundo valido.",
                "La hora debe estar demtro del rango [0-59].");
    }
    
    public MiTiempo incrementarHora(int incrementoHora){
        LocalTime horaAux = hora.plusHours((long) incrementoHora);
        MiTiempo tiempoAux = new MiTiempo(horaAux);
        return tiempoAux;
    }

    public MiTiempo incrementarMinuto(int incrementoMinuto){
        LocalTime horaAux = hora.plusMinutes((long) incrementoMinuto);
        MiTiempo tiempoAux = new MiTiempo(horaAux);
        return tiempoAux;
    }

    public MiTiempo incrementarSegundo(int incrementoSegundo){
        LocalTime horaAux = hora.minusSeconds((long) incrementoSegundo);
        MiTiempo tiempoAux = new MiTiempo(horaAux);
        return tiempoAux;
    }

    @Override
    public String toString() {
        return hora.getHour()+":"+hora.getMinute()+":"+hora.getSecond();
    }
    
}
