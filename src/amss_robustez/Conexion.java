/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amss_robustez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author E15
 */
public class Conexion {
   public Connection conn;
   public Statement stmt, stmt2;

   Conexion(){
      try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/escuela";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
        stmt2 = conn.createStatement();        
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
   }
}
