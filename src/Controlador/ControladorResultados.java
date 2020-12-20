
package Controlador;

import Modelo.Resultados.Departamento;
import Modelo.Resultados.Municipio;
import Modelo.RegistroCandidatos.Alcalde;
import Modelo.RegistroCandidatos.Categoria;
import Modelo.RegistroCandidatos.Conexion;
import Modelo.RegistroCandidatos.ConsultasVotaciones;
import Modelo.RegistroCandidatos.Diputado;
import Modelo.RegistroCandidatos.PartidoPolitico;
import Modelo.RegistroCandidatos.Presidente;
import Modelo.Resultados.ConsultasResultados;
import Vista.InterfazInicio;
import Vista.InterfazResultados;
import com.mysql.jdbc.ResultSetMetaData;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class ControladorResultados implements ActionListener,ItemListener,FocusListener,MouseListener{
    InterfazResultados ventana;
    Presidente presidente;
    Alcalde alcalde;
    Diputado diputado;
    ConsultasResultados consultas;
    PartidoPolitico partido;
    UIManager UI;

    public ControladorResultados(InterfazResultados ventana, Presidente presidente, Alcalde alcalde, Diputado diputado, ConsultasResultados consultas, PartidoPolitico partido) {
        this.ventana = ventana;
        this.presidente = presidente;
        this.alcalde = alcalde;
        this.diputado = diputado;
        this.consultas = consultas;
        this.partido = partido;
      
        insertarModelos();
        modeloPresidente();
        elementosVisibles();
        eventosResultados();
        
    }
        


    
public void inciar(){
    ventana.setLocationRelativeTo(null);
    ventana.setVisible(true);
}    

public void elementosVisibles(){
            ventana.departamentos.setVisible(false);
            ventana.municipios.setVisible(false);
            ventana.panelRegiones.setVisible(false);
            
            colorSeparador(ventana.jSeparator2);
           
        
    
}

private void eventosResultados(){
   eventosItem();
   eventosFocus();

   
   
}

public void eventosItem(){
    ventana.departamentos.addItemListener(this);
    ventana.candidatos.addItemListener(this);
    ventana.municipios.addItemListener(this);
    ventana.cerrar.addMouseListener(this);
    ventana.MENOS.addMouseListener(this);
}

public void eventosFocus(){
    ventana.departamentos.addFocusListener(this);
    
    ventana.municipios.addFocusListener(this);
    
    ventana.candidatos.addFocusListener(this);
    ventana.campoNombre.addFocusListener(this);
    ventana.campoPartido.addFocusListener(this);
    ventana.campoPorcentaje.addFocusListener(this);
    ventana.campoVotos.addFocusListener(this);
    ventana.tabla.addMouseListener(this);
}


public void insertarModelos(){
    insertarDepartamentos();
    agregarCategoria();
    
}
   public void agregarCategoria() {
        Categoria model = new Categoria();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(model.establecerCategoria());

        ventana.candidatos.setModel(modelo);
    }

    public void insertarDepartamentos(){
    Departamento departamento = new Departamento();
        DefaultComboBoxModel modeloDepartamento = new DefaultComboBoxModel(departamento.mostrarDepartamentos());
        ventana.departamentos.setModel(modeloDepartamento); 
}

   public void insertarModeloMunicipio(ItemEvent e){
    if(e.getStateChange() == ItemEvent.SELECTED){//si un elemento de la lista fue seleccionado esto me lo verifica y me lo indica xd y caa vez que un elemento de mi lista sea seleccionado yo Lo guarsdarte en un municipio y voy a crear un modelo para luego establ;ecerlo

            Departamento depa = (Departamento) ventana.departamentos.getSelectedItem();
            Municipio municipio = new Municipio();

            DefaultComboBoxModel modeloMuncipio = new DefaultComboBoxModel(municipio.mostrarMuncipios(depa));

            ventana.municipios.setModel(modeloMuncipio);
        }
    
      
}
   
 public void colorSeparador(JSeparator separar){
        separar.setForeground(new Color(160,160,160));
    }


















//Eventos abstractos de los listener
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
           if (e.getSource() == ventana.departamentos) {
            insertarModeloMunicipio(e);

            int indice = ventana.candidatos.getSelectedIndex();

            if (indice == 1 && ventana.departamentos.getSelectedIndex() != 0) {
                PreparedStatement consultas;
                ResultSet resultados;
                Conexion conexion = new Conexion();
               
                
                DefaultTableModel modeloTabla1 = new DefaultTableModel(){
                    @Override
                    public boolean isCellEditable(int row, int column) {
                                   if(column == 3){
                                       return true;
                                   }else{
                                       return false;
                                   }
                    }
                
                
                };
                ventana.tabla.setModel(modeloTabla1);

                modeloTabla1.addColumn("Nombre");
                modeloTabla1.addColumn("Partido Politico");
                modeloTabla1.addColumn("Votos");

                

             

                try {
                 Departamento depa = (Departamento) ventana.departamentos.getSelectedItem();
                
                int departamento = depa.getId_Departamento();
                
                    Connection conectar = conexion.getConnection();

                    consultas = conectar.prepareStatement("select d.nombre, pa.nombrePartido ,d.votos from diputados as d\n"
                            + "inner join partidos pa on d.idPartido = pa.idPartido where d.id_Departamento = ?");

                    consultas.setInt(1, departamento);

                    resultados = consultas.executeQuery();

                    ResultSetMetaData rsm = (ResultSetMetaData) resultados.getMetaData();
                    
                    int nColumnas = rsm.getColumnCount();

                    int anchos[] = {190,180,80};
                    
                    cambiarAncho(anchos, nColumnas);

                    while (resultados.next()) {
                        Object filas2[] = new Object[3];

                        for (int i = 0; i < nColumnas; i++) {
                            filas2[i] = resultados.getObject(i + 1);

                        }
                        modeloTabla1.addRow(filas2);
                    }
                    
                     

                } catch (Exception ex) {
                    System.err.println("Error " + ex);
                }
             
            }

             
             
            }
            
       else if(e.getSource() == ventana.candidatos){
          modeloPresidente();
            
        }else  if (e.getSource() == ventana.municipios) {
    
            if(ventana.municipios.getSelectedIndex() != 0 && ventana.candidatos.getSelectedIndex() == 2){
               PreparedStatement consultas;
                ResultSet resultados;
                Conexion conexion = new Conexion();
              
                 DefaultTableModel modeloTabla2 = new DefaultTableModel(){
                    @Override
                    public boolean isCellEditable(int row, int column) {
                                   if(column == 3){
                                       return true;
                                   }else{
                                       return false;
                                   }
                    }
                
                
                };
                
                ventana.tabla.setModel(modeloTabla2);

                modeloTabla2.addColumn("Nombre");
                modeloTabla2.addColumn("Partido Politico");
                modeloTabla2.addColumn("Votos");

                

             

                try {
                 Municipio muni = (Municipio) ventana.municipios.getSelectedItem();
                
                int municipio = muni.getIdMunicipio();
                
                    Connection conectar = conexion.getConnection();

                    consultas = conectar.prepareStatement("select a.nombre, pa.nombrePartido ,a.votos from alcaldes as a\n"
                            + "inner join partidos pa on a.idPartido = pa.idPartido where a.id_Municipio = ?");

                    consultas.setInt(1, municipio);

                    resultados = consultas.executeQuery();

                    ResultSetMetaData rsm = (ResultSetMetaData) resultados.getMetaData();
                    
                    int nColumnas = rsm.getColumnCount();

                    int anchos[] = {190,180,80};
                    
                    cambiarAncho(anchos, nColumnas);

                    while (resultados.next()) {
                        Object filas2[] = new Object[3];

                        for (int i = 0; i < nColumnas; i++) {
                            filas2[i] = resultados.getObject(i + 1);

                        }
                        modeloTabla2.addRow(filas2);
                    }
                    
                     

                } catch (Exception ex) {
                    System.err.println("Error " + ex);
                } 
            }
            
        }
           
            
    }

      public void modeloPresidente(){
         int indice = ventana.candidatos.getSelectedIndex();
            movimientosCandidatos(indice);
           
            PreparedStatement consultas;
            ResultSet resultados;
            Conexion conexion = new Conexion();
            switch(indice){
                
                
                case 0:
                    
                    if(indice == 0){
                      DefaultTableModel modeloTabla = new DefaultTableModel(){
                    @Override
                    public boolean isCellEditable(int row, int column) {
                                   if(column == 3){
                                       return true;
                                   }else{
                                       return false;
                                   }
                    }
                
                
                };
                    ventana.tabla.setModel(modeloTabla);
                    
                    modeloTabla.addColumn("Nombre");
                    modeloTabla.addColumn("Partido Politico");
                    modeloTabla.addColumn("Votos");
                    try{
                       Connection conectar = conexion.getConnection();
                       
                        
                       
                  consultas = conectar.prepareStatement("select p.nombre, pa.nombrePartido ,p.votos from presidentes as p\n" +
                                                         "inner join partidos pa on p.idPartido = pa.idPartido ");
                   resultados =  consultas.executeQuery();
                   ResultSetMetaData rsm = (ResultSetMetaData) resultados.getMetaData();
                   int nColumnas = rsm.getColumnCount();
                  
                   int anchos[] = {190,180,80};
                   cambiarAncho(anchos, nColumnas);
                   
                   while(resultados.next()){
                       Object filas[] = new Object[3];
                      
                       for(int i=0;i<nColumnas;i++){
                           filas[i] = resultados.getObject(i+1);
                           
                       }
                       modeloTabla.addRow(filas);
                   }
                   
                   
                    }catch(Exception ex){
                        System.err.println("Error "+ex);
                    }
                    }
                    
                    
                    break;
                    
            } 
    }

    
    public void cambiarAncho(int[] anchos,int col){
        for(int i=0;i<col;i++){
            ventana.tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        anadirFocusEnable(e, ventana.candidatos);
        anadirFocusEnable(e, ventana.departamentos);
        anadirFocusEnable(e, ventana.municipios);
        
        anadirFocusGainedCampos(e, ventana.campoNombre,"Nombre Candidato");
        anadirFocusGainedCampos(e, ventana.campoPartido,"Partido Político");
        anadirFocusGainedCampos(e, ventana.campoPorcentaje,"Porcentaje Votos");
        anadirFocusGainedCampos(e, ventana.campoVotos, "Votos");
    }

    @Override
    public void focusLost(FocusEvent e) {
        anadirFocuslost(e, ventana.candidatos);
         anadirFocuslost(e, ventana.departamentos);
          anadirFocuslost(e, ventana.municipios);
          
          anadirFocuslostCampos(e, ventana.campoNombre,"Nombre Candidato");
          anadirFocuslostCampos(e, ventana.campoPartido,"Partido Político");
           anadirFocuslostCampos(e, ventana.campoPorcentaje,"Porcentaje Votos");
           anadirFocuslostCampos(e, ventana.campoVotos, "Votos");
           
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
    
    public void movimientosCandidatos(int indice){
        switch(indice){
            case 0:
               ventana.departamentos.setVisible(false);
               ventana.municipios.setVisible(false);
               ventana.panelRegiones.setVisible(false);
               
                bordeListasQuitar(ventana.departamentos);
                bordeListasQuitar(ventana.municipios);
                limpiar();
            break;
                
            case 1:
                ventana.departamentos.setVisible(true);
               ventana.municipios.setVisible(false);
               ventana.panelRegiones.setVisible(true);  
                bordeListas(ventana.departamentos);
                ventana.municipios.removeAllItems();
                bordeListasQuitar(ventana.municipios);
                
            break;     
                
            case 2:
               
                
               ventana.departamentos.setVisible(true);
               ventana.municipios.setVisible(true);
               ventana.panelRegiones.setVisible(true); 
                bordeListasQuitar(ventana.departamentos);
                bordeListas(ventana.municipios);
                
                if(ventana.departamentos.getSelectedIndex() == 0){
                 ventana.municipios.removeAllItems();
               }
               
            break;    
        }
        
        
    }
    
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
    
    public void limpiar(){
        ventana.departamentos.setSelectedIndex(0);
       ventana.municipios.removeAllItems();
    }

    @Override
    public void mouseClicked(MouseEvent e) {//evento del mouse
        if(e.getSource() == ventana.tabla){
         int indice = ventana.candidatos.getSelectedIndex();
          int fila  = ventana.tabla.getSelectedRow();
             
        String nombre =   ventana.tabla.getValueAt(fila, 0).toString();//obteniendo el nombre d ela primera fila
        

 ventana.campoPartido.setForeground(new Color(200, 205, 208));
           ventana.campoPorcentaje.setForeground(new Color(200, 205, 208));

           ventana.campoVotos.setForeground(new Color(200, 205, 208));
           ventana.campoNombre.setForeground(new Color(200, 205, 208));
   
           
         switch(indice){
             case 0:
                //Presidente
            
           presidente = consultas.buscarNombre(nombre);
           
           ventana.campoNombre.setText(presidente.getNombre());
      
           ventana.campoVotos.setText(String.valueOf(presidente.getVotos()));
           
           String partidos = consultas.NombrePartidos(presidente.getId_Partido());
          BufferedImage imagen = consultas.imagenPartidos(presidente.getId_Partido());
           
           ventana.campoPartido.setText(partidos);
           
           ventana.imagenPresidente.setIcon(new ImageIcon(presidente.getImagen()));
            
           ventana.imagenPartido.setIcon(new ImageIcon(imagen));
           
           double nVotos = consultas.sumaVotos();
           double nCandidatos = consultas.nCandidatos();
           
           double porcantaje = (presidente.getVotos() * 100) / nVotos;
           
           ventana.campoPorcentaje.setText(String.format("%.2f", porcantaje) + " %");
             break;
             
             
             case 1:
                             
                   diputado = consultas.busacrNombreD(nombre);
                   
           ventana.campoNombre.setText(diputado.getNombre());
            
           
           ventana.campoVotos.setText(String.valueOf(diputado.getVotos()));
           
           String partidos1 = consultas.NombrePartidos(diputado.getId_Partido());
          
           BufferedImage imagenD = consultas.imagenPartidos(diputado.getId_Partido());
           
           ventana.campoPartido.setText(partidos1);
           
           ventana.imagenPresidente.setIcon(new ImageIcon(diputado.getImagen()));
            
           ventana.imagenPartido.setIcon(new ImageIcon(imagenD));
             
            double nVotos3 = consultas.sumaVotosD(diputado);
           
           double porcantaje2 = (diputado.getVotos() * 100) / nVotos3;
           
           ventana.campoPorcentaje.setText(String.format("%.2f", porcantaje2) + " %");
           
                   
                   break;    
                   
             case 2:
                
                   
                   alcalde = consultas.buscarNombreA(nombre);
                   
           ventana.campoNombre.setText(alcalde.getNombre());
      
           ventana.campoVotos.setText(String.valueOf(alcalde.getVotos()));
           
           String partidos2 = consultas.NombrePartidos(alcalde.getId_Partido());
          
           BufferedImage imagenA = consultas.imagenPartidos(alcalde.getId_Partido());
           
           ventana.campoPartido.setText(partidos2);
           
           ventana.imagenPresidente.setIcon(new ImageIcon(alcalde.getImagen()));
            
           ventana.imagenPartido.setIcon(new ImageIcon(imagenA));
                   
            double nVotos1 = consultas.sumaVotosA(alcalde);
           
           double porcantaje1 = (alcalde.getVotos() * 100) / nVotos1;
           
           ventana.campoPorcentaje.setText(String.format("%.2f", porcantaje1) + " %");
           
                 
                 break;
         }
            
          
         
           
            
        }
        
        if(e.getSource() == ventana.cerrar){
             int salir =1;//
      salir  = JOptionPane.showConfirmDialog(null,"¿Está seguro que quiere volver a la pantalla de incio? ", "Salir",JOptionPane.YES_NO_OPTION,-1 ,imagenNice("\\imagenes\\interrogacion.png", 40, 40));

      if(salir == 0){
        ventana.dispose();
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
        if(e.getSource() == ventana.MENOS){
            
           Color color = new Color(200,200,200);
       ventana.MENOS.setForeground(color); 
       
        }else if(e.getSource() == ventana.cerrar){
           Color color = new Color(200,200,200);
       ventana.cerrar.setForeground(color);  
        }
                
                
        
         
    }

    @Override
    public void mouseExited(MouseEvent e) {
         if(e.getSource() == ventana.MENOS){
             Color color = new Color(239,243,245);
        ventana.MENOS.setForeground(color);
             
        }else if(e.getSource() == ventana.cerrar){
            Color color = new Color(239,243,245);
        ventana.cerrar.setForeground(color); 
        }
    }
    
       public Icon imagenNice(String path,int ancho,int alto){
       Icon imagen = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().
                     getScaledInstance(ancho,alto,java.awt.Image.SCALE_SMOOTH));
  
   
   return imagen;
   }
   
         
         
         
}
