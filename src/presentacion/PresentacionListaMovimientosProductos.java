package presentacion;

import complementos.Complementos;
import datos.ListaMovimientoDeProductos;
import entidades.Almacen;
import entidades.Movimiento;

public class PresentacionListaMovimientosProductos {
    public static final int maximo = 6;
    public static boolean existenMovimientos = false;
    public static String mensajito = "Primero ingrese movimientos.";

    public static void main(String[] args) {
        int opcion;
        String menu = "\n1. Ingresar un movimiento de un producto.\n" +
                "2. Devolver el stock actual de un producto dado.\n" +
                "3. Reportar la relación de productos con su respectivo stock.\n" +
                "4. Reportar la relación de productos por stock de mayor a menor.\n" +
                "5. Mostrar todos los movimientos.";

        do {
            opcion = Complementos.menu(menu, maximo);
            ejecutar(opcion);
        } while (opcion != maximo);
    }

    public static void ejecutar(int x) {
        switch (x) {
            case 1:
                int opcion;
                String miniMenu = "\n1. Agregar producto nuevo.\n2. Entrada de un producto.\n3. Salida de producto.";
                System.out.println(miniMenu);
                if (!existenMovimientos) {
                    opcion = Complementos.validarInt(1, 1, "\nIngrese el tipo de movimiento: ",
                            "No se ha ingresado una opcion valida. ",
                            "Agregue un producto para desbloquear las demas opciones.");
                } else {
                    opcion = Complementos.validarInt(3, 1, "\nIngrese el tipo de movimiento: ",
                            "No se ha ingresado una opcion valida. ", "El rango de opiones esta estre (1-3).");
                }

                miniEjecutar(opcion);
                existenMovimientos = true;
                break;
            case 2:
                if (existenMovimientos) {
                    String nombreProductoBuscar = Complementos.validarString(
                            "\nIngrese el nombre del producto a buscar: ",
                            "Lo ingresado no es valido.");
                    int indice = Almacen.buscarProducto(nombreProductoBuscar);
                    if (indice >= 0) {
                        System.out.println("\nEl stock del producto es: " + Almacen.getStockProducto(indice));
                    } else {
                        System.out.println("No se ha encontrado el producto.");
                    }
                } else {
                    System.out.println(mensajito);
                }

                break;
            case 3:
                if (existenMovimientos) {
                    Almacen.mostrarProductos();
                } else {
                    System.out.println(mensajito);
                }

                break;
            case 4:

                if (existenMovimientos) {
                    Almacen.ordenarProductosDescendente();
                    Almacen.mostrarProductos();
                } else {
                    System.out.println(mensajito);
                }

                break;
            case 5:

                if (existenMovimientos) {
                    ListaMovimientoDeProductos.mostrarMovimientos();
                } else {
                    System.out.println(mensajito);
                }
                break;
            case 6:
                System.out.println("Adios.");
                break;
        }
    }

    public static void miniEjecutar(int opcion) {
        switch (opcion) {
            case 1:
                int cantidad = Complementos.validarInt(1000, 1, "\nIngrese el stock del producto: ",
                        "La entrada no es valida.", "La entrada ingresada debe estar en el rango de (1-1000)");
                Movimiento movimiento = new Movimiento(cantidad, cantidad);
                ListaMovimientoDeProductos.agregarMovimiento(movimiento);
                break;
            case 2:
                Almacen.mostrarProductos();
                int indice = Complementos.validarInt(Almacen.getTamaño(), 1, "\nIngrese el indice del producto: ",
                        "El indice ingresado no es valido.",
                        "El rango del indice debe estar entre (1-" + Almacen.getTamaño() + ").");
                int entrada = Complementos.validarInt(1000, 1, "\nIngrese la entrada del producto: ",
                        "La salida no es valida.", "El stock debe estar en el rango de (1-1000)");
                Movimiento movimiento2 = new Movimiento(entrada, opcion, indice-1);
                ListaMovimientoDeProductos.agregarMovimiento(movimiento2);
                break;
            case 3:
                Almacen.mostrarProductos();
                int indice2 = Complementos.validarInt(Almacen.getTamaño(), 1, "\nIngrese el indice del producto: ",
                        "El indice ingresado no es valido.",
                        "El rango del indice debe estar entre (1-" + Almacen.getTamaño() + ").");
                int salida = Complementos.validarInt(1000, 1, "\nIngrese la salida del producto: ",
                        "El stock ingresado no es valido.", "El stock debe estar en el rango de (1-1000)");
                Movimiento movimiento3 = new Movimiento(salida, opcion, indice2-1);
                ListaMovimientoDeProductos.agregarMovimiento(movimiento3);
                break;
        }
    }
}
