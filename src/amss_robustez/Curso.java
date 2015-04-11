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

public class Curso {
    
    private transient Conexion conn;
    private Statement stmt;
   
    //Constructor para inicializar la conexion a la base de datos
    public Curso(Conexion conn){
        this.conn = conn; 
    }
    
    // metodo que inserta un nuevo curso en la base de datos
    public boolean agregarCurso(int idcurso, String nombre) {
        try {
            String s = "INSERT INTO curso VALUES('"+idcurso+"','"+nombre+"')";
            stmt.executeUpdate(s); 
            return true;
        } catch (SQLException e) {
            System.out.println ("Cannot execute agregarCurso()" + e);
            return false;
        }
    }
  
    // metodo para modificar el nombre de un curso en la base de datos
    public boolean cambiarNombreCurso(int idcurso, String nombre) {
        try {
            String s = "UPDATE curso SET nombre = '"+nombre+"' WHERE idcurso =" 
                    + idcurso;
            stmt.executeUpdate(s); 
            return true;
        } catch (SQLException e) {
            System.out.println ("Cannot execute cambiarNombreCurso()" + e);
            return false;
        }
    }
  
}
