package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

import model.dao.LiderDao;
import model.dao.ProyectoDao;
import model.vo.Lider;
import model.vo.Proyecto;
import util.JDBCUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//Librerías para bases de datos
import java.sql.SQLException;

public class Controlador {

    private final ProyectoDao proyectoDao;
    private final LiderDao liderDao;

    public Controlador() {
        this.proyectoDao = new ProyectoDao();
        this.liderDao = new LiderDao();
    }


    public ArrayList<Proyecto> Solucionar_requerimiento_1() throws SQLException {
        // Crea arreglo para almacenar objetos tipo Proyecto
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        Connection conexion = JDBCUtilities.getConnection();

        try {
            String consulta = "SELECT  Fecha_Inicio,Numero_Habitaciones, Numero_Banos FROM Proyecto WHERE Constructora = 'Pegaso'";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            // Vamos a recorrer los resultados del query
            while (resultSet.next()) {
                //Se almacenan los resultados del querry en un objecto proyecto
                Proyecto objProyecto = new Proyecto();
                objProyecto.setFecha_inicio(resultSet.getString("Fecha_Inicio"));
                objProyecto.setNum_habitaciones(resultSet.getInt("Numero_Habitaciones"));
                objProyecto.setNum_banios(resultSet.getInt("Numero_Banos"));
                //Agrega el objeto al arraylist
                proyectos.add(objProyecto);
            }

            resultSet.close();
            statement.close();

        }catch (SQLException e) {
            System.err.println("Error en la consulta" + e);
        }finally {
            if (conexion != null) {
                conexion.close();
            }
        }
        return this.proyectoDao.query_requerimiento_1();
    }


    public ArrayList<Proyecto> Solucionar_requerimiento_2() throws SQLException {
        Connection conexion = JDBCUtilities.getConnection();
        // Crea arreglo para almacenar objetos tipo Proyecto
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        //Consulta
        try {
             // ejecuto el query:
            ResultSet query = conexion.createStatement().executeQuery(
                "SELECT  p.Fecha_Inicio, p.Numero_Habitaciones, p.Numero_Banos, l.Nombre, l.Primer_Apellido, t.Estrato FROM Proyecto p INNER JOIN Lider l ON l.ID_Lider = p.ID_Lider INNER JOIN Tipo t ON p.ID_Tipo = t.ID_Tipo WHERE Constructora = 'Pegaso' LIMIT 50");
            // Vamos a recorrer los resultados del query
            while (query.next()) {
                //Se almacenan los resultados del querry en un objecto proyecto
                Proyecto objProyecto = new Proyecto();
                objProyecto.setFecha_inicio(query.getString("Fecha_Inicio"));
                objProyecto.setNum_habitaciones(query.getInt("Numero_Habitaciones"));
                objProyecto.setNum_banios(query.getInt("Numero_Banos"));
                objProyecto.setEstrato_proyecto(query.getInt("Estrato"));
                //Creo objeto lider
                String nombre_lider = query.getString("Nombre");
                String apellido_lider =query.getString("Primer_Apellido");
                Lider objLider = new Lider(nombre_lider, apellido_lider);
                objProyecto.setLider(objLider);
                //Agrega el objeto al arraylist
                proyectos.add(objProyecto);
            }
        } catch (Exception e){
            // TODO: handle exception
            System.out.println(e);
        }

        return this.proyectoDao.query_requerimiento_2();
    }

    public ArrayList<Proyecto> Solucionar_requerimiento_3() throws SQLException {
        Connection conexion = JDBCUtilities.getConnection();
        // Crea arreglo para almacenar objetos tipo Proyecto
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        //Consulta
        try {
             // ejecuto el query:
            ResultSet query = conexion.createStatement().executeQuery(
                "SELECT SUM(Numero_Habitaciones) as Total_Habitaciones, Constructora FROM Proyecto GROUP BY Constructora HAVING Total_Habitaciones ORDER BY Constructora ASC");
                // Vamos a recorrer los resultados del query
            while (query.next()) {
                //Se almacenan los resultados del querry en un objecto proyecto
                Proyecto objProyecto = new Proyecto();
                objProyecto.setNum_habitaciones(query.getInt("Total_Habitaciones"));
                objProyecto.setNombre_constructora(query.getString("Constructora"));
                //Agrega el objeto al array
                proyectos.add(objProyecto);
            }
        } catch (Exception e){
            // TODO: handle exception
            System.out.println(e);
        }
        return this.proyectoDao.query_requerimiento_3();
    }

    public ArrayList<Lider> Solucionar_requerimiento_4() throws SQLException {
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
        return this.liderDao.query_requerimiento_4();
    
    }

    public ArrayList<Proyecto> Solucionar_requerimiento_5() throws SQLException {
        Connection conexion = JDBCUtilities.getConnection();
        // Crea arreglo para almacenar objetos tipo Proyecto
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        //Consulta
        try {
             // ejecuto el query:
            ResultSet query = conexion.createStatement().executeQuery(
                "SELECT SUM(Numero_Habitaciones) as Total_Habitaciones, Constructora FROM Proyecto GROUP BY Constructora HAVING Total_Habitaciones > 200.0 ORDER BY Total_Habitaciones ASC");
                // Vamos a recorrer los resultados del query
            while (query.next()) {
                //Se almacenan los resultados del querry en un objecto proyecto
                Proyecto objProyecto = new Proyecto();
                objProyecto.setNum_habitaciones(query.getInt("Total_Habitaciones"));
                objProyecto.setNombre_constructora(query.getString("Constructora"));
                //Agrega el objeto al array
                proyectos.add(objProyecto);
            }
        } catch (Exception e){
            // TODO: handle exception
            System.out.println(e);
        }
        return this.proyectoDao.query_requerimiento_5();
        
    }

}
