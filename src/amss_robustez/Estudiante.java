/*
 * Analisis y modelacion de sistemas de software
 * Prof. Guillermo Jimenez
 * Actividad: Codificacion de diagrama de rosbustez
 * (Asignada el martes 7 de abril de 2014)
 *
 * Autores: Eduardo Serna y Mario Sergio Fuentes
 */

package amss_robustez;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Estudiante {
    
    private transient Conexion conn;
    private Statement stmt;

    //Constructor para inicializar la conexion a la base de datos
    public Estudiante(Conexion conn){
        this.conn = conn; 
    }
    
    // metodo que crea un nuevo estudiante en la abse de datos,
    // y hace llamadas a agregarCurso() para insertar los cursos
    // del estudiante
    public boolean agregarEstudiante(String correo, String nombre, int idescuela, 
            int edad, Vector<Integer> vecCursos) {
        try {
            String s = "INSERT INTO estudiante VALUES('"+correo+"','"+
                    nombre+"',"+idescuela+","+edad+")";
            stmt.executeUpdate(s);
            for(int i=0; i<vecCursos.size(); i++){
                this.agregarCurso(correo,vecCursos.elementAt(i));
            }
            return true;
        } catch (SQLException e) {
            System.out.println ("Cannot execute agregarEstudiante()" + e);
            return false;
        }
    }
    
    // metodo que agrega un curso vinculado a un estudiante
    public boolean agregarCurso(String correo, int idCurso) {
        try {
            String s = "INSERT INTO estudiantecurso VALUES('"+
                 correo+"','"+idCurso+"')";
            stmt.executeUpdate(s); 
            return true;
        } catch (SQLException e) {
            System.out.println ("Cannot execute agregarCurso()" + e);
            return false;
        }
    }
    
    // metodo que devuelve todos los id's de los cursos en los que esta
    // inscrito un alumno
    public Vector<Integer> obtenerCursos(String correo) {
        try{
           Vector<Integer> vecCursos = new Vector<Integer>();
           stmt.executeQuery ("SELECT * FROM curso WHERE idCurso IN (SELECT idCurso FROM estudiantecurso WHERE correoEstudiante = '"+correo+"') ");
           ResultSet rs = stmt.getResultSet();
           while(rs.next()) {
              int _id = rs.getInt("idcurso");
              vecCursos.add(_id);
           }
           return vecCursos;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
