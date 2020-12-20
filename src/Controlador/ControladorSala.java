package Controlador;

import Modelo.RegistroCandidatos.Alcalde;
import Modelo.RegistroCandidatos.Categoria;
import Modelo.RegistroCandidatos.ConsultasCandidatos;
import Modelo.RegistroCandidatos.ConsultasValidaciones;
import Modelo.RegistroCandidatos.ConsultasVotaciones;
import Modelo.RegistroCandidatos.Diputado;
import Modelo.RegistroCandidatos.ModeloBusqueda;
import Modelo.RegistroCandidatos.PartidoPolitico;
import Modelo.RegistroCandidatos.Presidente;
import Modelo.Votantes.Consultas;
import Modelo.Votantes.Votante;
import Vista.InterfazInicio;
import Vista.SalaVotaciones;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import jdk.nashorn.internal.runtime.ListAdapter;

public class ControladorSala implements FocusListener, MouseListener, ActionListener, KeyListener, ItemListener  {

    Votante votante;
    SalaVotaciones sala;
    PartidoPolitico partido;
    Alcalde alcalde;
    Presidente presidente;
    Diputado diputado;
    ConsultasVotaciones modelo;
    ConsultasCandidatos modeloCandidatos;
    int opcionA = 1;
    int opcionP = 1;
    int opcionD = 1;
    boolean votoPresidnete = false;
    boolean votoNDiputados = false;
    boolean votoAlaclade = false;
     boolean votoPresidneteN = false;
    boolean votoNDiputadosN = false;
    boolean votoAlacladeN = false;
    private ArrayList<Diputado> listaDiputados = new ArrayList<Diputado>();//declarando el array de diputados comoa tributos para usarlo en todos lados
    private ArrayList<Integer> idDiputados = new ArrayList<>();

    public ControladorSala(Votante votante, SalaVotaciones sala, PartidoPolitico partido, Alcalde alcalde, Presidente presidente, Diputado diputado, ConsultasVotaciones modelo, ConsultasCandidatos modeloCandidatos) {
        this.votante = votante;
        this.sala = sala;
        this.partido = partido;
        this.alcalde = alcalde;
        this.presidente = presidente;
        this.diputado = diputado;
        this.modelo = modelo;
        this.modeloCandidatos = modeloCandidatos;
         salirApp();
        separadores();
        elementosInvisibles();
        agregarListas();
        eventos();
        
    }
     
    public void iniciar() {
        sala.setLocationRelativeTo(null);
        sala.setVisible(true);
        idDiputados.add(0);//para empezar a comparar esto iniciara en 0
    }

    private void eventos() {
        eventosFocus();
        eventosLabel();
        eventosListas();
        eventosBotones();

    }
    private void salirApp(){
        Consultas votantes = new Consultas();
        int votos = votantes.verificarUsuarioSacar2(votante);
        
       
        if(votos > 0 ||( votoAlacladeN && votoNDiputadosN && votoPresidneteN )){
           
            JOptionPane.showMessageDialog(null, "Usted ya ha hecho todos sus votos correspondientes", "", 0, imagenNice("\\imagenes\\waring .png", 40, 40));
            JOptionPane.showMessageDialog(null,votante.getNombre() + " le deseamos que la pase bien con su familia", "¡¡ Felices Fiestas !!", 0, imagenNice("\\imagenes\\adios.png", 40, 40));
            
                
                sala.dispose();
                InterfazInicio interfaz = new InterfazInicio();
                Controlador.ControladorInicio controlar = new ControladorInicio(interfaz);

                controlar.inicarApp();
        }
        
        
    }

    public void eventosBotones() {
        sala.botonBuscar.addActionListener(this);
        sala.botonVotar1.addActionListener(this);
        sala.botonVotarNullo.addActionListener(this);
    }

   
    public void elementosInvisibles() {
        String rutaHombre = "C:\\Users\\Allan\\Documents\\NetBeansProjects\\Elecciones2021\\src\\Controlador\\imagenes\\hombre (1).jpg";
        String rutaMujer = "C:\\Users\\Allan\\Documents\\NetBeansProjects\\Elecciones2021\\src\\Controlador\\imagenes\\mujer (1).png";
        if (votante.getGenero().equals("Masculino")) {
            sala.imagenUsuario.setIcon(new ImageIcon(rutaHombre));
        } else if (votante.getGenero().equals("Femenino")) {
            sala.imagenUsuario.setIcon(new ImageIcon(rutaMujer));

        }

        sala.NombreUsuario.setText(votante.getNombre() + " " + votante.getApellidos());
        sala.partidos.setVisible(false);
        sala.listaPartidos.setVisible(false);
        sala.campoMunicipio.setVisible(false);
        sala.campoDepartamento.setVisible(false);
        sala.municipio.setVisible(false);
        sala.departamento.setVisible(false);
        sala.listaCandidatos.setVisible(false);
        sala.Candidato1.setVisible(false);
        sala.idPresidente.setVisible(false);
        sala.idAlcalde.setVisible(false);
        sala.idDiputado.setVisible(false);

    }

    private void separadores() {
        colorSeparador(sala.jSeparator1);
        colorSeparador(sala.jSeparator2);
        colorSeparador(sala.jSeparator3);
    }

    public void colorSeparador(JSeparator separar) {
        separar.setForeground(new Color(160, 160, 160));
    }

    private void eventosListas() {
        sala.listaBusqueda.addItemListener(this);
        sala.listacategoria.addItemListener(this);
        sala.listaCandidatos.addItemListener(this);
        sala.listaPartidos.addItemListener(this);
    }

    private void eventosFocus() {
        sala.listaCandidatos.addFocusListener(this);
        sala.listacategoria.addFocusListener(this);
        sala.listaBusqueda.addFocusListener(this);
        sala.listaPartidos.addFocusListener(this);

        sala.buscar.addFocusListener(this);
        sala.campoGenero.addFocusListener(this);
        sala.campoNacionalidad.addFocusListener(this);
        sala.campoNombre.addFocusListener(this);
        sala.campoPartido1.addFocusListener(this);

    }

