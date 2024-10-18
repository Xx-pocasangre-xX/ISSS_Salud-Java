package Vista;

import Controlador.ctrlPantallaMenuDoctor;
import Modelo.CitasMedicas;
import Modelo.ExpedientesMedicos;
import Modelo.Usuarios;

public class PanelExpedienteMedico extends javax.swing.JPanel {

    /**
     * Creates new form PanelExpedienteMedico
     */
    public PanelExpedienteMedico() {
        initComponents();
    }
    
    public static void initPanelExpedienteMedico(){
            
        jfrPantallaMenuDoctor vista = new jfrPantallaMenuDoctor();
        PanelChatDoctoresSinDesplegar panel = new PanelChatDoctoresSinDesplegar();
        PanelCitasMedicasDoctor panel1 = new PanelCitasMedicasDoctor();
        PanelInfoCitaDoctor panel2 = new PanelInfoCitaDoctor();
        PanelExpedienteMedico panel3 = new PanelExpedienteMedico();
        CitasMedicas modelo = new CitasMedicas();
        ExpedientesMedicos modelo2 = new ExpedientesMedicos();
        Usuarios modelo3 = new Usuarios();
        
        ctrlPantallaMenuDoctor controlador = new ctrlPantallaMenuDoctor(vista, panel, panel1, panel2, panel3, modelo, modelo2, modelo3);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jlFotoPaciente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTelefonoPaciente = new javax.swing.JTextField();
        txtCorreoPaciente = new javax.swing.JTextField();
        txtDuiPaciente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTipoSangrePaciente = new javax.swing.JTextField();
        txtSexoPaciente = new javax.swing.JTextField();
        txtEdadPaciente = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAntencedentesFamiliares = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtSaludPreexistentes = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAlergias = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtSaludActual = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtExamenesDeLaboratotios = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtFichaIngreso = new javax.swing.JTextArea();
        btnEditarActualizarExpediente = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(740, 560));
        setPreferredSize(new java.awt.Dimension(740, 560));

        jScrollPane2.setBorder(null);

