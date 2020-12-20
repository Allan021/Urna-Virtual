
package Pruebas.sala;

import Modelo.RegistroCandidatos.Conexion;
import Modelo.RegistroCandidatos.Diputado;
import com.mysql.jdbc.PreparedStatement;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class PruebaArrya {
    public static void main(String[] args) {
          ArrayList<Diputado> diputadosGandores = new ArrayList<>();
           BufferedImage img= null;
           
           PreparedStatement consultas;
           ResultSet resultados;
           Conexion con = new Conexion();
             try{
                 
              Connection conexion = con.getConnection();
              
              consultas = (PreparedStatement) conexion.prepareStatement("SELECT * FROM diputados where id_Departamento = ? order by(votos) desc limit ?");
              consultas.setInt(1, 1);
              consultas.setInt(2, 7);
        
           resultados = consultas.executeQuery();
              while(resultados.next()){
              Diputado diputado = new Diputado();//creando un Diputado en cada iteracion
              
              
              diputado.setIdDiputado(resultados.getInt("idDiputado"));
            diputado.setNombre(resultados.getString("nombre"));
            diputado.setId_Partido(resultados.getInt("idPartido"));
            diputado.setId_Departamento(resultados.getInt("id_Departamento"));
            diputado.setNacionalidad(resultados.getString("nacionalidad"));
            diputado.setGenero(resultados.getString("genero"));
            diputado.setVotos(resultados.getInt("votos"));
            InputStream obtenerBites = resultados.getBinaryStream("foto");//obteniendo el codigo binario
                  System.out.println("ff");  
               img = ImageIO.read(obtenerBites);//LEYENDO los bites y guardandp estos datos
            diputado.setImagen(img);
              
              diputadosGandores.add(diputado);
             }
       
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
    }
  
}
