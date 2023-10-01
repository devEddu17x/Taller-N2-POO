package datos;

import java.util.ArrayList;

import entidades.Alumno;
import entidades.Curso;

public class ListaAlumnos {
    private static ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    public static void agregarAlumno(Alumno alumno){
        listaAlumnos.add(alumno);
    }

    public static void agregarCursoAlumno(int indice, Curso curso){
        listaAlumnos.get(indice).agregarCurso(curso);
        System.out.println("Curso agregado con exito.");
    }

    public static void reportarListaAlumnos(){
        for (Alumno alumno : listaAlumnos){
            System.out.println(alumno.toString());
        }
    }

    public static void reportarAlumnos(){
        System.out.println("ALUMNO\t\tCODIGO");
        for (Alumno alumno : listaAlumnos){
            System.out.println(alumno.getNombresYApellidos());
        }
    }

    public static int buscarAlumnoPorCodigo(String codigo){
        for (Alumno alumno : listaAlumnos){
            if (alumno.getCodigo().equals(codigo))
            return listaAlumnos.indexOf(alumno);
        } return -1;
    }
    public static void reportarAlumnoCursosYCreditos(int indice){
        System.out.println(listaAlumnos.get(indice).toString());
        System.out.println("El total de creditos es: "+listaAlumnos.get(indice).getTotalCreditos());
    }
}
