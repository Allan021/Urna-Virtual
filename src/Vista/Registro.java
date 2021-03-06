/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import FiveCodMover.FiveCodMoverJFrame;
import Modelo.Regiones.Departamento;
import Modelo.Regiones.Municipio;
import Vista.CambiarListas.combo.CustomUI;
import Vista.CambiarListas.combo.CustomUI1;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import java.awt.event.ItemEvent;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.plaf.ComboBoxUI;

/**
 *
 * @author Allan Crack
 */
public class Registro extends javax.swing.JFrame {

    
    public Registro() {
        initComponents();
        
    }

    
      private void estilosCombobox(JComboBox j){
         CustomUI1 custom = new CustomUI1();
       ComboBoxUI diseño= custom.createUI(j);
        j.setUI(diseño);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBoton = new javax.swing.ButtonGroup();
        tituloPanel = new javax.swing.JPanel();
        menos = new javax.swing.JLabel();
        x = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        panelInferior = new javax.swing.JPanel();
        texto = new javax.swing.JLabel();
        Apellido = new javax.swing.JLabel();
        CampoApelldo = new javax.swing.JTextField();
        CampoNombre = new javax.swing.JTextField();
        fecha = new javax.swing.JLabel();
        Departamento = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        listaMuncipio = new javax.swing.JComboBox<>();
        listaDepartamentos = new javax.swing.JComboBox<>();
        NumeroIdentidad = new javax.swing.JLabel();
        CampoIdentidad = new javax.swing.JTextField();
        btnRegistrarse = new javax.swing.JButton();
        Ciudad = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        informacionBasica = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JDateChooser();
        fecha1 = new javax.swing.JLabel();
        masculino = new javax.swing.JRadioButton();
        femenino = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        ubicar1 = new javax.swing.JLabel();
        ubicar2 = new javax.swing.JLabel();
        ubicar3 = new javax.swing.JLabel();
        vovler = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloPanel.setBackground(new java.awt.Color(152, 202, 63));

        menos.setFont(new java.awt.Font("Helvetica LT Std Black", 1, 24)); // NOI18N
        menos.setForeground(new java.awt.Color(255, 255, 255));
        menos.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        menos.setText("--");
        menos.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        menos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menosMouseClicked(evt);
            }
        });

        x.setFont(new java.awt.Font("Helvetica LT Std Black", 1, 24)); // NOI18N
        x.setForeground(new java.awt.Color(255, 255, 255));
        x.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        x.setText("x");
        x.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xMouseClicked(evt);
            }
        });

        Titulo.setFont(new java.awt.Font("Helvetica LT Std Black", 1, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Registro");

        javax.swing.GroupLayout tituloPanelLayout = new javax.swing.GroupLayout(tituloPanel);
        tituloPanel.setLayout(tituloPanelLayout);
        tituloPanelLayout.setHorizontalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
            .addGroup(tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tituloPanelLayout.createSequentialGroup()
                    .addContainerGap(413, Short.MAX_VALUE)
                    .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tituloPanelLayout.createSequentialGroup()
                    .addComponent(menos, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 36, Short.MAX_VALUE)))
        );
        tituloPanelLayout.setVerticalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
            .addGroup(tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tituloPanelLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(x, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tituloPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menos, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        getContentPane().add(tituloPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 60));

        panelInferior.setBackground(new java.awt.Color(18, 31, 61));

        texto.setBackground(new java.awt.Color(236, 240, 241));
        texto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        texto.setForeground(new java.awt.Color(239, 243, 248));
        texto.setText("Nombres: ");

        Apellido.setBackground(new java.awt.Color(236, 240, 241));
        Apellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Apellido.setForeground(new java.awt.Color(239, 243, 248));
        Apellido.setText("Apellidos:");

        CampoApelldo.setBackground(new java.awt.Color(3, 9, 30));
        CampoApelldo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        CampoApelldo.setForeground(new java.awt.Color(117, 142, 178));
        CampoApelldo.setText("Primer y segundo apellido");
        CampoApelldo.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(99, 123, 157), 1, true), javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        CampoApelldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });

        CampoNombre.setBackground(new java.awt.Color(3, 9, 30));
        CampoNombre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        CampoNombre.setForeground(new java.awt.Color(117, 142, 178));
        CampoNombre.setText("Primer y segundo nombre");
        CampoNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(99, 123, 157), 1, true), javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        CampoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNombreActionPerformed(evt);
            }
        });

        fecha.setBackground(new java.awt.Color(236, 240, 241));
        fecha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fecha.setForeground(new java.awt.Color(239, 243, 248));
        fecha.setText("Género: ");

        Departamento.setBackground(new java.awt.Color(236, 240, 241));
        Departamento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Departamento.setForeground(new java.awt.Color(239, 243, 248));
        Departamento.setText("Municipio: ");

        jLabel5.setBackground(new java.awt.Color(236, 240, 241));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(239, 243, 248));
        jLabel5.setText("Departamento:");

        listaMuncipio.setBackground(new java.awt.Color(3, 9, 30));
        listaMuncipio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        listaMuncipio.setForeground(new java.awt.Color(228, 241, 254));

        listaDepartamentos.setBackground(new java.awt.Color(3, 9, 30));
        listaDepartamentos.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        listaDepartamentos.setForeground(new java.awt.Color(228, 241, 254));
        listaDepartamentos.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        NumeroIdentidad.setBackground(new java.awt.Color(236, 240, 241));
        NumeroIdentidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NumeroIdentidad.setForeground(new java.awt.Color(239, 243, 248));
        NumeroIdentidad.setText("Numero de Identidad: ");

        CampoIdentidad.setBackground(new java.awt.Color(3, 9, 30));
        CampoIdentidad.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        CampoIdentidad.setForeground(new java.awt.Color(117, 142, 178));
        CampoIdentidad.setText("Tu numero de identidad");
        CampoIdentidad.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(99, 123, 157), 1, true), javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        CampoIdentidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });

        btnRegistrarse.setBackground(new java.awt.Color(152, 202, 63));
        btnRegistrarse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrarse.setForeground(new java.awt.Color(3, 9, 30));
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(99, 123, 157), 1, true));
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        Ciudad.setBackground(new java.awt.Color(236, 240, 241));
        Ciudad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Ciudad.setForeground(new java.awt.Color(255, 255, 255));
        Ciudad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Ciudad.setText("Lugar de Residencia");

        informacionBasica.setBackground(new java.awt.Color(236, 240, 241));
        informacionBasica.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        informacionBasica.setForeground(new java.awt.Color(255, 255, 255));
        informacionBasica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informacionBasica.setText("Información Básica");

        calendario.setBackground(new java.awt.Color(3, 9, 30));
        calendario.setForeground(new java.awt.Color(228, 241, 254));

        fecha1.setBackground(new java.awt.Color(236, 240, 241));
        fecha1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fecha1.setForeground(new java.awt.Color(239, 243, 248));
        fecha1.setText("Fecha de Nacimiento: ");

        masculino.setBackground(new java.awt.Color(18, 31, 61));
        masculino.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        masculino.setForeground(new java.awt.Color(239, 243, 248));
        masculino.setText("Masculino");

        femenino.setBackground(new java.awt.Color(18, 31, 61));
        femenino.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        femenino.setForeground(new java.awt.Color(239, 243, 248));
        femenino.setText("Femenino");

        jLabel1.setForeground(new java.awt.Color(44, 62, 108));
        jLabel1.setText("jLabel1");

        ubicar1.setForeground(new java.awt.Color(18, 31, 61));
        ubicar1.setText("Ubicar");

        ubicar2.setForeground(new java.awt.Color(18, 31, 61));
        ubicar2.setText("Ubivar2");

        ubicar3.setForeground(new java.awt.Color(18, 31, 61));
        ubicar3.setText("jLabel2");

        vovler.setFont(new java.awt.Font("Open Sans Light", 0, 14)); // NOI18N
        vovler.setForeground(new java.awt.Color(240, 240, 240));
        vovler.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vovler.setText("Volver a la pagina de Inicio");
        vovler.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vovler.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vovlerFocusGained(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(texto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelInferiorLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CampoApelldo, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                    .addComponent(CampoNombre)))
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelInferiorLayout.createSequentialGroup()
                                        .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelInferiorLayout.createSequentialGroup()
                                        .addComponent(NumeroIdentidad)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CampoIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelInferiorLayout.createSequentialGroup()
                                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(masculino, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(femenino, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ubicar1)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ciudad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(vovler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegistrarse, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(193, 193, 193))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel5))
                            .addComponent(Departamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listaDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listaMuncipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ubicar2)
                            .addComponent(ubicar3))
                        .addGap(228, 228, 228))))
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addComponent(informacionBasica, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(informacionBasica, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Apellido)
                    .addComponent(CampoApelldo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(jLabel1))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NumeroIdentidad)
                            .addComponent(CampoIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha1)
                            .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fecha)
                            .addComponent(masculino)
                            .addComponent(femenino)
                            .addComponent(ubicar1))
                        .addGap(25, 25, 25)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listaDepartamentos)
                            .addComponent(jLabel5)
                            .addComponent(ubicar2))
                        .addGap(18, 18, 18)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listaMuncipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Departamento)
                            .addComponent(ubicar3))
                        .addGap(40, 40, 40)
                        .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(vovler)
                .addGap(38, 38, 38))
        );

        getContentPane().add(panelInferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 450, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseClicked
      
    }//GEN-LAST:event_xMouseClicked

    private void menosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menosMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_menosMouseClicked

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    private void CampoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoNombreActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
          FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void vovlerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vovlerFocusGained
      
    }//GEN-LAST:event_vovlerFocusGained

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Apellido;
    public javax.swing.JTextField CampoApelldo;
    public javax.swing.JTextField CampoIdentidad;
    public javax.swing.JTextField CampoNombre;
    private javax.swing.JLabel Ciudad;
    private javax.swing.JLabel Departamento;
    private javax.swing.JLabel NumeroIdentidad;
    private javax.swing.JLabel Titulo;
    public javax.swing.JButton btnRegistrarse;
    public com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel fecha1;
    public javax.swing.JRadioButton femenino;
    public javax.swing.ButtonGroup grupoBoton;
    private javax.swing.JLabel informacionBasica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JComboBox<String> listaDepartamentos;
    public javax.swing.JComboBox<String> listaMuncipio;
    public javax.swing.JRadioButton masculino;
    public javax.swing.JLabel menos;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JLabel texto;
    private javax.swing.JPanel tituloPanel;
    public javax.swing.JLabel ubicar1;
    public javax.swing.JLabel ubicar2;
    public javax.swing.JLabel ubicar3;
    public javax.swing.JLabel vovler;
    public javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
