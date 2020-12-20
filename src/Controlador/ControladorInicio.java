
package Controlador;

import Modelo.Votantes.Consultas;
import Modelo.Votantes.Votante;
import Vista.InterfazInicio;
import Vista.Registro;
import Vista.RegistroCandidatos;
import Vista.SalaVotaciones;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class ControladorInicio implements MouseListener{
   private InterfazInicio interfaz;
    
//En el constructor se ubican los eventos
    public ControladorInicio(InterfazInicio interfaz) {
        this.interfaz = interfaz;
        interfaz.cerrar.addMouseListener(this);
    }
 
    
 public void inicarApp(){
     interfaz.setVisible(true);
     interfaz.setLocationRelativeTo(null);
 }

    @Override
    public void mouseClicked(MouseEvent e) {
         int salir =1;//
      salir  = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea salir de la aplicacion? ", "Salir",JOptionPane.YES_NO_OPTION,-1 ,imagenNice("\\imagenes\\interrogacion.png", 40, 40));

      if(salir == 0){
        System.exit(0);
      }
        
        salir = 1;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Color color = new Color(180,180,180);
       interfaz.cerrar.setForeground(color);
    }

    @Override
    public void mouseExited(MouseEvent e) {
          Color color = new Color(239,243,245);
       interfaz.cerrar.setForeground(color);
    }
    
    
    
    public Icon imagenNice(String path,int ancho,int alto){
       Icon imagen = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().
                     getScaledInstance(ancho,alto,java.awt.Image.SCALE_SMOOTH));
  
   
   return imagen;
   }

    
        
        
    
    
    
}
