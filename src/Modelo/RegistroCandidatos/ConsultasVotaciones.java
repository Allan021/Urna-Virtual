
package Modelo.RegistroCandidatos;

import Modelo.Votantes.Votante;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ConsultasVotaciones extends Conexion{
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
               presidente.setVotos(resultados.getInt("votos"));
               presidente.setCategoria(resultados.getInt("id_CategoriaCandidatos"));
               
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
    
    public Diputado busacrNombreD(String nombre,int idDepartamento){
        Diputado diputado = null; 
        BufferedImage img= null;
          
        try{
            Connection conexion = getConnection();
            
            diputado = new Diputado();
            diputado.setIdDiputado(0);
            
            consultas = conexion.prepareStatement("select * from diputados where nombre = ? and id_Departamento = ?");
            consultas.setString(1, nombre);
            consultas.setInt(2, idDepartamento);
            
           resultados = consultas.executeQuery();
           
        while(resultados.next()){
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
    
    public Alcalde buscarNombreA(String nombre,int idMunicipio){
       Alcalde alcalde = null; 
        BufferedImage img= null;
          
        try{
            Connection conexion = getConnection();
            
            alcalde = new Alcalde();
            alcalde.setIdAlcalde(0);
            
            consultas = conexion.prepareStatement("select * from alcaldes where nombre = ? and id_municipio = ?");
            consultas.setString(1, nombre);
            consultas.setInt(2, idMunicipio);
            
           resultados = consultas.executeQuery();
           
        while(resultados.next()){
            alcalde.setIdAlcalde(resultados.getInt("idalcalde"));
            alcalde.setNombre(resultados.getString("nombre"));
            alcalde.setId_Partido(resultados.getInt("idPartido"));
            
            alcalde.setNacionalidad(resultados.getString("nacionalidad"));
            alcalde.setGenero(resultados.getString("genero"));
            
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
    
    public boolean votarPresidnete(Votante votante,int idPresidente){//aca se le etablecera el foto y elel votante se le establecera que ya voto
       
        
        
        try{
         Connection conexion = getConnection();
         
         
        int votos = votosPresidente(idPresidente) ;
        
        votos+=1;
        
       consultas =   conexion.prepareStatement("update presidentes set votos = ? where id_Presidente=?");
       consultas.setInt(1, votos);
       consultas.setInt(2, idPresidente);
         
       int resultado = consultas.executeUpdate();
         
       if(resultado > 0){//todo salio bien 
       ConsultasValidaciones modelo = new ConsultasValidaciones();
        
          int respuesta = modelo.validarPresidnete(votante);
           int respuesta2 = modelo.validarPresidnete2(votante);
           int respuesta3 = modelo.validarPresidnete3(votante);
           int respuesta4 = modelo.validarDiputados4(votante);
           if(respuesta > 0 || respuesta2 > 0 || respuesta3 > 0 ||respuesta4 > 0 ){//si hay mas de 1 usuario en el cual haya votado por un usuarioo
    consultas =  conexion.prepareStatement("update personasvotaron set votoPresidente = ? where idVotante = ?");
     consultas.setInt(1,idPresidente);

     consultas.setInt(2,votante.getIdVotante());
     consultas.executeUpdate(); 
       
     
      }else{//si nada de esto se cumple se introducira los votos del presidente
           consultas =  conexion.prepareStatement("insert into personasvotaron (idVotante,votoPresidente) values(?,?) ");
     consultas.setInt(2,idPresidente);

     consultas.setInt(1,votante.getIdVotante());
     consultas.executeUpdate(); 
     
      }
        
        
        return true;
       }else{
           return false;
       }
       
        }catch(Exception e){
            System.err.println("Error " + e);
            return false;
        }finally{
            try {
                consultas.close();
            } catch (SQLException ex) {
            }
        }
        
        
        
    }
    
      public boolean votarAlcalde(Votante votante,int idAlcalde){//aca se le etablecera el foto y elel votante se le establecera que ya voto
       
        
        
        try{
         Connection conexion = getConnection();
         
         
        int votos = votosAlcalde(idAlcalde,votante.getIdMunicipio()) ;
        
        votos+=1;
        
       consultas =   conexion.prepareStatement("update alcaldes set votos = ? where idalcalde =?");
       consultas.setInt(1, votos);
       consultas.setInt(2, idAlcalde);
         
       int resultado = consultas.executeUpdate();
         
       if(resultado > 0){//todo salio bien 
           ConsultasValidaciones modelo = new ConsultasValidaciones();
           int respuesta = modelo.validarAlcalde(votante);
           int respuesta2 = modelo.validarAlcalde2(votante);
           int respuesta3 = modelo.validarAlcalde3(votante);
            int respuesta4 = modelo.validarAlcalde4(votante);
           if(respuesta > 0 || respuesta2 > 0 || respuesta3 > 0 || respuesta4 > 0){
          consultas =  conexion.prepareStatement("update personasvotaron set votoAlcalde = ? where idVotante = ?");
          consultas.setInt(1,idAlcalde);

          consultas.setInt(2,votante.getIdVotante());
          consultas.executeUpdate(); 
     
      
     
      }else{
         consultas =  conexion.prepareStatement("insert into personasvotaron (idVotante,votoAlcalde) values(?,?) ");
     consultas.setInt(2,idAlcalde);

     consultas.setInt(1,votante.getIdVotante());
     consultas.executeUpdate(); 
     
      
      }
        
        
        
        return true;
       }else{
           return false;
       }
       
        }catch(Exception e){
            System.err.println("Error " + e);
            return false;
        }finally{
            try {
                consultas.close();
            } catch (SQLException ex) {
            }
        }
        
        
        
    }
    
    
    public void insertarNulos(Votante votante){
        try{
            Connection conexion = getConnection();
            
            int idVotacion = idVotacion(votante);
            
            
            if(idVotacion > 0 ){
                   
     consultas =  conexion.prepareStatement("update personasvotaron \n" +
     "set acceso = 1 where idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consultas.setInt(1, votante.getIdVotante());
     
     consultas.executeUpdate();  
           
            }else{
        consultas =  conexion.prepareStatement("insert into personasvotaron (idVotante,acceso) values(?,2) ");
       
        consultas.setInt(1,votante.getIdVotante());
        consultas.executeUpdate();
            }
    
     
        }catch(Exception e){
            System.err.println("Error "+e);
        }
        
        
    }
    
     public boolean votarDiputado(Votante votante,int idDiputado){//aca se le etablecera el foto y elel votante se le establecera que ya voto
       
        
        
        try{
         Connection conexion = getConnection();
         
         int votos = votosDiputado(idDiputado, votante.getIdDepartamento());
         votos+=1;
         
       consultas =   conexion.prepareStatement("update diputados set votos = ? where idDiputado=?");
       consultas.setInt(1, votos);
       consultas.setInt(2, idDiputado);
         
       int resultado = consultas.executeUpdate();
         
       if(resultado > 0){//todo salio bien 
           
      ConsultasValidaciones modelo = new ConsultasValidaciones();
      int respuesta = modelo.validarDiputados(votante);
      int respuesta2 = modelo.validarDiputados2(votante);
      int respuesta3 =  modelo.validarDiputados3(votante);    
      int respuesta4 = modelo.validarDiputados4(votante);
      int respuesta5 = modelo.validarDiputados5(votante);
      int respuesta6 = modelo.validarDiputados6(votante);
      int respuesta7 = modelo.validarDiputados7(votante);
      if(respuesta > 0 || respuesta2 > 0 || respuesta3 > 0 || respuesta4 > 0 || respuesta5 > 0 || respuesta6 > 0  || respuesta7 > 0){
   
             consultas =  conexion.prepareStatement("update personasvotaron set votosDiputados = ? where idVotante = ?");
     consultas.setInt(1,idDiputado);

     consultas.setInt(2,votante.getIdVotante());
     consultas.executeUpdate(); 
     
      
     
      }else{
          consultas =  conexion.prepareStatement("insert into personasvotaron (idVotante,votosDiputados) values(?,?) ");
     consultas.setInt(2,idDiputado);

     consultas.setInt(1,votante.getIdVotante());
     consultas.executeUpdate();  
      }
        
        
        return true;
       }else{
           return false;
       }
       
        }catch(Exception e){
            System.err.println("Error " + e);
            return false;
        }finally{
            try {
                consultas.close();
            } catch (SQLException ex) {
            }
        }
        
        
        
    }
  
     public int votosPresidente(int idPresidente){
         int Votos=0;
             try{
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("select votos from presidentes where id_Presidente = ?");
               consultas.setInt(1,idPresidente );
              resultados =  consultas.executeQuery();
            
              while(resultados.next()){
               Votos = resultados.getInt(1);
             }
       
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             return Votos;
         
         
     }
     public int votosAlcalde(int idAlcalde,int idMunicipio){
          int Votos=0;
             try{
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("select votos from alcaldes where idalcalde = ? and id_municipio = ?");
               consultas.setInt(1,idAlcalde );
               consultas.setInt(2, idMunicipio);
              resultados =  consultas.executeQuery();
            
              while(resultados.next()){
               Votos = resultados.getInt(1);
             }
       
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             return Votos;
           
     }
     
       public int votosDiputado(int idDiputado,int idDepartamento){
          int Votos=0;
             try{
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("select votos from diputados where idDiputado = ? and id_Departamento = ?");
               consultas.setInt(1,idDiputado );
               consultas.setInt(2, idDepartamento);
              resultados =  consultas.executeQuery();
            
              while(resultados.next()){
               Votos = resultados.getInt(1);
             }
       
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             return Votos;
           
     }
    
       public int LimiteDiputados(int idDepartamento){
          
             int nDiputados=0;
             try{
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("select nDiputados from departamentos where id_Departamento = ?");
               consultas.setInt(1, idDepartamento);
              resultados =  consultas.executeQuery();
            
              while(resultados.next()){
               nDiputados = resultados.getInt(1);
             }
       
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             return nDiputados;
         }
       
    public int IdPresidenteVotado(Votante votante){
         int idPresidente=0;
             try{
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("select votoPresidente from personasvotaron where idVotante = ?");
              consultas.setInt(1, votante.getIdVotante());
              resultados =  consultas.executeQuery();
            
              while(resultados.next()){
               idPresidente = resultados.getInt(1);
             }
       
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             return idPresidente;
         }
    
        public int IdAlcaldeVotado(Votante votante){
         int idAlcalde=0;
             try{
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("select votoAlcalde from personasvotaron where idVotante = ?");
               consultas.setInt(1, votante.getIdVotante());
              resultados =  consultas.executeQuery();
            
              while(resultados.next()){
               idAlcalde = resultados.getInt(1);
             }
       
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             return idAlcalde;
         }
        
        public String nombreAlcalde(Votante votante){
            String nombre = "";
            
            try{
                
               Connection conexion = getConnection(); 
               
               int idAlcalde = IdAlcaldeVotado(votante);
              consultas = conexion.prepareStatement("select nombre from alcaldes where idalcalde = ?");
               consultas.setInt(1, idAlcalde);
               resultados =  consultas.executeQuery();
               
                while(resultados.next()){
               nombre = resultados.getString("nombre");
             }
               
            }catch(Exception ex){
                
                System.err.println("Error "+ex);
            }
            
            
           return nombre; 
        }
        
        public String nombrePresidente(Votante votante){
            String nombre = "";
            
            try{
                
               Connection conexion = getConnection(); 
               
               int idPresidente = IdPresidenteVotado(votante);
              consultas = conexion.prepareStatement("select nombre from presidentes where id_Presidente = ?");
               consultas.setInt(1, idPresidente);
               resultados =  consultas.executeQuery();
               
                while(resultados.next()){
               nombre = resultados.getString("nombre");
             }
               
            }catch(Exception ex){
                
                System.err.println("Error "+ex);
            }
            
            
           return nombre; 
        }
        
          public void votarPresidnetenNulo(Votante votante,int idPresidente){//aca se le etablecera el foto y elel votante se le establecera que ya voto
       
        
        
        try{
         Connection conexion = getConnection();
       
       ConsultasValidaciones modelo = new ConsultasValidaciones();
            
          int respuesta = modelo.validarPresidnete(votante);
           int respuesta2 = modelo.validarPresidnete2(votante);
           int respuesta3 = modelo.validarPresidnete3(votante);
           int respuesta4 = modelo.validarPresidnete4(votante);
           if(respuesta > 0 || respuesta2 > 0 || respuesta3 > 0 ||respuesta4 > 0 ){//si hay mas de 1 usuario en el cual haya votado por un usuarioo
    consultas =  conexion.prepareStatement("update personasvotaron set votoPresidente = null,acceso = 2 where idVotante = ?");
    

     consultas.setInt(1,votante.getIdVotante());
     consultas.executeUpdate(); 
       
     
      }else{//si nada de esto se cumple se introducira los votos del presidente
           consultas =  conexion.prepareStatement("insert into personasvotaron (idVotante,votoPresidente,acceso) values(?,null,2) ");

     consultas.setInt(1,votante.getIdVotante());
     consultas.executeUpdate(); 
     
      }
        
   
       
        }catch(Exception e){
            System.err.println("Error " + e);
            
        }finally{
            try {
                consultas.close();
            } catch (SQLException ex) {
            }
        }
        
        
        
    }
     public void votarDiputadoNull(Votante votante,int idDiputado){//aca se le etablecera el foto y elel votante se le establecera que ya voto
       
        
        
        try{
         Connection conexion = getConnection();
         
        
           
      ConsultasValidaciones modelo = new ConsultasValidaciones();
       int respuesta = modelo.validarDiputados(votante);
      int respuesta2 = modelo.validarDiputados2(votante);
      int respuesta3 =  modelo.validarDiputados3(votante);    
      int respuesta4 = modelo.validarDiputados4(votante);
      int respuesta5 = modelo.validarDiputados5(votante);
      int respuesta6 = modelo.validarDiputados6(votante);
      if(respuesta > 0 || respuesta2 > 0 || respuesta3 > 0 || respuesta4 > 0 || respuesta5 > 0 || respuesta6 > 0 ){
     
        consultas =  conexion.prepareStatement("update personasvotaron set votosDiputados = null,acceso = 2 where idVotante = ?");
             consultas.setInt(1,votante.getIdVotante());
     consultas.executeUpdate(); 
       
     
      }else{
          consultas =  conexion.prepareStatement("insert into personasvotaron (idVotante,votosDiputados,acceso) values(?,null,2) ");
    

     consultas.setInt(1,votante.getIdVotante());
     consultas.executeUpdate();  
      }
        
        
      
        }catch(Exception e){
            System.err.println("Error " + e);
           
        }finally{
            try {
                consultas.close();
            } catch (SQLException ex) {
            }
        }
        
        
        
    }
     
     
 
      public void votarAlcaldeNull(Votante votante,int idAlcalde){//aca se le etablecera el foto y elel votante se le establecera que ya voto
       
        
        
        try{
         Connection conexion = getConnection();
         
         
       
           ConsultasValidaciones modelo = new ConsultasValidaciones();
           int respuesta = modelo.validarAlcalde(votante);
           int respuesta2 = modelo.validarAlcalde2(votante);
           int respuesta3 = modelo.validarAlcalde3(votante);
           int respuesta4 = modelo.validarAlcalde4(votante);
           if(respuesta > 0 || respuesta2 > 0 || respuesta3 > 0 || respuesta4 >0){
           consultas =  conexion.prepareStatement("update personasvotaron set votoAlcalde = null,acceso = 2 where idVotante = ?");
    

     consultas.setInt(1,votante.getIdVotante());
     consultas.executeUpdate(); 
       
     
      }else{//si nada de esto se cumple se introducira los votos del presidente
           consultas =  conexion.prepareStatement("insert into personasvotaron (idVotante,votoAlcalde,acceso) values(?,null,2) ");

     consultas.setInt(1,votante.getIdVotante());
     consultas.executeUpdate(); 
     
      }
        
      
        
        
        
       
       
        }catch(Exception e){
            System.err.println("Error " + e);
           
        }finally{
            try {
                consultas.close();
            } catch (SQLException ex) {
            }
        }
        
        
        
    }
     public int idVotacion(Votante vot){
          
             int nVotacion=0;
             try{
              Connection conexion = getConnection();
              
              consultas = conexion.prepareStatement("SELECT count(idVotacion) FROM personasvotaron \n" +
     "where idVotante = ?");
              consultas.setInt(1, vot.getIdVotante());
              resultados =  consultas.executeQuery();
            
              while(resultados.next()){
               nVotacion = resultados.getInt(1);
             }
       
              
             }catch(Exception e){
                 System.err.println("Error "+e);
             }
             
             return nVotacion;
         }
       
}
