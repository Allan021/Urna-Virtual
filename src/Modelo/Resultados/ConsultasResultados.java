
package Modelo.Resultados;

import Modelo.RegistroCandidatos.Alcalde;
import Modelo.RegistroCandidatos.Conexion;
import Modelo.RegistroCandidatos.Diputado;
import Modelo.RegistroCandidatos.PartidoPolitico;
import Modelo.RegistroCandidatos.Presidente;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;


public class ConsultasResultados extends Conexion {
     PreparedStatement consultas;
    ResultSet resultados;
    
    public Presidente buscarNombre(String nombre){
        Presidente presidente= null;
        BufferedImage img= null;
          
        try{
            Connection conexion = getConnection();
            
            consultas = conexion.prepareStatement("select * from presidentes where nombre = ?");
            consultas.setString(1, nombre);
            
           resultados = consultas.executeQuery();
           
           presidente = new Presidente();
           presidente.setId_Presidende(0);
           
           while(resultados.next()){
               presidente.setId_Presidende(resultados.getInt("id_Presidente"));
             
               presidente.setNombre(resultados.getString("nombre"));
               
               presidente.setId_Partido(resultados.getInt("idPartido"));
               
               presidente.setCategoria(resultados.getInt("id_CategoriaCandidatos"));
               presidente.setVotos(resultados.getInt("votos"));
               
               presidente.setNacionalidad(resultados.getString("nacionalidad"));
               
               presidente.setGenero(resultados.getString("genero"));
               
               InputStream obtenerBites = resultados.getBinaryStream("fotografia");//obteniendo el codigo binario
               
               img = ImageIO.read(obtenerBites);//LEYENDO los bites y guardandp estos datos
               presidente.setImagen(img);
               
               presidente.setDiscurso(resultados.getString("discurso"));
               
             
           }
           
           if(presidente.getId_Presidende() == 0){
               presidente =null;
           }
            
        }catch(Exception e){
            System.err.println("Error "+e);
        }finally{
            try {
                consultas.close();
            } catch (SQLException ex) {
            }
        }
        
        
        return presidente;
    }
    
     public BufferedImage imagenPartidos(int partido){
        BufferedImage img= null;
        try{
            Connection conexion = getConnection();
            
           consultas =  conexion.prepareStatement("select foto from partidos where idPartido = ?");//traendo la imagen de la base de datos
           consultas.setInt(1,partido);
           
           resultados = consultas.executeQuery();
           
           while(resultados.next()){
               InputStream obtenerBites = resultados.getBinaryStream("foto");//obteniendo el codigo binario
               img = ImageIO.read(obtenerBites);//LEYENDO los bites y guardandp estos datos
           }
           
        }catch(Exception ex){
            System.err.println("Error "+ex);
            
        }
        
        return img;//retornamos la imagen de la consulta
        
    }
     
        public String NombrePartidos(int idpartido){
        String partido = null;
        try{
            Connection conexion = getConnection();
            
           consultas =  conexion.prepareStatement("select nombrePartido from partidos where idPartido = ?");//traendo la imagen de la base de datos
           consultas.setInt(1, idpartido);
           
           resultados = consultas.executeQuery();
           
           while(resultados.next()){
               partido = resultados.getString("nombrePartido");
           }
           
        }catch(Exception ex){
            System.err.println("Error "+ex);
            
        }
        
        return partido;//retornamos la imagen de la consulta
        
    }
        
         public Diputado busacrNombreD(String nombre){
        Diputado diputado = null; 
        BufferedImage img= null;
          
        try{
            Connection conexion = getConnection();
            
            diputado = new Diputado();
            diputado.setIdDiputado(0);
            
            consultas = conexion.prepareStatement("select * from diputados where nombre = ?");
            consultas.setString(1, nombre);
           
            
           resultados = consultas.executeQuery();
           
        while(resultados.next()){
            diputado.setIdDiputado(resultados.getInt("idDiputado"));
            diputado.setNombre(resultados.getString("nombre"));
            diputado.setId_Partido(resultados.getInt("idPartido"));
            diputado.setId_Departamento(resultados.getInt("id_Departamento"));
            diputado.setNacionalidad(resultados.getString("nacionalidad"));
            diputado.setGenero(resultados.getString("genero"));
            diputado.setCategoria(resultados.getInt("id_CategoriaCandidatos"));
            diputado.setVotos(resultados.getInt("votos"));
            InputStream obtenerBites = resultados.getBinaryStream("foto");//obteniendo el codigo binario
               
               img = ImageIO.read(obtenerBites);//LEYENDO los bites y guardandp estos datos
            diputado.setImagen(img);
            
        }
        
        if(diputado.getIdDiputado() == 0){
            diputado = null;
        }
            
        }catch(Exception e){
            System.err.println("Error "+e);
        }finally{
            try {
                consultas.close();
            } catch (SQLException ex) {
            }
        }
        
        
        return diputado;
        
    }
         
