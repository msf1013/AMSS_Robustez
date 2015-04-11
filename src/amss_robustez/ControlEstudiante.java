/*
 * Analisis y modelacion de sistemas de software
 * Prof. Guillermo Jimenez
 * Actividad: Codificacion de diagrama de rosbustez
 * (Asignada el martes 7 de abril de 2014)
 *
 * Autores: Eduardo Serna y Mario Sergio Fuentes
 */

package amss_robustez;

import java.util.Vector;

public class ControlEstudiante {
    
    private Estudiante estudiante;
    private Escuela escuela;
    private Curso curso;
    private transient Conexion conexion;
   
    //Prepara la conexión que comparte con las entidades
    ControlEstudiante(){
        conexion = new Conexion();
        estudiante = new Estudiante(conexion);
        escuela = new Escuela(conexion);
        curso = new Curso(conexion);
    }
   
    // obtener cursos dado un correo electronico
    public Vector<Integer> obtenerCursos(String correo){
        return estudiante.obtenerCursos(correo);
    }
    
    // agregar un estudiante en la base de datos
    public boolean agregarEstudiante(String correo, String nombre,
            int idescuela, int edad, Vector<Integer> vecCursos) {
        return estudiante.agregarEstudiante(correo, nombre,
                idescuela, edad, vecCursos);   
    }
    
    // crear un nuevo curso a un alumno dado su correo electronico
    public boolean agregarCurso(String correo, int idCurso) {
        return estudiante.agregarCurso(correo, idCurso);
    }
    
}
