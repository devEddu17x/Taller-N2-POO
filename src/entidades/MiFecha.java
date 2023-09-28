package entidades;
//import java.time.LocalDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class MiFecha {

    String formato[] = new String[4];
    public MiFecha(String nuevoFormato[]){
        for (int i=0; i<4; i++){
            formato[i] = nuevoFormato[i];
        }
    }
    public MiFecha(int dia, int mes, int año) {
        String diaParametro = verificarCeros(dia);
        String mesParametro = verificarCeros(mes);
        String añoParametro = verificarCeros(año);

        formato[0] = mesParametro + "/" + diaParametro + "/" + añoParametro;
        formato[1] = diaParametro + "/" + mesParametro + "/" + añoParametro;
        formato[2] = generarMes(mes) + " " + diaParametro + ", 20" + añoParametro;
        formato[3] = generarMes(mes) + " 20" + añoParametro;
    }

    public MiFecha(String mes, int dia, int año) {
        String diaParametro = verificarCeros(dia);
        String mesParametro = verificarCeros(generarMes(mes));
        String añoParametro = verificarCeros(año);
        formato[0] = mesParametro + "/" + diaParametro + "/" + añoParametro;
        formato[1] = diaParametro + "/" + mesParametro + "/" + añoParametro;
        formato[2] = mes + " " + diaParametro + ", 20" + añoParametro;
        formato[3] = mes + " 20" + añoParametro;

    }

    public MiFecha(String mes, int año) {
        String añoParametro = verificarCeros(año);
        String mesParametro = verificarCeros(generarMes(mes));
        formato[0] = mesParametro + "/" + añoParametro;
        formato[1] = mesParametro + "/" + añoParametro;
        formato[2] = mes + " ,20" + añoParametro;
        formato[3] = mes + " 20" + añoParametro;
    }

    public String getFormatoFecha() {
        return formato[0] + "\t\t" + formato[1] + "\t\t" + formato[2] + "\t\t" + formato[3];
    }

    public String verificarCeros(int valor) {

        if (valor <= 9) {
            return "0" + valor;
        }
        return String.valueOf(valor);
    }

    public MiFecha aumentarFecha(int parametroDeAumento, int aumento) {
        DateTimeFormatter dateFormat0 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dateFormat2 = DateTimeFormatter.ofPattern("MMMM dd ',' yyyy", new Locale("es", "PE"));
        DateTimeFormatter dateFormat3 = DateTimeFormatter.ofPattern("MMMM yyyy", new Locale("es", "PE"));
    
        try {
            LocalDate date0 = LocalDate.parse(formato[0], dateFormat0);
            LocalDate date1 = LocalDate.parse(formato[1], dateFormat1);
            LocalDate date2 = LocalDate.parse(formato[2], dateFormat2);
            LocalDate date3 = LocalDate.parse(formato[3], dateFormat3);
    
            if (parametroDeAumento == 1) {
                if (date0.getDayOfMonth() + aumento < date0.getMonth().lengthOfMonth()) {
                    date0 = date0.plusDays((long) aumento);
                } else {
                    date0 = date0.plusMonths((long) aumento);
                }
            } else {
                date0 = date0.plusMonths((long) aumento);
            }
    
            String nuevosFormatos[] = new String[4];
    
            nuevosFormatos[0] = date0.format(dateFormat0);
            nuevosFormatos[1] = date1.format(dateFormat1);
            nuevosFormatos[2] = date2.format(dateFormat2);
            nuevosFormatos[3] = date3.format(dateFormat3);
    
            return new MiFecha(nuevosFormatos);
    
        } catch (DateTimeParseException e) {
            if (parametroDeAumento == 1) {
                System.err.println("No se puede aumentar el dia de una fecha invalida");
            } else {
                System.err.println("No se puede aumentar el mes de una fecha invalida");
            }
            return this;
        }
    }


    public String generarMes(int mes) {
        switch (mes) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "x";
        }
    }

    public int generarMes(String mes) {
        switch (mes) {
            case "Enero":
                return 1;
            case "Febrero":
                return 2;
            case "marzo":
                return 3;
            case "Abril":
                return 4;
            case "Mayo":
                return 5;
            case "Junio":
                return 6;
            case "Julio":
                return 7;
            case "Agosto":
                return 8;
            case "Septiembre":
                return 9;
            case "Octubre":
                return 10;
            case "Noviembre":
                return 11;
            case "Diciembre":
                return 12;
            default:
                return 0;

        }
    }

}
