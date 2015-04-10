/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amss_robustez;

import java.util.Vector;

/**
 *
 * @author E15
 */
public class ControlEstudiante {
   Estudiante estudiante;  Escuela escuela; Curso curso;

   private transient Conexion conexion;
   
   //Prepara la conexión que comparte con las entidades
   ControlEstudiante(){
      conexion = new Conexion();
      estudiante = new Estudiante(conexion);
      escuela = new Escuela(conexion);
      curso = new Curso(conexion);
   }
   
  public Vector<Integer> obtenerCursos(String correo){
      return estudiante.obtenerCursos(correo);
   }

   public boolean agregarEstudiante(String correo, String nombre, String escuela, int edad, Vector<Integer> vecCursos) {
      return estudiante.agregarEstudiante(correo, nombre, escuela, edad, vecCursos);   
   }

   public boolean agregarCurso(String correo, int idCurso) {
      return estudiante.agregarCurso(correo, idCurso);
   }
}
