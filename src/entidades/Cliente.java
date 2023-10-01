package entidades;

import java.util.ArrayList;
import java.util.UUID;

public class Cliente {
    private String DNI;
    private String nombre;
    private String direccion;
    private String telefonoContacto;
    private String codigo;
    private ArrayList<Auto> listaAutos = new ArrayList<>();

    public Cliente(String DNI, String nombre, String direccion, String telefonoContacto) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
        generarCodigo();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDNI() {
        return DNI;
    }

    public void generarCodigo() {
        UUID codigoUID = UUID.randomUUID();
        String fragmento = String.valueOf(codigoUID);
        this.codigo = fragmento.substring(0, 8);
    }

    public int buscarAuto(String numeroDePlaca){
        for (Auto McQueen : listaAutos){
            if (McQueen.getNumeroDePlaca().equals(numeroDePlaca)){
                return listaAutos.indexOf(McQueen);
            } 
        } return -1;
    }
    public Auto getAuto(int indice){
        return listaAutos.get(indice);
    }

    public int existeAuto(String numeroDePlaca){
        for (Auto McQueen : listaAutos){
            if (McQueen.getNumeroDePlaca().equals(numeroDePlaca)){
                return listaAutos.indexOf(McQueen);
            }
        } return -1;
    }

    public void agregarAuto(Auto McQueen) {
        listaAutos.add(McQueen);
    }

    public String toString() {
        StringBuilder lista = new StringBuilder("\nMARCA \tMODELO \tCOLOR \tN° PLACA \tDUEÑO");
        for (Auto McQueen : listaAutos) {
            lista.append(McQueen.toString());
        }
        return "\nCliente: " + nombre + "\nDNI: " + DNI + "\nDirección: " + direccion + "\nTelefono: "
                + telefonoContacto + "\nCodigo: " + codigo + lista;
    }

}
