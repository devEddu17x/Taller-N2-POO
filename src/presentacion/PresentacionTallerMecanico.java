package presentacion;

import complementos.Complementos;
import entidades.Cliente;
import entidades.OrdenDeTrabajo;
import entidades.Taller;
import entidades.Auto;

public class PresentacionTallerMecanico {
    public static boolean existeClientes = false;
    public static boolean existenAutos = false;

    public static void main(String[] args) {
        int opcion;
        String menu = "1. Registrar los datos de los clientes.\n"
                + "2. Registrar los datos de los automóviles.\n"
                + "3. Registrar las órdenes de trabajo.\n"
                + "4. Reportar la relación de clientes con sus respectivos automóviles.\n"
                + "5. Dado un código de cliente reportar la relación de órdenes de trabajo que se generaron a su nombre.";

        do {
            opcion = Complementos.menu(menu, 6);
            ejecutar(opcion);
        } while (opcion != 6);
    }

    public static void ejecutar(int x) {
        switch (x) {
            case 1:
                Taller.agregarCliente(generarCliente());
                existeClientes = true;
                break;
            case 2:
                if (existeClientes)
                    generarAuto();
                else
                    System.out.println("Primero agregue clientes");
                existenAutos = true;
                break;
            case 3:
                if (existeClientes && existenAutos)
                    generarOrdenDeTrabajo();
                else
                    System.out.println("Primero agregue clientes y autos.");
                break;
            case 4:
                if (existeClientes && existenAutos)
                    Taller.reportarClientesConMoviles();
                else
                    System.out.println("Primero agregue clientes y autos.");
                break;
            case 5:
                if (existeClientes) {
                    String codigo = Complementos.validarString("Ingrese el codigo del cliente: ",
                            "No es un codigo valido");
                    int indice = Taller.existeCliente(codigo);
                    System.out.println(indice);
                    if (indice != -1) {
                        Taller.reportarOrdenesCliente(indice);
                    } else {
                        System.out.println("No se encontro al cliente...");
                    }
                } else {
                    System.out.println("Primero ordenes.");
                }

                break;
            case 6:
                System.out.println("Adios.");
                break;
        }
    }

    public static Cliente generarCliente() {
        int dni = Complementos.validarInt(99999999, 10000000, "Ingrese el DNI del cliente: ",
                "No se ha ingresado un DNI valido.", "El DNI debe tener 8 digitos.");
        String nombre = Complementos.validarString("Ingrese el nombre del cliente: ",
                "No se ha ingresado un nombre valido.");
        String direccion = Complementos.leerCadenas("Ingrese la direccion: ");
        int telefono = Complementos.validarInt(999999999, 900000000, "Ingrese el numero de telefono del cliente: ",
                "No se ha ingresado un numero valido.", "El numero debe tener 9 digitos.");
        String numeroTelefono = String.valueOf(telefono);
        return new Cliente(String.valueOf(dni), nombre, direccion, numeroTelefono);
    }

    public static void generarAuto() { // marca modelo color numero de palaca cliente

        Taller.reportarClienteConCodigo();
        String codigo = Complementos.validarString("Ingrese el codigo del cliente: ",
                "No se ha ingresado un codigo valido.");
        int indice = Taller.existeCliente(codigo);
        if (indice != -1) {
            String marca = Complementos.validarString("Ingrese la marca del auto: ",
                    "No se ha ingresado una marca valida.");
            String modelo = Complementos.validarString("Ingrese el modelo del auto: ",
                    "No se ha ingresado una marca valida.");
            String color = Complementos.validarString("Ingrese el color del auto: ",
                    "No se ha ingresado una marca valida.");
            String numeroDePlaca = Complementos.validarString("Ingrese numrero de placa del auto: ",
                    "No se ha ingresado una marca valida.");
            Auto McQueen = new Auto(marca, modelo, color, numeroDePlaca, Taller.getCliente(indice));
            Taller.getCliente(indice).agregarAuto(McQueen);
        } else {
            System.out.println("No se encontro al cliente...");
        }
    }

    public static void generarOrdenDeTrabajo() {
        Taller.reportarClienteConCodigo();
        String codigo = Complementos.validarString("\nIngrese el codigo del cliente: ",
                "No se ha ingresado un codigo valido.");
        int indice = Taller.existeCliente(codigo);
        if (indice != -1) {
            System.out.println(Taller.getCliente(indice).toString());
            String placa = Complementos.validarString("\nIngrese el numero de placa del auto: ",
                    "No es una placa valida.");
            int indiceAuto = Taller.getCliente(indice).existeAuto(placa);
            if (indiceAuto != -1) {
                OrdenDeTrabajo orden = new OrdenDeTrabajo(Taller.getCliente(indice),
                        Taller.getCliente(indice).getAuto(indiceAuto));
                Taller.agregarOrden(orden);
            } else {
                System.out.println("\nNo se encontro el Auto...");
            }
        } else {
            System.out.println("\nNo se encontro al cliente...");
        }

    }
}
