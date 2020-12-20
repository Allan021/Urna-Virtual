
package Modelo.Regiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Departamento {
   //atributos del departamento sera el id_Departamento y el nombre
    private int id_Departamento;
    private String nombre;//estos atributos se llenaran con los departamentos

    public int getnDiputados() {
        return nDiputados;
    }

    public void setnDiputados(int nDiputados) {
        this.nDiputados = nDiputados;
    }
    private int nDiputados;
    
    public int getId_Departamento() {
        return id_Departamento;
    }

    public void setId_Departamento(int id_Departamento) {
        this.id_Departamento = id_Departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  this.nombre;//retornando solo el nombre de cada uno de los objetos 
    }
    
    //Crear Un Vector de departamentos dentro de esta clase para solo instanciarla y luego [parasle al modelo del combo box
    public Vector<Departamento> mostrarDepartamentos(){
        
        PreparedStatement consulta=null;
        ResultSet resultados = null;
       Vector<Departamento> departamentos = new Vector<Departamento>();
       
        try{
            Conexion con = new Conexion();
            Connection conectar = con.getConnection();
            
            Departamento depa = new Departamento();
            depa.setId_Departamento(0);
            depa.setNombre("Seleccione un Departamento");
            //mi primer objeto de tipoDepartamento iniciara el seleccione un departamento
            departamentos.add(depa);//esto es para retornar un arreglo de objetos que luego se lo pasare al comboBoxMode por eso el Objeto VECTOR ESTA MAZIZO
            
            
           consulta = conectar.prepareStatement("select * from departamentos");//aca selecciono tanto el nombre y el id [para inciializar ambos atributos de mi clase departamento que son el id y el noimbre
           resultados = consulta.executeQuery();
            
            while(resultados.next()){
                 Departamento depas = new Departamento();//EN CADA ITERACION SE IRA CREANDO UN OBJKETP Y LO INICIALIZAR GRACIAS A LA CONSULTA con el el result y despues solamento uso el metodo toString en el ComboBoxModel
                 depas.setId_Departamento(resultados.getInt("id_Departamento"));
                 depas.setNombre(resultados.getString("nombreDepa"));
                 departamentos.add(depas);//en cada iteracion me va instanciar un objeto y luego lo añadira al arreglo de departamentos y esto estabecere en cada parte de mi comboBoxModel 
            }
            
        }catch(Exception exception){
            System.err.println("Error "+exception);
        }
        
        return departamentos;
}
    //2 metodos diferentes para en otro no mostrar el seleccione Departament
     public Vector<Departamento> mostrarDepartamentos2(){
        
        PreparedStatement consulta=null;
        ResultSet resultados = null;
       Vector<Departamento> departamentos = new Vector<Departamento>();
       
        try{
            Conexion con = new Conexion();
            Connection conectar = con.getConnection();
            
            
           consulta = conectar.prepareStatement("select * from departamentos");//aca selecciono tanto el nombre y el id [para inciializar ambos atributos de mi clase departamento que son el id y el noimbre
           resultados = consulta.executeQuery();
            
            while(resultados.next()){
                 Departamento depas = new Departamento();//EN CADA ITERACION SE IRA CREANDO UN OBJKETP Y LO INICIALIZAR GRACIAS A LA CONSULTA con el el result y despues solamento uso el metodo toString en el ComboBoxModel
                 depas.setId_Departamento(resultados.getInt("id_Departamento"));
                 depas.setNombre(resultados.getString("nombreDepa"));
                 departamentos.add(depas);//en cada iteracion me va instanciar un objeto y luego lo añadira al arreglo de departamentos y esto estabecere en cada parte de mi comboBoxModel 
            }
            
        }catch(Exception exception){
            System.err.println("Error "+exception);
        }
        
        return departamentos;
}
    
}
