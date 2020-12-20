
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
import javax.imageio.ImageIO;

public class Diputado extends Persona {
    private int idDiputado;
    private int id_Partido;
    private int Votos;
    private BufferedImage imagen;
    private int id_Departamento;
    private int categoria;
    public File archivo;
    private FileInputStream archivoLeido;
    PreparedStatement consultas;
    ResultSet resultados;
    
    
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

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    
    public int getIdDiputado() {
        return idDiputado;
    }

    public void setIdDiputado(int idDiputado) {
        this.idDiputado = idDiputado;
    }

    public int getId_Departamento() {
        return id_Departamento;
    }

    public void setId_Departamento(int id_Departamento) {
        this.id_Departamento = id_Departamento;
    }

    public int getId_Partido() {
        return id_Partido;
    }

    public void setId_Partido(int id_Partido) {
        this.id_Partido = id_Partido;
    }

    public int getVotos() {
        return Votos;
    }

    public void setVotos(int Votos) {
        this.Votos = Votos;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
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
    public void setEstadoCivil(String estadoCivil) {
        super.setEstadoCivil(estadoCivil); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEstadoCivil() {
        return super.getEstadoCivil(); //To change body of generated methods, choose Tools | Templates.
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
    public void setNacionalidad(String nacionalidad) {
        super.setNacionalidad(nacionalidad); //To change body of generated methods, choose Tools | Templates.
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
    public String getNacionalidad() {
        return super.getNacionalidad(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getEdad() {
        return super.getEdad(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
    
    
     public Vector<Diputado> DiputadosPartido (PartidoPolitico partido,int idDepartamento){
      Vector<Diputado> diputados = new Vector<Diputado>();
       BufferedImage img= null;
       
      Diputado muestra = new Diputado();
      
      
      muestra.setIdDiputado(0);
      
      muestra.setNombre("Seleccione Diputado");
      
      diputados.add(muestra);
      
         Conexion con = new Conexion();
      
        try{
          
          Connection conexion = con.getConnection();
          
          consultas = conexion.prepareStatement("select * from diputados where idPartido = ? and id_Departamento = ?");
            consultas.setInt(1,partido.getId_PartidoPolitico());
            consultas.setInt(2, idDepartamento);
            
           resultados = consultas.executeQuery();
           
        while(resultados.next()){
            Diputado diputado = new Diputado();
            
            diputado.setIdDiputado(resultados.getInt("idDiputado"));
            diputado.setNombre(resultados.getString("nombre"));
            diputado.setId_Partido(resultados.getInt("idPartido"));
            diputado.setId_Departamento(resultados.getInt("id_Departamento"));
            diputado.setNacionalidad(resultados.getString("nacionalidad"));
            diputado.setGenero(resultados.getString("genero"));
            diputado.setCategoria(resultados.getInt("id_CategoriaCandidatos"));
            
            InputStream obtenerBites = resultados.getBinaryStream("foto");//obteniendo el codigo binario
               
               img = ImageIO.read(obtenerBites);//LEYENDO los bites y guardandp estos datos
            diputado.setImagen(img);
            
            diputados.add(diputado);
        }
          
      }catch(Exception ex){
          
      }finally{
          try {
              consultas.close();
          } catch (SQLException ex) {
              
          }
        }  
        
       return diputados;
    }
     
   
     public Vector<Diputado> Diputados (int idDepartamento){
      Vector<Diputado> diputados = new Vector<Diputado>();
       BufferedImage img= null;
       
      Diputado muestra = new Diputado();
      
      
      muestra.setIdDiputado(0);
      
      muestra.setNombre("Seleccione Diputado");
      
      diputados.add(muestra);
      
         Conexion con = new Conexion();
      
        try{
          
          Connection conexion = con.getConnection();
          
          consultas = conexion.prepareStatement("select * from diputados where id_Departamento = ?");
            consultas.setInt(1, idDepartamento);
            
           resultados = consultas.executeQuery();
           
        while(resultados.next()){
            Diputado diputado = new Diputado();
            
            diputado.setIdDiputado(resultados.getInt("idDiputado"));
            diputado.setNombre(resultados.getString("nombre"));
            diputado.setId_Partido(resultados.getInt("idPartido"));
            diputado.setId_Departamento(resultados.getInt("id_Departamento"));
            diputado.setNacionalidad(resultados.getString("nacionalidad"));
            diputado.setGenero(resultados.getString("genero"));
            diputado.setCategoria(resultados.getInt("id_CategoriaCandidatos"));
            
            InputStream obtenerBites = resultados.getBinaryStream("foto");//obteniendo el codigo binario
               
               img = ImageIO.read(obtenerBites);//LEYENDO los bites y guardandp estos datos
            diputado.setImagen(img);
            
            diputados.add(diputado);
        }
          
      }catch(Exception ex){
          
      }finally{
          try {
              consultas.close();
          } catch (SQLException ex) {
              
          }
        }  
        
       return diputados;
    }
    
    
    
}
