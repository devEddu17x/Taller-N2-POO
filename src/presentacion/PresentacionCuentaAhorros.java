package presentacion;

import complementos.Complementos;
import datos.ListaCuentaAhorros;
import entidades.CuentaAhorro;

public class PresentacionCuentaAhorros {
    static int maximo = 6;
    static boolean existenCuentas = false;

    public static void main(String[] args) {
        int opcion;
        System.out.println("\n\t\tBIENVENIDO");
        double tasaDeInteres = Complementos.validarDouble(30, 1, "Ingrese la tasa de interes: ",
                "Error: No se ha ingresado una tasa de interes valida.",
                "La tasa de interes debe estar en el rango de (1-30)%.");
        CuentaAhorro.modificarTasaDeInteres(tasaDeInteres);
        String menu = "1. Agregar cuentas.\n2. Depositar a cuenta.\n3. Mostrar cuentas.\n4. Mostrar intereses mensuales.\n5. Cambiar tasa de interes.";
        do {
            opcion = Complementos.menu(menu, maximo);
            ejecutar(opcion);
        } while (opcion != maximo);
    }

    public static void ejecutar(int x) {
        switch (x) {
            case 1:
                double primerDeposito = Complementos.validarDouble(10000, 15,
                        "Ingrese el primer deposito de la cuenta: ", "Error: Lo ingresado no es un monto valido",
                        "El deposito minimo y máximo es 15-10000");
                CuentaAhorro cuenta = new CuentaAhorro(primerDeposito);
                ListaCuentaAhorros.agregarCuentaAhorro(cuenta);
                existenCuentas = true;
                return;
            case 2:
                if (existenCuentas) {
                    ListaCuentaAhorros.mostrarCuentas();
                    int indice = Complementos.validarInt(ListaCuentaAhorros.getTamaño(), 1,
                            "Ingrese el indice de la cuenta a la cual modificar: ", " Error: Indice no valido",
                            "Cuenta no existe.");
                    double deposito = Complementos.validarDouble(100000, 15, "Ingrese el deposito: ",
                            "Error: monto invalido. ", "El monto a depositar debe estar en el rango de (15-10000)");
                    ListaCuentaAhorros.deposito(indice-1, deposito);
                } else {
                    System.out.println("No hay cuentas disponibles para depositar.");
                }
                return;
            case 3:
                if (existenCuentas) {
                    ListaCuentaAhorros.mostrarCuentas();
                } else {
                    System.out.println("No existen cuentas para mostrar.");
                }
                return;
            case 4:
                if (existenCuentas) {
                    ListaCuentaAhorros.mostrarInteresesMensuales();
                } else {
                    System.out.println("No existen cuentas para mostrar.");
                }

                return;
            case 5:
                double nuevaTasaInteres = Complementos.validarDouble(30, 1, "Ingrese la tasa de interes: ",
                        "No se ha ingresado una tasa de interes valida.",
                        "La tasa de interes debe estar en un rango de (1-50)%.");
                CuentaAhorro.modificarTasaDeInteres(nuevaTasaInteres);
                ListaCuentaAhorros.actualizarSaldoMasIntereses();
                return;
            case 6:
                System.out.println("Adios.");
                return;
        }
    }
}