package entidades;
public class Trabajador {
        private String nombre;
        private double pagoPorHora;
        private int cantidadHorasTrabajadas;
        private static final double descuento =  0.12;

    
        
    public Trabajador(String nombre, double pagoPorHora, int cantidadHorasTrabajadas) {
            setNombre(nombre);
            this.pagoPorHora = pagoPorHora;
            this.cantidadHorasTrabajadas = cantidadHorasTrabajadas;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public double getSueldoBruto(){
        return (double) pagoPorHora*cantidadHorasTrabajadas;
    }

    public double getDescuento(){
        return (double) Math.round(getSueldoBruto()*descuento*100)/100 ;
    }

    public double getSueldoNeto(){
        return (double) Math.round((getSueldoBruto()-getDescuento())*100)/100 ;
    }

    public String toString(){
        return nombre+"\t"+"\t"+getSueldoBruto()+"\t\t\t"+getDescuento()+"\t\t\t"+getSueldoNeto();
    }
}
