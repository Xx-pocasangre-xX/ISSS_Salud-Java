/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.ctrlPantallaMenuJefesEnfermeria;

/**
 *
 * @author ricar
 */
public class PanelSolicitudesCitas extends javax.swing.JPanel {

    /**
     * Creates new form PanelSolicitudesCitas
     */
    public PanelSolicitudesCitas() {
        initComponents();
        
        jfrPantallaMenuJefesEnfermeria vista = new jfrPantallaMenuJefesEnfermeria();
        PanelSolicitudesCitas panel = this;
        ctrlPantallaMenuJefesEnfermeria controlador = new ctrlPantallaMenuJefesEnfermeria(vista, panel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDUI = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtMotivoCita = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnAgendarCita = new javax.swing.JButton();
        txtTipoSangre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(1120, 640));
        setMinimumSize(new java.awt.Dimension(1120, 640));

        jPanel5.setBackground(new java.awt.Color(73, 80, 96));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(156, 156, 156)));
        jPanel5.setMinimumSize(new java.awt.Dimension(400, 80));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Roboto", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Solicitudes");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 25, 130, -1));

        jPanel6.setBackground(new java.awt.Color(62, 68, 83));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(156, 156, 156)));
        jPanel6.setMinimumSize(new java.awt.Dimension(400, 80));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Roboto", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Información de la cita médica ");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 25, 350, -1));

        jPanel7.setBackground(new java.awt.Color(70, 76, 92));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(156, 156, 156)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DUI");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 40, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 80, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo sangre");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 140, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dirección");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Correo");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Motivo de la cita");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        txtDUI.setBackground(new java.awt.Color(70, 76, 92));
        txtDUI.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtDUI.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel7.add(txtDUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 150, 30));

        txtNombre.setBackground(new java.awt.Color(70, 76, 92));
        txtNombre.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel7.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 270, 30));

        txtDireccion.setBackground(new java.awt.Color(70, 76, 92));
        txtDireccion.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel7.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 270, 30));

        txtMotivoCita.setBackground(new java.awt.Color(70, 76, 92));
        txtMotivoCita.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtMotivoCita.setToolTipText("");
        txtMotivoCita.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel7.add(txtMotivoCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 350, 100));

        txtCorreo.setBackground(new java.awt.Color(70, 76, 92));
        txtCorreo.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtCorreo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel7.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 270, 30));

        btnAgendarCita.setBackground(new java.awt.Color(41, 72, 152));
        btnAgendarCita.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnAgendarCita.setText("Agendar cita");
        btnAgendarCita.setBorder(null);
        jPanel7.add(btnAgendarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 120, 40));

        txtTipoSangre.setBackground(new java.awt.Color(70, 76, 92));
        txtTipoSangre.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtTipoSangre.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel7.add(txtTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 150, 30));

        jPanel1.setBackground(new java.awt.Color(50, 55, 69));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgendarCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDUI;
    private javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtMotivoCita;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTipoSangre;
    // End of variables declaration//GEN-END:variables
}
