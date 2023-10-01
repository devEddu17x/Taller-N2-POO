package presentacion;

import complementos.Complementos;
import entidades.Trabajador;

public class PresentacionTrabajador {
    public static void main(String[] args) {
        System.out.println("\n\t\tBIENVENIDO");

        String nombre = Complementos.validarString("Ingrese un nombre: ", "No se ha ingresado un nombre.");
        double pagoPorHora = Complementos.validarDouble(150, 1, "\nIngrese el pago por hora: ",
                "El monto no es válido: ", "El monto debe estar en el rango adecuado (1-150)");
        int cantidadHorasTrabajadas = Complementos.validarInt(288, 96, "\nIngrese el la cantidad de horas trabajadas: ",
                "La cantidad de horas no es valida", "No esta dentro del rango adecuado horas al mes (96-288)");

        Trabajador chambeador = new Trabajador(nombre, pagoPorHora, cantidadHorasTrabajadas);
        System.out.println("El sueldo bruto es: "+chambeador.getSueldoBruto());
        System.out.println("El descuento es: "+chambeador.getDescuento());
        System.out.println("El sueldo neto es: "+chambeador.getSueldoNeto());
    }
}