         public Alcalde buscarNombreA(String nombre){
       Alcalde alcalde = null; 
        BufferedImage img= null;
          
        try{
            Connection conexion = getConnection();
            
            alcalde = new Alcalde();
            alcalde.setIdAlcalde(0);
            
            consultas = conexion.prepareStatement("select * from alcaldes where nombre = ? ");
            consultas.setString(1, nombre);
           
            
           resultados = consultas.executeQuery();
           
        while(resultados.next()){
            alcalde.setIdAlcalde(resultados.getInt("idalcalde"));
            alcalde.setNombre(resultados.getString("nombre"));
            alcalde.setId_Partido(resultados.getInt("idPartido"));
            
            alcalde.setNacionalidad(resultados.getString("nacionalidad"));
            alcalde.setGenero(resultados.getString("genero"));
            alcalde.setVotos(resultados.getInt("votos"));
            alcalde.setId_Municipio(resultados.getInt("id_municipio"));
            alcalde.setCategoria(resultados.getInt("id_CategoriaCandidatos"));
            
            InputStream obtenerBites = resultados.getBinaryStream("fotoAlcalde");//obteniendo el codigo binario
               
               img = ImageIO.read(obtenerBites);//LEYENDO los bites y guardandp estos datos
            alcalde.setImagen(img);
            
        }
        
        if(alcalde.getIdAlcalde() == 0){
            alcalde = null;
        }
            
        }catch(Exception e){
            System.err.println("Error "+e);
        }finally{
            try {
                consultas.close();
            } catch (SQLException ex) {
            }
        }
        
        
        return alcalde;
         
    }
         
         public int sumaVotos(){
             int votos = 0;
             try{
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("SELECT sum(votos) FROM presidentes");
             resultados =  consultas.executeQuery();
              while(resultados.next()){
                  votos = resultados.getInt(1);
              }
              
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             
             
            return votos; 
         }
         
           public int sumaVotosD(Diputado diputado){
             int votos = 0;
             try{
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("SELECT sum(votos) FROM diputados where id_Departamento = ?");
              consultas.setInt(1, diputado.getId_Departamento());
              resultados =  consultas.executeQuery();
              while(resultados.next()){
                  votos = resultados.getInt(1);
              }
              
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             
             
            return votos; 
         }
         public Alcalde alcalde(int Votos,Municipio muni){
             
        Alcalde alcalde= null;
        BufferedImage img= null;
           try{
              
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("SELECT * FROM alcaldes where votos = ? and id_municipio =?");
              consultas.setInt(1, Votos);
              consultas.setInt(2, muni.getIdMunicipio());
              resultados =  consultas.executeQuery();
           alcalde = new Alcalde();
           
               while (resultados.next()) {                   
                   
               alcalde.setId_Partido(resultados.getInt("idPartido"));
               
               
               alcalde.setVotos(resultados.getInt("votos"));
               
            
              
               InputStream obtenerBites = resultados.getBinaryStream("fotoAlcalde");//obteniendo el codigo binario
               
               img = ImageIO.read(obtenerBites);//LEYENDO los bites y guardandp estos datos
               alcalde.setImagen(img);
               alcalde.setNombre(resultados.getString("nombre"));
               }
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
               
             
             
            return alcalde;
         }   
           
         public Presidente president(int Votos){
             
        Presidente presidente= null;
        BufferedImage img= null;
           try{
              
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("SELECT * FROM presidentes where votos =?");
              consultas.setInt(1, Votos);
              resultados =  consultas.executeQuery();
           presidente = new Presidente();
           
               while (resultados.next()) {                   
                   
               presidente.setId_Partido(resultados.getInt("idPartido"));
               
               
               presidente.setVotos(resultados.getInt("votos"));
               
            
              
               InputStream obtenerBites = resultados.getBinaryStream("fotografia");//obteniendo el codigo binario
               
               img = ImageIO.read(obtenerBites);//LEYENDO los bites y guardandp estos datos
               presidente.setImagen(img);
               presidente.setNombre(resultados.getString("nombre"));
               }
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
               
             
             
            return presidente;
         }
           
         public int sumaVotosA(Alcalde alcalde){
             int votos = 0;
             try{
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("SELECT sum(votos) FROM alcaldes where id_Municipio = ?");
              consultas.setInt(1, alcalde.getId_Municipio());
              resultados =  consultas.executeQuery();
              while(resultados.next()){
                  votos = resultados.getInt(1);
              }
              
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             
             
            return votos; 
         }
           
         public int nCandidatos(){
             int nCandidatos= 0;
             try{
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("SELECT count(id_Presidente) FROM presidentes");
             resultados =  consultas.executeQuery();
              while(resultados.next()){
                  nCandidatos = resultados.getInt(1);
              }
              
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             
             
            return nCandidatos; 
         }
         
         public int Maxvotos(){
             
             int nVotos=0;
           
             try{
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("SELECT max(votos) from presidentes ");
             resultados =  consultas.executeQuery();
             while(resultados.next()){
               nVotos = resultados.getInt(1);
             }
       
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             
           return nVotos;  
         }
         
         public int Maxvotos(Municipio municipio){
             
             int nVotos=0;
           
             try{
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("SELECT max(votos) from alcaldes where id_municipio =?");
               consultas.setInt(1, municipio.getIdMunicipio());
              resultados =  consultas.executeQuery();
             while(resultados.next()){
               nVotos = resultados.getInt(1);
             }
       
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             
           return nVotos;  
         } 
         
        public Vector<Diputado> diputadosGanadores(Departamento depa,int maximo){
             Vector<Diputado> diputadosGandores = new Vector<>();
              BufferedImage img= null;
           
             try{
              Connection conexion = getConnection();
              
               Diputado diputado1 = new Diputado();//creando un Diputado en cada iteracion
              diputado1.setNombre("Ganadores");
              diputado1.setIdDiputado(0);
              
              diputadosGandores.add(diputado1);
               
              consultas = conexion.prepareStatement("SELECT * FROM diputados where id_Departamento = ? order by(votos) desc limit ?");
              consultas.setInt(1, depa.getId_Departamento());
              consultas.setInt(2, maximo);
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
                   
               img = ImageIO.read(obtenerBites);//LEYENDO los bites y guardandp estos datos
            diputado.setImagen(img);
              
              diputadosGandores.add(diputado);
             }
       
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             
           
           return diputadosGandores;
        }
    
}
