
package Modelo.Personas;

import java.sql.Date;

public class Persona {
    private String nombre;
    private String Apellidos;
    private Date fechaNacimiento;//atributos de cada persona
    private String genero;
    private int edad;
    private String estadoCivil;
    private String nacionalidad;
    private String identidad;
    
    
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getIdentidad() {
        return identidad;
    }

    @Override
    public String toString() {
        return nombre ;//con este metodo toString vamos a implementar el polimorfismo
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }
    
    public int getEdad() {
        return edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    
}
