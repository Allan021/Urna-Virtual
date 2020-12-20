
package Modelo.Regiones;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;



public class Conexion {
   private static final String URL ="jdbc:mysql://localhost:3307/elecciones2020?autoReconnet=true&useSSL=false";
   private static final String usuario = "root"; 
   private static final String contraseña = "allan123"; 
   
      public  Connection getConnection(){//esto es lo unico que necesito, ya que en esta clase solo establecere la conexion con mysql y esta clase la relacionare con las consultar que yo pondre en la base de datos
      Connection conexion = null;
        
      //para evitar qie me salgan excepcione al momeno de hacer la conexion
      
      try{
      Class.forName("com.mysql.jdbc.Driver");//aca establezco los driverde la direccion
          
      //aca le paso como parametros los 3 parametro de la informacion en la bae de datos
     conexion  = (Connection)  DriverManager.getConnection(URL, usuario,contraseña);//este metodo ser el que me establezca la conexion
      //esto lo guardo aqui y hago un upcating para rtranformarlo a un objeto de tipo conexion
      
      
      
      
      }catch(Exception ex){
          System.err.println("Error de "+ex);
      }
     
     return conexion; 
    }    
    
}
