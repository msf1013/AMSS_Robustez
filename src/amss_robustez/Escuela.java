/*
 * Analisis y modelacion de sistemas de software
 * Prof. Guillermo Jimenez
 * Actividad: Codificacion de diagrama de rosbustez
 * (Asignada el martes 7 de abril de 2014)
 *
 * Autores: Eduardo Serna y Mario Sergio Fuentes
 */

package amss_robustez;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Escuela {
    
    private transient Conexion conn;
    private Statement stmt;
    
    //Constructor para inicializar la conexion a la base de datos
    public Escuela(Conexion conn){
        this.conn = conn; 
    }
    
    // metodo que agrega una escuela a la base de datos
    public boolean agregarEscuela(int idescuela, String nombre) {
        try {
            String s = "INSERT INTO escuela VALUES("+idescuela+",'"+nombre+"')";
            stmt.executeUpdate(s); 
            return true;
        } catch (SQLException e) {
            System.out.println ("Cannot execute agregarEscuela()" + e);
            return false;
        }
    }
    
    // metodo que llama al metodo de la clase Estudiante para insertar un nuevo
    // estudiante en la base de datos
    public boolean agregarEstudiante(int idescuela, String correo, 
            String nombre, String escuela, int edad, Vector<Integer> vecCursos){
        Estudiante est = new Estudiante(conn);
        est.agregarEstudiante(correo,nombre,idescuela,edad,vecCursos);
        return true;
    }
    
    // metodo para agregar un Departamento a la base de datos
    public boolean agregarDepartamento(int iddepartamento, int idescuela, 
            String nombre, int idprofesorjefe) {
        Departamento dep = new Departamento(conn);
        //return dep.agregarDepartamento(iddepartamento,idescuela,nombre,idprofesorjefe);
        return true;
    }
   
}
