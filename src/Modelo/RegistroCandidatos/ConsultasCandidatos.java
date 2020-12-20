
package Modelo.RegistroCandidatos;

import Modelo.Personas.Persona;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.naming.spi.DirStateFactory;


public class ConsultasCandidatos extends Conexion{
    PreparedStatement consulta;
    ResultSet resultados;
    
    public BufferedImage imagenPartidos(PartidoPolitico partido){
        BufferedImage img= null;
        try{
            Connection conexion = getConnection();
            
           consulta =  conexion.prepareStatement("select foto from partidos where idPartido = ?");//traendo la imagen de la base de datos
           consulta.setInt(1, partido.getId_PartidoPolitico());
           
           resultados = consulta.executeQuery();
           
           while(resultados.next()){
               InputStream obtenerBites = resultados.getBinaryStream("foto");//obteniendo el codigo binario
               img = ImageIO.read(obtenerBites);//LEYENDO los bites y guardandp estos datos
           }
           
        }catch(Exception ex){
            System.err.println("Error "+ex);
            
        }
        
        return img;//retornamos la imagen de la consulta
        
    }
    
    public int verificarUsuario(String numeroIdentidad,String baseDatos,String celda){
    Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consulta =  conexion.prepareStatement("SELECT count(?) from "+ baseDatos +" where identidad =?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     consulta.setString(2, numeroIdentidad);
     consulta.setString(1, celda);
     resultados = consulta.executeQuery();
     
     
        if (resultados.next()) {
            nUsuarios = resultados.getInt(1);//aca obtengo el conteo de uantos usuarios tengo de la columna 1
       
        }else{
            nUsuarios = 0;
        }
     
    }catch(Exception ex){
        System.err.println("Error "+ex);
        nUsuarios =0;
    }
    return nUsuarios;
}
    
    //Aca se usaran los metodos sobreescritos para cada uno de los elementos
    public boolean insertarCandidato(Alcalde alcalde) {//le pasare una persona que gracias al polimorfismo la convertire en una persona
        boolean estado = false;
        Connection conexion = getConnection();
      
         try{
          
              
          consulta =  conexion.prepareStatement("insert into alcaldes (nombre,edad,IdPartido,id_municipio,fotoAlcalde,nacionalidad,genero,estado,identidad,fechaNacimiento,id_CategoriaCandidatos) values(?,?,?,?,?,?,?,?,?,?,?) ");
                     
          consulta.setString(1, alcalde.getNombre());
          consulta.setInt(2, alcalde.getEdad());
          consulta.setInt(3, alcalde.getId_Partido());
          consulta.setInt(4, alcalde.getId_Municipio());
          consulta.setBinaryStream(5, alcalde.getArchivoLeido(), (int) alcalde.getArchivo().length());
          consulta.setString(6, alcalde.getNacionalidad());
          consulta.setString(7, alcalde.getGenero());
          consulta.setString(8, alcalde.getEstadoCivil());
          consulta.setString(9, alcalde.getIdentidad());
          consulta.setDate(10, alcalde.getFechaNacimiento());
          consulta.setInt(11, alcalde.getCategoria());
       int resultado =  consulta.executeUpdate();//Insertar,eliminar o modificar
          
         if(resultado > 0){//si el resultado es mayor que uno todo salio buen
             estado = true;
         }else{
             estado = false;
         }
          
        }catch(Exception ex){
            System.err.println("Error " + ex);//para atrapar todas las excepciones
            estado = false;
        }finally{
            try{
               conexion.close(); 
                       
            }catch(Exception ex){
            System.err.println("Error " + ex);//para atrapar todas las excepciones
          
        }
        }
        
       return estado; 
        
    }
    public boolean insertarCandidato(Presidente presidente) {//le pasare una persona que gracias al polimorfismo la convertire en una persona
        boolean estado = false;
        Connection conexion = getConnection();
      
         try{
          
              
          consulta =  conexion.prepareStatement("insert into presidentes (nombre,edad,IdPartido,fotografia,genero,fechaNacimiento,estado,nacionalidad,identidad,discurso,id_CategoriaCandidatos) values(?,?,?,?,?,?,?,?,?,?,?) ");
            
   //(nombres,edad,IdPartido,fotografia,genero,fechaNacimiento,estado,nacionalidad,identidad,categoria)
  
   consulta.setString(1, presidente.getNombre());
          consulta.setInt(2, presidente.getEdad());
          consulta.setInt(3, presidente.getId_Partido());
          consulta.setBinaryStream(4, presidente.getArchivoLeido(), (int) presidente.getArchivo().length());
          consulta.setString(5, presidente.getGenero());
          consulta.setDate(6, presidente.getFechaNacimiento()); 
          consulta.setString(7, presidente.getEstadoCivil());
           consulta.setString(8, presidente.getNacionalidad());
          consulta.setString(9, presidente.getIdentidad());
          consulta.setInt(11, presidente.getCategoria());
          consulta.setString(10,presidente.getDiscurso());
          
       int resultado =  consulta.executeUpdate();//Insertar,eliminar o modificar
          
         if(resultado > 0){//si el resultado es mayor que uno todo salio buen
             estado = true;
         }else{
             estado = false;
         }
          
        }catch(Exception ex){
            System.err.println("Error " + ex);//para atrapar todas las excepciones
            estado = false;
        }finally{
            try{
               conexion.close(); 
                       
            }catch(Exception ex){
            System.err.println("Error " + ex);//para atrapar todas las excepciones
          
        }
        }
        
       return estado; 
        
    }
    
