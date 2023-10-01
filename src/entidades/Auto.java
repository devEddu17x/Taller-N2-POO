package entidades;

public class Auto {
    String marca;
    String modelo;
    String color;
    String numeroDePlaca;
    Cliente cliente;

    public Auto(String marca, String modelo, String color, String numeroDePlaca, Cliente cliente) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.numeroDePlaca = numeroDePlaca;
        this.cliente = cliente;
    }
    
    public String toString(){
        return "\n"+marca+"\t"+modelo+"\t"+color+"\t"+numeroDePlaca+"\t"+cliente.getNombre();
    }

    public String getNumeroDePlaca() {
        return numeroDePlaca;
    }

}
