
package Modelo.Regiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Municipio {
    //crearle atributos al municipio
    private int idMunicipio;
    private String nombre;
    private int IdDepartamento;

    public int getIdDepartamento() {
        return IdDepartamento;
    }

    public void setIdDepartamento(int IdDepartamento) {
        this.IdDepartamento = IdDepartamento;
    }
    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return nombre;//solo quiero que retorne el metodo ToString ya que necesito imprimir algo en el ComboBox porque sino solo me imprimira su referecnia
    }
    
    public Vector<Municipio> mostrarMuncipios(Departamento departamento){//aqui le mandare como parametro un munciipio para mostrar un arreglo de municipio con el VECTOR que me perite agregar los elementos al comboBox dinamicamente
      
        
        Vector<Municipio> municipios = null;
        PreparedStatement consultaPreparada;
        ResultSet resultados;
        try{
            Conexion conexion = new Conexion();
            Connection conectar = conexion.getConnection();
            
            //Primero crear lo de seleccione Tal
            Municipio muni = new Municipio();//agregando el primer elemento de la lista o del vector que sea para seleccionar el mucnicipio
            muni.setIdMunicipio(0);
            muni.setNombre("Seleccione Municipio");
            municipios = new Vector<Municipio>();
            municipios.add(muni);//en mi posicion 0 ya he agregado un municipio a mi variable muncicipip
            
          consultaPreparada =  conectar.prepareStatement("select * from municipios where id_Departamento = ?");
          consultaPreparada.setInt(1, departamento.getId_Departamento());
         
          resultados =  consultaPreparada.executeQuery();//los resultados seran igual a la consula mySql que habria hechio
            
          while(resultados.next()){//solo me faltaria incializar cada uno de los atributos en cada iteracion y luego agregarle el nuevo elemento incializandp a mi Arreglo de tipo Vector
              Municipio nuevoMuncipio = new Municipio();
              nuevoMuncipio.setIdDepartamento(resultados.getInt("id_Departamento"));
              nuevoMuncipio.setIdMunicipio(resultados.getInt("id_municipio"));
              nuevoMuncipio.setNombre(resultados.getString("nombreMuni"));
              
              municipios.add(nuevoMuncipio);
          }
          
        }catch(Exception ex){
            System.err.println("Error "+ex);
        }
        return municipios;        
    }
    
}
