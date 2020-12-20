
package Modelo.Votantes;

import Modelo.Personas.Persona;
import java.sql.Date;


public class Votante extends Persona{
    private String numeroIdentidad;
    private String departamento;
    private String municpio;
    private int IdVotante;
    private int idMunicipio;
    private int idDepartamento;


    
    
    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public void setEdad(int edad) {
        super.setEdad(edad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getEdad() {
        return super.getEdad(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void setFechaNacimiento(Date fechaNacimiento) {
        super.setFechaNacimiento(fechaNacimiento); //To change body of generated methods, choose Tools | Templates.
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
    public Date getFechaNacimiento() {
        return super.getFechaNacimiento(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setApellidos(String Apellidos) {
        super.setApellidos(Apellidos); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getApellidos() {
        return super.getApellidos(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public void setNumeroIdentidad(String numeroIdentidad) {
        this.numeroIdentidad = numeroIdentidad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicpio() {
        return municpio;
    }

    public void setMunicpio(String municpio) {
        this.municpio = municpio;
    }

    public int getIdVotante() {
        return IdVotante;
    }

    public void setIdVotante(int IdVotante) {
        this.IdVotante = IdVotante;
    }

  
    
   
}
