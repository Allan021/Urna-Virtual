
package Modelo.RegistroCandidatos;

import Modelo.Votantes.Votante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConsultasValidaciones extends Conexion {
    PreparedStatement consultas;
    ResultSet resultados;

    public int validarDiputados(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where votosDiputados is null and votoPresidente is not null and votoAlcalde is not null and idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
    
      public int validarDiputados2(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where votosDiputados is not null and votoPresidente is not null and votoAlcalde is not null and idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
     public int validarDiputados4(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where votosDiputados is null and votoPresidente is null and votoAlcalde is not null and idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
     
     
     public int validarDiputados3(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where votosDiputados is null and votoPresidente is not null and votoAlcalde is null and idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
    
        public int validarDiputados5(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where votosDiputados is not null and votoPresidente is not null and votoAlcalde is null and idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
    
           public int validarDiputados6(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where idVotante is not null and votosDiputados is null and votoPresidente is  null and votoAlcalde is null and idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
                 public int validarDiputados7(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where votosDiputados is  not null and votoPresidente is  null and votoAlcalde is null and idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
    
    
    
    
    public int validarPresidnete(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where votosDiputados is not null and votoPresidente is null and votoAlcalde is not null and idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
    public int validarPresidnete2(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where votosDiputados is not null and votoPresidente is null and votoAlcalde is null and idVotante = ?");
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
    
     public int validarPresidnete3(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where votosDiputados is  null and votoPresidente is null and votoAlcalde is not null and idVotante = ?");
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
     public int validarPresidnete4(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where idVotante is not null and votosDiputados is null and votoPresidente is null and votoAlcalde is null and idVotante = ?");
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
    
     
    public int validarAlcalde(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where  votosDiputados is not null and votoPresidente is not null and votoAlcalde is null and idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
    
        public int validarAlcalde3(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where votosDiputados is not null and votoPresidente is null and votoAlcalde is null and idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
        public int validarAlcalde2(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where votosDiputados is not null and votoPresidente is null and votoAlcalde is null and idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
        
    
         public int validarAlcalde4(Votante v){
       Connection conexion = getConnection();//conectandome a la base de datos
    int nUsuarios;
    try{
     
     consultas =  conexion.prepareStatement("SELECT count(idVotante) FROM personasvotaron \n" +
     "where idVotante is not null and votosDiputados is null and votoPresidente is null and votoAlcalde is null and idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     
     consultas.setInt(1, v.getIdVotante());
     
     resultados = consultas.executeQuery();
     
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
         
       public void sacarUsuarioDiputado(Votante v){
    Connection conexion = getConnection();//conectandome a la base de datos

           
         try{
     
     consultas =  conexion.prepareStatement("update personasvotaron set acceso = 2 where idVotante = ?");//aca me doy cuenta si el numero de identidad se repite entonces ya voto
     consultas.setInt(1, v.getIdVotante());
     
     consultas.executeUpdate();
     
   
     
    }catch(Exception ex){
        System.err.println("Error "+ex);
        
    }finally{
             
         }    
       }  
       
       
}
