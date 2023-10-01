package entidades;

public class Curso {

    private String nombre; 
    private int creditos;
    private double promedioFinal;

    
    public String toString(){
        return "\n"+nombre+"\t"+creditos+"\t"+promedioFinal;
    }

    public int getCreditos() {
        return creditos;
    }

    public Curso(String nombre, int creditos, double promedioFinal) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.promedioFinal = promedioFinal;
    }
    
}
