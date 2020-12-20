
package Controlador;
//paquetes para importar en las demas clases
import Modelo.Personas.Persona;
import Modelo.Regiones.Departamento;
import Modelo.Regiones.Municipio;
import Modelo.RegistroCandidatos.Alcalde;
import Modelo.RegistroCandidatos.Categoria;
import Modelo.RegistroCandidatos.Conexion;
import Modelo.RegistroCandidatos.ConsultasCandidatos;
import Modelo.RegistroCandidatos.Diputado;
import Modelo.RegistroCandidatos.ImagenPartido;
import Modelo.RegistroCandidatos.Nacionalidades;
import Modelo.RegistroCandidatos.PartidoPolitico;
import Modelo.RegistroCandidatos.Presidente;
import Vista.InterfazInicio;
import Vista.RegistroCandidatos;
import java.awt.Color;
import java.awt.Event;
import java.awt.MenuComponent;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.BorderImage;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ControladorCandidatosRegistro implements ActionListener,ItemListener,FocusListener,KeyListener,MouseListener{
    //atributos para los eventos con el controlador
    RegistroCandidatos ventanaRegistro;//esta el la clase de la interfaz grafica
    UIManager UI;
    Alcalde alcalde;
    PartidoPolitico partido;
    ConsultasCandidatos modelo;
    Presidente presidente;
    int opcionP = 1;
    int opcionD = 1;
    int opcionA = 1;
    int opcionDiscurso = 1;
    File archivo;
    String rutaImagenHombre = "C:\\Users\\Allan\\Documents\\NetBeansProjects\\Elecciones2021\\src\\Controlador\\imagenes\\desonocido.jpg";
    String rutaImagenMujer = "C:\\Users\\Allan\\Documents\\NetBeansProjects\\Elecciones2021\\src\\Controlador\\imagenes\\mujer.jpg";
    
//todo esto se ejecutara para inicar toda la aplicacion y en el construcir iran los evetos
    
    
    public ControladorCandidatosRegistro(RegistroCandidatos ventanaRegistro, Alcalde alcalde, PartidoPolitico partido, ConsultasCandidatos modelo, Presidente presidente) {
        this.ventanaRegistro = ventanaRegistro;
        this.alcalde = alcalde;
        this.partido = partido;
        this.modelo = modelo;
        this.presidente = presidente;
        insertarListas();
        insertarEventos();
        ventanaRegistro.listaDepartamentos.setVisible(false);
        ventanaRegistro.Muncipios.setVisible(false);
        ventanaRegistro.depa.setVisible(false);
        ventanaRegistro.muni.setVisible(false);
        ventanaRegistro.lugar.setVisible(false);
        colorSeparador(ventanaRegistro.jSeparator1);
        colorSeparador(ventanaRegistro.separarCampo);
        
    }
    
    private void insertarEventos(){//para mejorar el codigo esto lo haremos aparte y solo lo llamamos en el constructor
         ventanaRegistro.candidatura.addItemListener(this);
        ventanaRegistro.listaDepartamentos.addItemListener(this);
        ventanaRegistro.listaDepartamentos.addFocusListener(this);
         ventanaRegistro.candidatura.addFocusListener(this);
         ventanaRegistro.listaNacionalidades.addFocusListener(this);
         ventanaRegistro.listaPartidos.addFocusListener(this);
         ventanaRegistro.Muncipios.addFocusListener(this);
         
         //los campos y sus eventos
         ventanaRegistro.InsertarPartido.setVisible(false);
         ventanaRegistro.Telefono.addFocusListener(this);
         ventanaRegistro.Nombre.addFocusListener(this);
         ventanaRegistro.Identidad1.addFocusListener(this);
         ventanaRegistro.Telefono.addKeyListener(this);
         ventanaRegistro.Identidad1.addKeyListener(this);
         ventanaRegistro.Nombre.addKeyListener(this);
         ventanaRegistro.seleccionarImagen.addActionListener(this);
         ventanaRegistro.listaPartidos.addItemListener(this);
         ventanaRegistro.discurso.addFocusListener(this);
         ventanaRegistro.discurso.addKeyListener(this);
         ventanaRegistro.insertarCandidato.addActionListener(this);
         ventanaRegistro.InsertarPartido.addActionListener(this);
        ventanaRegistro.Eliminar.addActionListener(this);
        ventanaRegistro.cerrar.addMouseListener(this);
        ventanaRegistro.MENOS.addMouseListener(this);
    }
    
    public void inciarApp(){
       ventanaRegistro.setLocationRelativeTo(null);
        ventanaRegistro.setVisible(true);
    }
    
    public void colorSeparador(JSeparator separar){
        separar.setForeground(new Color(160,160,160));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == ventanaRegistro.seleccionarImagen){
            JFileChooser escoger = new JFileChooser();//para seleccionar la imagen de los presidentes
            escoger.setCurrentDirectory(new File("C:\\Users\\Allan\\Desktop\\Imagenes Candidatos\\diputado"));//aca creamos un archivo con la ruta del usuario principal
            
            
            escoger.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            FileNameExtensionFilter filtroJpg = new FileNameExtensionFilter("",".images","jpg","png","gif");
            escoger.setFileFilter(filtroJpg);
            
            int seleccion = escoger.showOpenDialog(escoger);//mostrar o retornar lo que el usuario ingreso
            
            
            try{
                if(seleccion == JFileChooser.APPROVE_OPTION){
                    File imagen = escoger.getSelectedFile();//obtener el archivo seleccionado
                    archivo = escoger.getSelectedFile();
                    String ruta = imagen.getAbsolutePath();//obttener la ruta del archivo seleccionado   
                       
                
                    ventanaRegistro.imagenCandidatura.setIcon(new ImageIcon(ruta));
                   
                                

                    
                }else{
                
                }
             
                
            }catch(Exception xe){
                System.err.println("Error "+xe);
            }
            
            
            
        }
      /*
        if(e.getSource().equals(ventanaRegistro.InsertarPartido)){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del Partido a insertar"));
            JFileChooser escoger = new JFileChooser();//para seleccionar la imagen de los presidentes
            escoger.setCurrentDirectory(new File("C:\\Users\\Allan\\Desktop\\Imagenes Candidatos\\Partidos Politicos"));//aca creamos un archivo con la ruta del usuario principal
            
            
            escoger.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            FileNameExtensionFilter filtroJpg = new FileNameExtensionFilter("",".images","jpg","png","gif");
            escoger.setFileFilter(filtroJpg);
            
            int seleccion = escoger.showOpenDialog(escoger);//mostrar o retornar lo que el usuario ingreso 
            PreparedStatement consulta;
            Conexion con = new Conexion();
            //hasta que el usuario seleccione la imagen se guardara en la base de datos
           
                if(seleccion == JFileChooser.APPROVE_OPTION){
                    File imagen = escoger.getSelectedFile();//obtener el archivo seleccionado
                   
                    try{
                    FileInputStream archivoEntrada= new FileInputStream(imagen);//esto sera para leer los bites del archivo y pasar esto a la base de datos
                    Connection conexion = con.getConnection();
              
                   
                    consulta =  conexion.prepareStatement("update partidos set foto=? where idPartido=?");
                   consulta.setBinaryStream(1, archivoEntrada, (int) imagen.length());//mandandole la imagen a la base de datos con los 3 parametros
                   consulta.setInt(2, id);
                   consulta.executeUpdate();//ejecutando la actualizacion
                
                   JOptionPane.showMessageDialog(null,"Imagen guardada");
            }catch(Exception xe){
                System.err.println("Error "+xe);
            }
            
        }
        }
        //Esto estara comentariado y solo cuando sea necesario se usara
        */
        if(e.getSource().equals(ventanaRegistro.insertarCandidato)){
         //instanciando a los 3 votantes de la manera polimosrfica o sea que usamos polimorfismo
         Persona alcaldes = null;
         Persona diputados = null;
         Persona presidente = null;
         int seleccionp = 1;
         int seguro ;
         String candidatura[] = new String[]{"presidentes","diputados","alcaldes"};//aca es para poner el nombre de las tablas
         String columnasID[] = new String[]{"id_Presidente","id_Diputado","id_Alcalde"};
         
         File imagenMujer = new File(rutaImagenMujer);
         File imagenHombre = new File(rutaImagenHombre);

//1 primero hay que saber que tipo de interfaz es 
           int indice = ventanaRegistro.candidatura.getSelectedIndex();
           //el switch va a controlar el registro dependiendo de los 3 campos
            switch(indice){
             
                case 0:
                   
                   if(comprobarCampos(ventanaRegistro.Nombre, "Nombre Completo", "Por favor ingrese su nombre")){
            
                   }else if(comprobarCampos(ventanaRegistro.Identidad1, "Identidad", "Por favor ingrese su Numero de identidad")){

                   }else if(comprobarCampos(ventanaRegistro.Telefono, "Teléfono", "Por favor ingrese su Numero Teléfono")){
                       
                    }else if(ventanaRegistro.fechaNacimiento.getDate() == null){//si no selecciono la fecha
                JOptionPane.showMessageDialog(ventanaRegistro.fechaNacimiento, "Por favor ingrese su fecha de nacimiento","ERROR",0,imagenNice("\\imagenes\\error.png", 40, 40));
                         
                     
                   }else if(limiteNumericos(ventanaRegistro.Telefono, 7, "Numero Teléfonico incorrecto")){
              
                   
                   }else if(limiteNumericos(ventanaRegistro.Identidad1, 12, "Numero de identidad Incorrecto")){
                    
                   } else if (ventanaRegistro.masculino.isSelected() == false && ventanaRegistro.femenino.isSelected() == false ) {//si ninguno de los campos de genero fue seleccionado
                JOptionPane.showMessageDialog(ventanaRegistro.ubicar2, "Por favor seleccione su genero", "ERROR", 0,imagenNice("\\imagenes\\error.png", 40, 40));
           
                   } else if (ventanaRegistro.casado.isSelected() == false && ventanaRegistro.divorciado.isSelected() == false &&ventanaRegistro.soltero.isSelected() == false  ) {//si ninguno de los campos de genero fue seleccionado
                JOptionPane.showMessageDialog(ventanaRegistro.ubicar1, "Por favor seleccione su estado seglar", "QUE NO LE DE PENA", 0,imagenNice("\\imagenes\\error.png", 40, 40));
           
                   }else if(comprobarListas(ventanaRegistro.listaPartidos, "Por favor seleccione su partido político","Asi que chiste")){
                       
                   }else if(comprobarNcionalidad(ventanaRegistro.listaNacionalidades, "Por lo momentos no esta permitido que un extranjero se postule para Presidente\n\t\tSolo los Hondureños se pueden postular", "¡¡LO SENTIMOS!!")){
                       
                   }else if(ventanaRegistro.imagenCandidatura.getIcon() == null && opcionP !=0){
                      //si selecciona yes esto se cambia
                       opcionP = JOptionPane.showConfirmDialog(ventanaRegistro.seleccionarImagen,"¿Está seguro que no quiere seleccionar una imagen? ", "¡¡No sera reconocido!!",JOptionPane.YES_NO_OPTION,-1 ,imagenNice("\\imagenes\\interrogacion.png", 40, 40));
                       if(opcionP == 0 && ventanaRegistro.femenino.isSelected()){
                           
                            ventanaRegistro.imagenCandidatura.setIcon(new ImageIcon(rutaImagenMujer));                           
                        
                           }else if(opcionP == 0 && ventanaRegistro.masculino.isSelected()){
                            
                          ventanaRegistro.imagenCandidatura.setIcon(new ImageIcon(rutaImagenHombre));
                         
                        }
                       
                   }else if((ventanaRegistro.discurso.getText().trim().equals("DIscurso Presidencial")//mientras le de que no quiere su discurso presidencual o no le de si
                            ||ventanaRegistro.discurso.getText().equals("")) && opcionDiscurso  !=0 ){
                  
                       opcionDiscurso = JOptionPane.showConfirmDialog(ventanaRegistro.discurso,"¿Está seguro que no quiere escribir su discurso presidencial? ", "¡¡Sus posibilidades de ganar pueden bajar!!",JOptionPane.YES_NO_OPTION,-1 ,imagenNice("\\imagenes\\interrogacion.png", 40, 40));
                       
                   }else{      
                   Date fechaObtenida1 = (Date) ventanaRegistro.fechaNacimiento.getDate();
        
                         long milisegundos1 = fechaObtenida1.getTime();
                          java.sql.Date fechas = new java.sql.Date(milisegundos1);
                   
                     int edad = calcularEdad(fechaObtenida1);
                   
                     if(edad <=30){//si el candidato es meno o igual de 30
                         JOptionPane.showMessageDialog(ventanaRegistro.fechaNacimiento, "Usted no tiene la edad suficiente para postularse\nEl limite de edad por ahora es de 30 años", "ERROR", 0,imagenNice("\\imagenes\\error.png", 40, 40));
                    
                         //aca estamos comprobando si ya hay un presidente registrado con ese numero de identifaf
                     }else if( modelo.verificarUsuario(ventanaRegistro.Identidad1.getText(), candidatura[0], columnasID[0]) == 0){ 
                         
                         
                         
                            FileInputStream leerBytes = null;
                    
                           //si este usuario ya se registrp
                           Date fechaObtenida = (Date) ventanaRegistro.fechaNacimiento.getDate();
                           long milisegundos = fechaObtenida.getTime();
                           java.sql.Date fechaNacimiento = new java.sql.Date(milisegundos1);
                           int edadUsuario = calcularEdad(fechaObtenida);
                           //primero usar polimorfisdmo para instanciar un alcalde que viene de la clase persona
                           presidente = new Presidente();//haciendo un upcasting para luego hacer un down casting
                           Presidente president = (Presidente) presidente;//haciendo un downcasting para la jerarquia de clases
                          
                           //Estableciendo los atributos del objeto presidente
                           president.setNombre(ventanaRegistro.Nombre.getText().trim());
                           president.setIdentidad(ventanaRegistro.Identidad1.getText().trim());
                           president.setEdad(edad);
                           president.setFechaNacimiento(fechaNacimiento);
                           president.setNacionalidad(ventanaRegistro.listaNacionalidades.getSelectedItem().toString());
                          
                           //atrapar a las celementos de la app y pasandolas como parametrps
                           Categoria categoria = (Categoria)ventanaRegistro.candidatura.getSelectedItem();
                           PartidoPolitico partido = (PartidoPolitico)ventanaRegistro.listaPartidos.getSelectedItem();

                          
                           String genero = "";
                           String estadoSeglar = "";
                           
                            if(ventanaRegistro.femenino.isSelected()){
                          genero = "Femenino";
                        }//si seleccionaron el sexo femenini
                        else if(ventanaRegistro.masculino.isSelected()){
                            genero = "Masculino";
                        }
                        //aca verificamos que item fue seleccionado
                        if(ventanaRegistro.casado.isSelected()){
                            estadoSeglar = "Casado";
                        }else if(ventanaRegistro.divorciado.isSelected()){
                            estadoSeglar = "Divorciado";
                        }else{
                            estadoSeglar = "Soltero";
                        }
                           
                           
                           president.setCategoria(categoria.getIdCategoria());
                           president.setId_Partido(partido.getId_PartidoPolitico());
                           
                           if(opcionP == 0 && ventanaRegistro.femenino.isSelected()){
                            archivo = imagenMujer;
                        
                           }else if(opcionP == 0 && ventanaRegistro.masculino.isSelected()){
                            
                          archivo = imagenHombre;
                        }
                           
                           
                          if(opcionDiscurso == 0){
                     president.setDiscurso("'Sin Discurso'");
  
                          }else{
                               president.setDiscurso(ventanaRegistro.discurso.getText()); 
                          }
                          
                           president.setArchivo(archivo);
                           
                             try {
                           leerBytes = new FileInputStream(archivo); //esto se pasaran a losites
                       } catch (FileNotFoundException ex) {
                           System.err.println("Archivo no encontrado");
                       }
                         
                        president.setArchivoLeido(leerBytes);
                        president.setEstadoCivil(estadoSeglar);
                        president.setGenero(genero);
                      
                        
                         
                       
                        
                        
                         if(modelo.verificarUsuarioCompleto(ventanaRegistro.Identidad1.getText()) > 0){
              JOptionPane.showMessageDialog(ventanaRegistro.Identidad1, " Este numero de identidad ya esta en el registro", "¡¡ACÀ NO HABRA FRAUDE!! ", 0,imagenNice("\\imagenes\\waring .png", 40, 40));
    
                        }
                         else if(modelo.contarPresidentes(president) != 0){//para contar los presidentes de un partido politico
                                 
                             JOptionPane.showMessageDialog(null, "Ya hay registrado un presidente en el partido " + partido.toString(), "¡¡SOLO SE PUEDE POSTULAR UN PRESIDENTE POR PARTIDO!! ", 0,imagenNice("\\imagenes\\waring .png", 40, 40));
  
                         }
                         else if(modelo.insertarCandidato(president)){//insertando el cadidato en la base de dato que esta vinculado con un booleanoi
             JOptionPane.showMessageDialog(null, "Registro ingresado correctamente","¡¡Felicitaciones!!",JOptionPane.PLAIN_MESSAGE,imagenNice("\\imagenes\\nice.png", 40, 40));
                          limpiarCampos();
                        }
                        
                        
                              
                         

                     }else{
               
                         JOptionPane.showMessageDialog(ventanaRegistro.Identidad1, "Usted ya esta registrado como candidato para presidente", "¡¡ACÀ NO HABRA FRAUDE!! ", 0,imagenNice("\\imagenes\\waring .png", 40, 40));
  
                     }
                   }
                   
                    
                    
                    break;
                    
                    
                case 1: // Diputado
                    
                    
                     if(comprobarCampos(ventanaRegistro.Nombre, "Nombre Completo", "Por favor ingrese su nombre")){
            
                   }else if(comprobarCampos(ventanaRegistro.Identidad1, "Identidad", "Por favor ingrese su Numero de identidad")){

                   }else if(comprobarCampos(ventanaRegistro.Telefono, "Teléfono", "Por favor ingrese su Numero Teléfono")){
                       
                   }else if(ventanaRegistro.fechaNacimiento.getDate() == null){//si no selecciono la fecha
                JOptionPane.showMessageDialog(ventanaRegistro.fechaNacimiento, "Por favor ingrese su fecha de nacimiento","ERROR",0,imagenNice("\\imagenes\\error.png", 40, 40));
                      
                   
                   }else if(limiteNumericos(ventanaRegistro.Telefono, 7, "Numero Teléfonico incorrecto")){
              
                   
                   }else if(limiteNumericos(ventanaRegistro.Identidad1, 12, "Numero de identidad Incorrecto")){
                    
                   } else if (ventanaRegistro.masculino.isSelected() == false && ventanaRegistro.femenino.isSelected() == false ) {//si ninguno de los campos de genero fue seleccionado
                JOptionPane.showMessageDialog(ventanaRegistro.ubicar2, "Por favor seleccione su genero", "ERROR", 0,imagenNice("\\imagenes\\error.png", 40, 40));
                   
                   } else if (ventanaRegistro.casado.isSelected() == false && ventanaRegistro.divorciado.isSelected() == false &&ventanaRegistro.soltero.isSelected() == false  ) {//si ninguno de los campos de genero fue seleccionado
                JOptionPane.showMessageDialog(ventanaRegistro.ubicar1, "Por favor seleccione su estado seglar", "QUE NO LE DE PENA", 0,imagenNice("\\imagenes\\error.png", 40, 40));
                 
                   }else if(comprobarListas(ventanaRegistro.listaPartidos, "Por favor seleccione su partido político","Asi que chiste")){
                       
                   }else if(comprobarNcionalidad(ventanaRegistro.listaNacionalidades, "Por lo momentos no esta permitido que un extranjero se postule para Diputado\n\t\tSolo los Hondureños se pueden postular", "¡¡LO SENTIMOS!!")){
                       
                   }else if(ventanaRegistro.imagenCandidatura.getIcon() == null && opcionD !=0){
                      //si selecciona yes esto se cambia
                       opcionD = JOptionPane.showConfirmDialog(ventanaRegistro.seleccionarImagen,"¿Está seguro que no quiere seleccionar una imagen? ", "¡¡No sera reconocido!!",JOptionPane.YES_NO_OPTION,-1 ,imagenNice("\\imagenes\\interrogacion.png", 40, 40));
                           if(opcionD == 0 && ventanaRegistro.femenino.isSelected()){
                           
                            ventanaRegistro.imagenCandidatura.setIcon(new ImageIcon(rutaImagenMujer));                           
                        
                           }else if(opcionD == 0 && ventanaRegistro.masculino.isSelected()){
                            
                          ventanaRegistro.imagenCandidatura.setIcon(new ImageIcon(rutaImagenHombre));
                         
                        }
                   }
                     else{      
                   Date fechaObtenida1 = (Date) ventanaRegistro.fechaNacimiento.getDate();
        
                         long milisegundos1 = fechaObtenida1.getTime();
                          java.sql.Date fechas = new java.sql.Date(milisegundos1);
                   
                     int edad = calcularEdad(fechaObtenida1);
                   
                     if(edad <=30){//si el candidato es meno o igual de 30
                         JOptionPane.showMessageDialog(ventanaRegistro.fechaNacimiento, "Usted no tiene la edad suficiente para postularse\nEl limite de edad por ahora es de 30 años", "ERROR", 0,imagenNice("\\imagenes\\error.png", 40, 40));
                     }else if( modelo.verificarUsuario(ventanaRegistro.Identidad1.getText(), candidatura[1], columnasID[1]) == 0){ 
                         
                         
                            FileInputStream leerBytes = null;
                    
                           //si este usuario ya se registrp
                           Date fechaObtenida = (Date) ventanaRegistro.fechaNacimiento.getDate();
                           long milisegundos = fechaObtenida.getTime();
                           java.sql.Date fechaNacimiento = new java.sql.Date(milisegundos1);
                           
                           
                           //primero usar polimorfisdmo para instanciar un alcalde que viene de la clase persona
                           diputados = new Diputado();//haciendo un upcasting para luego hacer un down casting
                           Diputado diputado = (Diputado) diputados;//haciendo un downcasting para la jerarquia de clases
                          
                           //Estableciendo los atributos del objeto diputadoe
                           diputado.setNombre(ventanaRegistro.Nombre.getText().trim());
                           diputado.setIdentidad(ventanaRegistro.Identidad1.getText().trim());
                           diputado.setEdad(edad);
                           diputado.setFechaNacimiento(fechaNacimiento);
                           diputado.setNacionalidad(ventanaRegistro.listaNacionalidades.getSelectedItem().toString());
                          
                           //atrapar a las celementos de la app y pasandolas como parametrps
                           Categoria categoria = (Categoria)ventanaRegistro.candidatura.getSelectedItem();
                           PartidoPolitico partido = (PartidoPolitico)ventanaRegistro.listaPartidos.getSelectedItem();
                           Departamento departamento = (Departamento) ventanaRegistro.listaDepartamentos.getSelectedItem();
                          
                           String genero = "";
                           String estadoSeglar = "";
                           
                            if(ventanaRegistro.femenino.isSelected()){
                          genero = "Femenino";
                        }//si seleccionaron el sexo femenini
                        else if(ventanaRegistro.masculino.isSelected()){
                            genero = "Masculino";
                        }
                        //aca verificamos que item fue seleccionado
                        if(ventanaRegistro.casado.isSelected()){
                            estadoSeglar = "Casado";
                        }else if(ventanaRegistro.divorciado.isSelected()){
                            estadoSeglar = "Divorciado";
                        }else{
                            estadoSeglar = "Soltero";
                        }
                           
                           diputado.setId_Departamento(departamento.getId_Departamento());
                           diputado.setCategoria(categoria.getIdCategoria());
                           diputado.setId_Partido(partido.getId_PartidoPolitico());
                           
                           if(opcionD == 0 && ventanaRegistro.femenino.isSelected()){
                            archivo = imagenMujer;
                        
                           }else if(opcionD == 0 && ventanaRegistro.masculino.isSelected()){
                            
                          archivo = imagenHombre;
                        }
                           
                           
                          
                           diputado.setArchivo(archivo);
                           
                             try {
                           leerBytes = new FileInputStream(archivo); //esto se pasaran a losites
                       } catch (FileNotFoundException ex) {
                           System.err.println("Archivo no encontrado");
                       }
                         
                        diputado.setArchivoLeido(leerBytes);
                        diputado.setEstadoCivil(estadoSeglar);
                        diputado.setGenero(genero);
                      
                        
                         
                       
                        
                        
                        if(modelo.verificarUsuarioCompleto(ventanaRegistro.Identidad1.getText()) > 0){
              JOptionPane.showMessageDialog(ventanaRegistro.Identidad1,  "Este numero de identidad ya esta en el registro", "¡¡ACÀ NO HABRA FRAUDE!! ", 0,imagenNice("\\imagenes\\waring .png", 40, 40));
    
                        }
                       else if(modelo.insertarCandidato(diputado)){//insertando el cadidato en la base de dato que esta vinculado con un booleanoi
             JOptionPane.showMessageDialog(null, "Registro ingresado correctamente","¡¡Felicitaciones!!",JOptionPane.PLAIN_MESSAGE,imagenNice("\\imagenes\\nice.png", 40, 40));
                          limpiarCampos();
                        }
                        
                              
                         

                     }else{
               
                         JOptionPane.showMessageDialog(ventanaRegistro.Identidad1, "Usted ya esta registrado como candidato para diputado", "¡¡ACÀ NO HABRA FRAUDE!! ", 0,imagenNice("\\imagenes\\waring .png", 40, 40));
  
                     }
                   
                     
                   }
            
                     
                     
                   
                   
                    
                    break;
                    
                    
                case 2: // Alcalde
                    
                     if(comprobarCampos(ventanaRegistro.Nombre, "Nombre Completo", "Por favor ingrese su nombre")){
            
                   }else if(comprobarCampos(ventanaRegistro.Identidad1, "Identidad", "Por favor ingrese su Numero de identidad")){

                   }else if(comprobarCampos(ventanaRegistro.Telefono, "Teléfono", "Por favor ingrese su Numero Teléfonico")){
                       
                    }else if(ventanaRegistro.fechaNacimiento.getDate() == null){//si no selecciono la fecha
                JOptionPane.showMessageDialog(ventanaRegistro.fechaNacimiento, "Por favor ingrese su fecha de nacimiento","ERROR",0,imagenNice("\\imagenes\\error.png", 40, 40));
                       
                   
                    }else if(limiteNumericos(ventanaRegistro.Telefono, 7, "Numero Teléfonico incorrecto")){
              
                   }else if(limiteNumericos(ventanaRegistro.Identidad1, 12, "Numero de identidad Incorrecto")){
                    
                    } else if (ventanaRegistro.masculino.isSelected() == false && ventanaRegistro.femenino.isSelected() == false ) {//si ninguno de los campos de genero fue seleccionado
                JOptionPane.showMessageDialog(ventanaRegistro.ubicar2, "Por favor seleccione su genero", "ERROR", 0,imagenNice("\\imagenes\\error.png", 40, 40));
          
                    } else if (ventanaRegistro.casado.isSelected() == false && ventanaRegistro.divorciado.isSelected() == false &&ventanaRegistro.soltero.isSelected() == false  ) {//si ninguno de los campos de genero fue seleccionado
                JOptionPane.showMessageDialog(ventanaRegistro.ubicar1, "Por favor seleccione su estado seglar", "QUE NO LE DE PENA", 0,imagenNice("\\imagenes\\error.png", 40, 40));
                     }else if(comprobarListas(ventanaRegistro.listaPartidos, "Por favor seleccione su partido político","Asi que chiste")){
                       
                    }else if(comprobarNcionalidad(ventanaRegistro.listaNacionalidades, "Por lo momentos no esta permitido que un extranjero se postule Alcalde"+"\n                Solo los Hondureños se pueden postular", "¡¡LO SENTIMOS!!")){
                       
                    }else if(ventanaRegistro.imagenCandidatura.getIcon() == null && opcionA !=0){
                      //si selecciona yes esto se cambia
                       opcionA = JOptionPane.showConfirmDialog(ventanaRegistro.seleccionarImagen,"¿Está seguro que no quiere seleccionar una imagen? ", "¡¡No sera reconocido!!",JOptionPane.YES_NO_OPTION,-1 ,imagenNice("\\imagenes\\interrogacion.png", 40, 40));
                   if(opcionA == 0 && ventanaRegistro.femenino.isSelected()){
                           
                            ventanaRegistro.imagenCandidatura.setIcon(new ImageIcon(rutaImagenMujer));                           
                        
                           }else if(opcionA == 0 && ventanaRegistro.masculino.isSelected()){
                            
                          ventanaRegistro.imagenCandidatura.setIcon(new ImageIcon(rutaImagenHombre));
                         
                        }
                    }else if(ventanaRegistro.Muncipios.getSelectedItem() == null || ventanaRegistro.Muncipios.getSelectedIndex() == 0){
                       
                    JOptionPane.showMessageDialog(ventanaRegistro.Muncipios, "Por favor ingrese el municipio al que se va a postular","ERROR",0,imagenNice("\\imagenes\\error.png", 40, 40)); 
                          bordesErrores(ventanaRegistro.Muncipios);
                       
                   }else{      
                   Date fechaObtenida1 = (Date) ventanaRegistro.fechaNacimiento.getDate();
        
                         long milisegundos1 = fechaObtenida1.getTime();
                          java.sql.Date fechas = new java.sql.Date(milisegundos1);
                   
                     int edad = calcularEdad(fechaObtenida1);
                   
                     if(edad <=30){//si el candidato es meno o igual de 30
                         JOptionPane.showMessageDialog(ventanaRegistro.fechaNacimiento, "Usted no tiene la edad suficiente para postularse\nEl limite de edad por ahora es de 30 años", "ERROR", 0,imagenNice("\\imagenes\\error.png", 40, 40));
                     } else if( modelo.verificarUsuario(ventanaRegistro.Identidad1.getText(), candidatura[2], columnasID[2]) == 0){ 
                         
                         
                            FileInputStream leerBytes = null;
                    
                           //si este usuario ya se registrp
                           Date fechaObtenida = (Date) ventanaRegistro.fechaNacimiento.getDate();
                           long milisegundos = fechaObtenida.getTime();
                           java.sql.Date fechaNacimiento = new java.sql.Date(milisegundos1);
                           
                           
                           //primero usar polimorfisdmo para instanciar un alcalde que viene de la clase persona
                           alcaldes = new Alcalde();//haciendo un upcasting para luego hacer un down casting
                           Alcalde alcalde = (Alcalde) alcaldes;//haciendo un downcasting para la jerarquia de clases
                          
                           //Estableciendo los atributos del objeto alcaldee
                           alcalde.setNombre(ventanaRegistro.Nombre.getText().trim());
                           alcalde.setIdentidad(ventanaRegistro.Identidad1.getText().trim());
                           alcalde.setEdad(edad);
                           alcalde.setFechaNacimiento(fechaNacimiento);
                           alcalde.setNacionalidad(ventanaRegistro.listaNacionalidades.getSelectedItem().toString());
                          
                           //atrapar a las celementos de la app y pasandolas como parametrps
                           Categoria categoria = (Categoria)ventanaRegistro.candidatura.getSelectedItem();
                           PartidoPolitico partido = (PartidoPolitico)ventanaRegistro.listaPartidos.getSelectedItem();
                           Municipio municipio = (Municipio) ventanaRegistro.Muncipios.getSelectedItem();

                           String genero = "";
                           String estadoSeglar = "";
                           
                            if(ventanaRegistro.femenino.isSelected()){
                          genero = "Femenino";
                        }//si seleccionaron el sexo femenini
                        else if(ventanaRegistro.masculino.isSelected()){
                            genero = "Masculino";
                        }
                        //aca verificamos que item fue seleccionado
                        if(ventanaRegistro.casado.isSelected()){
                            estadoSeglar = "Casado";
                        }else if(ventanaRegistro.divorciado.isSelected()){
                            estadoSeglar = "Divorciado";
                        }else{
                            estadoSeglar = "Soltero";
                        }
                           
                           alcalde.setId_Municipio(municipio.getIdMunicipio());
                           alcalde.setCategoria(categoria.getIdCategoria());
                           alcalde.setId_Partido(partido.getId_PartidoPolitico());
                           
                           if(opcionA == 0 && ventanaRegistro.femenino.isSelected()){
                            archivo = imagenMujer;
                        
                           }else if(opcionA == 0 && ventanaRegistro.masculino.isSelected()){
                            
                          archivo = imagenHombre;
                        }
                           
                           
                          
                           alcalde.setArchivo(archivo);
                           
                             try {
                           leerBytes = new FileInputStream(archivo); //esto se pasaran a losites
                       } catch (FileNotFoundException ex) {
                           System.err.println("Archivo no encontrado");
                       }
                         
                        alcalde.setArchivoLeido(leerBytes);
                        alcalde.setEstadoCivil(estadoSeglar);
                        alcalde.setGenero(genero);
                      
                        
                         
                       
                        
                        if(modelo.verificarUsuarioCompleto(ventanaRegistro.Identidad1.getText()) > 0){
              JOptionPane.showMessageDialog(ventanaRegistro.Identidad1, "Este numero de identidad ya esta en el registro", "¡¡ACÀ NO HABRA FRAUDE!! ", 0,imagenNice("\\imagenes\\waring .png", 40, 40));
    
                        }else if(modelo.alcaldesPartido(alcalde) > 0){
             JOptionPane.showMessageDialog(null, "El Partido "+partido.toString()+" ya tiene un candidato a alcalde en el municipio de "+municipio.toString(), "Partido Politico lleno", 0,imagenNice("\\imagenes\\waring .png", 40, 40));

                            }else if(modelo.insertarCandidato(alcalde) ){//insertando el cadidato en la base de dato que esta vinculado con un booleanoi
             JOptionPane.showMessageDialog(null, "Registro ingresado correctamente","¡¡Felicitaciones!!",JOptionPane.PLAIN_MESSAGE,imagenNice("\\imagenes\\nice.png", 40, 40));
                          limpiarCampos();
                        }
                        
                        
                              
                         

                     }else{
               
                         JOptionPane.showMessageDialog(ventanaRegistro.Identidad1, "Usted ya esta registrado como candidato para alcalde", "¡¡ACÀ NO HABRA FRAUDE!! ", 0,imagenNice("\\imagenes\\waring .png", 40, 40));
  
                     }
                   
                     
                   }
            
                    
                    
                    break;
                
                
                default:
                    break;
                
            }
        }
        
        if(e.getSource().equals(ventanaRegistro.Eliminar)){
            Object options[]= {"Presidente","Diputado","Alcalde"};
          
       int seleccion =  JOptionPane.showOptionDialog(null, "Escoja cual de los 3 desea eliminar","No se vaya a arrepentir", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,imagenNice("\\imagenes\\interrogacion.png",40,40), options, options[1]);
         
       if(seleccion == 0){
         Presidente presidente = new Presidente();
         int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del candidato a presidente a eliminar", "Escoja sabiamente", JOptionPane.QUESTION_MESSAGE));
        
         presidente.setId_Presidende(id);
           
         if(modelo.borrarCandidato(presidente)){
       JOptionPane.showMessageDialog(null, "Candidato a Presidente eliminado correctamente","Otra vez será",JOptionPane.PLAIN_MESSAGE,imagenNice("\\imagenes\\triste.png", 40, 40));

         }else{
        JOptionPane.showMessageDialog(null, "Ese candidato a presidente no existe", "ERROR", 0,imagenNice("\\imagenes\\error.png", 40, 40));
 
         }
         
       }else if(seleccion == 1){
           Diputado diputado = new Diputado();
         int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del candidato a diputado a eliminar", "Escoja sabiamente", JOptionPane.QUESTION_MESSAGE));
        
         diputado.setIdDiputado(id);
           
         if(modelo.borrarCandidato(diputado)){
       JOptionPane.showMessageDialog(null, "Candidato a Diputado eliminado correctamente","Otra vez será",JOptionPane.PLAIN_MESSAGE,imagenNice("\\imagenes\\triste.png", 40, 40));

         }else{
        JOptionPane.showMessageDialog(null, "Ese candidato a diputado no existe", "ERROR", 0,imagenNice("\\imagenes\\error.png", 40, 40));
 
         }
       }
       else if(seleccion == 2){
             Alcalde alcalde = new Alcalde();
         int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del candidato a Alcalde a eliminar", "Escoja sabiamente", JOptionPane.QUESTION_MESSAGE));
        
         alcalde.setIdAlcalde(id);
           
         if(modelo.borrarCandidato(alcalde)){
       JOptionPane.showMessageDialog(null, "Candidato a Alcalde eliminado correctamente","Otra vez será",JOptionPane.PLAIN_MESSAGE,imagenNice("\\imagenes\\triste.png", 40, 40));

         }else{
        JOptionPane.showMessageDialog(null, "Ese candidato a alcalde no existe", "ERROR", 0,imagenNice("\\imagenes\\error.png", 40, 40));
 
         }
       }
            
    }
        
        
        
   
            
        
        
        }
    
         
        
        public boolean comprobarCampos(JTextField campo,String placeHolder,String mensaje){
         
            if (campo.getText().equals("")
                    || campo.getText().trim().equals(placeHolder)) {
                        bordesErrores(campo);
                JOptionPane.showMessageDialog(campo, mensaje,"ERROR",0,imagenNice("\\imagenes\\error.png", 40, 40)); 
                   return true;        
           }else{
                
              return false;  
            }
        
        }
        
        public void limpiarCampos(){
            ventanaRegistro.Identidad1.setText("");
            ventanaRegistro.Nombre.setText("");
            ventanaRegistro.Telefono.setText("");
            ventanaRegistro.imagenCandidatura.setIcon(null);
            ventanaRegistro.Muncipios.removeAllItems();
            ventanaRegistro.candidatura.setSelectedIndex(0);
            ventanaRegistro.listaDepartamentos.setSelectedIndex(0);
            ventanaRegistro.listaNacionalidades.setSelectedIndex(0);
            ventanaRegistro.listaPartidos.setSelectedIndex(0);
            archivo = null;
            opcionA = 1;
            opcionD = 1;
            opcionDiscurso =1;
            opcionP = 1;
            ventanaRegistro.discurso.setText("");
            ventanaRegistro.fechaNacimiento.setDate(null);
            ventanaRegistro.grupoEstadoCivil.clearSelection();
            ventanaRegistro.grupoGenero.clearSelection();
              
        }
        
        public boolean comprobarListas(JComboBox lista,String mensaje,String error){
            if(lista.getSelectedIndex() == 0){
             JOptionPane.showMessageDialog(lista, mensaje,error,0,imagenNice("\\imagenes\\error.png", 40, 40)); 
                bordesErrores(lista);
             
             return true;
            }else{
                return false;
            }
        }
           public boolean comprobarNcionalidad(JComboBox lista,String mensaje,String error){
            if(lista.getSelectedIndex() != 0){
             JOptionPane.showMessageDialog(lista, mensaje,error,0,imagenNice("\\imagenes\\waring .png", 40, 40)); 
                bordesErrores(lista);
             
             return true;
            }else{
                return false;
            }
        }
        
        
    
