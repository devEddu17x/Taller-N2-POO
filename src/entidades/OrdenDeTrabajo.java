package entidades;
import java.security.SecureRandom;

public class OrdenDeTrabajo {
    private int identificadorNumerico;
    private Cliente cliente;
    private Auto auto;

    public OrdenDeTrabajo(Cliente cliente, Auto auto) {
        this.identificadorNumerico = generarIndentificador();
        this.cliente = cliente;
        this.auto = auto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int generarIndentificador(){
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(6);
    }

    public String toString(){
        return identificadorNumerico+"\t"+cliente.getNombre()+"\t"+auto.getNumeroDePlaca();
    }
    
}
