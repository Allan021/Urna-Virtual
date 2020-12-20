/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.RegistroCandidatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Allan Crack
 */
public class Nacionalidades {
    private int idNacionalidad;
    private String nombre;

    @Override
    public String toString() {
        return  nombre ;
    }

    public int getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(int idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Vector<Nacionalidades> establecerNacionalidad(){//establecer un arreglo de partidos politicos
         Vector<Nacionalidades> nacionalidades = new Vector<Nacionalidades>();//un nuevo arreglo de partidos politicos
      
        Conexion con = new Conexion();
        PreparedStatement consulta =null;
        ResultSet resultados;
        try {
            Connection conexion =con.getConnection();
         consulta = conexion.prepareStatement("select idnacionalidad,nombreNacionalidad from nacionalidad");
            
         resultados = consulta.executeQuery();
         
         while(resultados.next()){
             Nacionalidades nacionalidad = new Nacionalidades();
            
             nacionalidad.setIdNacionalidad(resultados.getInt("idnacionalidad"));
             nacionalidad.setNombre(resultados.getString("nombreNacionalidad"));
            
             nacionalidades.add(nacionalidad);//terminar de llenar los partidos
         }
         
         
            
        } catch (Exception e) {
            System.err.println("Error "+e);
        }
        
        return nacionalidades;
    }
    
    
    
    
    
    
    
}
