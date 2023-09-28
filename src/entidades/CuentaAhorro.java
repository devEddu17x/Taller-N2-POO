package entidades;

public class CuentaAhorro{
    private static double tasaDeInteres; // si es 12% se guarda como 0.12
    private static int contador = 0;

    private double saldoAhorros; // lo que tengo en deposito
    private double saldoMasInteres;
    private int indice;

    public CuentaAhorro(double saldoAhorros){
        this.saldoAhorros = saldoAhorros;
        contador++;
        indice = contador;
        saldoMasInteres = calcularSaldoMasInteresAnual();

    }

    public void depositar(double deposito){
        saldoAhorros += deposito;
        saldoMasInteres = calcularSaldoMasInteresAnual();
    }

    public double calcularSaldoMasInteresAnual(){
        return saldoAhorros+saldoAhorros*tasaDeInteres;
    }

    public static void modificarTasaDeInteres(double nuevoInteres){
        tasaDeInteres = nuevoInteres/100;
    }

    public double calcularInteresMes(){
        return saldoAhorros*tasaDeInteres/12;
    }

    @Override
    public String toString() {
        return indice+"\t\t"+saldoAhorros+"\t\t"+saldoMasInteres;
    }

    
}