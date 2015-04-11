/*
 * Analisis y modelacion de sistemas de software
 * Prof. Guillermo Jimenez
 * Actividad: Codificacion de diagrama de rosbustez
 * (Asignada el martes 7 de abril de 2014)
 *
 * Autores: Eduardo Serna y Mario Sergio Fuentes
 */

package amss_robustez;

public class Departamento {
    private transient Conexion conn;
    
    //Constructor para inicializar la conexion a la base de datos
    public Departamento(Conexion conn){
        this.conn = conn; 
    }
    
}
