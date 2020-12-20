
package Modelo.RegistroCandidatos;

import Modelo.Personas.Persona;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class Presidente extends Persona {
  private int id_Presidende;
  private int id_Partido;  
  private int votos;    
  private BufferedImage imagen; 
private int categoria;
public File archivo;
private FileInputStream archivoLeido;
private String discurso; 
    PreparedStatement consultas;
    ResultSet resultados;

    public String getDiscurso() {
        return discurso;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }

  

    public void setDiscurso(String discurso) {
        this.discurso = discurso;
    }
        
    

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public FileInputStream getArchivoLeido() {
        return archivoLeido;
    }

    public void setArchivoLeido(FileInputStream archivoLeido) {
        this.archivoLeido = archivoLeido;
    }
    public int getCategoria() {
        return categoria;
    }

    @Override
    public void setIdentidad(String identidad) {
        super.setIdentidad(identidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIdentidad() {
        return super.getIdentidad(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNacionalidad(String nacionalidad) {
        super.setNacionalidad(nacionalidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNacionalidad() {
        return super.getNacionalidad(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getId_Presidende() {
        return id_Presidende;
    }

    public void setId_Presidende(int id_Presidende) {
        this.id_Presidende = id_Presidende;
    }

    public int getId_Partido() {
        return id_Partido;
    }

    public void setId_Partido(int id_Partido) {
        this.id_Partido = id_Partido;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    @Override
    public void setEstadoCivil(String estadoCivil) {
        super.setEstadoCivil(estadoCivil); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEstadoCivil() {
        return super.getEstadoCivil(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFechaNacimiento(Date fechaNacimiento) {
        super.setFechaNacimiento(fechaNacimiento); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getFechaNacimiento() {
        return super.getFechaNacimiento(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setGenero(String genero) {
        super.setGenero(genero); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getGenero() {
        return super.getGenero(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEdad(int edad) {
        super.setEdad(edad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getEdad() {
        return super.getEdad(); //To change body of generated methods, choose Tools | Templates.
    }
  
   
  
    
        public Vector<Presidente> presidentesPartido (PartidoPolitico partido){
     
       Vector<Presidente> presidentes = new Vector<Presidente>();
       BufferedImage img= null;
       
            Presidente muestra = new Presidente();
      muestra.setId_Presidende(0);
      
      muestra.setNombre("Seleccione Presidente");
      
      presidentes.add(muestra);
      
         Conexion con = new Conexion();
      
        try{
          
          Connection conexion = con.getConnection();
          
          consultas = conexion.prepareStatement("select * from presidentes where idPartido = ? ");
            
          consultas.setInt(1, partido.getId_PartidoPolitico());
         
           resultados = consultas.executeQuery();
           
        while(resultados.next()){
            Presidente presidente = new Presidente();
            
             presidente.setId_Presidende(resultados.getInt("id_Presidente"));
             
               presidente.setNombre(resultados.getString("nombre"));
               
               presidente.setId_Partido(resultados.getInt("idPartido"));
               
               presidente.setCategoria(resultados.getInt("id_CategoriaCandidatos"));
               
               presidente.setNacionalidad(resultados.getString("nacionalidad"));
               
               presidente.setGenero(resultados.getString("genero"));
               
               InputStream obtenerBites = resultados.getBinaryStream("fotografia");//obteniendo el codigo binario
               
               img = ImageIO.read(obtenerBites);//LEYENDO los bites y guardandp estos datos
               presidente.setImagen(img);
               
               presidente.setDiscurso(resultados.getString("discurso"));
            
           presidentes.add(presidente);
        }
          
      }catch(Exception ex){
          
      }finally{
          try {
              consultas.close();
          } catch (SQLException ex) {
              
          }
        }  
        
       return presidentes;
    }
    
   public Vector<Presidente> presidentes(){
         Vector<Presidente> presidentes = new Vector<Presidente>();
       BufferedImage img= null;
       
            Presidente muestra = new Presidente();
      muestra.setId_Presidende(0);
      
      muestra.setNombre("Seleccione Presidente");
      
      presidentes.add(muestra);
      
         Conexion con = new Conexion();
      
        try{
          
          Connection conexion = con.getConnection();
          
          consultas = conexion.prepareStatement("select * from presidentes");
            
         
           resultados = consultas.executeQuery();
           
        while(resultados.next()){
            Presidente presidente = new Presidente();
            
             presidente.setId_Presidende(resultados.getInt("id_Presidente"));
             
               presidente.setNombre(resultados.getString("nombre"));
               
               presidente.setId_Partido(resultados.getInt("idPartido"));
               
               presidente.setCategoria(resultados.getInt("id_CategoriaCandidatos"));
               
               presidente.setNacionalidad(resultados.getString("nacionalidad"));
               
               presidente.setGenero(resultados.getString("genero"));
               
               InputStream obtenerBites = resultados.getBinaryStream("fotografia");//obteniendo el codigo binario
               
               img = ImageIO.read(obtenerBites);//LEYENDO los bites y guardandp estos datos
               presidente.setImagen(img);
               
               presidente.setDiscurso(resultados.getString("discurso"));
            
           presidentes.add(presidente);
        }
          
      }catch(Exception ex){
          
      }finally{
          try {
              consultas.close();
          } catch (SQLException ex) {
              
          }
        }  
        
       return presidentes;
        
    }
  
  
  
  
    
}