        jPanel2.setBackground(new java.awt.Color(76, 82, 99));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setBackground(new java.awt.Color(76, 82, 99));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImagenBtnRegresarModoOscuro.png"))); // NOI18N
        btnRegresar.setBorder(null);
        jPanel2.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 50));

        jlFotoPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/profile.jpg"))); // NOI18N
        jlFotoPaciente.setPreferredSize(new java.awt.Dimension(150, 150));
        jPanel2.add(jlFotoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 150, 150));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Roboto", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(183, 186, 193));
        jLabel6.setText("Información del paciente");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 225, 290, -1));

        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(156, 156, 156)));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 722, 10));

        jLabel5.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(183, 186, 193));
        jLabel5.setText("DUI");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 40, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(183, 186, 193));
        jLabel7.setText("Tipo sangre");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 110, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(183, 186, 193));
        jLabel9.setText("Nombre");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 70, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 3, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Antencedentes familiares");
        jLabel10.setToolTipText("");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 645, 200, -1));

        txtTelefonoPaciente.setBackground(new java.awt.Color(76, 82, 99));
        txtTelefonoPaciente.setFont(new java.awt.Font("Raleway Thin", 3, 14)); // NOI18N
        txtTelefonoPaciente.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefonoPaciente.setToolTipText("");
        txtTelefonoPaciente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel2.add(txtTelefonoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 230, 30));

        txtCorreoPaciente.setBackground(new java.awt.Color(76, 82, 99));
        txtCorreoPaciente.setFont(new java.awt.Font("Raleway Thin", 3, 14)); // NOI18N
        txtCorreoPaciente.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreoPaciente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel2.add(txtCorreoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 310, 30));

        txtDuiPaciente.setBackground(new java.awt.Color(76, 82, 99));
        txtDuiPaciente.setFont(new java.awt.Font("Raleway Thin", 3, 14)); // NOI18N
        txtDuiPaciente.setForeground(new java.awt.Color(255, 255, 255));
        txtDuiPaciente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        txtDuiPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuiPacienteActionPerformed(evt);
            }
        });
        jPanel2.add(txtDuiPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 230, 30));

        jLabel12.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(183, 186, 193));
        jLabel12.setText("Fecha de nacimiento");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 180, -1));

        jLabel13.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(183, 186, 193));
        jLabel13.setText("Sexo");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 50, -1));

        txtTipoSangrePaciente.setBackground(new java.awt.Color(76, 82, 99));
        txtTipoSangrePaciente.setFont(new java.awt.Font("Raleway Thin", 3, 14)); // NOI18N
        txtTipoSangrePaciente.setForeground(new java.awt.Color(255, 255, 255));
        txtTipoSangrePaciente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        txtTipoSangrePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoSangrePacienteActionPerformed(evt);
            }
        });
        jPanel2.add(txtTipoSangrePaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 230, 30));

        txtSexoPaciente.setBackground(new java.awt.Color(76, 82, 99));
        txtSexoPaciente.setFont(new java.awt.Font("Raleway Thin", 3, 14)); // NOI18N
        txtSexoPaciente.setForeground(new java.awt.Color(255, 255, 255));
        txtSexoPaciente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel2.add(txtSexoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 310, 30));

        txtEdadPaciente.setBackground(new java.awt.Color(76, 82, 99));
        txtEdadPaciente.setFont(new java.awt.Font("Raleway Thin", 3, 14)); // NOI18N
        txtEdadPaciente.setForeground(new java.awt.Color(255, 255, 255));
        txtEdadPaciente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        txtEdadPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadPacienteActionPerformed(evt);
            }
        });
        jPanel2.add(txtEdadPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 310, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Roboto", 3, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(183, 186, 193));
        jLabel14.setText("Información del paciente");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 575, 290, -1));

        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(156, 156, 156)));
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 722, 10));

        jLabel16.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(183, 186, 193));
        jLabel16.setText("Teléfono");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 80, -1));

        txtAntencedentesFamiliares.setBackground(new java.awt.Color(76, 82, 99));
        txtAntencedentesFamiliares.setColumns(20);
        txtAntencedentesFamiliares.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        txtAntencedentesFamiliares.setForeground(new java.awt.Color(255, 255, 255));
        txtAntencedentesFamiliares.setRows(5);
        txtAntencedentesFamiliares.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(156, 156, 156)));
        jScrollPane3.setViewportView(txtAntencedentesFamiliares);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 670, 220));

        jLabel17.setFont(new java.awt.Font("Roboto", 3, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Problemas de salud preexistentes ");
        jLabel17.setToolTipText("");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 925, 260, -1));

        txtSaludPreexistentes.setBackground(new java.awt.Color(76, 82, 99));
        txtSaludPreexistentes.setColumns(20);
        txtSaludPreexistentes.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        txtSaludPreexistentes.setForeground(new java.awt.Color(255, 255, 255));
        txtSaludPreexistentes.setRows(5);
        txtSaludPreexistentes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(156, 156, 156)));
        jScrollPane4.setViewportView(txtSaludPreexistentes);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 950, 670, 220));

        jLabel18.setFont(new java.awt.Font("Roboto", 3, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Alergias");
        jLabel18.setToolTipText("");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1205, 200, -1));

        txtAlergias.setBackground(new java.awt.Color(76, 82, 99));
        txtAlergias.setColumns(20);
        txtAlergias.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        txtAlergias.setForeground(new java.awt.Color(255, 255, 255));
        txtAlergias.setRows(5);
        txtAlergias.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(156, 156, 156)));
        jScrollPane5.setViewportView(txtAlergias);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1230, 670, 220));

        jLabel19.setFont(new java.awt.Font("Roboto", 3, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Salud actual");
        jLabel19.setToolTipText("");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1485, 260, -1));

        txtSaludActual.setBackground(new java.awt.Color(76, 82, 99));
        txtSaludActual.setColumns(20);
        txtSaludActual.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        txtSaludActual.setForeground(new java.awt.Color(255, 255, 255));
        txtSaludActual.setRows(5);
        txtSaludActual.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(156, 156, 156)));
        jScrollPane6.setViewportView(txtSaludActual);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1510, 670, 220));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Roboto", 3, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(183, 186, 193));
        jLabel20.setText("Ficha de ingreso");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2150, 310, -1));

        jLabel21.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(156, 156, 156)));
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2180, 722, 10));

        jLabel22.setFont(new java.awt.Font("Roboto", 3, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Examenes de laboratorios");
        jLabel22.setToolTipText("");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1845, 260, -1));

        txtExamenesDeLaboratotios.setBackground(new java.awt.Color(76, 82, 99));
        txtExamenesDeLaboratotios.setColumns(20);
        txtExamenesDeLaboratotios.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        txtExamenesDeLaboratotios.setForeground(new java.awt.Color(255, 255, 255));
        txtExamenesDeLaboratotios.setRows(5);
        txtExamenesDeLaboratotios.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(156, 156, 156)));
        jScrollPane7.setViewportView(txtExamenesDeLaboratotios);

        jPanel2.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1870, 670, 220));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Roboto", 3, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(183, 186, 193));
        jLabel23.setText("Resultados de laboratorios");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1780, 310, -1));

        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(156, 156, 156)));
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1810, 722, 10));

        jLabel25.setFont(new java.awt.Font("Roboto", 3, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Ficha de ingreso");
        jLabel25.setToolTipText("");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2215, 260, -1));

        txtFichaIngreso.setBackground(new java.awt.Color(76, 82, 99));
        txtFichaIngreso.setColumns(20);
        txtFichaIngreso.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        txtFichaIngreso.setForeground(new java.awt.Color(255, 255, 255));
        txtFichaIngreso.setRows(5);
        txtFichaIngreso.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(156, 156, 156)));
        jScrollPane8.setViewportView(txtFichaIngreso);

        jPanel2.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2240, 670, 220));

        btnEditarActualizarExpediente.setBackground(new java.awt.Color(41, 72, 152));
        btnEditarActualizarExpediente.setFont(new java.awt.Font("Roboto", 2, 16)); // NOI18N
        btnEditarActualizarExpediente.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarActualizarExpediente.setText("Editar expediente");
        btnEditarActualizarExpediente.setBorder(null);
        btnEditarActualizarExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActualizarExpedienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarActualizarExpediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 2480, 160, 40));
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 2540, -1, -1));

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipoSangrePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoSangrePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoSangrePacienteActionPerformed

    private void txtDuiPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuiPacienteActionPerformed
    }//GEN-LAST:event_txtDuiPacienteActionPerformed

    private void txtEdadPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadPacienteActionPerformed
    }//GEN-LAST:event_txtEdadPacienteActionPerformed

    private void btnEditarActualizarExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActualizarExpedienteActionPerformed
        }//GEN-LAST:event_btnEditarActualizarExpedienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEditarActualizarExpediente;
    public javax.swing.JButton btnRegresar;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    public javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JLabel jlFotoPaciente;
    public javax.swing.JTextArea txtAlergias;
    public javax.swing.JTextArea txtAntencedentesFamiliares;
    public javax.swing.JTextField txtCorreoPaciente;
    public javax.swing.JTextField txtDuiPaciente;
    public javax.swing.JTextField txtEdadPaciente;
    public javax.swing.JTextArea txtExamenesDeLaboratotios;
    public javax.swing.JTextArea txtFichaIngreso;
    public javax.swing.JTextArea txtSaludActual;
    public javax.swing.JTextArea txtSaludPreexistentes;
    public javax.swing.JTextField txtSexoPaciente;
    public javax.swing.JTextField txtTelefonoPaciente;
    public javax.swing.JTextField txtTipoSangrePaciente;
    // End of variables declaration//GEN-END:variables
}
