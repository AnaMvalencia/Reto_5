package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.Lider;

public class LiderDao {

    public ArrayList<Lider> query_requerimiento_4() throws SQLException {
        Connection conexion = JDBCUtilities.getConnection();
        // Crea arreglo para almacenar objetos tipo Proyecto
        ArrayList<Lider> lideres = new ArrayList<Lider>();
        // Consultas:
        try{
            // ejecuto el query:
            ResultSet query = conexion.createStatement().executeQuery(
                "SELECT l.Nombre, l.Primer_Apellido FROM Proyecto p INNER JOIN Lider l ON l.ID_Lider  = p.ID_Lider WHERE P.Constructora ='Pegaso'");
                //Se recorre los resultados del querry:
                while (query.next()){
                    //Se almacenan los resultados del querry en un objecto proyecto
                    Lider objLider = new Lider(query.getString("Nombre"), query.getString("Primer_Apellido"));
                    //Se agrega el objeto al arraylist
                    lideres.add(objLider);
                }
        } catch (Exception e){
            // TODO: handle exception
            System.out.println(e);
        }
        
        return lideres;
    }// Fin del método query_requerimiento_4

}