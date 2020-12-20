
package Controlador;

import Modelo.Personas.Persona;
import Modelo.Regiones.Departamento;
import Modelo.Regiones.Municipio;
import Modelo.RegistroCandidatos.Alcalde;
import Modelo.RegistroCandidatos.ConsultasCandidatos;
import Modelo.RegistroCandidatos.ConsultasVotaciones;
import Modelo.RegistroCandidatos.Diputado;
import Modelo.RegistroCandidatos.PartidoPolitico;
import Modelo.RegistroCandidatos.Presidente;
import Modelo.Votantes.Consultas;
import Modelo.Votantes.Votante;
import Vista.InterfazInicio;
import Vista.Registro;
import Vista.SalaVotaciones;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import java.awt.font.TextAttribute;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ControladorRegistro implements ActionListener,ItemListener,KeyListener,FocusListener,MouseListener{
    
    
    
    Registro ventanaRegistro;
    Consultas modelo;
    Votante votante;
    UIManager UI;
    
    public ControladorRegistro(Registro ventanaRegistro, Consultas modelo, Votante persona) {
        this.ventanaRegistro = ventanaRegistro;
        this.modelo = modelo;
        this.votante = persona;
        
        //Componentes que tendran Eventos
         mensajeError();
        ventanaRegistro.listaDepartamentos.addItemListener(this);
      
        ValidarCaracteres();
        eventosFocus();
        eventosSalir();
        
        
       
    }
    private void mensajeError(){
    UI=new UIManager();
    UI.put("OptionPane.background", new Color(220, 221, 225));
    UI.put("Panel.background", new Color(220, 221, 225));

    
    }
    
    private void eventosSalir(){
        ventanaRegistro.x.addMouseListener(this);
        ventanaRegistro.menos.addMouseListener(this);   
        
        ventanaRegistro.btnRegistrarse.addActionListener(this);       
        ventanaRegistro.vovler.addMouseListener(this);
    }
    
    private void eventosFocus(){
         
        ventanaRegistro.CampoIdentidad.addFocusListener(this);
        ventanaRegistro.CampoApelldo.addFocusListener(this);
        ventanaRegistro.CampoNombre.addFocusListener(this);
        
    }
    
    public void iniciarVentana(){
          
        ventanaRegistro.setLocationRelativeTo(null);
        ventanaRegistro.setVisible(true);
        insertarModeloDepartamentos();
        ventanaRegistro.grupoBoton.add(ventanaRegistro.masculino);
        ventanaRegistro.grupoBoton.add(ventanaRegistro.femenino);
        ventanaRegistro.setVisible(true);
        
    }
    
    public void insertarModeloDepartamentos(){
    Departamento departamento = new Departamento();
        DefaultComboBoxModel modeloDepartamento = new DefaultComboBoxModel(departamento.mostrarDepartamentos());
        ventanaRegistro.listaDepartamentos.setModel(modeloDepartamento); 
}

    @Override
    public void actionPerformed(ActionEvent e) {
     
        
        
        if(e.getSource() == ventanaRegistro.btnRegistrarse){
           
            
            votante = new Votante();
          
            if (ventanaRegistro.CampoNombre.getText().equals("")
                    || ventanaRegistro.CampoNombre.getText().trim().equals("Primer y segundo nombre")) {

              bordesErrorCampoNombre();
                JOptionPane.showMessageDialog(ventanaRegistro.CampoNombre, "Por favor ingrese su nombre","ERROR",0,imagenNice("\\imagenes\\error.png", 40, 40));
            }
           else if (ventanaRegistro.CampoApelldo.getText().equals("")
                    || ventanaRegistro.CampoApelldo.getText().trim().equals("Primer y segundo apellido")) {
              
               //aca no engorro mi codigo y este es para errorres
               bordesErrorCampoApellido();
               
                JOptionPane.showMessageDialog(ventanaRegistro.CampoApelldo, "Por favor ingrese su apellido","ERROR",0,imagenNice("\\imagenes\\error.png", 40, 40));
            }
          
           else if (ventanaRegistro.CampoIdentidad.getText().equals("")
                    || ventanaRegistro.CampoIdentidad.getText().trim().equals("Tu numero de identidad")) {
              
               bordesErrorCampoIdentidad();
                JOptionPane.showMessageDialog(ventanaRegistro.CampoIdentidad, "Por favor ingrese su numero de identidad","ERROR",0,imagenNice("\\imagenes\\error.png", 40, 40));

            }
            
           else if(ventanaRegistro.calendario.getDate() == null){//si no selecciono la fecha
                JOptionPane.showMessageDialog(ventanaRegistro.calendario, "Por favor ingrese su fecha de nacimiento","ERROR",0,imagenNice("\\imagenes\\error.png", 40, 40));
            }
           else if (ventanaRegistro.masculino.isSelected() == false && ventanaRegistro.femenino.isSelected() == false ) {//si ninguno de los campos de genero fue seleccionado
                JOptionPane.showMessageDialog(ventanaRegistro.ubicar1, "Por favor seleccione su genero", "ERROR", 0,imagenNice("\\imagenes\\error.png", 40, 40));
            }
                       //si esto es igual a 0 es que no eligio nada
          else  if(ventanaRegistro.listaDepartamentos.getSelectedIndex() == 0){
              
              JOptionPane.showMessageDialog(ventanaRegistro.ubicar2, "Por favor seleccione su departamento", "ERROR", 0,imagenNice("\\imagenes\\error.png", 40, 40));
            }
          
          else  if(ventanaRegistro.listaMuncipio.getSelectedIndex()== 0){
       
         JOptionPane.showMessageDialog(ventanaRegistro.ubicar3, "Por favor seleccione su municipio", "ERROR", 0,imagenNice("\\imagenes\\error.png", 40, 40));
           
            }//ai no hay ningun municipio departamento
            
          else{
              
              Date fechaObtenida1 = (Date) ventanaRegistro.calendario.getDate();
        
          long milisegundos1 = fechaObtenida1.getTime();
          java.sql.Date fechas = new java.sql.Date(milisegundos1);
          
            int edad1 = calcularEdad(fechaObtenida1);
             
            if(edad1<18){
         JOptionPane.showMessageDialog(ventanaRegistro.calendario, "Usted no tiene la edad suficiente para votar", "ERROR", 0,imagenNice("\\imagenes\\error.png", 40, 40));

            } 
              
             else if(modelo.verificarUsuario(ventanaRegistro.CampoIdentidad.getText()) == 0){
              String genero = "";
           //transformando la fecha que obtenga del ususario pero debo convertirla al formato mysql
           Date fechaObtenida = (Date) ventanaRegistro.calendario.getDate();
        
          long milisegundos = fechaObtenida.getTime();
          java.sql.Date fecha = new java.sql.Date(milisegundos);
          
            int edad = calcularEdad(fechaObtenida);
            
                
           
          
            
           if(ventanaRegistro.masculino.isSelected() == true){//si este se elecciono
            genero = "Masculino";   
           }else if(ventanaRegistro.femenino.isSelected() == true){
               genero = "Femenino";
           }
           
          votante.setNombre(ventanaRegistro.CampoNombre.getText());
          votante.setApellidos(ventanaRegistro.CampoApelldo.getText()); 
          votante.setNumeroIdentidad(ventanaRegistro.CampoIdentidad.getText()); 
          votante.setGenero(genero);
          votante.setFechaNacimiento(fecha );
          votante.setDepartamento(ventanaRegistro.listaDepartamentos.getSelectedItem().toString());
          votante.setMunicpio(ventanaRegistro.listaMuncipio.getSelectedItem().toString());//el toSTRING me toma la onformacion seleccionado
          votante.setEdad(edad);          //aca guardo un objeti de tipo departamento y se lo establezco de este objeto para envuar el id
          Departamento depar = (Departamento)ventanaRegistro.listaDepartamentos.getSelectedItem();
          Municipio muni = (Municipio)  ventanaRegistro.listaMuncipio.getSelectedItem();
         
          
          
         votante.setIdDepartamento(depar.getId_Departamento());
         votante.setIdMunicipio(muni.getIdMunicipio());
            
          if(modelo.insertarVotante(votante)){
              //si se inserto el usuario correctamente entonces voy a insertar en unio pp
              
              
              JOptionPane.showMessageDialog(null, "Registro ingresado correctamente","FELICITACIONES!!",JOptionPane.PLAIN_MESSAGE,imagenNice("\\imagenes\\nice.png", 40, 40));
               modelo.joinUserAdress(votante);//aca lo uniremos al 
             
               
                 Object options[]= {"Registrar otro usuario","Entrar a la sala"};
                
                 int seleccion =  JOptionPane.showOptionDialog(null, "Puede entrar a la sala después","Seleccione la accion a realizar", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,imagenNice("\\imagenes\\interrogacion.png",40,40), options, options[1]);

               if(seleccion == 0){
                 limpiarCajar();
  
               }else{
                 
               JOptionPane.showMessageDialog(null, "BIENVENIDO A LA SALA DE VOTACIONES"+"\n\nUsuario: "+votante.getNombre()+"\nDepartamento: "+votante.getDepartamento()+"\nMunicipio: "+votante.getMunicpio(),"Elija con sabiduria",JOptionPane.PLAIN_MESSAGE,imagenNice("\\Imagenes\\soldado.png", 40, 40));
               ventanaRegistro.dispose();
                              

               SalaVotaciones sala = new SalaVotaciones();
                 PartidoPolitico partido = new PartidoPolitico();
                 Alcalde alcalde = new Alcalde();
                 Presidente presidente = new Presidente();
                 Diputado diputado = new Diputado();
                 ConsultasVotaciones modelo = new ConsultasVotaciones();
                 ConsultasCandidatos modeloCandidatos = new ConsultasCandidatos();

               Controlador.ControladorSala controlador = new ControladorSala(votante, sala, partido, alcalde, presidente, diputado, modelo,modeloCandidatos);
               controlador.iniciar();
              limpiarCajar();
              
               }    
           }
           
           
              
          }else{
              JOptionPane.showMessageDialog(ventanaRegistro.CampoIdentidad, "Este ciudadano ya esta en el registro\nIngrese otro numero de identidad","ALERTA ACA NO ESTAMOS EN HONDURAS",2,imagenNice("\\imagenes\\waring .png", 40, 39));
           
          }
        }
        }
        
        }
    
   public Icon imagenNice(String path,int ancho,int alto){
       Icon imagen = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().
                     getScaledInstance(ancho,alto,java.awt.Image.SCALE_SMOOTH));
  
   
   return imagen;
   }
     

    @Override
    public void itemStateChanged(ItemEvent e) {
         if(e.getStateChange() == ItemEvent.SELECTED){//si un elemento de la lista fue seleccionado esto me lo verifica y me lo indica xd y caa vez que un elemento de mi lista sea seleccionado yo Lo guarsdarte en un municipio y voy a crear un modelo para luego establ;ecerlo

            Departamento depa = (Departamento) ventanaRegistro.listaDepartamentos.getSelectedItem();
            Municipio municipio = new Municipio();

            DefaultComboBoxModel modeloMuncipio = new DefaultComboBoxModel(municipio.mostrarMuncipios(depa));

            ventanaRegistro.listaMuncipio.setModel(modeloMuncipio);
        }
         
         
         

    }//los hago privados para que nadie se meta con mis caracteres
    private void ValidarCaracteres(){
        ventanaRegistro.CampoIdentidad.addKeyListener(this);
        ventanaRegistro.CampoApelldo.addKeyListener(this);
        ventanaRegistro.CampoNombre.addKeyListener(this);//el this hace refernecia a la misma clase   
        
    }
    
    

    @Override//verificar que el usuario no me escriba otra cosa en el campo identidad
    public void keyTyped(KeyEvent e) {//
        
        if(e.getSource() == ventanaRegistro.CampoIdentidad){//verificando que este evento sea solo del numero de identidad
    
            if(!Character.isDigit(e.getKeyChar()) || ventanaRegistro.CampoIdentidad.getText().length() >= 13){//verifivando si el caracter es un digito parra que no me escriba mamonadas deletras en el numero de identidad y ademas no podra escribir mas de 16 digitos 
          e.consume();//si el digito ingresado no es un 
        }//si el usuario ingresa una letra no le dejare escribir nada gracias al consume y el Caracter es digit me ayuda a validar si un caracter es un digito y este evento al ser un keyTyped se ejecutara cada vez que yo presione una tecla
       
        }else if(e.getSource() == ventanaRegistro.CampoApelldo){
    
        if(Character.isAlphabetic(e.getKeyChar()) ||Character.isSpaceChar(e.getKeyChar()) ){//aca digo que si el caracter ingresado y esto lo valiendo con el Caracter is Digit para evitar cosas rraras despues
             
        }else{
             e.consume();
        }
    
    }else if(e.getSource() == ventanaRegistro.CampoNombre){
    
        if(Character.isAlphabetic(e.getKeyChar()) ||Character.isSpaceChar(e.getKeyChar()) ){//aca digo que si el caracter ingresado y esto lo valiendo con el Caracter is Digit para evitar cosas rraras despues
             
        }else{
             e.consume();
        }
        
        
    
    }
    
    
}
    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        //Solamente comprobanco que tipo de campo tiene el focus
   if(e.getSource() == ventanaRegistro.CampoNombre){//verificando que este evento sea solo del numero de identidad
    
      
     if(ventanaRegistro.CampoNombre.getText().trim().equals("Primer y segundo nombre")){
         ventanaRegistro.CampoNombre.setText("");
         ventanaRegistro.CampoNombre.setForeground(Color.WHITE);
     }
       Border bordeCampo =  BorderFactory.createLineBorder( new Color(51, 177, 255),2,true );
       Border campoVacio = BorderFactory.createEmptyBorder(6, 6, 6, 6);
       Border agregarBorde = BorderFactory.createCompoundBorder(bordeCampo, campoVacio);
       
          ventanaRegistro.CampoNombre.setBorder(agregarBorde);
    }
      
      if(e.getSource() == ventanaRegistro.CampoApelldo){

          if(ventanaRegistro.CampoApelldo.getText().trim().equals("Primer y segundo apellido")){
         ventanaRegistro.CampoApelldo.setText("");
         ventanaRegistro.CampoApelldo.setForeground(Color.WHITE);
     }
           Border bordeCampo =  BorderFactory.createLineBorder( new Color(51, 177, 255),2,true );
       Border campoVacio = BorderFactory.createEmptyBorder(6, 6, 6, 6);
       Border agregarBorde = BorderFactory.createCompoundBorder(bordeCampo, campoVacio);
       
          ventanaRegistro.CampoApelldo.setBorder(agregarBorde);
          
       
    }
    if(e.getSource() == ventanaRegistro.CampoIdentidad){
  
           if(ventanaRegistro.CampoIdentidad.getText().trim().equals("Tu numero de identidad")){
         ventanaRegistro.CampoIdentidad.setText("");
         ventanaRegistro.CampoIdentidad.setForeground(Color.WHITE);
     } 
        Border bordeCampo =  BorderFactory.createLineBorder( new Color(51, 177, 255),2,true );
       Border campoVacio = BorderFactory.createEmptyBorder(6, 6, 6, 6);
       Border agregarBorde = BorderFactory.createCompoundBorder(bordeCampo, campoVacio);
       
          ventanaRegistro.CampoIdentidad.setBorder(agregarBorde);    
          
          
    }
          if(e.getSource() == ventanaRegistro.vovler){
                Font font = ventanaRegistro.vovler.getFont();
                ventanaRegistro.vovler.setForeground(Color.red);
          }
        
    }
        
      /*Calcula la edad tomando como referencia la fecha actual con la fecha de  nació*/ 
   public int calcularEdad(Date fechaNaci){
      
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//para establecer el formato Horario de Mysql
       sdf.setTimeZone(TimeZone.getTimeZone("UTC")); // Establcecer la zona Horaroa UTC que es el meridiano
      
       LocalDate fechaNacimiento = fechaNaci.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
       
       LocalDate fechaActual = LocalDate.now();
       
       Period periodoAños = Period.between(fechaNacimiento, fechaActual);
       
       
       
       
//con esta Period calculo el periodo de tiempo entre 2 fechas
       
       
       return periodoAños.getYears();//retornando la diferencia entre los 2 años
}//Cierra método calcularEdad  
    
   
   @Override
    public void focusLost(FocusEvent e) {
      
//Los eventos focus se ejecutaran cuando el usuario deje de presionar el boton ese de campo
if(e.getSource() == ventanaRegistro.CampoNombre){//verificando que este evento sea solo del numero de identidad
    
      
     if(ventanaRegistro.CampoNombre.getText().equals("")
      || ventanaRegistro.CampoNombre.getText().trim().equals("Primer y segundo nombre")){
         
         ventanaRegistro.CampoNombre.setText("Primer y segundo nombre");
         ventanaRegistro.CampoNombre.setForeground(new Color(117,142,178));
     }
        Border bordeCampo =  BorderFactory.createLineBorder( new Color(99,123,157),1,true );
       Border campoVacio = BorderFactory.createEmptyBorder(6, 6, 6, 6);
       Border agregarBorde = BorderFactory.createCompoundBorder(bordeCampo, campoVacio);
       
          ventanaRegistro.CampoNombre.setBorder(agregarBorde);
    }
      
      if(e.getSource() == ventanaRegistro.CampoApelldo){

          if(ventanaRegistro.CampoApelldo.getText().trim().equals("Primer y segundo apellido") ||
                  ventanaRegistro.CampoApelldo.getText().equals("")){
         ventanaRegistro.CampoApelldo.setText("Primer y segundo apellido");
         ventanaRegistro.CampoApelldo.setForeground(new Color(117,142,178));
     }
           Border bordeCampo =  BorderFactory.createLineBorder( new Color(99,123,157),1,true );
       Border campoVacio = BorderFactory.createEmptyBorder(6, 6, 6, 6);
       Border agregarBorde = BorderFactory.createCompoundBorder(bordeCampo, campoVacio);
       
          ventanaRegistro.CampoApelldo.setBorder(agregarBorde);
          
       
    }
    if(e.getSource() == ventanaRegistro.CampoIdentidad){
  
           if(ventanaRegistro.CampoIdentidad.getText().trim().equals("Tu numero de identidad") ||
                   ventanaRegistro.CampoIdentidad.getText().equals("")){
         ventanaRegistro.CampoIdentidad.setText("Tu numero de identidad");
         ventanaRegistro.CampoIdentidad.setForeground(new Color(117,142,178));
         
         
             
         }
           if(ventanaRegistro.CampoIdentidad.getText().length() <= 12 && ventanaRegistro.CampoIdentidad.getText().length() >=1){
               bordesErrorCampoIdentidad();
               JOptionPane.showMessageDialog(ventanaRegistro.CampoIdentidad,"El numero de identidad es incorrecto","ERROR",0);
                
           }
      
           
      Border bordeCampo =  BorderFactory.createLineBorder( new Color(99,123,157),1,true );
       Border campoVacio = BorderFactory.createEmptyBorder(6, 6, 6, 6);
       Border agregarBorde = BorderFactory.createCompoundBorder(bordeCampo, campoVacio);
       
          ventanaRegistro.CampoIdentidad.setBorder(agregarBorde);    
    }



    }
    //encapsulando estos bordes para evitar engprdar el codigo
     private void bordesErrorCampoIdentidad(){
           Border bordePrecaucion = BorderFactory.createLineBorder(new Color(255, 96, 91), 2, true);
                Border campoVacio = BorderFactory.createEmptyBorder(6, 6, 6, 6);
                Border agregarBorde = BorderFactory.createCompoundBorder(bordePrecaucion, campoVacio);
                ventanaRegistro.CampoIdentidad.setBorder(agregarBorde);
    }
    
     private void bordesErrorCampoApellido(){
           Border bordePrecaucion = BorderFactory.createLineBorder(new Color(255, 96, 91), 2, true);
                Border campoVacio = BorderFactory.createEmptyBorder(6, 6, 6, 6);
                Border agregarBorde = BorderFactory.createCompoundBorder(bordePrecaucion, campoVacio);
                ventanaRegistro.CampoApelldo.setBorder(agregarBorde);
    }
     private void bordesErrorCampoNombre(){
           Border bordePrecaucion = BorderFactory.createLineBorder(new Color(255, 96, 91), 2, true);
                Border campoVacio = BorderFactory.createEmptyBorder(6, 6, 6, 6);
                Border agregarBorde = BorderFactory.createCompoundBorder(bordePrecaucion, campoVacio);
                ventanaRegistro.CampoNombre.setBorder(agregarBorde);
    }
     private void bordesErrorDepartamentos(){
           Border bordePrecaucion = BorderFactory.createLineBorder(new Color(255, 96, 91), 2, true);
          
              
                ventanaRegistro.listaDepartamentos.setBorder(bordePrecaucion);
    }
     
      private void bordesErrorMunicipio(){
           Border bordePrecaucion = BorderFactory.createLineBorder(new Color(255, 96, 91), 2, true);
          
              
                ventanaRegistro.listaMuncipio.setBorder(bordePrecaucion);
    }
     
     public void limpiarCajar(){
         eventosFocus();
        ventanaRegistro.CampoNombre.setText("");
        ventanaRegistro.CampoIdentidad.setText("");
        ventanaRegistro.CampoApelldo.setText("");
        ventanaRegistro.listaDepartamentos.setSelectedIndex(0);
        ventanaRegistro.grupoBoton.clearSelection();
        ventanaRegistro.calendario.setDate(null);
        ventanaRegistro.listaMuncipio.removeAllItems();
        
    }

     
     
     
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == ventanaRegistro.vovler){
            InterfazInicio interfaz = new InterfazInicio();
            interfaz.pack();
            interfaz.setVisible(true);
            
            ventanaRegistro.dispose();
        }
       
        if(e.getSource() == ventanaRegistro.x){
             int salir =1;//
      salir  = JOptionPane.showConfirmDialog(null,"¿Está seguro que quiere volver qa la pantalla de incio? ", "Salir",JOptionPane.YES_NO_OPTION,-1 ,imagenNice("\\imagenes\\interrogacion.png", 40, 40));

      if(salir == 0){
       
       InterfazInicio interfaz = new InterfazInicio();
    Controlador.ControladorInicio controlar = new ControladorInicio(interfaz);
    
    controlar.inicarApp();
         ventanaRegistro.dispose();
      }
        
        salir = 1;
        
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Unicamente cuando presionan pero no suletan el click
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //cuando ustedes soltaron el click
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       if(e.getSource() == ventanaRegistro.vovler){
           Font font = ventanaRegistro.vovler.getFont();
           Map attributes = font.getAttributes();
           attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
           ventanaRegistro.vovler.setFont(font.deriveFont(attributes));
           ventanaRegistro.vovler.setForeground(new Color(160,160,160));
        }
         if(e.getSource() == ventanaRegistro.menos){
             Color color = new Color(200,200,200);
       ventanaRegistro.menos.setForeground(color);
      }
        if(e.getSource() == ventanaRegistro.x){
        Color color = new Color(200,200,200);
       ventanaRegistro.x.setForeground(color);
        }
          
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
         if(e.getSource() == ventanaRegistro.vovler){
          Font font = ventanaRegistro.vovler.getFont();
           Map attributes = font.getAttributes();
           attributes.put(TextAttribute.UNDERLINE, -1);//aca le quito el subrayado
           ventanaRegistro.vovler.setFont(font.deriveFont(attributes));
           ventanaRegistro.vovler.setForeground(new Color(240,240,240));
        }
         
         if(e.getSource() == ventanaRegistro.menos){
             Color color = new Color(239,243,245);
       ventanaRegistro.menos.setForeground(color);
      }
        if(e.getSource() == ventanaRegistro.x){
        Color color = new Color(239,243,245);
       ventanaRegistro.x.setForeground(color);
        }
        
    }
}
