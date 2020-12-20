package Vista.CambiarListas.combo;
import com.jtattoo.plaf.BaseScrollButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class CustomUI1 extends BasicComboBoxUI{
    
    private ImageIcon espacio =  new ImageIcon(getClass().getResource("/Vista/CambiarListas/res/espacio.png"));
    private Color Beautiful = new Color(42,59,71);
    
    
    private Color colorseleccion = new Color(160, 167, 172);
    private Color colorFondo =new Color(3,9,30);
    private Color flecha = new Color(105,116,112);
    
    public static ComboBoxUI createUI(JComponent c) {
        return new CustomUI1();
    }
    
    @Override 
    protected JButton createArrowButton() {     
       
        BasicArrowButton basicArrowButton = new BasicArrowButton(BasicArrowButton.SOUTH, //Direccion de la flecha
                Beautiful, //Color de fondo
                flecha,//sombra
                flecha,//darkShadow
                Color.WHITE //highlight
                
                
                );         
        //se quita el efecto 3d del boton, sombra y darkShadow no se aplican 
        basicArrowButton.setBorder(BorderFactory.createLineBorder(Beautiful,2));
        basicArrowButton.setContentAreaFilled(false);
        basicArrowButton.setForeground(flecha);
        
        
        
        
        return basicArrowButton;
    }        

    //Se puede usar un JButton para usar un icono personalizado en lugar del arrow
    /*     
    @Override 
    protected JButton createArrowButton() {                 
        JButton button = new JButton();        
        //se quita el efecto 3d del boton, sombra y darkShadow no se aplican 
        button.setText("");
        button.setBorder(BorderFactory.createLineBorder(red,2));
        button.setContentAreaFilled(false);
        button.setIcon( new ImageIcon(getClass().getResource("/Vista/CambiarListas/res/estrella.png")) );
        return button;
    }      
    */
    
    @Override
    public void paintCurrentValueBackground(Graphics g,
                               Rectangle bounds,
                               boolean hasFocus)
    {
        g.setColor( Beautiful );            
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }
      
    //Pinta los items
    @Override
    protected ListCellRenderer createRenderer()
    {
        return new DefaultListCellRenderer() {      
            
        @Override
        public Component getListCellRendererComponent(JList list,Object value,int index,
          boolean isSelected,boolean cellHasFocus) {
      
        super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        list.setSelectionBackground(Beautiful);
        list.setSelectionForeground(new Color(239, 243, 245));
        
        list.setForeground(colorseleccion);
        if (isSelected)
        {
            setBackground( new Color(17,146,238) );
            setForeground(Color.WHITE);
        }
        else
        {
            setBackground( colorFondo );            
            setForeground( colorseleccion);
        }
        if (index!=-1) {          
          setIcon( espacio );          
        }
        return this;
      }
    };
    }
}
