
package Modelo.RegistroCandidatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Categoria {
   private int idCategoria;
   private String nombre;
   
   
   
   
   
   
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre ;
    }
   
   
   public Vector<Categoria> establecerCategoria(){//establecer un arreglo de partidos politicos
         Vector<Categoria> categorias = new Vector<Categoria>();//un nuevo arreglo de partidos politicos
      
        Conexion con = new Conexion();
        PreparedStatement consulta =null;
        ResultSet resultados;
        try {
            Connection conexion =con.getConnection();
         consulta = conexion.prepareStatement("select id_CategoriaCandidatos,nombreCategoria from categoriacandidatos");
            
         resultados = consulta.executeQuery();
         
         while(resultados.next()){
             Categoria categoria = new Categoria();
             categoria.setIdCategoria(resultados.getInt("id_CategoriaCandidatos"));
             categoria.setNombre(resultados.getString("nombreCategoria"));
            
             categorias.add(categoria);//terminar de llenar los partidos
         }
         
         
            
        } catch (Exception e) {
            System.err.println("Error "+e);
        }
        
        return categorias;
    }
   
}