//aca se llamaran y llenarar todos los elementos de la tabla de datos con el CombobocModel
  private void insertarListas(){
      insertarPartidos();
      insertarCategorias();
      insertarNacionalidades();
      insertarDepartamentos();
  }
  //Inserrtar cada uno de los elementos de los Jcombobox
      public void insertarPartidos(){
        PartidoPolitico partidos = new PartidoPolitico();
        
        DefaultComboBoxModel modeloPartidos = new DefaultComboBoxModel(partidos.establecerPartidos());//aca creo un modelo para aplicarla a el arreglo de paises y lo hice de vector porque solo acepta vector
  
        ventanaRegistro.listaPartidos.setModel(modeloPartidos);
        //estableciendo el modelo de partidos
    }
  
      public void insertarCategorias(){
          
          Categoria categorias = new Categoria();
        DefaultComboBoxModel modeloCategotia = new DefaultComboBoxModel(categorias.establecerCategoria());//aca creo un modelo para aplicarla a el arreglo de paises y lo hice de vector porque solo acepta vector
        ventanaRegistro.candidatura.setModel(modeloCategotia);
        //estableciendo el modelo de partidos
    }
     public void insertarNacionalidades(){
          
         Nacionalidades nacionalidades = new Nacionalidades();
         
        DefaultComboBoxModel modeloNacionalidad = new DefaultComboBoxModel(nacionalidades.establecerNacionalidad());//aca creo un modelo para aplicarla a el arreglo de paises y lo hice de vector porque solo acepta vector
      
        ventanaRegistro.listaNacionalidades.setModel(modeloNacionalidad);
        //estableciendo el modelo de partidos
    }
     
     public void insertarDepartamentos(){
         Departamento departamentos = new Departamento();
          DefaultComboBoxModel modeloDepartamento = new DefaultComboBoxModel(departamentos.mostrarDepartamentos2());
         
          ventanaRegistro.listaDepartamentos.setModel(modeloDepartamento);
     }

     
     
    @Override
    public void itemStateChanged(ItemEvent e) {
        
     if(e.getSource().equals(ventanaRegistro.listaDepartamentos)){
        if(e.getStateChange() == ItemEvent.SELECTED){//si un elemento de la lista fue seleccionado esto me lo verifica y me lo indica xd y caa vez que un elemento de mi lista sea seleccionado yo Lo guarsdarte en un municipio y voy a crear un modelo para luego establ;ecerlo
            Departamento depa = (Departamento) ventanaRegistro.listaDepartamentos.getSelectedItem();
            Municipio municipio = new Municipio();

            DefaultComboBoxModel modeloMuncipio = new DefaultComboBoxModel(municipio.mostrarMuncipios(depa));

            ventanaRegistro.Muncipios.setModel(modeloMuncipio);//estableciendole el modelo a la lista de municipios
            ventanaRegistro.Muncipios.setSelectedIndex(0);
        }
    }
     
     else if(e.getSource().equals(ventanaRegistro.listaPartidos)){
             if(e.getStateChange() == ItemEvent.SELECTED){//si un elemento de la lista fue seleccionado esto me lo verifica y me lo indica xd y caa vez que un elemento de mi lista sea seleccionado yo Lo guarsdarte en un municipio y voy a crear un modelo para luego establ;ecerlo
           
                 if(ventanaRegistro.listaPartidos.getSelectedIndex() ==0){
                     ventanaRegistro.Partido.setIcon(null);
                     
                 }
                 else{
                 PartidoPolitico partido = (PartidoPolitico) ventanaRegistro.listaPartidos.getSelectedItem();


                 BufferedImage imagenPanel = modelo.imagenPartidos(partido);//le mando todos los campos incializados
                 partido.setImagen(imagenPanel);
                 
                 ventanaRegistro.Partido.setIcon(new ImageIcon(imagenPanel));
                
                 }
        }
             
         
     }
    
                 if(e.getSource().equals(ventanaRegistro.candidatura)){
                     Categoria candidatura= (Categoria) ventanaRegistro.candidatura.getSelectedItem();
                    
                     int categoria = candidatura.getIdCategoria();//obtener el id de la categoria cuando se selecciona el elemento
                     
                     
                     
                     switch(categoria){
                         case 1://presidentes
                     ventanaRegistro.scroll.setVisible(true);
                     ventanaRegistro.discurso.setVisible(true); 
                     ventanaRegistro.listaDepartamentos.setVisible(false);
                     ventanaRegistro.Muncipios.setVisible(false);
                     ventanaRegistro.depa.setVisible(false);
                     ventanaRegistro.muni.setVisible(false);
                      ventanaRegistro.lugar.setVisible(false);
                          break;
                          
                         case 2://diputados
                         ventanaRegistro.scroll.setVisible(false);
                         ventanaRegistro.discurso.setVisible(false);

                         ventanaRegistro.lugar.setVisible(true);
                         ventanaRegistro.listaDepartamentos.setVisible(true);
                         ventanaRegistro.depa.setVisible(true);
                         ventanaRegistro.muni.setVisible(false);
                         ventanaRegistro.Muncipios.setVisible(false);
                         break;
                         
                         case 3://alcaldes
                         ventanaRegistro.scroll.setVisible(false);
                          ventanaRegistro.discurso.setVisible(false); 
                             ventanaRegistro.lugar.setVisible(true);
                         ventanaRegistro.listaDepartamentos.setVisible(true);
                         ventanaRegistro.depa.setVisible(true);
                         ventanaRegistro.muni.setVisible(true);
                         ventanaRegistro.Muncipios.setVisible(true);
                      break;
                             
                         
                         default: //si ninguno sale seleccionado solo se mostrara el mensaje
                   
                     
                     break;
                     }
                     
                 
                 
                 
                 
             }
    }

    @Override
    public void focusGained(FocusEvent e) {
        //anadir los borders
        anadirFocusEnable(e, ventanaRegistro.listaDepartamentos);
        anadirFocusEnable(e, ventanaRegistro.listaNacionalidades);
        anadirFocusEnable(e, ventanaRegistro.listaPartidos);
        anadirFocusEnable(e, ventanaRegistro.candidatura);
        anadirFocusEnable(e, ventanaRegistro.Muncipios);
      
        //esto seran los eventos de los campos xd
        anadirFocusGainedCampos(e, ventanaRegistro.Identidad1, "Identidad");
        anadirFocusGainedCampos(e, ventanaRegistro.Nombre, "Nombre Completo");
        anadirFocusGainedCampos(e, ventanaRegistro.Telefono, "Teléfono");
        anadirFocusGainedCampos2(e, ventanaRegistro.discurso,"DIscurso Presidencial");
      }

    @Override
    public void focusLost(FocusEvent e) {
        //Todo esto lo separamos para limpiar el cofigo y evitar elk codigo espagueti
        
        anadirFocuslost(e, ventanaRegistro.listaDepartamentos);
        anadirFocuslost(e, ventanaRegistro.listaNacionalidades);
        anadirFocuslost(e, ventanaRegistro.listaPartidos);
        anadirFocuslost(e, ventanaRegistro.candidatura);
        anadirFocuslost(e, ventanaRegistro.Muncipios);
       

      
        //esto seran los eventos de los campos xd
        anadirFocuslostCampos(e, ventanaRegistro.Identidad1, "Identidad");
        anadirFocuslostCampos(e, ventanaRegistro.Nombre, "Nombre Completo");
        anadirFocuslostCampos(e, ventanaRegistro.Telefono, "Teléfono");
        anadirFocuslostCampos2(e, ventanaRegistro.discurso,"DIscurso Presidencial");
          
    }
    
    public void anadirFocusEnable(FocusEvent e,JComponent combo){
        
        if(e.getSource() == combo){
           Color azul = new Color(0,109,196)  ;
             
          Border borde = BorderFactory.createEmptyBorder(2, 2, 2, 0);
          Border bordeDentro = BorderFactory.createLineBorder(azul, 2, true);
         
          Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);
         
        combo.setBorder(bordeFinal);
          
        
        
    }
        
    }
        
       
    //gracias a las funciones podemos ahorrarnos una gran cantidad de espacio y tiempo en la aplicacion
        public void anadirFocuslost(FocusEvent e,JComponent combo){
        
        if(e.getSource() == combo){
    
            Color sombras = new Color(105,116,112);  
              
          Border borde = BorderFactory.createEmptyBorder(2, 2, 2, 0);
          Border bordeDentro = BorderFactory.createLineBorder(sombras, 1, true);
         
          Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);
         
        combo.setBorder(bordeFinal);
          
      }
        
    }
        
         public void anadirFocusGainedCampos(FocusEvent e,JTextField campo,String placeholder){
            if(e.getSource() == campo){
             
             if(campo.getText().trim().equals(placeholder)){
                campo.setText("");
                campo.setForeground(new Color(200, 205, 208));
            }
             
          Color ColorBlanco = new Color(239,243,245);
          Border borde = BorderFactory.createEmptyBorder(3,3,3,3);
          Border bordeDentro = BorderFactory.createLineBorder(ColorBlanco, 1, true);
         
         
          Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);
         
        campo.setBorder(bordeFinal);
             
         }
            
         }
          public void anadirFocusGainedCampos2(FocusEvent e,JTextArea campo,String placeholder){
            if(e.getSource() == campo){
             
             if(campo.getText().trim().equals(placeholder)){
                campo.setText("");
                campo.setForeground(new Color(200, 205, 208));
            }
             
          Color ColorBlanco = new Color(239,243,245);
          Border borde = BorderFactory.createEmptyBorder(3,3,3,3);
          Border bordeDentro = BorderFactory.createLineBorder(ColorBlanco, 1, true);
         
         
          Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);
         
        campo.setBorder(bordeFinal);
             
         }
            
         }
         
         
         
           public void anadirFocuslostCampos(FocusEvent e,JTextField campo,String placeholder){
        
               if (e.getSource() == campo) {
                    if(campo.getText().trim().equals(placeholder) || campo.getText().equals("")){
                campo.setText(placeholder);
                campo.setForeground(new Color(105,116,112));
            }
             
          Color ColorGris = new Color(118,118,118);
          Border borde = BorderFactory.createEmptyBorder(3,3,3,3);
          Border bordeDentro = BorderFactory.createLineBorder(ColorGris, 1, true);
         
          Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);
         
        campo.setBorder(bordeFinal);
              
               }
               
     
    }
             public void anadirFocuslostCampos2(FocusEvent e,JTextArea campo,String placeholder){
        
               if (e.getSource() == campo) {
                    if(campo.getText().trim().equals(placeholder) || campo.getText().equals("")){
                campo.setText(placeholder);
                campo.setForeground(new Color(105,116,112));
            }
             
          Color ColorGris = new Color(118,118,118);
          Border borde = BorderFactory.createEmptyBorder(3,3,3,3);
          Border bordeDentro = BorderFactory.createLineBorder(ColorGris, 1, true);
         
          Border bordeFinal = BorderFactory.createCompoundBorder(bordeDentro, borde);
         
        campo.setBorder(bordeFinal);
              
               }
               
     
    }
      private void bordesErrores(JComponent componente){
           Border bordePrecaucion = BorderFactory.createLineBorder(new Color(255, 96, 91), 2, true);
                componente.setBorder(bordePrecaucion);
    }    
        
 public void anadirEventoNumeros(KeyEvent e,JTextField campo,int limite){
        if(e.getSource() == campo){
            if(!Character.isDigit(e.getKeyChar()) || campo.getText().length() >= limite ){
                e.consume();//no dejaremos que escriban mas caracters
            }
        }
        
    }
    
     public void anadirEventoDiscurso(KeyEvent e,JTextArea campo,int limite){
        if(e.getSource() == campo){
            if(Character.isAlphabetic(e.getKeyChar()) || Character.isSpaceChar(e.getKeyChar()) || campo.getText().length() >= limite ){
              
            }else{
                e.consume();
            }
            
            if(campo.getText().length() ==limite){
                 JOptionPane.showMessageDialog(ventanaRegistro.discurso, "Se alcanzo el limite de caracteres","No se riegue tanto",2,imagenNice("\\imagenes\\waring .png", 40, 39));
                 e.consume();
            }
        }
        
    }
     
     public boolean limiteNumericos(JTextField campo,int limite,String mensaje){
         if(campo.getText().length() <= limite && campo.getText().length() >=1){
            JOptionPane.showMessageDialog(campo,mensaje,"Rellene completamente los campos",2,imagenNice("\\imagenes\\waring .png", 40, 39));
              bordesErrores(campo);
             return true;
             
         }else{
             return false;
         }
         
     }
    
      public void anadirEventoCampo(KeyEvent e,JTextField campo){
        if(e.getSource() == campo){
            if(Character.isAlphabetic(e.getKeyChar()) || Character.isSpaceChar(e.getKeyChar())){
            }else{
             e.consume();//no dejaremos que escriban mas caracters

            }
        }
        
    }
      
      
           public int calcularEdad(Date fechaNaci){
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//para establecer el formato Horario de Mysql
       sdf.setTimeZone(TimeZone.getTimeZone("UTC")); // Establcecer la zona Horaroa UTC que es el meridiano
      
       LocalDate fechaNacimiento = fechaNaci.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
       
       LocalDate fechaActual = LocalDate.now();
       
       Period periodoAños = Period.between(fechaNacimiento, fechaActual);
       return periodoAños.getYears();
}
     //estas son las imagenes de los JOptionPane
      public Icon imagenNice(String path,int ancho,int alto){
       Icon imagen = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().
                     getScaledInstance(ancho,alto,java.awt.Image.SCALE_SMOOTH));
  
   
   return imagen;
   }
      

      //Eventos de teclado
    @Override
    public void keyTyped(KeyEvent e) {
        anadirEventoNumeros(e, ventanaRegistro.Identidad1,13);
        anadirEventoNumeros(e, ventanaRegistro.Telefono,9);
        anadirEventoCampo(e, ventanaRegistro.Nombre);
        anadirEventoDiscurso(e, ventanaRegistro.discurso,200);
        
    }
   
    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    

    
    //Eventos de del mouse
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == ventanaRegistro.cerrar){
     int salir =1;//
      salir  = JOptionPane.showConfirmDialog(null,"¿Está seguro que quiere volver a la pantalla de incio? ", "Salir",JOptionPane.YES_NO_OPTION,-1 ,imagenNice("\\imagenes\\interrogacion.png", 40, 40));

      if(salir == 0){
        ventanaRegistro.dispose();
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
      if(e.getSource() == ventanaRegistro.MENOS){
             Color color = new Color(180,180,180);
       ventanaRegistro.MENOS.setForeground(color);
      }
        if(e.getSource() == ventanaRegistro.cerrar){
        Color color = new Color(180,180,180);
       ventanaRegistro.cerrar.setForeground(color);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == ventanaRegistro.MENOS){
             Color color = new Color(239,243,245);
       ventanaRegistro.MENOS.setForeground(color);
      }
        if(e.getSource() == ventanaRegistro.cerrar){
        Color color = new Color(239,243,245);
       ventanaRegistro.cerrar.setForeground(color);
        }
    }
}
