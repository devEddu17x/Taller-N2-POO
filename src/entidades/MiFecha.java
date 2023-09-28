package entidades;

public class MiFecha {

    private String formato[] = new String[4];
    private int dia;
    private int mes;
    private int año;

    public MiFecha(String nuevoFormato[]) {
        for (int i = 0; i < 4; i++) {
            formato[i] = nuevoFormato[i];
        }
    }

    public MiFecha(int dia, int mes, int año) {

        this.dia = dia;
        this.mes = mes;
        this.año = año;

        String diaParametro = verificarCeros(dia);
        String mesParametro = verificarCeros(mes);
        String añoParametro = verificarCeros(año);

        formato[0] = mesParametro + "/" + diaParametro + "/" + añoParametro;
        formato[1] = diaParametro + "/" + mesParametro + "/" + añoParametro;
        formato[2] = generarMes(mes) + " " + diaParametro + ", 20" + añoParametro;
        formato[3] = generarMes(mes) + " 20" + añoParametro;
    }

    public MiFecha(String mes, int dia, int año) {
        this.dia = dia;
        this.mes = generarMes(mes);
        this.año = año;
        String diaParametro = verificarCeros(dia);
        String mesParametro = verificarCeros(generarMes(mes));
        String añoParametro = verificarCeros(año);
        formato[0] = mesParametro + "/" + diaParametro + "/" + añoParametro;
        formato[1] = diaParametro + "/" + mesParametro + "/" + añoParametro;
        formato[2] = mes + " " + diaParametro + ", 20" + añoParametro;
        formato[3] = mes + " 20" + añoParametro;

    }

    public MiFecha(String mes, int año) {
        
        dia = 0;
        this.mes = generarMes(mes);
        this.año = año;
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
        int nuevoDia = dia;
        int nuevoMes = mes;
        int nuevoAnio = año;

        if (parametroDeAumento == 1) {
            nuevoDia += aumento;

            while (nuevoDia > 31) {
                nuevoDia -= 31;
                nuevoMes++;
            }
        } else {
            nuevoMes += aumento;

            while (nuevoMes > 12) {
                nuevoMes -= 12;
                nuevoAnio++;
            }
        }

        return new MiFecha(nuevoDia, nuevoMes, nuevoAnio);
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
            case "Marzo":
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