    private void eventosLabel() {
        sala.MENOS.addMouseListener(this);
        sala.cerrar.addMouseListener(this);
        sala.buscar.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sala.botonBuscar) {
            Color blanco = new Color(200, 205, 208);
            int indice = sala.listacategoria.getSelectedIndex();

            switch (indice) {
                case 0:
                    if (comprobarCampos(sala.buscar, "Nombre Candidato", "Por favor ingresa el nombre del Presidente")) {
                    } else {

                        presidente = modelo.buscarNombre(sala.buscar.getText());

                        if (presidente == null) {//si no se encontro ningun presidente
                            bordesErrores(sala.buscar);
                            JOptionPane.showMessageDialog(sala.buscar, "Ese Presidente no esta registrado", "No existe ese candidato", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                            limpiarCajas();
                        } else {
                            //estableciendo los campos
                            sala.campoNombre.setText(presidente.getNombre());
                            sala.campoNombre.setForeground(blanco);

                            sala.campoNacionalidad.setText(presidente.getNacionalidad());//obteniendo todo y estableciendolo en los campos
                            sala.campoNacionalidad.setForeground(blanco);

                            sala.campoGenero.setText(presidente.getGenero());
                            sala.campoGenero.setForeground(blanco);

                            sala.idPresidente.setText(String.valueOf(presidente.getId_Presidende()));

                            sala.jTextArea1.setText(presidente.getDiscurso());
                            sala.jTextArea1.setForeground(blanco);

                            PartidoPolitico partido1 = new PartidoPolitico();

                            partido = partido1.partido(presidente.getId_Partido());

                            BufferedImage imagx = modeloCandidatos.imagenPartidos(partido);//le mando todos los campos incializados

                            sala.imagenPartido.setIcon(new ImageIcon(imagx));

                            sala.campoPartido1.setText(partido.getNombre());
                            sala.campoPartido1.setForeground(blanco);

                            sala.imagenPresidente.setIcon(new ImageIcon(presidente.getImagen()));

                        }
                    }

                    break;

                case 1:

                    if (comprobarCampos(sala.buscar, "Nombre Candidato", "Por favor ingresa el nombre del Diputado")) {

                    } else {

                        diputado = modelo.busacrNombreD(sala.buscar.getText(), votante.getIdDepartamento());//sel le mostraran los diputados de este mismo departamento

                        if (diputado == null) {//si no se encontro ningun presidente
                            bordesErrores(sala.buscar);
                            JOptionPane.showMessageDialog(sala.buscar, "Ese Diputado no esta registrado", "No existe ese candidato", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                            limpiarCajas();

                        } else {
                            //estableciendo los campos
                            sala.campoNombre.setText(diputado.getNombre());
                            sala.campoNombre.setForeground(blanco);

                            sala.campoNacionalidad.setText(diputado.getNacionalidad());//obteniendo todo y estableciendolo en los campos
                            sala.campoNacionalidad.setForeground(blanco);

                            sala.campoGenero.setText(diputado.getGenero());
                            sala.campoGenero.setForeground(blanco);

                            sala.idDiputado.setText(String.valueOf(diputado.getIdDiputado()));

                            PartidoPolitico partido1 = new PartidoPolitico();

                            partido = partido1.partido(diputado.getId_Partido());

                            BufferedImage imagx = modeloCandidatos.imagenPartidos(partido);//le mando todos los campos incializados

                            sala.imagenPartido.setIcon(new ImageIcon(imagx));

                            sala.campoPartido1.setText(partido.getNombre());
                            sala.campoPartido1.setForeground(blanco);

                            sala.imagenPresidente.setIcon(new ImageIcon(diputado.getImagen()));
                            sala.campoDepartamento.setText(votante.getDepartamento());

                        }
                    }

                    break;

                case 2:
                    if (comprobarCampos(sala.buscar, "Nombre Candidato", "Por favor ingresa el nombre del Alcalde")) {

                    } else {

                        alcalde = modelo.buscarNombreA(sala.buscar.getText(), votante.getIdMunicipio());//sel le mostraran los alcaldes de este mismo departamento

                        if (alcalde == null) {//si no se encontro ningun presidente
                            bordesErrores(sala.buscar);
                            JOptionPane.showMessageDialog(sala.buscar, "Ese Alcalde no esta registrado", "No existe ese candidato", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                            limpiarCajas();

                        } else {
                            //estableciendo los campos
                            sala.campoNombre.setText(alcalde.getNombre());
                            sala.campoNombre.setForeground(blanco);

                            sala.campoNacionalidad.setText(alcalde.getNacionalidad());//obteniendo todo y estableciendolo en los campos
                            sala.campoNacionalidad.setForeground(blanco);

                            sala.campoGenero.setText(alcalde.getGenero());
                            sala.campoGenero.setForeground(blanco);

                            sala.idAlcalde.setText(String.valueOf(alcalde.getIdAlcalde()));

                            PartidoPolitico partido1 = new PartidoPolitico();

                            partido = partido1.partido(alcalde.getId_Partido());

                            BufferedImage imagx = modeloCandidatos.imagenPartidos(partido);//le mando todos los campos incializados

                            sala.imagenPartido.setIcon(new ImageIcon(imagx));

                            sala.campoPartido1.setText(partido.getNombre());
                            sala.campoPartido1.setForeground(blanco);

                            sala.imagenPresidente.setIcon(new ImageIcon(alcalde.getImagen()));
                            sala.campoDepartamento.setText(votante.getDepartamento());

                            sala.campoMunicipio.setText(votante.getMunicpio());

                        }
                    }

                    break;

                default:
                    break;

            }

        } else if (e.getSource().equals(sala.botonVotar1)) {
            int indiceBusqueda = sala.listaBusqueda.getSelectedIndex();
            
            switch (indiceBusqueda) {
                case 0://Caso principal dependiendo del metodo de busqueda

                    int indice = sala.listacategoria.getSelectedIndex();

                    switch (indice) {
                        case 0:
                            if (comprobarCampos(sala.buscar, "Nombre Candidato", "Por favor ingresa el nombre del Presidente")) {
                            } else {
                                if (sala.idPresidente.getText().equals("")) {
                                    //si el campo id  esta vacio es porque no hay nadie
                                    JOptionPane.showMessageDialog(sala.buscar, "No hay ningun presidente para votar", "No se ha encontrado presidente", 0, imagenNice("\\imagenes\\error.png", 40, 40));

                                } else {
                                    if (!votoPresidneteN) {
                                        if (!votoPresidnete) {//si no ha votado por un presidente

                                            opcionP = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea votar por " + sala.campoNombre.getText(), "El futuro de Honduras esta en juego", JOptionPane.YES_NO_OPTION, -1, imagenNice("\\imagenes\\interrogacion.png", 40, 40));
                                            if (opcionP == 0) {
                                                modelo.votarPresidnete(votante, Integer.parseInt(sala.idPresidente.getText()));
                                                JOptionPane.showMessageDialog(null, "Usted ha votado por " + sala.campoNombre.getText(), "Voto ingresado correctamente", JOptionPane.PLAIN_MESSAGE, imagenNice("\\imagenes\\nice.png", 40, 40));
                                                votoPresidnete = true;
                                                limpiarCajasVotar();
                                            }
                                        } else {
                                            String nombre = modelo.nombrePresidente(votante);
                                            JOptionPane.showMessageDialog(null, "Usted ya registro su voto por " + nombre, "!! No se puede votar 2 veces por un presidente ¡¡", 0, imagenNice("\\imagenes\\waring .png", 40, 40));
                                            limpiarCajasVotar();
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null,  votante.getNombre() + " usted ya escogio que no votaría por ningún presidente","Ya es demasiado tarde", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                    limpiarCajasVotar();
                                    }

                                }
                            }

                            break;

                        case 1:
                            if (comprobarCampos(sala.buscar, "Nombre Candidato", "Por favor ingresa el nombre del Diputado")) {
                            } else {
                                if (sala.idDiputado.getText().equals("")) {
                                    //si el campo id  esta vacio es porque no hay nadie
                                    JOptionPane.showMessageDialog(sala.buscar, "No hay ningun diputado para votar", "No se ha encontrado diputado", 0, imagenNice("\\imagenes\\error.png", 40, 40));

                                } else {

                                    if (!votoNDiputadosN) {
                                        if (listaDiputados.size() != modelo.LimiteDiputados(votante.getIdDepartamento())) {  //estyo se ejecutara mientras l array de diputados no sea el limite alcalnzado orr el departamento
                                            opcionD = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea votar por " + sala.campoNombre.getText(), "El futuro de Honduras esta en juego", JOptionPane.YES_NO_OPTION, -1, imagenNice("\\imagenes\\interrogacion.png", 40, 40));

                                            if (opcionD == 0) {
                                                Diputado dip = modelo.busacrNombreD(sala.campoNombre.getText(), votante.getIdDepartamento());//vamos a obtener ese diputado que el usuario voot

                                                if (!idDiputados.contains(dip.getIdDiputado())) {//nos damos cuenta si ya voto poreste dipuitado

                                                    listaDiputados.add(dip);//Añadiendo un diputado al arrayList 
                                                    idDiputados.add(dip.getIdDiputado());//ara darnos cuenta si el ususario ya voto por este candidato le obtenemos el id y verifiicamops depues

                                                    modelo.votarDiputado(votante, Integer.parseInt(sala.idDiputado.getText()));
                                                    JOptionPane.showMessageDialog(null, "Usted ha votado por " + sala.campoNombre.getText(), "Voto ingresado correctamente", JOptionPane.PLAIN_MESSAGE, imagenNice("\\imagenes\\nice.png", 40, 40));

                                                    limpiarCajasVotar();

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Usted ya ha votado por se candidato", "!! Acá no habre fraude ¡¡", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                                    limpiarCajasVotar();
                                                }

                                            }

                                        } else {
                                            JOptionPane.showMessageDialog(null, "En el departamento de  " + votante.getDepartamento() + " solo se permiten " + modelo.LimiteDiputados(votante.getIdDepartamento()) + " diputados por los que usted puede votar", "Ya no puede votar por mas diputados en su departamento", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                            limpiarCajasVotar();
                                            votoNDiputados = true;
                                            
                                            if(votoNDiputados){
                                           ConsultasValidaciones sacar = new ConsultasValidaciones();
                                           sacar.sacarUsuarioDiputado(votante);
                                            }
                                        }
                                    } else {
                                  JOptionPane.showMessageDialog(null,  votante.getNombre() + " usted ya escogio que no votaría por ningún diputado","Ya es demasiado tarde", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                    limpiarCajasVotar();
                                    }
                                }

                            }
                            break;

                        case 2:
                            if (comprobarCampos(sala.buscar, "Nombre Candidato", "Por favor ingresa el nombre del Alcalde")) {
                            } else {
                                if (sala.idAlcalde.getText().equals("")) {
                                    //si el campo id  esta vacio es porque no hay nadie
                                    JOptionPane.showMessageDialog(sala.buscar, "No hay ningun Alcalde para votar", "No se ha encontrado alcalde", 0, imagenNice("\\imagenes\\error.png", 40, 40));

                                } else {
                                    if(!votoAlacladeN){
                                    if(!votoAlaclade){//si no ha votado por un palcalde
                                    
                                    opcionA = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea votar por " + sala.campoNombre.getText(), "El futuro de Honduras esta en juego", JOptionPane.YES_NO_OPTION, -1, imagenNice("\\imagenes\\interrogacion.png", 40, 40));
                                    if (opcionA == 0) {
                                        modelo.votarAlcalde(votante, Integer.parseInt(sala.idAlcalde.getText()));
                                        JOptionPane.showMessageDialog(null, "Usted ha votado por " + sala.campoNombre.getText(), "Voto ingresado correctamente", JOptionPane.PLAIN_MESSAGE, imagenNice("\\imagenes\\nice.png", 40, 40));
                                        votoAlaclade = true;
                                        limpiarCajasVotar();
                                    }
                                    }else{
                                 String nombre = modelo.nombreAlcalde(votante);//esto es solo para mostrar por quien voto el usuario
                                 JOptionPane.showMessageDialog(null, "Usted ya registro su voto por " + nombre, "!! No se puede votar 2 veces por un alcalde ¡¡", 0, imagenNice("\\imagenes\\waring .png", 40, 40));
                                        limpiarCajasVotar();
                                    }                                
                                
                                }else{
                             JOptionPane.showMessageDialog(null,  votante.getNombre() + " usted ya escogio que no votaría por ningún alcalde","Ya es demasiado tarde", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                    limpiarCajasVotar();            
                                  }
                                
                            }
                            }

                            break;

                        default:
                            break;

                    }

                    break;

                //Caso que sea por lista
                case 1:

                    int indice1 = sala.listacategoria.getSelectedIndex();

                    switch (indice1) {
                        case 0:

                            if (comprobarListas(sala.listaPartidos, "Seleccione un partido para buscar al presidente", "No se ha seleccionado Partido")) {
                            } else {
                                if (sala.idPresidente.getText().equals("")) {
                                    //si el campo id  esta vacio es porque no hay nadie
                                    JOptionPane.showMessageDialog(sala.listaCandidatos, "Seleccione un presidente", "No se ha seleccionado Presidente", 0, imagenNice("\\imagenes\\error.png", 40, 40));

                                } else {
                                    if (!votoPresidneteN) {
                                        if (!votoPresidnete) {//si no ha votado por un presidente

                                            opcionP = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea votar por " + sala.campoNombre.getText(), "El futuro de Honduras esta en juego", JOptionPane.YES_NO_OPTION, -1, imagenNice("\\imagenes\\interrogacion.png", 40, 40));
                                            if (opcionP == 0) {
                                                modelo.votarPresidnete(votante, Integer.parseInt(sala.idPresidente.getText()));
                                                JOptionPane.showMessageDialog(null, "Usted ha votado por " + sala.campoNombre.getText(), "Voto ingresado correctamente", JOptionPane.PLAIN_MESSAGE, imagenNice("\\imagenes\\nice.png", 40, 40));
                                                votoPresidnete = true;
                                                limpiarCajasVotar();
                                            }
                                        } else {
                                            String nombre = modelo.nombrePresidente(votante);
                                            JOptionPane.showMessageDialog(null, "Usted ya registro su voto por " + nombre, "!! No se puede votar 2 veces por un presidente ¡¡", 0, imagenNice("\\imagenes\\waring .png", 40, 40));
                                            limpiarCajas2();
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null,  votante.getNombre() + " usted ya escogio que no votaría por ningún presidente","Ya es demasiado tarde", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                    limpiarCajas();
                                    }

                                }
                            }

                            break;

                        case 1:
                            if (comprobarListas(sala.listaPartidos, "Seleccione un partido para buscar al Diputado", "No se ha seleccionado Partido")) {
                            } else {
                                if (sala.idDiputado.getText().equals("")) {
                                    //si el campo id  esta vacio es porque no hay nadie
                                    JOptionPane.showMessageDialog(sala.listaCandidatos, "Seleccione un Diputado", "No se ha seleccionado Diputado", 0, imagenNice("\\imagenes\\error.png", 40, 40));

                                } else {

                                    if (!votoNDiputadosN) {
                                        if (listaDiputados.size() != modelo.LimiteDiputados(votante.getIdDepartamento())) {  //estyo se ejecutara mientras l array de diputados no sea el limite alcalnzado orr el departamento
                                            opcionD = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea votar por " + sala.campoNombre.getText(), "El futuro de Honduras esta en juego", JOptionPane.YES_NO_OPTION, -1, imagenNice("\\imagenes\\interrogacion.png", 40, 40));

                                            if (opcionD == 0) {
                                                Diputado dip = modelo.busacrNombreD(sala.campoNombre.getText(), votante.getIdDepartamento());//vamos a obtener ese diputado que el usuario voot

                                                if (!idDiputados.contains(dip.getIdDiputado())) {//nos damos cuenta si ya voto poreste dipuitado

                                                    listaDiputados.add(dip);//Añadiendo un diputado al arrayList 
                                                    idDiputados.add(dip.getIdDiputado());//ara darnos cuenta si el ususario ya voto por este candidato le obtenemos el id y verifiicamops depues

                                                    modelo.votarDiputado(votante, Integer.parseInt(sala.idDiputado.getText()));
                                                    JOptionPane.showMessageDialog(null, "Usted ha votado por " + sala.campoNombre.getText(), "Voto ingresado correctamente", JOptionPane.PLAIN_MESSAGE, imagenNice("\\imagenes\\nice.png", 40, 40));

                                                    limpiarCajas();

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Usted ya ha votado por se candidato", "!! Acá no habre fraude ¡¡", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                                    limpiarCajas();
                                                }

                                            }

                                        } else {
                                            JOptionPane.showMessageDialog(null, "En el departamento de  " + votante.getDepartamento() + " solo se permiten " + modelo.LimiteDiputados(votante.getIdDepartamento()) + " diputados por los que usted puede votar", "Ya no puede votar por mas diputados en su departamento", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                            limpiarCajas();
                                            votoNDiputados = true;
                                               if(votoNDiputados){
                                           ConsultasValidaciones sacar = new ConsultasValidaciones();
                                           sacar.sacarUsuarioDiputado(votante);
                                            }
                                        }
                                    } else {
                                  JOptionPane.showMessageDialog(null,  votante.getNombre() + " usted ya escogio que no votaría por ningún diputado","Ya es demasiado tarde", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                    limpiarCajas2();
                                    }
                                }
                            }
                            break;

                        case 2:
                            if (comprobarListas(sala.listaPartidos, "Seleccione un partido para buscar al Alcalde", "No se ha seleccionado Partido")) {
                            } else {
                                if (sala.idAlcalde.getText().equals("")) {
                                    //si el campo id  esta vacio es porque no hay nadie
                                    JOptionPane.showMessageDialog(sala.listaCandidatos, "Seleccione un Alcalde", "No se ha seleccionado Alcalde", 0, imagenNice("\\imagenes\\error.png", 40, 40));

                                } else {
                                    if(!votoAlacladeN){
                                    if(!votoAlaclade){//si no ha votado por un palcalde
                                    
                                    opcionA = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea votar por " + sala.campoNombre.getText(), "El futuro de Honduras esta en juego", JOptionPane.YES_NO_OPTION, -1, imagenNice("\\imagenes\\interrogacion.png", 40, 40));
                                    if (opcionA == 0) {
                                        modelo.votarAlcalde(votante, Integer.parseInt(sala.idAlcalde.getText()));
                                        JOptionPane.showMessageDialog(null, "Usted ha votado por " + sala.campoNombre.getText(), "Voto ingresado correctamente", JOptionPane.PLAIN_MESSAGE, imagenNice("\\imagenes\\nice.png", 40, 40));
                                        votoAlaclade = true;
                                        limpiarCajasVotar();
                                    }
                                    }else{
                                 String nombre = modelo.nombreAlcalde(votante);//esto es solo para mostrar por quien voto el usuario
                                 JOptionPane.showMessageDialog(null, "Usted ya registro su voto por " + nombre, "!! No se puede votar 2 veces por un alcalde ¡¡", 0, imagenNice("\\imagenes\\waring .png", 40, 40));
                                        limpiarCajas();
                                    }                                
                                
                                }else{
                             JOptionPane.showMessageDialog(null,  votante.getNombre() + " usted ya escogio que no votaría por ningún alcalde","Ya es demasiado tarde", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                    limpiarCajas();            
                                  }
                                
                            }

                            }
                            break;

                        default:
                            break;

                    }

                    break;

                //En el caso sea por Lista
                case 2:
                    int indice2 = sala.listacategoria.getSelectedIndex();

                    switch (indice2) {
                        case 0:
                            if (comprobarListas(sala.listaCandidatos, "Seleccione un presidente", "No se ha seleccionado Presidente")) {
                            } else {
                                if (sala.idPresidente.getText().equals("")) {
                                    //si el campo id  esta vacio es porque no hay nadie
                                    JOptionPane.showMessageDialog(sala.listaCandidatos, "Seleccione un presidente", "No se ha seleccionado Presidente", 0, imagenNice("\\imagenes\\error.png", 40, 40));

                                } else {
                                    if (!votoPresidneteN) {
                                        if (!votoPresidnete) {//si no ha votado por un presidente

                                            opcionP = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea votar por " + sala.campoNombre.getText(), "El futuro de Honduras esta en juego", JOptionPane.YES_NO_OPTION, -1, imagenNice("\\imagenes\\interrogacion.png", 40, 40));
                                            if (opcionP == 0) {
                                                modelo.votarPresidnete(votante, Integer.parseInt(sala.idPresidente.getText()));
                                                JOptionPane.showMessageDialog(null, "Usted ha votado por " + sala.campoNombre.getText(), "Voto ingresado correctamente", JOptionPane.PLAIN_MESSAGE, imagenNice("\\imagenes\\nice.png", 40, 40));
                                                votoPresidnete = true;
                                                
                                                limpiarCajas2();
                                            }
                                        } else {
                                            String nombre = modelo.nombrePresidente(votante);
                                            JOptionPane.showMessageDialog(null, "Usted ya registro su voto por " + nombre, "!! No se puede votar 2 veces por un presidente ¡¡", 0, imagenNice("\\imagenes\\waring .png", 40, 40));
                                            limpiarCajas();
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null,  votante.getNombre() + " usted ya escogio que no votaría por ningún presidente","Ya es demasiado tarde", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                    limpiarCajas();
                                    }

                                }

                            }

                            break;

                        case 1:
                            if (comprobarListas(sala.listaCandidatos, "Seleccione un Diputado", "No se ha seleccionado Diputado")) {
                            } else {
                                if (sala.idDiputado.getText().equals("")) {
                                    //si el campo id  esta vacio es porque no hay nadie
                                    JOptionPane.showMessageDialog(sala.listaCandidatos, "Seleccione un Diputado", "No se ha seleccionado Diputado", 0, imagenNice("\\imagenes\\error.png", 40, 40));

                                }  else {

                                    if (!votoNDiputadosN) {
                                        if (listaDiputados.size() != modelo.LimiteDiputados(votante.getIdDepartamento())) {  //estyo se ejecutara mientras l array de diputados no sea el limite alcalnzado orr el departamento
                                            opcionD = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea votar por " + sala.campoNombre.getText(), "El futuro de Honduras esta en juego", JOptionPane.YES_NO_OPTION, -1, imagenNice("\\imagenes\\interrogacion.png", 40, 40));

                                            if (opcionD == 0) {
                                                Diputado dip = modelo.busacrNombreD(sala.campoNombre.getText(), votante.getIdDepartamento());//vamos a obtener ese diputado que el usuario voot

                                                if (!idDiputados.contains(dip.getIdDiputado())) {//nos damos cuenta si ya voto poreste dipuitado

                                                    listaDiputados.add(dip);//Añadiendo un diputado al arrayList 
                                                    idDiputados.add(dip.getIdDiputado());//ara darnos cuenta si el ususario ya voto por este candidato le obtenemos el id y verifiicamops depues

                                                    modelo.votarDiputado(votante, Integer.parseInt(sala.idDiputado.getText()));
                                                    JOptionPane.showMessageDialog(null, "Usted ha votado por " + sala.campoNombre.getText(), "Voto ingresado correctamente", JOptionPane.PLAIN_MESSAGE, imagenNice("\\imagenes\\nice.png", 40, 40));

                                                    limpiarCajas2();

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Usted ya ha votado por se candidato", "!! Acá no habre fraude ¡¡", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                                    limpiarCajas2();
                                                }

                                            }

                                        } else {
                                            JOptionPane.showMessageDialog(null, "En el departamento de  " + votante.getDepartamento() + " solo se permiten " + modelo.LimiteDiputados(votante.getIdDepartamento()) + " diputados por los que usted puede votar", "Ya no puede votar por mas diputados en su departamento", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                            limpiarCajas2();
                                            votoNDiputados = true;
                                              if(votoNDiputados){
                                           ConsultasValidaciones sacar = new ConsultasValidaciones();
                                           sacar.sacarUsuarioDiputado(votante);
                                            }
                                        }
                                    } else {
                                  JOptionPane.showMessageDialog(null,  votante.getNombre() + " usted ya escogio que no votaría por ningún diputado","Ya es demasiado tarde", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                    limpiarCajas2();
                                    }
                                }

                            }

                            break;

                        case 2:
                            if (comprobarListas(sala.listaCandidatos, "Seleccione un Alcalde", "No se ha seleccionado Alcalde")) {
                            } else {
                                if (sala.idAlcalde.getText().equals("")) {
                                    //si el campo id  esta vacio es porque no hay nadie
                                    JOptionPane.showMessageDialog(sala.listaCandidatos, "Seleccione un Alcalde", "No se ha seleccionado Alcalde", 0, imagenNice("\\imagenes\\error.png", 40, 40));

                                } else {
                                    if(!votoAlacladeN){
                                    if(!votoAlaclade){//si no ha votado por un palcalde
                                    
                                    opcionA = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea votar por " + sala.campoNombre.getText(), "El futuro de Honduras esta en juego", JOptionPane.YES_NO_OPTION, -1, imagenNice("\\imagenes\\interrogacion.png", 40, 40));
                                    if (opcionA == 0) {
                                        modelo.votarAlcalde(votante, Integer.parseInt(sala.idAlcalde.getText()));
                                        JOptionPane.showMessageDialog(null, "Usted ha votado por " + sala.campoNombre.getText(), "Voto ingresado correctamente", JOptionPane.PLAIN_MESSAGE, imagenNice("\\imagenes\\nice.png", 40, 40));
                                        votoAlaclade = true;
                                        limpiarCajasVotar();
                                    }
                                    }else{
                                 String nombre = modelo.nombreAlcalde(votante);//esto es solo para mostrar por quien voto el usuario
                                 JOptionPane.showMessageDialog(null, "Usted ya registro su voto por " + nombre, "!! No se puede votar 2 veces por un alcalde ¡¡", 0, imagenNice("\\imagenes\\waring .png", 40, 40));
                                        limpiarCajas2();
                                    }                                
                                
                                }else{
                             JOptionPane.showMessageDialog(null,  votante.getNombre() + " usted ya escogio que no votaría por ningún alcalde","Ya es demasiado tarde", 0, imagenNice("\\imagenes\\error.png", 40, 40));
                                    limpiarCajas2();            
                                  }
                                
                            }

                            }
                            break;

                    }
             salirApp();
            }

           
        }else if(e.getSource() == sala.botonVotarNullo){//si le dio en votar null
             int indice = sala.listacategoria.getSelectedIndex();//aca es solo para no actaulizar esto
            ConsultasValidaciones consultas = new ConsultasValidaciones() ;
             switch(indice){
                 case 0:
                     if(!votoPresidnete){
                    if(!votoPresidneteN){ 
                     
                 opcionP = JOptionPane.showConfirmDialog(null, "¿Está seguro que no quiere votar por ningún presidente ?", "Eso no lo hacen los buenos ciudadanos", JOptionPane.YES_NO_OPTION, -1, imagenNice("\\imagenes\\interrogacion.png", 40, 40));
                   
                 if (opcionP == 0) {
                                 JOptionPane.showMessageDialog(null, "Por eso siempre gana JOH", " ¡¡ Despues no se arrepienta !!", 0, imagenNice("\\imagenes\\enojo.png", 40, 40));
                                modelo.votarPresidnetenNulo(votante, 0);
                                 votoPresidneteN = true;
                                 limpiarCajasVotar();
                             }

                         } else {

                             JOptionPane.showMessageDialog(null, votante.getNombre() + " usted ya escogio que no votaria por ningún presidente", "¡¡ Ya nos quedo claro !!", 0, imagenNice("\\imagenes\\error.png", 40, 40));

                         }
                     } else {
                         String nombre = modelo.nombrePresidente(votante);
                         JOptionPane.showMessageDialog(null, "Usted ya registro su voto por " + nombre, "Ya no se puede votar nulo", 0, imagenNice("\\imagenes\\waring .png", 40, 40));
                         limpiarCajasVotar();
                     }

                     break;

                 case 1:
                     
                     if(!votoNDiputados){
                     if (!votoNDiputadosN) {

                         opcionD = JOptionPane.showConfirmDialog(null, "¿Está seguro que no quiere votar por ningún Diputado ?", "Eso no lo hacen los buenos ciudadanos", JOptionPane.YES_NO_OPTION, -1, imagenNice("\\imagenes\\interrogacion.png", 40, 40));

                         if (opcionD == 0) {
                      JOptionPane.showMessageDialog(null, "Por eso siempre tenemos inútiles en el congreso", " ¡¡ Despues no se arrepienta !!", 0, imagenNice("\\imagenes\\enojo.png", 40, 40));   
                     
                      votoNDiputadosN = true;
                     limpiarCajasVotar();
                     modelo.votarDiputadoNull(votante, 0);
                             
                   }
                     }else{
              
                     JOptionPane.showMessageDialog(null, votante.getNombre() + " usted ya escogio que no votaria por ningún diputado", "¡¡ Ya nos quedo claro !!", 0, imagenNice("\\imagenes\\error.png", 40, 40));
  
  
                     }
                   
                }else{
                        JOptionPane.showMessageDialog(null, "Usted ya registro todos sus votos por los diputados ","Ya no se puede votar nulo", 0, imagenNice("\\imagenes\\waring .png", 40, 40)); 
                    } 
                     
                     
                     break;
                     
                      case 2:
                          if(!votoAlaclade){
                     if(!votoAlacladeN){ 
                     
                 opcionA = JOptionPane.showConfirmDialog(null, "¿Está seguro que no quiere votar por ningún alcalde ?", "Eso no lo hacen los buenos ciudadanos", JOptionPane.YES_NO_OPTION, -1, imagenNice("\\imagenes\\interrogacion.png", 40, 40));
                   
                 if (opcionA == 0) {
                      JOptionPane.showMessageDialog(null, "Por eso nunca tendran buenas calles", " ¡¡ Despues no se arrepienta !!", 0, imagenNice("\\imagenes\\enojo.png", 40, 40));   
                      votoAlacladeN = true;
                     limpiarCajasVotar();
                     modelo.votarAlcaldeNull(votante, 0);
                   }
                   
                }else{
                 
                        JOptionPane.showMessageDialog(null,votante.getNombre() + " usted ya escogio que no votaria por ningún alcalde", "¡¡ Ya nos quedo claro !!", 0, imagenNice("\\imagenes\\error.png", 40, 40));

                    } 
                   
                          }else{
                               String nombre = modelo.nombreAlcalde(votante);
                         JOptionPane.showMessageDialog(null, "Usted ya registro su voto por " + nombre, "Ya no se puede votar nulo", 0, imagenNice("\\imagenes\\waring .png", 40, 40));
                         limpiarCajasVotar();
                          }
                     
                     break;
                     
                      default:
                          break;
             }
            salirApp();
        }

    }//final del AccionListener

    public boolean comprobarCampos(JTextField campo, String placeHolder, String mensaje) {

        if (campo.getText().equals("")
                || campo.getText().trim().equals(placeHolder)) {
            bordesErrores(campo);
            JOptionPane.showMessageDialog(campo, mensaje, "ERROR", 0, imagenNice("\\imagenes\\error.png", 40, 40));
            return true;
        } else {

            return false;
        }

    }

    public Icon imagenNice(String path, int ancho, int alto) {
        Icon imagen = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().
                getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH));

        return imagen;
    }

    @Override
    public void focusGained(FocusEvent e) {
        anadirFocusEnable(e, sala.listaCandidatos);
        anadirFocusEnable(e, sala.listaBusqueda);
        anadirFocusEnable(e, sala.listacategoria);
        anadirFocusEnable(e, sala.listaPartidos);
        //campo nombre
        anadirFocusGainedCampos(e, sala.buscar, "Nombre Candidato");
        anadirFocusGainedCampos(e, sala.campoGenero, "");
        anadirFocusGainedCampos(e, sala.campoNacionalidad, "");
        anadirFocusGainedCampos(e, sala.campoPartido1, "");
        anadirFocusGainedCampos(e, sala.campoNombre, "");

        anadirFocusGainedCampos2(e, sala.jTextArea1, "Discurso Presidencial");

    }

    @Override
    public void focusLost(FocusEvent e) {
        anadirFocuslost(e, sala.listaCandidatos);
        anadirFocuslost(e, sala.listaBusqueda);
        anadirFocuslost(e, sala.listacategoria);

        anadirFocuslostCampos(e, sala.buscar, "Nombre Candidato");
        anadirFocuslostCampos(e, sala.campoGenero, "");
        anadirFocuslostCampos(e, sala.campoNacionalidad, "");
        anadirFocuslostCampos(e, sala.campoPartido1, "");
        anadirFocuslostCampos(e, sala.campoNombre, "");
        anadirFocuslostCampos2(e, sala.jTextArea1, "Discurso Presidencial");

    }

    public void agregarListas() {
        agregarMetodoBusqueda();
        agregarCategoria();
        insertarPartidos();
    }

    public void insertarPartidos() {
        PartidoPolitico partidos = new PartidoPolitico();

        DefaultComboBoxModel modeloPartidos = new DefaultComboBoxModel(partidos.establecerPartidos());//aca creo un modelo para aplicarla a el arreglo de paises y lo hice de vector porque solo acepta vector

        sala.listaPartidos.setModel(modeloPartidos);
        //estableciendo el modelo de partidos
    }

    public void agregarMetodoBusqueda() {
        ModeloBusqueda model = new ModeloBusqueda();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(model.modelos());

        sala.listaBusqueda.setModel(modelo);
    }

    public void agregarCategoria() {
        Categoria model = new Categoria();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(model.establecerCategoria());

        sala.listacategoria.setModel(modelo);
    }

    //le mando un componente cualquiera en los parametros
    public void anadirFocusEnable(FocusEvent e, JComponent combo) {

        if (e.getSource() == combo) {
            Color azul = new Color(0, 109, 196);

            Border borde = BorderFactory.createEmptyBorder(2, 2, 2, 0);
            Border bordeDentro = BorderFactory.createLineBorder(azul, 2, true);

            Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);

            combo.setBorder(bordeFinal);

        }

    }

    public void anadirFocuslost(FocusEvent e, JComponent combo) {

        if (e.getSource() == combo) {

            Color sombras = new Color(105, 116, 112);

            Border borde = BorderFactory.createEmptyBorder(2, 2, 2, 0);
            Border bordeDentro = BorderFactory.createLineBorder(sombras, 1, true);

            Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);

            combo.setBorder(bordeFinal);

        }

    }

    public void anadirFocusGainedCampos(FocusEvent e, JTextField campo, String placeholder) {
        if (e.getSource() == campo) {

            if (campo.getText().trim().equals(placeholder)) {
                campo.setText("");
                campo.setForeground(new Color(200, 205, 208));
            }

            Color ColorBlanco = new Color(239, 243, 245);
            Border borde = BorderFactory.createEmptyBorder(3, 3, 3, 3);
            Border bordeDentro = BorderFactory.createLineBorder(ColorBlanco, 1, true);

            Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);

            campo.setBorder(bordeFinal);

        }

    }

    public void anadirFocuslostCampos(FocusEvent e, JTextField campo, String placeholder) {

        if (e.getSource() == campo) {
            if (campo.getText().trim().equals(placeholder) || campo.getText().equals("")) {
                campo.setText(placeholder);
                campo.setForeground(new Color(105, 116, 112));
            }

            Color ColorGris = new Color(118, 118, 118);
            Border borde = BorderFactory.createEmptyBorder(3, 3, 3, 3);
            Border bordeDentro = BorderFactory.createLineBorder(ColorGris, 1, true);

            Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);

            campo.setBorder(bordeFinal);

        }
    }

    public void anadirFocuslostCampos2(FocusEvent e, JTextArea campo, String placeholder) {

        if (e.getSource() == campo) {
            if (campo.getText().trim().equals(placeholder) || campo.getText().equals("")) {
                campo.setText(placeholder);
                campo.setForeground(new Color(105, 116, 112));
            }

            Color ColorGris = new Color(118, 118, 118);
            Border borde = BorderFactory.createEmptyBorder(3, 3, 3, 3);
            Border bordeDentro = BorderFactory.createLineBorder(ColorGris, 1, true);

            Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);

            campo.setBorder(bordeFinal);

        }

    }

    public void anadirFocusGainedCampos2(FocusEvent e, JTextArea campo, String placeholder) {
        if (e.getSource() == campo) {

            if (campo.getText().trim().equals(placeholder)) {
                campo.setText("");
                campo.setForeground(new Color(200, 205, 208));
            }

            Color ColorBlanco = new Color(239, 243, 245);
            Border borde = BorderFactory.createEmptyBorder(3, 3, 3, 3);
            Border bordeDentro = BorderFactory.createLineBorder(ColorBlanco, 1, true);

            Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);

            campo.setBorder(bordeFinal);

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == sala.cerrar) {
            int salir = 1;//
            JOptionPane.showMessageDialog(null, "¡¡NO PODRA VOVLER A ENTRAR!!", "Pienselo bien ", 0, imagenNice("\\imagenes\\waring .png", 40, 40));

            salir = JOptionPane.showConfirmDialog(null, "¿Está seguro(a) que quiere volver a la pantalla de incio?", "Salir", JOptionPane.YES_NO_OPTION, -1, imagenNice("\\imagenes\\interrogacion.png", 40, 40));

            if (salir == 0) {
                Consultas con = new Consultas();

                ConsultasVotaciones cons = new ConsultasVotaciones();
                cons.insertarNulos(votante);
            
                sala.dispose();

                InterfazInicio interfaz = new InterfazInicio();
                Controlador.ControladorInicio controlar = new ControladorInicio(interfaz);

                controlar.inicarApp();

            }

            salir = 1;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == sala.MENOS) {
            Color color = new Color(200, 200, 200);
            sala.MENOS.setForeground(color);
        }
        if (e.getSource() == sala.cerrar) {
            Color color = new Color(200, 200, 200);
            sala.cerrar.setForeground(color);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == sala.MENOS) {
            Color color = new Color(239, 243, 245);
            sala.MENOS.setForeground(color);
        }
        if (e.getSource() == sala.cerrar) {
            Color color = new Color(239, 243, 245);
            sala.cerrar.setForeground(color);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        anadirEventoCampo(e, sala.buscar);

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource() == sala.listaBusqueda) {
            if (sala.listaBusqueda.getSelectedIndex() == 0) {
                bordeListasQuitar(sala.listaCandidatos);
                sala.nombre3.setVisible(true);
                sala.buscar.setVisible(true);
                sala.botonBuscar.setVisible(true);

                sala.listaPartidos.setSelectedIndex(0);
                sala.listaCandidatos.setVisible(false);
                sala.Candidato1.setVisible(false);

                sala.partidos.setVisible(false);
                sala.listaPartidos.setVisible(false);
                bordeListasQuitar(sala.listaCandidatos);
                limpiarCajas();
            } else if (sala.listaBusqueda.getSelectedIndex() == 1) {
                bordeListasQuitar(sala.listaCandidatos);
                sala.nombre3.setVisible(false);
                sala.buscar.setVisible(false);
                sala.botonBuscar.setVisible(false);
                sala.listaCandidatos.setVisible(true);
                sala.Candidato1.setVisible(true);
                sala.partidos.setVisible(true);
                sala.listaPartidos.setVisible(true);
                bordeListas(sala.listaPartidos);

                limpiarCajas();

            } else if (sala.listaBusqueda.getSelectedIndex() == 2) {
                sala.nombre3.setVisible(false);
                sala.buscar.setVisible(false);
                sala.botonBuscar.setVisible(false);
                sala.listaCandidatos.setVisible(true);
                sala.Candidato1.setVisible(true);
                sala.partidos.setVisible(false);
                sala.listaPartidos.setVisible(false);

                bordeListas(sala.listaCandidatos);

                limpiarCajas2();
            }
        }

        if (e.getSource().equals(sala.listacategoria)) {

            if (sala.listacategoria.getSelectedIndex() == 0) {

                sala.scroll.setVisible(true);
                sala.campoMunicipio.setVisible(false);
                sala.campoDepartamento.setVisible(false);
                sala.municipio.setVisible(false);
                sala.departamento.setVisible(false);
                sala.Candidato1.setText("Presidentes");
                sala.buscar.setText("Nombre Candidato");

                if (sala.listaBusqueda.getSelectedIndex() == 2) {

                    presidente = new Presidente();
                    DefaultComboBoxModel modeloPresidentes = new DefaultComboBoxModel(presidente.presidentes());

                    sala.listaCandidatos.setModel(modeloPresidentes);
                    bordeListas(sala.listaCandidatos);
                    sala.listaCandidatos.setSelectedIndex(0);

                } else {
                    limpiarCajas();
                }

                limpiarCajas2();

            } else if (sala.listacategoria.getSelectedIndex() == 1) {
                sala.scroll.setVisible(false);
                sala.Candidato1.setText("Diputados");
                sala.campoMunicipio.setVisible(false);
                sala.campoDepartamento.setVisible(true);
                sala.municipio.setVisible(false);
                sala.departamento.setVisible(true);
                sala.buscar.setText("Nombre Candidato");

                if (sala.listaBusqueda.getSelectedIndex() == 2) {

                    diputado = new Diputado();
                    DefaultComboBoxModel modeloDiputados = new DefaultComboBoxModel(diputado.Diputados(votante.getIdDepartamento()));

                    sala.listaCandidatos.setModel(modeloDiputados);
                    bordeListas(sala.listaCandidatos);
                    sala.listaCandidatos.setSelectedIndex(0);

                } else {
                    limpiarCajas();
                }

                limpiarCajas2();

            } else if (sala.listacategoria.getSelectedIndex() == 2) {

                sala.scroll.setVisible(false);
                sala.Candidato1.setText("Alcaldes");

                sala.campoMunicipio.setVisible(true);
                sala.campoDepartamento.setVisible(true);
                sala.municipio.setVisible(true);
                sala.departamento.setVisible(true);
                sala.buscar.setText("Nombre Candidato");

                if (sala.listaBusqueda.getSelectedIndex() == 2) {

                    alcalde = new Alcalde();
                    DefaultComboBoxModel modeloAlcalde = new DefaultComboBoxModel(alcalde.alcalde(votante.getIdMunicipio()));

                    sala.listaCandidatos.setModel(modeloAlcalde);
                    bordeListas(sala.listaCandidatos);

                    sala.listaCandidatos.setSelectedIndex(0);

                } else {
                    limpiarCajas();
                }
                limpiarCajas2();

            }

        } else if (e.getSource().equals(sala.listaPartidos)) {

            if (e.getStateChange() == ItemEvent.SELECTED) {//si un elemento de la lista fue seleccionado esto me lo verifica y me lo indica xd y caa vez que un elemento de mi lista sea seleccionado yo Lo guarsdarte en un municipio y voy a crear un modelo para luego establ;ecerlo

                if (sala.listaPartidos.getSelectedIndex() == 0) {
                    sala.imagenPartido.setIcon(null);

                } else {
                    PartidoPolitico partidos = (PartidoPolitico) sala.listaPartidos.getSelectedItem();

                    BufferedImage imagen = modeloCandidatos.imagenPartidos(partidos);//le mando todos los campos incializados
                    partidos.setImagen(imagen);

                    sala.imagenPartido.setIcon(new ImageIcon(imagen));

                    int indice = sala.listacategoria.getSelectedIndex();

                    switch (indice) {
                        case 0:
                            Presidente presidentes = new Presidente();

                            DefaultComboBoxModel modeloPresidentes = new DefaultComboBoxModel(presidentes.presidentesPartido(partidos));

                            sala.listaCandidatos.setModel(modeloPresidentes);

                            if (sala.listaPartidos.getSelectedIndex() == 0) {
                                sala.listaCandidatos.setModel(modeloPresidentes);
                            } else {
                                bordeListas(sala.listaCandidatos);
                            }

                            break;

                        case 1:
                            Diputado diputados = new Diputado();
                            DefaultComboBoxModel modeloDiputados = new DefaultComboBoxModel(diputados.DiputadosPartido(partidos, votante.getIdDepartamento()));
                            sala.listaCandidatos.setModel(modeloDiputados);

                            if (sala.listaPartidos.getSelectedIndex() == 0) {
                                sala.listaCandidatos.setModel(modeloDiputados);
                            } else {

                                bordeListas(sala.listaCandidatos);

                            }

                            break;

                        case 2:

                            Alcalde alcaldes = new Alcalde();
                            DefaultComboBoxModel modeloAlcaldes = new DefaultComboBoxModel(alcaldes.alcaldesPartido(partidos, votante.getIdMunicipio()));
                            sala.listaCandidatos.setModel(modeloAlcaldes);

                            if (sala.listaPartidos.getSelectedIndex() == 0) {
                                sala.listaCandidatos.setModel(modeloAlcaldes);

                            } else {
                                bordeListas(sala.listaCandidatos);

                            }

                            break;
                    }

                }
            }

        } else if (e.getSource().equals(sala.listaCandidatos)) {//eventos de la lista candidato
            Color blanco = new Color(200, 205, 208);
            if (e.getStateChange() == ItemEvent.SELECTED) {

                int indices = sala.listacategoria.getSelectedIndex();

                switch (indices) {
                    case 0://dependiendo de cada indice se intanciara y obtendra un objeto
                        if (sala.listaCandidatos.getSelectedIndex() == 0) {
                            limpiarCajas2();

                        } else {
                            Presidente president = (Presidente) sala.listaCandidatos.getSelectedItem();
                            //estableciendo los campos
                            sala.campoNombre.setText(president.getNombre());
                            sala.campoNombre.setForeground(blanco);

                            sala.campoNacionalidad.setText(president.getNacionalidad());//obteniendo todo y estableciendolo en los campos
                            sala.campoNacionalidad.setForeground(blanco);

                            sala.campoGenero.setText(president.getGenero());
                            sala.campoGenero.setForeground(blanco);

                            sala.idPresidente.setText(String.valueOf(president.getId_Presidende()));

                            sala.jTextArea1.setText(president.getDiscurso());
                            sala.jTextArea1.setForeground(blanco);

                            PartidoPolitico partido1 = new PartidoPolitico();

                            partido = partido1.partido(president.getId_Partido());

                            BufferedImage imagx = modeloCandidatos.imagenPartidos(partido);//le mando todos los campos incializados

                            sala.imagenPartido.setIcon(new ImageIcon(imagx));

                            sala.campoPartido1.setText(partido.getNombre());
                            sala.campoPartido1.setForeground(blanco);

                            sala.imagenPresidente.setIcon(new ImageIcon(president.getImagen()));

                        }

                        break;

                    case 1:
                        if (sala.listaCandidatos.getSelectedIndex() == 0) {
                            limpiarCajas2();

                        } else {

                            diputado = (Diputado) sala.listaCandidatos.getSelectedItem();
                            sala.campoNombre.setText(diputado.getNombre());
                            sala.campoNombre.setForeground(blanco);

                            sala.campoNacionalidad.setText(diputado.getNacionalidad());//obteniendo todo y estableciendolo en los campos
                            sala.campoNacionalidad.setForeground(blanco);

                            sala.campoGenero.setText(diputado.getGenero());
                            sala.campoGenero.setForeground(blanco);

                            sala.idDiputado.setText(String.valueOf(diputado.getIdDiputado()));

                            PartidoPolitico partido1 = new PartidoPolitico();

                            partido = partido1.partido(diputado.getId_Partido());

                            BufferedImage imagx = modeloCandidatos.imagenPartidos(partido);//le mando todos los campos incializados

                            sala.imagenPartido.setIcon(new ImageIcon(imagx));

                            sala.campoPartido1.setText(partido.getNombre());
                            sala.campoPartido1.setForeground(blanco);

                            sala.imagenPresidente.setIcon(new ImageIcon(diputado.getImagen()));
                            sala.campoDepartamento.setText(votante.getDepartamento());

                        }

                        break;

                    case 2:
                        if (sala.listaCandidatos.getSelectedIndex() == 0) {
                            limpiarCajas2();

                        } else {

                            alcalde = (Alcalde) sala.listaCandidatos.getSelectedItem();
                            sala.campoNombre.setText(alcalde.getNombre());
                            sala.campoNombre.setForeground(blanco);

                            sala.campoNacionalidad.setText(alcalde.getNacionalidad());//obteniendo todo y estableciendolo en los campos
                            sala.campoNacionalidad.setForeground(blanco);

                            sala.campoGenero.setText(alcalde.getGenero());
                            sala.campoGenero.setForeground(blanco);

                            sala.idAlcalde.setText(String.valueOf(alcalde.getIdAlcalde()));

                            PartidoPolitico partido1 = new PartidoPolitico();

                            partido = partido1.partido(alcalde.getId_Partido());

                            BufferedImage imagx = modeloCandidatos.imagenPartidos(partido);//le mando todos los campos incializados

                            sala.imagenPartido.setIcon(new ImageIcon(imagx));

                            sala.campoPartido1.setText(partido.getNombre());
                            sala.campoPartido1.setForeground(blanco);

                            sala.imagenPresidente.setIcon(new ImageIcon(alcalde.getImagen()));
                            sala.campoDepartamento.setText(votante.getDepartamento());

                            sala.campoMunicipio.setText(votante.getMunicpio());
                        }

                        break;
                }

            }

        }

    }

    public void anadirEventoCampo(KeyEvent e, JTextField campo) {
        if (e.getSource() == campo) {
            if (Character.isAlphabetic(e.getKeyChar()) || Character.isSpaceChar(e.getKeyChar())) {
            } else {
                e.consume();//no dejaremos que escriban mas caracters

            }
        }

    }

    public void bordeListas(JComponent combo) {
        Color azul = new Color(69, 170, 242);

        Border borde = BorderFactory.createEmptyBorder(2, 2, 2, 0);

        Border bordeDentro = BorderFactory.createLineBorder(azul, 2, true);

        Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);

        combo.setBorder(bordeFinal);
    }

    public void bordeListasQuitar(JComponent combo) {
        Border borde = combo.getBorder();
        combo.setBorder(borde);
    }

    private void bordesErrores(JComponent componente) {
        Border bordePrecaucion = BorderFactory.createLineBorder(new Color(255, 96, 91), 2, true);
        componente.setBorder(bordePrecaucion);
    }

    public void limpiarCajas() {
        sala.campoDepartamento.setText(null);
        sala.campoGenero.setText(null);
        sala.campoMunicipio.setText(null);
        sala.campoNacionalidad.setText(null);
        sala.campoPartido1.setText(null);
        sala.imagenPresidente.setIcon(null);
        sala.jTextArea1.setText("Discurso Presidencial");
        sala.campoNombre.setText(null);
        sala.listaPartidos.setSelectedIndex(0);
        sala.imagenPartido.setIcon(null);
        sala.idAlcalde.setText(null);
        sala.idDiputado.setText(null);
        sala.idPresidente.setText(null);
        sala.listaCandidatos.removeAllItems();
        opcionA = 1;
        opcionP = 1;
        opcionD = 1;
    }
    
    
    public void limpiarCajasVotar() {
        sala.campoDepartamento.setText(null);
        sala.campoGenero.setText(null);
        sala.campoMunicipio.setText(null);
        sala.campoNacionalidad.setText(null);
        sala.campoPartido1.setText(null);
        sala.imagenPresidente.setIcon(null);
        sala.jTextArea1.setText("Discurso Presidencial");
        sala.campoNombre.setText(null);
        sala.buscar.setText("Nombre Candidato");
        sala.listaPartidos.setSelectedIndex(0);
        sala.imagenPartido.setIcon(null);
        sala.idAlcalde.setText(null);
        sala.idDiputado.setText(null);
        sala.idPresidente.setText(null);
        sala.listaCandidatos.removeAllItems();
        opcionA = 1;
        opcionP = 1;
        opcionD = 1;
    }

    public void limpiarCajas2() {
        sala.campoDepartamento.setText(null);
        sala.campoGenero.setText(null);
        sala.campoMunicipio.setText(null);
        sala.campoNacionalidad.setText(null);
        sala.campoPartido1.setText(null);
        sala.imagenPresidente.setIcon(null);
        sala.jTextArea1.setText("Discurso Presidencial");
        sala.campoNombre.setText(null);
        sala.listaPartidos.setSelectedIndex(0);
        sala.imagenPartido.setIcon(null);
        sala.idAlcalde.setText(null);
        sala.idDiputado.setText(null);
        sala.idPresidente.setText(null);
        opcionA = 1;
        opcionP = 1;
        opcionD = 1;

    }

    public boolean comprobarListas(JComboBox lista, String mensaje, String error) {
        if (lista.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(lista, mensaje, error, 0, imagenNice("\\imagenes\\error.png", 40, 40));
            bordesErrores(lista);

            return true;
        } else {
            return false;
        }
    }


}
