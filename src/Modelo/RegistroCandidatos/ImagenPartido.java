
package Modelo.RegistroCandidatos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class ImagenPartido extends JPanel{//para sobreescribir el metodo paint
 BufferedImage imagen;
    
    public ImagenPartido(int ancho,int largo,BufferedImage imagen){
        this.setSize(ancho,largo);
        this.imagen = imagen;//esta imagen la conseguire cuando la tranforme a binario y esto lo conseguire desde un codigo binario
    
    }

    @Override
    public void paint(Graphics g) {
        //para pintar una imagen necesito sobreescribir el metodo Paint
        
       
        Dimension tamañoImagen = getSize();//este objeto de tipo dimension sera igual al tamanio de esta clase imagen
        g.drawImage(imagen, 0, 0,tamañoImagen.width,tamañoImagen.height, null);
        
        setOpaque(false);
        super.paintComponent(g);//y con el painComppnente pinto la imagen que me transformen en codigo Binario
        
    }
    
    
    
    
}
