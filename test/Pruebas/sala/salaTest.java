
package Pruebas.sala;

import Controlador.ControladorResultados;
import Controlador.ControladorSala;
import Modelo.RegistroCandidatos.Alcalde;
import Modelo.RegistroCandidatos.ConsultasCandidatos;
import Modelo.RegistroCandidatos.ConsultasVotaciones;
import Modelo.RegistroCandidatos.Diputado;
import Modelo.RegistroCandidatos.PartidoPolitico;
import Modelo.RegistroCandidatos.Presidente;
import Modelo.Resultados.ConsultasResultados;
import Modelo.Votantes.Votante;
import Vista.InterfazResultados;
import Vista.SalaVotaciones;

public class salaTest {
    public static void main(String[] args) {
         Votante votante = new Votante();
        votante.setIdVotante(49);
        votante.setIdDepartamento(4);
        votante.setIdMunicipio(42);
        votante.setGenero("Femenino");
        votante.setNombre("Paola Isabel");
        votante.setApellidos("Dueñas Diaz");
        votante.setMunicpio("Puerto Lempira");
        votante.setDepartamento("Gracias a Dios");
        
        
    SalaVotaciones sala = new SalaVotaciones();
    PartidoPolitico partido = new PartidoPolitico();
    Alcalde alcalde = new Alcalde();
    Presidente presidente = new Presidente();
    Diputado diputado = new Diputado();
    ConsultasVotaciones modelo = new ConsultasVotaciones();
      ConsultasCandidatos modeloCandidatos = new ConsultasCandidatos();
    
      ControladorSala controlador = new ControladorSala(votante, sala, partido, alcalde, presidente, diputado, modelo, modeloCandidatos);
        controlador.iniciar();
     
    }
    
   
    public static void iniciarResultados() {
        InterfazResultados ventana = new InterfazResultados();
    
    Alcalde alcalde =  new Alcalde();
    
    PartidoPolitico partido = new PartidoPolitico();
    
    Diputado diputado = new Diputado();
    
    ConsultasResultados modelo = new ConsultasResultados();
    
    Presidente presidente = new Presidente();
    
    ControladorResultados controlador = new ControladorResultados(ventana, presidente, alcalde, diputado, modelo, partido);
    
    controlador.inciar();
    }
}
