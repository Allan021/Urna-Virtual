/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import FiveCodMover.FiveCodMoverJFrame;
import Modelo.RegistroCandidatos.Nacionalidades;
import Vista.CambiarListas.combo.CustomUI;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Set;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.plaf.ComboBoxUI;

/**
 *
 * @author Allan Crack
 */
public class RegistroCandidatos extends javax.swing.JFrame {
  
    
    /**
     * Creates new form RegistroCandidatos
     */
    public RegistroCandidatos() {
     
        
       
        initComponents();
       
        estilosCombobox(listaDepartamentos);
        estilosCombobox(listaPartidos);
        estilosCombobox(candidatura);
        estilosCombobox(Muncipios);
        estilosCombobox(listaNacionalidades);
        
        
       grupoEstadoCivil.add(casado);
        grupoEstadoCivil.add(divorciado);
        grupoEstadoCivil.add(soltero);
        
        grupoGenero.add(femenino);
        grupoGenero.add(masculino);
        
        
                
        
        
    }

    private void estilosCombobox(JComboBox j){
         CustomUI custom = new CustomUI();
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

        grupoEstadoCivil = new javax.swing.ButtonGroup();
        grupoGenero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        Partenferior = new javax.swing.JPanel();
        Resposive = new javax.swing.JPanel();
        Nombre = new javax.swing.JTextField();
        Telefono = new javax.swing.JTextField();
        fechaNacimiento = new com.toedter.calendar.JDateChooser();
        casado = new javax.swing.JRadioButton();
        soltero = new javax.swing.JRadioButton();
        divorciado = new javax.swing.JRadioButton();
        Identidad1 = new javax.swing.JTextField();
        Civil1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        separarCampo = new javax.swing.JSeparator();
        ubicar1 = new javax.swing.JLabel();
        panelImagen = new javax.swing.JPanel();
        imagenCandidatura = new javax.swing.JLabel();
        PanelCandidatura = new javax.swing.JPanel();
        candidatura = new javax.swing.JComboBox<>();
        PartidosPoliticos = new javax.swing.JLabel();
        listaPartidos = new javax.swing.JComboBox<>();
        panelImagenPartido = new javax.swing.JPanel();
        Partido = new javax.swing.JLabel();
        Genero = new javax.swing.JLabel();
        femenino = new javax.swing.JRadioButton();
        masculino = new javax.swing.JRadioButton();
        lugar = new javax.swing.JLabel();
        Muncipios = new javax.swing.JComboBox<>();
        Genero1 = new javax.swing.JLabel();
        listaNacionalidades = new javax.swing.JComboBox<>();
        listaDepartamentos = new javax.swing.JComboBox<>();
        muni = new javax.swing.JLabel();
        depa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        scroll = new javax.swing.JScrollPane();
        discurso = new javax.swing.JTextArea();
        ubicar2 = new javax.swing.JLabel();
        seleccionarImagen = new javax.swing.JButton();
        insertarCandidato = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        InsertarPartido = new javax.swing.JButton();
        Titulo = new javax.swing.JPanel();
        cerrar = new javax.swing.JLabel();
        MENOS = new javax.swing.JLabel();
        tituloLabel = new javax.swing.JLabel();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(223, 224, 225), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Partenferior.setBackground(new java.awt.Color(40, 45, 49));
        Partenferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(223, 224, 224), 3));
        Partenferior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Resposive.setBackground(new java.awt.Color(33, 46, 54));
        Resposive.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(223, 224, 224), 1, true), " Información Personal", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Raleway Light", 0, 15), new java.awt.Color(239, 243, 245))); // NOI18N
        Resposive.setForeground(new java.awt.Color(40, 45, 49));
        Resposive.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nombre.setBackground(new java.awt.Color(42, 59, 71));
        Nombre.setFont(new java.awt.Font("Open Sans Light", 0, 15)); // NOI18N
        Nombre.setForeground(new java.awt.Color(105, 116, 112));
        Nombre.setText("Nombre Completo");
        Nombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 118, 118), 1, true), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        Resposive.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 390, 30));

        Telefono.setBackground(new java.awt.Color(42, 59, 71));
        Telefono.setFont(new java.awt.Font("Open Sans Light", 0, 15)); // NOI18N
        Telefono.setForeground(new java.awt.Color(105, 116, 112));
        Telefono.setText("Teléfono");
        Telefono.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 118, 118), 1, true), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelefonoActionPerformed(evt);
            }
        });
        Resposive.add(Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 190, 30));

        fechaNacimiento.setBackground(new java.awt.Color(42, 59, 71));
        fechaNacimiento.setForeground(new java.awt.Color(105, 116, 112));
        Resposive.add(fechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 390, 30));

        casado.setBackground(new java.awt.Color(33, 46, 54));
        casado.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        casado.setForeground(new java.awt.Color(105, 116, 112));
        casado.setText("Casado(a)");
        Resposive.add(casado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, 20));

        soltero.setBackground(new java.awt.Color(33, 46, 54));
        soltero.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        soltero.setForeground(new java.awt.Color(105, 116, 112));
        soltero.setText("Soltero(a)");
        Resposive.add(soltero, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, 20));

        divorciado.setBackground(new java.awt.Color(33, 46, 54));
        divorciado.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        divorciado.setForeground(new java.awt.Color(105, 116, 112));
        divorciado.setText("Divorciado(a)");
        Resposive.add(divorciado, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, 20));

        Identidad1.setBackground(new java.awt.Color(42, 59, 71));
        Identidad1.setFont(new java.awt.Font("Open Sans Light", 0, 15)); // NOI18N
        Identidad1.setForeground(new java.awt.Color(105, 116, 112));
        Identidad1.setText("Identidad");
        Identidad1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 118, 118), 1, true), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        Identidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Identidad1ActionPerformed(evt);
            }
        });
        Resposive.add(Identidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 190, 30));

        Civil1.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        Civil1.setForeground(new java.awt.Color(239, 243, 245));
        Civil1.setText("Estado Civil:");
        Resposive.add(Civil1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(239, 243, 245));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Fecha de Nacimiento:");
        Resposive.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 370, -1));

        separarCampo.setBackground(new java.awt.Color(160, 160, 160));
        Resposive.add(separarCampo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 390, 1));
        Resposive.add(ubicar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 10, 20));

        Partenferior.add(Resposive, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 410, 230));

        panelImagen.setBackground(new java.awt.Color(33, 46, 54));
        panelImagen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(223, 224, 224), 1, true));

        imagenCandidatura.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        imagenCandidatura.setForeground(new java.awt.Color(239, 243, 245));
        imagenCandidatura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenCandidatura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenCandidatura, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );

        Partenferior.add(panelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 250, 180));

        PanelCandidatura.setBackground(new java.awt.Color(33, 46, 54));
        PanelCandidatura.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(223, 224, 224), 1, true), "Inscripcion partido politico", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Raleway Light", 0, 15), new java.awt.Color(239, 243, 245))); // NOI18N
        PanelCandidatura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        candidatura.setBackground(new java.awt.Color(42, 59, 71));
        candidatura.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        candidatura.setForeground(new java.awt.Color(239, 243, 245));
        candidatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        candidatura.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 116, 112), 1, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 0)));
        PanelCandidatura.add(candidatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 32, 139, -1));

        PartidosPoliticos.setFont(new java.awt.Font("Raleway", 1, 16)); // NOI18N
        PartidosPoliticos.setForeground(new java.awt.Color(240, 240, 240));
        PartidosPoliticos.setText("Partidos Politicos:");
        PanelCandidatura.add(PartidosPoliticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 33, -1, -1));

        listaPartidos.setBackground(new java.awt.Color(42, 59, 71));
        listaPartidos.setFont(new java.awt.Font("Open Sans", 0, 15)); // NOI18N
        listaPartidos.setForeground(new java.awt.Color(239, 243, 245));
        listaPartidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listaPartidos.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 116, 112), 1, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 0)));
        listaPartidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaPartidosActionPerformed(evt);
            }
        });
        PanelCandidatura.add(listaPartidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 58, 197, -1));

        panelImagenPartido.setBackground(new java.awt.Color(40, 45, 49));
        panelImagenPartido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(223, 224, 224), 1, true));

        javax.swing.GroupLayout panelImagenPartidoLayout = new javax.swing.GroupLayout(panelImagenPartido);
        panelImagenPartido.setLayout(panelImagenPartidoLayout);
        panelImagenPartidoLayout.setHorizontalGroup(
            panelImagenPartidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Partido, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        );
        panelImagenPartidoLayout.setVerticalGroup(
            panelImagenPartidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Partido, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        PanelCandidatura.add(panelImagenPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 33, -1, -1));

        Genero.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        Genero.setForeground(new java.awt.Color(239, 243, 245));
        Genero.setText("Género:");
        PanelCandidatura.add(Genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 151, -1, 30));

        femenino.setBackground(new java.awt.Color(33, 46, 54));
        femenino.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        femenino.setForeground(new java.awt.Color(105, 116, 112));
        femenino.setText("Femenino");
        PanelCandidatura.add(femenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 157, -1, 20));

        masculino.setBackground(new java.awt.Color(33, 46, 54));
        masculino.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        masculino.setForeground(new java.awt.Color(105, 116, 112));
        masculino.setText("Masculino");
        PanelCandidatura.add(masculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 157, -1, 20));

        lugar.setFont(new java.awt.Font("Raleway", 1, 16)); // NOI18N
        lugar.setForeground(new java.awt.Color(239, 243, 245));
        lugar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lugar.setText("Lugar al que se postulara");
        PanelCandidatura.add(lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 87, 317, -1));

        Muncipios.setBackground(new java.awt.Color(42, 59, 71));
        Muncipios.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        Muncipios.setForeground(new java.awt.Color(239, 243, 245));
        Muncipios.setMaximumRowCount(5);
        Muncipios.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 116, 112), 1, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 0)));
        Muncipios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MuncipiosActionPerformed(evt);
            }
        });
        PanelCandidatura.add(Muncipios, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 159, 196, -1));

        Genero1.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        Genero1.setForeground(new java.awt.Color(239, 243, 245));
        Genero1.setText("Nacionalidad: ");
        PanelCandidatura.add(Genero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 115, -1, 30));

        listaNacionalidades.setBackground(new java.awt.Color(42, 59, 71));
        listaNacionalidades.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        listaNacionalidades.setForeground(new java.awt.Color(239, 243, 245));
        listaNacionalidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listaNacionalidades.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 116, 112), 1, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 0)));
        PanelCandidatura.add(listaNacionalidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 117, 195, -1));

        listaDepartamentos.setBackground(new java.awt.Color(42, 59, 71));
        listaDepartamentos.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        listaDepartamentos.setForeground(new java.awt.Color(239, 243, 245));
        listaDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listaDepartamentos.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 116, 112), 1, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 0)));
        PanelCandidatura.add(listaDepartamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 120, 166, -1));

        muni.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        muni.setForeground(new java.awt.Color(115, 126, 122));
        muni.setText("Municipio:");
        PanelCandidatura.add(muni, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 160, -1, -1));

        depa.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        depa.setForeground(new java.awt.Color(115, 126, 122));
        depa.setText("Departamento:");
        PanelCandidatura.add(depa, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 121, -1, -1));

        jLabel6.setFont(new java.awt.Font("Raleway", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(239, 243, 245));
        jLabel6.setText("Tipo Candidatura:");
        PanelCandidatura.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 36, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelCandidatura.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 32, 1, 155));

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        discurso.setBackground(new java.awt.Color(42, 59, 71));
        discurso.setColumns(20);
        discurso.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        discurso.setForeground(new java.awt.Color(105, 116, 112));
        discurso.setLineWrap(true);
        discurso.setRows(5);
        discurso.setText("DIscurso Presidencial");
        discurso.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 118, 118), 1, true), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        scroll.setViewportView(discurso);

        PanelCandidatura.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 300, 110));
        PanelCandidatura.add(ubicar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        Partenferior.add(PanelCandidatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 680, 210));

        seleccionarImagen.setBackground(new java.awt.Color(17, 146, 238));
        seleccionarImagen.setFont(new java.awt.Font("Open Sans Semibold", 0, 13)); // NOI18N
        seleccionarImagen.setForeground(new java.awt.Color(255, 255, 255));
        seleccionarImagen.setText("Seleccionar Imagen");
        Partenferior.add(seleccionarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 160, 30));

        insertarCandidato.setBackground(new java.awt.Color(17, 146, 238));
        insertarCandidato.setFont(new java.awt.Font("Open Sans Semibold", 0, 13)); // NOI18N
        insertarCandidato.setForeground(new java.awt.Color(255, 255, 255));
        insertarCandidato.setText("Registrar Candidato");
        Partenferior.add(insertarCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 520, 160, 40));

        Eliminar.setBackground(new java.awt.Color(255, 96, 91));
        Eliminar.setFont(new java.awt.Font("Open Sans Semibold", 0, 13)); // NOI18N
        Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar.setText("Eliminar Candidato");
        Partenferior.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 160, 40));

        InsertarPartido.setBackground(new java.awt.Color(102, 255, 0));
        InsertarPartido.setFont(new java.awt.Font("Open Sans Semibold", 0, 13)); // NOI18N
        InsertarPartido.setForeground(new java.awt.Color(255, 255, 255));
        InsertarPartido.setText("Insertar Partido");
        Partenferior.add(InsertarPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 160, 40));

        jPanel1.add(Partenferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 730, 590));

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
        });
        Titulo.add(cerrar);
        cerrar.setBounds(680, 10, 20, 43);

        MENOS.setFont(new java.awt.Font("Raleway", 1, 36)); // NOI18N
        MENOS.setForeground(new java.awt.Color(239, 243, 245));
        MENOS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MENOS.setText("-");
        MENOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MENOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MENOSMouseClicked(evt);
            }
        });
        Titulo.add(MENOS);
        MENOS.setBounds(640, 10, 20, 43);

        tituloLabel.setBackground(new java.awt.Color(239, 243, 245));
        tituloLabel.setFont(new java.awt.Font("Raleway Black", 1, 34)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(239, 243, 245));
        tituloLabel.setText("Registro de Candidatos");
        Titulo.add(tituloLabel);
        tituloLabel.setBounds(30, 10, 690, 60);

        jPanel1.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
      
        
    }//GEN-LAST:event_cerrarMouseClicked

    private void MENOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENOSMouseClicked
       
         this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_MENOSMouseClicked

    private void TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefonoActionPerformed

    private void Identidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Identidad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Identidad1ActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
   FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
     
         FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void listaPartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPartidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaPartidosActionPerformed

    private void MuncipiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MuncipiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MuncipiosActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroCandidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroCandidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroCandidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroCandidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroCandidatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Civil1;
    public javax.swing.JButton Eliminar;
    private javax.swing.JLabel Genero;
    private javax.swing.JLabel Genero1;
    public javax.swing.JTextField Identidad1;
    public javax.swing.JButton InsertarPartido;
    public javax.swing.JLabel MENOS;
    public javax.swing.JComboBox<String> Muncipios;
    public javax.swing.JTextField Nombre;
    private javax.swing.JPanel PanelCandidatura;
    private javax.swing.JPanel Partenferior;
    public javax.swing.JLabel Partido;
    private javax.swing.JLabel PartidosPoliticos;
    private javax.swing.JPanel Resposive;
    public javax.swing.JTextField Telefono;
    private javax.swing.JPanel Titulo;
    public javax.swing.JComboBox<String> candidatura;
    public javax.swing.JRadioButton casado;
    public javax.swing.JLabel cerrar;
    public javax.swing.JLabel depa;
    public javax.swing.JTextArea discurso;
    public javax.swing.JRadioButton divorciado;
    public com.toedter.calendar.JDateChooser fechaNacimiento;
    public javax.swing.JRadioButton femenino;
    public javax.swing.ButtonGroup grupoEstadoCivil;
    public javax.swing.ButtonGroup grupoGenero;
    public javax.swing.JLabel imagenCandidatura;
    public javax.swing.JButton insertarCandidato;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JComboBox<String> listaDepartamentos;
    public javax.swing.JComboBox<String> listaNacionalidades;
    public javax.swing.JComboBox<String> listaPartidos;
    public javax.swing.JLabel lugar;
    public javax.swing.JRadioButton masculino;
    public javax.swing.JLabel muni;
    public javax.swing.JPanel panelImagen;
    public javax.swing.JPanel panelImagenPartido;
    public javax.swing.JScrollPane scroll;
    public javax.swing.JButton seleccionarImagen;
    public javax.swing.JSeparator separarCampo;
    public javax.swing.JRadioButton soltero;
    private javax.swing.JLabel tituloLabel;
    public javax.swing.JLabel ubicar1;
    public javax.swing.JLabel ubicar2;
    // End of variables declaration//GEN-END:variables
}
