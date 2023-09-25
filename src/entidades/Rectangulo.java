package entidades;

import complementos.Complementos;

/*
 * Crear una clase Rectángulo, con los atributos longitud y ancho, ambos con valor por omisión de uno. La
clase cuenta con métodos que calculan el perímetro y el área del rectángulo, así como métodos set y get
para longitud y ancho. Los métodos set deben verificar que tanto la longitud como el ancho sean números
reales mayores que 0 y menores que 20
 */
public class Rectangulo {
    private int longitud;
    private int ancho;

    public Rectangulo(){
        setLongitud();
        setAncho();
    }

    public void setLongitud() {
        int longitudAux = Complementos.validarInt(Integer.MAX_VALUE, Integer.MIN_VALUE, "Ingresa el valor entero de la longitud: ", "Error: No se ha ingresado un entero.", "x");
        if (longitudAux <= 0 || longitudAux >=20){
            longitud = 1;
        } else {
            longitud = longitudAux;
        }
    }

    public void setAncho() {
        int anchoAux = Complementos.validarInt(Integer.MAX_VALUE, Integer.MIN_VALUE, "Ingresa el valor entero del ancho: ", "Error: No se ha ingresado un numero entero.", "x");
        if (anchoAux <= 0 || anchoAux >=20){
            ancho = 1;
        } else {
            ancho = anchoAux;
        }
    }
    

    public int getLongitud() {
        return longitud;
    }

    public int getAncho() {
        return ancho;
    }

    public int getPerimetro(){
        return 2*(longitud + ancho);
    }
    
    public int getArea(){
        return longitud*ancho;
    }

    
}
