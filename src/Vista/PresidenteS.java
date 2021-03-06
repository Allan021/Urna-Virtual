/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorInicio;
import Modelo.RegistroCandidatos.Presidente;
import Modelo.Resultados.ConsultasResultados;
import Modelo.Resultados.Departamento;
import Modelo.Resultados.Municipio;
import Vista.CambiarListas.combo.CustomUI;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.plaf.ComboBoxUI;

/**
 *
 * @author Allan Crack
 */
public class PresidenteS extends javax.swing.JDialog {

    /**
     * Creates new form Alcaldes
     */
    public PresidenteS(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
          
        gif();
        presidente();
    
    }

    public void gif(){
        if(imagenCandidatura.getIcon() == null){
          jLabel1.setVisible(true);
        }
        else{
            jLabel1.setVisible(false);
        }
        
    }
    
    public void presidente(){
        ConsultasResultados modelo = new ConsultasResultados();
       int max = modelo.Maxvotos();
        
       Presidente president = modelo.president(max);
        votos.setText(president.getNombre());
        campoNombre.setText(String.valueOf(president.getVotos()));
        imagenCandidatura.setIcon(new ImageIcon(president.getImagen()));
        
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JPanel();
        cerrar = new javax.swing.JLabel();
        tituloLabel = new javax.swing.JLabel();
        panelAbajo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelImagen = new javax.swing.JPanel();
        imagenCandidatura = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        votos = new javax.swing.JTextField();
        nombre2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setBackground(new java.awt.Color(0, 123, 200));
        Titulo.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 0, 3, new java.awt.Color(223, 224, 224)));
        Titulo.setLayout(null);

        cerrar.setFont(new java.awt.Font("Raleway", 1, 36)); // NOI18N
        cerrar.setForeground(new java.awt.Color(239, 243, 245));
        cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrar.setText("x");
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cerrarMouseExited(evt);
            }
        });
        Titulo.add(cerrar);
        cerrar.setBounds(380, 10, 60, 43);

        tituloLabel.setBackground(new java.awt.Color(239, 243, 245));
        tituloLabel.setFont(new java.awt.Font("Raleway Black", 1, 34)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(239, 243, 245));
        tituloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLabel.setText("Presidente");
        Titulo.add(tituloLabel);
        tituloLabel.setBounds(0, 10, 440, 60);

        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        panelAbajo.setBackground(new java.awt.Color(40, 45, 49));
        panelAbajo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(223, 224, 224), 3));
        panelAbajo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/confetti.gif"))); // NOI18N
        panelAbajo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 410, 270));

        panelImagen.setBackground(new java.awt.Color(33, 46, 54));
        panelImagen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(223, 224, 224), 1, true));

        imagenCandidatura.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        imagenCandidatura.setForeground(new java.awt.Color(239, 243, 245));
        imagenCandidatura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
            .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelImagenLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(imagenCandidatura, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
            .addGroup(panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelImagenLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(imagenCandidatura, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelAbajo.add(panelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        campoNombre.setEditable(false);
        campoNombre.setBackground(new java.awt.Color(42, 59, 66));
        campoNombre.setFont(new java.awt.Font("Open Sans Light", 0, 15)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(232, 231, 222));
        campoNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(232, 231, 222), 1, true), javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        panelAbajo.add(campoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 129, -1));

        votos.setEditable(false);
        votos.setBackground(new java.awt.Color(42, 59, 66));
        votos.setFont(new java.awt.Font("Open Sans Light", 0, 15)); // NOI18N
        votos.setForeground(new java.awt.Color(232, 231, 222));
        votos.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(232, 231, 222), 1, true), javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        panelAbajo.add(votos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 250, -1));

        nombre2.setFont(new java.awt.Font("Open Sans Semibold", 0, 24)); // NOI18N
        nombre2.setForeground(new java.awt.Color(239, 243, 245));
        nombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre2.setText("¡¡ GANADOR !!");
        panelAbajo.add(nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 250, 45));

        getContentPane().add(panelAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 440, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
       dispose();
        TablaGanadores tabla = new TablaGanadores();
        tabla.setLocationRelativeTo(null);
        tabla.setVisible(true);
       
    
 
 
    
    }//GEN-LAST:event_cerrarMouseClicked

    private void cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseEntered
      Color color = new Color(200,200,200);
        cerrar.setForeground(color);
    }//GEN-LAST:event_cerrarMouseEntered

    private void cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseExited
        Color color = new Color(239,243,245);
        cerrar.setForeground(color);
    }//GEN-LAST:event_cerrarMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PresidenteS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PresidenteS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PresidenteS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PresidenteS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PresidenteS dialog = new PresidenteS(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void estilosCombobox(JComboBox j){
         CustomUI custom = new CustomUI();
       ComboBoxUI diseño= custom.createUI(j);
        j.setUI(diseño);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Titulo;
    public javax.swing.JTextField campoNombre;
    public javax.swing.JLabel cerrar;
    public javax.swing.JLabel imagenCandidatura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nombre2;
    private javax.swing.JPanel panelAbajo;
    public javax.swing.JPanel panelImagen;
    private javax.swing.JLabel tituloLabel;
    public javax.swing.JTextField votos;
    // End of variables declaration//GEN-END:variables
}
