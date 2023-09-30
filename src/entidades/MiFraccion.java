package entidades;

import complementos.Complementos;

public class MiFraccion {
    private int numerador;
    private int denominador;

    public MiFraccion(int numerador, int denominador) {
        int mcd = Complementos.generarMCD(numerador, denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
        if (this.numerador <0 && this.denominador < 0){
            this.numerador*=-1;
            this.denominador/=-1;
        } if (this.numerador<0 || this.denominador<0){
            this.denominador = Math.abs(denominador);
            this.numerador = Math.abs(numerador) *-1;
        }
    }

    public MiFraccion() {
        numerador = 1;
        denominador = 1;
    }

    public static MiFraccion sumarFracciones(MiFraccion fraccion1, MiFraccion fraccion2) {
        int numeradorAux = fraccion1.numerador * fraccion2.denominador + fraccion2.numerador * fraccion1.denominador;
        int denominadorAux = fraccion1.denominador * fraccion2.denominador;

        MiFraccion resultado = new MiFraccion(numeradorAux, denominadorAux);
        return resultado;
    }

    public static MiFraccion restarFracciones(MiFraccion fraccion1, MiFraccion fraccion2) {
        int numeradorAux = fraccion1.numerador * fraccion2.denominador - fraccion2.numerador * fraccion1.denominador;
        int denominadorAux = fraccion1.denominador * fraccion2.denominador;

        MiFraccion resultado = new MiFraccion(numeradorAux, denominadorAux);
        return resultado;
    }

    public static MiFraccion multiplicarFracciones(MiFraccion fraccion1, MiFraccion fraccion2) {

        int numeradorAux = fraccion1.numerador * fraccion2.numerador;
        int denominadorAux = fraccion1.denominador * fraccion2.denominador;

        MiFraccion resultado = new MiFraccion(numeradorAux, denominadorAux);
        return resultado;
    }

    public static MiFraccion dividirFracciones(MiFraccion fraccion1, MiFraccion fraccion2) {
        int numeradorAux = fraccion1.numerador*fraccion2.denominador;
        int denominadorAux = fraccion1.denominador * fraccion2.numerador;
        
        MiFraccion resultado = new MiFraccion(numeradorAux, denominadorAux);
        return resultado;
    }

    public double devolverEnDecimales(int numeroDecimales){
        double division = (double) numerador/denominador;
        double multiplicador = Math.pow(10, numeroDecimales);
        return Math.round(division*multiplicador)/multiplicador;
    }
    
    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

}
