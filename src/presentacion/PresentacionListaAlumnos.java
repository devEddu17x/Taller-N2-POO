package presentacion;

import complementos.Complementos;
import datos.ListaAlumnos;
import entidades.Alumno;
import entidades.Curso;

public class PresentacionListaAlumnos {
    public static final int maximo = 5;
    public static boolean existenAlumnos = false;
    public static String mensajito = "Primero ingrese alumnos.";

    public static void main(String[] args) {
        int opcion;
        String menu = "\n1. Ingresar un alumno dado.\n" +
                "2. Agregar un curso determinado a un alumno.\n" +
                "3. Reportar la relación de alumnos con sus respectivos cursos.\n" +
                "4. Dado un código de alumno reportar su relación de cursos y el total de créditos que lleva.";

        do {
            opcion = Complementos.menu(menu, maximo);
            ejecutar(opcion);
        } while (opcion != maximo);
    }

    public static void ejecutar(int x) {
        switch (x) {
            case 1:
                String nombre = Complementos.validarString("Ingrese el nombre del alumno: ",
                        "No se ha ingresado un nombre valido.");
                String apellido = Complementos.validarString("Ingrese el apellido del alumno: ",
                        "No se ha ingresado un nombre valido.");
                Alumno alumno = new Alumno(nombre, apellido);
                ListaAlumnos.agregarAlumno(alumno);
                existenAlumnos = true;
                break;
            case 2:
                if (existenAlumnos) {
                    ListaAlumnos.reportarAlumnos();
                    String codigoAlumno = Complementos.validarString("Ingrese el codigo del alumno: ",
                            "No se ha ingresado un codigo.");
                    int indiceAgregar = ListaAlumnos.buscarAlumnoPorCodigo(codigoAlumno);
                    if (indiceAgregar > -1) {
                        String nombreCurso = Complementos.validarString("Ingrese el nombre del curso: ",
                                "No se ha ingresado un curso.");
                        int creditos = Complementos.validarInt(4, 1, "Ingrese la cantidad de creditos: ",
                                "No se ha ingresado un credito valido.",
                                "La cantidad de creditos esta dentro del rango (1-4).");
                        double promedioFinal = Complementos.validarDouble(20, 0,
                                "Ingrese el promedio final del curso: ", "No se ha ingresado un promedio valido.",
                                "El promedio final debe estar entre el rango (1-20).");
                        Curso curso = new Curso(nombreCurso, creditos, promedioFinal);
                        ListaAlumnos.agregarCursoAlumno(indiceAgregar, curso);
                    } else {
                        System.out.println("No se ha encontrado al alumno.");
                    }

                } else {
                    System.out.println(mensajito);
                }
                break;
            case 3:
                if (existenAlumnos) {
                    ListaAlumnos.reportarListaAlumnos();
                } else {
                    System.out.println(mensajito);
                }
                break;
            case 4:
                if (existenAlumnos) {
                    ListaAlumnos.reportarListaAlumnos();
                    String codigoAlumno = Complementos.validarString("Ingrese el codigo del alumno:",
                            "No se ha ingresado un codigo.");
                    int indiceAgregar = ListaAlumnos.buscarAlumnoPorCodigo(codigoAlumno);
                    if (indiceAgregar > -1) {
                        ListaAlumnos.reportarAlumnoCursosYCreditos(indiceAgregar);
                    } else {
                        System.out.println("No se ha encontraado al alumno.");
                    }
                } else {
                    System.out.println(mensajito);
                }
                break;
            case 5:
            System.out.println("Adios.");
                break;
        }
    }
}