    public boolean insertarCandidato(Diputado diputados) {//le pasare una persona que gracias al polimorfismo la convertire en una persona
        boolean estado = false;
        Connection conexion = getConnection();
      
        
         try{
          
              
          consulta =  conexion.prepareStatement("insert into diputados (nombre,edad,fechaNacimiento,id_Departamento,idPartido,nacionalidad,foto,genero,estado,identidad,id_CategoriaCandidatos) values (?,?,?,?,?,?,?,?,?,?,?) ");
            
          
      //(nombre,edad,fechaNacimiento,id_Departamento,idPartido,nacionalidad,foto,genero,estado,identidad)
          consulta.setString(1, diputados.getNombre());
          consulta.setInt(2,diputados.getEdad() );
          consulta.setDate(3, diputados.getFechaNacimiento());   
            consulta.setInt(4,diputados.getId_Departamento() );
            consulta.setInt(5,diputados.getId_Partido() );
            consulta.setString(6, diputados.getNacionalidad());
            consulta.setBinaryStream(7, diputados.getArchivoLeido(), (int)diputados.getArchivo().length());
            consulta.setString(8, diputados.getGenero());
            consulta.setString(9, diputados.getEstadoCivil());
            consulta.setString(10, diputados.getIdentidad());
            consulta.setInt(11, diputados.getCategoria());
            
       ;
          
          
       int resultado =  consulta.executeUpdate();//Insertar,eliminar o modificar
          
         if(resultado > 0){//si el resultado es mayor que uno todo salio buen
             estado = true;
         }else{
             estado = false;
         }
          
        }catch(Exception ex){
            System.err.println("Error " + ex);//para atrapar todas las excepciones
            estado = false;
        }finally{
            try{
               conexion.close(); 
                       
            }catch(Exception ex){
            System.err.println("Error " + ex);//para atrapar todas las excepciones
          
        }
        }
        
       return estado; 
        
    }
    
    public boolean borrarCandidato(Presidente presidente){
      
        try{
        Connection conexion = getConnection();
        consulta = conexion.prepareStatement("delete from presidentes where id_Presidente = ?");
        consulta.setInt(1, presidente.getId_Presidende());
        int resultado = consulta.executeUpdate();
        
        if(resultado > 0){
            return true;
        }else{
            return false;
        }
        
        }catch(Exception er){
            System.err.println("Error");
            return false;
        }finally{
            try {
                consulta.close();
            } catch (SQLException ex) {
            }
        }
        
        
    }
       
     public boolean borrarCandidato(Diputado diputado){
        
        try{
        Connection conexion = getConnection();
        consulta = conexion.prepareStatement("delete from diputados where idDiputado = ?");
        consulta.setInt(1, diputado.getIdDiputado());
        int resultado = consulta.executeUpdate();
        
        if(resultado > 0){
            return true;
        }else{
            return false;
        }
        
        }catch(Exception er){
            System.err.println("Error");
            return false;
        }finally{
            try {
                consulta.close();
            } catch (SQLException ex) {
            }
        }
    }
      public boolean borrarCandidato(Alcalde alcalde){
        try{
        Connection conexion = getConnection();
        consulta = conexion.prepareStatement("delete from alcaldes where idalcalde = ?");
        consulta.setInt(1, alcalde.getIdAlcalde());
        int resultado = consulta.executeUpdate();
        
        if(resultado > 0){
            return true;
        }else{
            return false;
        }
        
        }catch(Exception er){
            System.err.println("Error");
            return false;
        }finally{
            try {
                consulta.close();
            } catch (SQLException ex) {
            }
        }
    }
      
       public int verificarUsuarioCompleto(String numeroIdentidad){
    Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consulta =  conexion.prepareStatement("select count(idNumerosIdentidad) from identidadcandidatos where identidades = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     consulta.setString(1, numeroIdentidad);
     
     resultados = consulta.executeQuery();
     
     
        if (resultados.next()) {
            nUsuarios = resultados.getInt(1);//aca obtengo el conteo de uantos usuarios tengo de la columna 1
       
        }else{
            nUsuarios = 0;
        }
     
    }catch(Exception ex){
        System.err.println("Error "+ex);
        nUsuarios =0;
    }
    return nUsuarios;
}
       
       public int contarPresidentes(Presidente presidente){
          Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consulta =  conexion.prepareStatement("SELECT count(id_Presidente) from presidentes where idPartido = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consulta.setInt(1, presidente.getId_Partido());
     resultados = consulta.executeQuery();
     
     
        if (resultados.next()) {
            nUsuarios = resultados.getInt(1);//aca obtengo el conteo de uantos usuarios tengo de la columna 1
       
        }else{
            nUsuarios = 0;
        }
     
    }catch(Exception ex){
        System.err.println("Error "+ex);
        nUsuarios =0;
    }
    return nUsuarios;
       }
       
       
       public int alcaldesPartido(Alcalde alcalde){
            Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consulta =  conexion.prepareStatement("SELECT count(idPartido) from alcaldes where idPartido = ? and id_municipio = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     consulta.setInt(1, alcalde.getId_Partido());
     consulta.setInt(2, alcalde.getId_Municipio());
     
     resultados = consulta.executeQuery();
     
     
     if (resultados.next()) {
            nUsuarios = resultados.getInt(1);//aca obtengo el conteo de uantos usuarios tengo de la columna 1
        }else{
         nUsuarios = 0;
     }
     
    }catch(Exception ex){
        System.err.println("Error "+ex);
        nUsuarios =0;
    }
    return nUsuarios;
       }
       
       
}
