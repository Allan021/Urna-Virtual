
package MVC;

import Controlador.ControladorInicio;
import Modelo.RegistroCandidatos.Alcalde;
import Modelo.RegistroCandidatos.ConsultasCandidatos;
import Modelo.RegistroCandidatos.PartidoPolitico;
import Modelo.RegistroCandidatos.Presidente;
import Modelo.Votantes.Consultas;
import Modelo.Votantes.Votante;
import Vista.InterfazInicio;
import Vista.Registro;
import Vista.RegistroCandidatos;
import Vista.SalaVotaciones;
import static java.awt.PageAttributes.MediaType.C;


public class IniciarTodo {
    public static void main(String[] args) {
    
    
    InterfazInicio interfaz = new InterfazInicio();
    Controlador.ControladorInicio controlar = new ControladorInicio(interfaz);
    
    controlar.inicarApp();
 
    
    
    
    
    }
    
    
}
