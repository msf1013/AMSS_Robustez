/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amss_robustez;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author E15
 */
public class Estudiante {
    private transient Conexion conn;
    private Statement stmt;

  //Constructor para inicializar la conexiÃ³n a la base de datos
  public Estudiante(Conexion conn){
      this.conn = conn; 
  }

  public boolean agregarEstudiante(String correo, String nombre, String escuela, int edad, Vector<Integer> vecCursos) {
      try {
         String s = "INSERT INTO estudiante VALUES('"+correo+"','"+nombre+"','"+escuela+"',"+edad+")";
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

  public boolean agregarCurso(String correo, int idCurso) {
      try {
         String s = "INSERT INTO estudiantecurso VALUES('"+correo+"','"+idCurso+"')";
         stmt.executeUpdate(s); 
         return true;
      } catch (SQLException e) {
          System.out.println ("Cannot execute agregarCurso()" + e);
          return false;
      }
  }

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
        } catch (SQLException e) {return null;}
  }
}
