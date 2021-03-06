/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import FiveCodMover.FiveCodMoverJFrame;
import Vista.CambiarListas.combo.CustomUI;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.plaf.ComboBoxUI;

/**
 *
 * @author Allan Crack
 */
public class SalaVotaciones extends javax.swing.JFrame {
      
    
    
    public SalaVotaciones() {
        initComponents();
        
        estilosCombobox(listaCandidatos);
        estilosCombobox(listaBusqueda);
        estilosCombobox(listacategoria); 
        estilosCombobox(listaPartidos);
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        MENOS = new javax.swing.JLabel();
        PanelInferior = new javax.swing.JPanel();
        panelPeque = new javax.swing.JPanel();
        Candidato = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        partidoPolitico = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        imagenPartidoPolitico = new javax.swing.JPanel();
        imagenPartido = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Candidato1 = new javax.swing.JLabel();
        listaCandidatos = new javax.swing.JComboBox<>();
        listaBusqueda = new javax.swing.JComboBox<>();
        listacategoria = new javax.swing.JComboBox<>();
        partidos = new javax.swing.JLabel();
        listaPartidos = new javax.swing.JComboBox<>();
        buscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        nombre3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelbig = new javax.swing.JPanel();
        nacionalidad2 = new javax.swing.JLabel();
        campoPartido1 = new javax.swing.JTextField();
        panelImagen1 = new javax.swing.JPanel();
        imagenPresidente = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        nombre1 = new javax.swing.JLabel();
        genero2 = new javax.swing.JLabel();
        nacionalidad3 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        campoGenero = new javax.swing.JTextField();
        campoNacionalidad = new javax.swing.JTextField();
        campoDepartamento = new javax.swing.JTextField();
        departamento = new javax.swing.JLabel();
        campoMunicipio = new javax.swing.JTextField();
        municipio = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        botonVotarNullo = new javax.swing.JButton();
        botonVotar1 = new javax.swing.JButton();
        PanelUsuario = new javax.swing.JPanel();
        NombreUsuario = new javax.swing.JLabel();
        imagenUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idAlcalde = new javax.swing.JTextField();
        idPresidente = new javax.swing.JTextField();
        idDiputado = new javax.swing.JTextField();
        insertar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sala Votaciones");
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

        PanelTitulo.setBackground(new java.awt.Color(240, 147, 43));
        PanelTitulo.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 2, new java.awt.Color(223, 224, 224)));
        PanelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Raleway Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 243, 245));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sala de Votaciones");
        PanelTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 70));

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
        PanelTitulo.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 3, 39, 50));

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
        PanelTitulo.add(MENOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 3, 30, 50));

        getContentPane().add(PanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 70));

        PanelInferior.setBackground(new java.awt.Color(40, 45, 49));
        PanelInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(223, 224, 224), 3));
        PanelInferior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPeque.setBackground(new java.awt.Color(33, 46, 54));
        panelPeque.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(223, 224, 224), 1, true), "Búsqueda Candidato", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Raleway Light", 0, 15), new java.awt.Color(239, 243, 245))); // NOI18N
        panelPeque.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Candidato.setFont(new java.awt.Font("Raleway", 1, 16)); // NOI18N
        Candidato.setForeground(new java.awt.Color(239, 243, 245));
        Candidato.setText("Tipo Votacion:");
        panelPeque.add(Candidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 79, -1, 30));

        jLabel7.setFont(new java.awt.Font("Raleway", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(239, 243, 245));
        jLabel7.setText("Busqueda por:");
        panelPeque.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, 30));
        panelPeque.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 650, 1));

        partidoPolitico.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        partidoPolitico.setForeground(new java.awt.Color(239, 243, 245));
        partidoPolitico.setText("Partido Político:");
        panelPeque.add(partidoPolitico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 90));
        panelPeque.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        imagenPartidoPolitico.setBackground(new java.awt.Color(37, 50, 60));
        imagenPartidoPolitico.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(223, 224, 224), 1, true));

        javax.swing.GroupLayout imagenPartidoPoliticoLayout = new javax.swing.GroupLayout(imagenPartidoPolitico);
        imagenPartidoPolitico.setLayout(imagenPartidoPoliticoLayout);
        imagenPartidoPoliticoLayout.setHorizontalGroup(
            imagenPartidoPoliticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
            .addGroup(imagenPartidoPoliticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(imagenPartidoPoliticoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(imagenPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        imagenPartidoPoliticoLayout.setVerticalGroup(
            imagenPartidoPoliticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
            .addGroup(imagenPartidoPoliticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(imagenPartidoPoliticoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(imagenPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelPeque.add(imagenPartidoPolitico, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelPeque.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 1, 80));

        Candidato1.setFont(new java.awt.Font("Raleway", 1, 16)); // NOI18N
        Candidato1.setForeground(new java.awt.Color(239, 243, 245));
        Candidato1.setText("Presidentes:");
        panelPeque.add(Candidato1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 100, 30));

        listaCandidatos.setBackground(new java.awt.Color(42, 59, 71));
        listaCandidatos.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        listaCandidatos.setForeground(new java.awt.Color(239, 243, 245));
        listaCandidatos.setMaximumRowCount(5);
        listaCandidatos.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 116, 112), 1, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 0)));
        panelPeque.add(listaCandidatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 210, -1));

        listaBusqueda.setBackground(new java.awt.Color(42, 59, 71));
        listaBusqueda.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        listaBusqueda.setForeground(new java.awt.Color(239, 243, 245));
        listaBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listaBusqueda.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 116, 112), 1, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 0)));
        panelPeque.add(listaBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 32, 140, -1));

        listacategoria.setBackground(new java.awt.Color(42, 59, 71));
        listacategoria.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        listacategoria.setForeground(new java.awt.Color(239, 243, 245));
        listacategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listacategoria.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 116, 112), 1, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 0)));
        panelPeque.add(listacategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 200, -1));

        partidos.setFont(new java.awt.Font("Raleway", 1, 16)); // NOI18N
        partidos.setForeground(new java.awt.Color(239, 243, 245));
        partidos.setText("Partidos: ");
        panelPeque.add(partidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 50));

        listaPartidos.setBackground(new java.awt.Color(42, 59, 71));
        listaPartidos.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        listaPartidos.setForeground(new java.awt.Color(239, 243, 245));
        listaPartidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listaPartidos.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 116, 112), 1, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 0)));
        panelPeque.add(listaPartidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 210, 30));

        buscar.setBackground(new java.awt.Color(42, 59, 71));
        buscar.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        buscar.setForeground(new java.awt.Color(105, 116, 112));
        buscar.setText("Nombre Candidato");
        buscar.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 118, 118), 1, true), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        panelPeque.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 180, 30));

        botonBuscar.setBackground(new java.awt.Color(240, 147, 43));
        botonBuscar.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscar.setText("Buscar");
        panelPeque.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 100, 30));

        nombre3.setFont(new java.awt.Font("Open Sans Semibold", 0, 15)); // NOI18N
        nombre3.setForeground(new java.awt.Color(239, 243, 245));
        nombre3.setText("Nombre:");
        panelPeque.add(nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        PanelInferior.add(panelPeque, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 700, 170));

        jPanel1.setBackground(new java.awt.Color(40, 45, 49));
        jPanel1.setForeground(new java.awt.Color(40, 45, 49));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        PanelInferior.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 630, -1, 30));

        panelbig.setBackground(new java.awt.Color(33, 46, 54));
        panelbig.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(223, 224, 224), 1, true), "Informacion Candidato", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Raleway Light", 0, 15), new java.awt.Color(239, 243, 245))); // NOI18N
        panelbig.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nacionalidad2.setFont(new java.awt.Font("Open Sans Semibold", 0, 16)); // NOI18N
        nacionalidad2.setForeground(new java.awt.Color(239, 243, 245));
        nacionalidad2.setText("Partido Politico:");
        panelbig.add(nacionalidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, 30));

        campoPartido1.setEditable(false);
        campoPartido1.setBackground(new java.awt.Color(42, 59, 66));
        campoPartido1.setFont(new java.awt.Font("Open Sans Light", 0, 15)); // NOI18N
        campoPartido1.setForeground(new java.awt.Color(200, 205, 208));
        campoPartido1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 118, 118), 1, true), javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        panelbig.add(campoPartido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 190, 30));

        panelImagen1.setBackground(new java.awt.Color(37, 50, 60));
        panelImagen1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(239, 243, 245), 1, true));
        panelImagen1.setPreferredSize(new java.awt.Dimension(250, 180));

        javax.swing.GroupLayout panelImagen1Layout = new javax.swing.GroupLayout(panelImagen1);
        panelImagen1.setLayout(panelImagen1Layout);
        panelImagen1Layout.setHorizontalGroup(
            panelImagen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenPresidente, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );
        panelImagen1Layout.setVerticalGroup(
            panelImagen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenPresidente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );

        panelbig.add(panelImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 180));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setMinimumSize(new java.awt.Dimension(50, 1));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 1));
        panelbig.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 21, 1, 250));

        nombre1.setFont(new java.awt.Font("Open Sans Semibold", 0, 16)); // NOI18N
        nombre1.setForeground(new java.awt.Color(239, 243, 245));
        nombre1.setText("Nombre: ");
        panelbig.add(nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        genero2.setFont(new java.awt.Font("Open Sans Semibold", 0, 16)); // NOI18N
        genero2.setForeground(new java.awt.Color(239, 243, 245));
        genero2.setText("Género:");
        panelbig.add(genero2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, 30));

        nacionalidad3.setFont(new java.awt.Font("Open Sans Semibold", 0, 16)); // NOI18N
        nacionalidad3.setForeground(new java.awt.Color(239, 243, 245));
        nacionalidad3.setText("Nacionalidad:");
        panelbig.add(nacionalidad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, 30));

        campoNombre.setEditable(false);
        campoNombre.setBackground(new java.awt.Color(42, 59, 66));
        campoNombre.setFont(new java.awt.Font("Open Sans Light", 0, 15)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(200, 205, 208));
        campoNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 118, 118), 1, true), javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        panelbig.add(campoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 220, 30));

        campoGenero.setEditable(false);
        campoGenero.setBackground(new java.awt.Color(42, 59, 66));
        campoGenero.setFont(new java.awt.Font("Open Sans Light", 0, 15)); // NOI18N
        campoGenero.setForeground(new java.awt.Color(200, 205, 208));
        campoGenero.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 118, 118), 1, true), javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        panelbig.add(campoGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 250, 30));

        campoNacionalidad.setEditable(false);
        campoNacionalidad.setBackground(new java.awt.Color(42, 59, 66));
        campoNacionalidad.setFont(new java.awt.Font("Open Sans Light", 0, 15)); // NOI18N
        campoNacionalidad.setForeground(new java.awt.Color(200, 205, 208));
        campoNacionalidad.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 118, 118), 1, true), javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        panelbig.add(campoNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 210, 30));

        campoDepartamento.setEditable(false);
        campoDepartamento.setBackground(new java.awt.Color(42, 59, 66));
        campoDepartamento.setFont(new java.awt.Font("Open Sans Light", 0, 15)); // NOI18N
        campoDepartamento.setForeground(new java.awt.Color(200, 205, 208));
        campoDepartamento.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 118, 118), 1, true), javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        panelbig.add(campoDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 200, 30));

        departamento.setFont(new java.awt.Font("Open Sans Semibold", 0, 16)); // NOI18N
        departamento.setForeground(new java.awt.Color(239, 243, 245));
        departamento.setText("Departamento:");
        panelbig.add(departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, 30));

        campoMunicipio.setEditable(false);
        campoMunicipio.setBackground(new java.awt.Color(42, 59, 66));
        campoMunicipio.setFont(new java.awt.Font("Open Sans Light", 0, 15)); // NOI18N
        campoMunicipio.setForeground(new java.awt.Color(200, 205, 208));
        campoMunicipio.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 118, 118), 1, true), javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        panelbig.add(campoMunicipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 230, 30));

        municipio.setFont(new java.awt.Font("Open Sans Semibold", 0, 16)); // NOI18N
        municipio.setForeground(new java.awt.Color(239, 243, 245));
        municipio.setText("Municipio: ");
        panelbig.add(municipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, 30));

        scroll.setBackground(new java.awt.Color(42, 59, 66));
        scroll.setForeground(new java.awt.Color(42, 59, 66));
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(42, 59, 66));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Open Sans", 0, 15)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(105, 116, 112));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Discurso Presidencial\n\n");
        jTextArea1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 118, 118), 1, true), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        scroll.setViewportView(jTextArea1);

        panelbig.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 320, 90));

        PanelInferior.add(panelbig, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 700, 290));

        botonVotarNullo.setBackground(new java.awt.Color(255, 96, 91));
        botonVotarNullo.setFont(new java.awt.Font("Open Sans Semibold", 0, 16)); // NOI18N
        botonVotarNullo.setForeground(new java.awt.Color(255, 255, 255));
        botonVotarNullo.setText("No votar");
        PanelInferior.add(botonVotarNullo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 590, 130, 40));

        botonVotar1.setBackground(new java.awt.Color(17, 146, 238));
        botonVotar1.setFont(new java.awt.Font("Open Sans Semibold", 0, 16)); // NOI18N
        botonVotar1.setForeground(new java.awt.Color(255, 255, 255));
        botonVotar1.setText("Votar");
        PanelInferior.add(botonVotar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 140, 40));

        PanelUsuario.setBackground(new java.awt.Color(37, 50, 60));
        PanelUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        PanelUsuario.setLayout(null);

        NombreUsuario.setFont(new java.awt.Font("Open Sans", 0, 15)); // NOI18N
        NombreUsuario.setForeground(new java.awt.Color(239, 239, 238));
        NombreUsuario.setText("Texto");
        PanelUsuario.add(NombreUsuario);
        NombreUsuario.setBounds(120, 0, 220, 50);

        imagenUsuario.setPreferredSize(new java.awt.Dimension(30, 30));
        PanelUsuario.add(imagenUsuario);
        imagenUsuario.setBounds(80, 10, 30, 30);

        jLabel4.setFont(new java.awt.Font("Open Sans Semibold", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(239, 243, 245));
        jLabel4.setText("Votante:");
        PanelUsuario.add(jLabel4);
        jLabel4.setBounds(11, 1, 62, 50);

        PanelInferior.add(PanelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 340, 50));
        PanelInferior.add(idAlcalde, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 60, -1));
        PanelInferior.add(idPresidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 60, -1));
        PanelInferior.add(idDiputado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 60, -1));
        PanelInferior.add(insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 590, -1, -1));

        getContentPane().add(PanelInferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, 740, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked

    }//GEN-LAST:event_cerrarMouseClicked

    private void MENOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENOSMouseClicked
         this.setState(JFrame.ICONIFIED);

    }//GEN-LAST:event_MENOSMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
   FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
       FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_formMousePressed

      private void estilosCombobox(JComboBox j){
         CustomUI custom = new CustomUI();
       ComboBoxUI diseño= custom.createUI(j);
        j.setUI(diseño);
    }
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
            java.util.logging.Logger.getLogger(SalaVotaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalaVotaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalaVotaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalaVotaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalaVotaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Candidato;
    public javax.swing.JLabel Candidato1;
    public javax.swing.JLabel MENOS;
    public javax.swing.JLabel NombreUsuario;
    private javax.swing.JPanel PanelInferior;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JPanel PanelUsuario;
    public javax.swing.JButton botonBuscar;
    public javax.swing.JButton botonVotar1;
    public javax.swing.JButton botonVotarNullo;
    public javax.swing.JTextField buscar;
    public javax.swing.JTextField campoDepartamento;
    public javax.swing.JTextField campoGenero;
    public javax.swing.JTextField campoMunicipio;
    public javax.swing.JTextField campoNacionalidad;
    public javax.swing.JTextField campoNombre;
    public javax.swing.JTextField campoPartido1;
    public javax.swing.JLabel cerrar;
    public javax.swing.JLabel departamento;
    private javax.swing.JLabel genero2;
    public javax.swing.JTextField idAlcalde;
    public javax.swing.JTextField idDiputado;
    public javax.swing.JTextField idPresidente;
    public javax.swing.JLabel imagenPartido;
    public javax.swing.JPanel imagenPartidoPolitico;
    public javax.swing.JLabel imagenPresidente;
    public javax.swing.JLabel imagenUsuario;
    public javax.swing.JLabel insertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JSeparator jSeparator2;
    public javax.swing.JSeparator jSeparator3;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JComboBox<String> listaBusqueda;
    public javax.swing.JComboBox<String> listaCandidatos;
    public javax.swing.JComboBox<String> listaPartidos;
    public javax.swing.JComboBox<String> listacategoria;
    public javax.swing.JLabel municipio;
    private javax.swing.JLabel nacionalidad2;
    private javax.swing.JLabel nacionalidad3;
    private javax.swing.JLabel nombre1;
    public javax.swing.JLabel nombre3;
    private javax.swing.JPanel panelImagen1;
    private javax.swing.JPanel panelPeque;
    private javax.swing.JPanel panelbig;
    public javax.swing.JLabel partidoPolitico;
    public javax.swing.JLabel partidos;
    public javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
