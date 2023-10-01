package entidades;

import java.util.ArrayList;

public class Taller {
    private static ArrayList <OrdenDeTrabajo> listaOrdenes = new ArrayList<>();
    private static ArrayList <Cliente> listaClientes = new ArrayList<>();

    public static void agregarOrden(OrdenDeTrabajo orden){
        listaOrdenes.add(orden);
    }
    public static void agregarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    public static void reportarClientesConMoviles(){
        for (Cliente cliente : listaClientes){
            System.out.println(cliente.toString());
        }
    }

    public static void reportarClienteConCodigo(){
        System.out.println("NOMBRE\tCODIGO");
        for (Cliente cliente : listaClientes){
            System.out.println(cliente.getNombre()+"\t"+cliente.getCodigo()); 
        }
    }
    public static int existeCliente(String codigoCliente){
        for (Cliente cliente : listaClientes){
            if (cliente.getCodigo().equals(codigoCliente)){
                return listaClientes.indexOf(cliente);
            }
        } return -1;
    }

    public static Cliente getCliente(int indice){
        return listaClientes.get(indice);
    }

    public static void reportarOrdenesCliente(int indice){
        for (OrdenDeTrabajo orden : listaOrdenes){
            if (listaClientes.get(indice).equals(orden.getCliente())){
                System.out.println(orden.toString());
            }
        }
    }
}
