package entidades;

import complementos.Complementos;

public class MiFraccion {
    private int numerador;
    private int denominador;

    public MiFraccion(int numerador, int denominador) {
        int mcd = Complementos.generarMCD(numerador, denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    public MiFraccion() {
        numerador = 1;
        denominador = 1;
    }

    public static MiFraccion sumarFracciones(MiFraccion fraccion1, MiFraccion fraccion2) {
        int numeradorAux = fraccion1.numerador * fraccion2.denominador + fraccion2.numerador * fraccion1.denominador;
        int denominadorAux = fraccion1.denominador * fraccion2.denominador;

        int mcd = Complementos.generarMCD(numeradorAux, denominadorAux);

        numeradorAux /= mcd;
        denominadorAux /= mcd;

        MiFraccion resultado = new MiFraccion(numeradorAux, denominadorAux);
        return resultado;
    }

    public static MiFraccion restarFracciones(MiFraccion fraccion1, MiFraccion fraccion2) {
        int numeradorAux = fraccion1.numerador * fraccion2.denominador - fraccion2.numerador * fraccion1.denominador;
        int denominadorAux = fraccion1.denominador * fraccion2.denominador;

        int mcd = Complementos.generarMCD(numeradorAux, denominadorAux);

        numeradorAux /= mcd;
        denominadorAux /= mcd;

        MiFraccion resultado = new MiFraccion(numeradorAux, denominadorAux);
        return resultado;
    }

    public static MiFraccion multiplicarFracciones(MiFraccion fraccion1, MiFraccion fraccion2) {

        int numeradorAux = fraccion1.numerador * fraccion2.numerador;
        int denominadorAux = fraccion1.denominador * fraccion2.denominador;

        int mcd = Complementos.generarMCD(numeradorAux, denominadorAux);

        numeradorAux /= mcd;
        denominadorAux /= mcd;

        MiFraccion resultado = new MiFraccion(numeradorAux, denominadorAux);
        return resultado;
    }

    public static MiFraccion dividirFracciones(MiFraccion fraccion1, MiFraccion fraccion2) {
        int numeradorAux = fraccion1.numerador*fraccion2.denominador;
        int denominadorAux = fraccion1.denominador * fraccion2.numerador;

        int mcd = Complementos.generarMCD(numeradorAux, denominadorAux);

        numeradorAux /= mcd;
        denominadorAux /= mcd;

        MiFraccion resultado = new MiFraccion(numeradorAux, denominadorAux);
        return resultado;
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

}
