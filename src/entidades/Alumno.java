package entidades;

import java.util.ArrayList;
import java.util.UUID;

public class Alumno {
    private String codigo;
    private String nombre;
    private String apellido;
    private ArrayList<Curso> listaCursos = new ArrayList<>();

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        codigo = generarUUID();
    }

    public String getNombresYApellidos(){
        return nombre + "\t"+ codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    private String generarUUID() {
        UUID codigoUUID = UUID.randomUUID();
        String codigoString = String.valueOf(codigoUUID);
        return codigoString.substring(0, 8);
    }

    public void agregarCurso(Curso asignatura) {
        listaCursos.add(asignatura);
    }

    public String toString() {
        StringBuilder lista = new StringBuilder();
        if (listaCursos.isEmpty()) {
            lista.append("\nNO TIENE CURSOS ASIGNADOS.");
        } else {
            for (Curso curso : listaCursos) {
                lista.append(curso.toString());
            }
        }
        return "\nAlumno: " + nombre + "  " + apellido + "  Codigo: " + codigo + "\n"
                + " CURSO\tN CREDITOS\tPROMEDIO FINAL" + lista + "\n";

    }

    public int getTotalCreditos() {
        int totalCreditos = 0;
        for (Curso curso : listaCursos) {
            totalCreditos += curso.getCreditos();
        }
        return totalCreditos;
    }
}
