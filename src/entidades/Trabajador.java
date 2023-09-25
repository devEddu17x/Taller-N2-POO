package entidades;
public class Trabajador {
        private String nombre;
        private double pagoPorHora;
        private int cantidadHorasTrabajadas;
        private static final double descuento =  0.12;

    
        
    public Trabajador(String nombre, double pagoPorHora, int cantidadHorasTrabajadas) {
            this.nombre = nombre;
            this.pagoPorHora = pagoPorHora;
            this.cantidadHorasTrabajadas = cantidadHorasTrabajadas;
        }
    public String getNombre() {
        return nombre;
    }
    public double getSueldoBruto(){
        return (double) pagoPorHora*cantidadHorasTrabajadas;
    }

    public double getDescuento(){
        return getSueldoBruto()*descuento;
    }

    public double getSueldoNeto(){
        return getSueldoBruto()-getDescuento();
    }
}
