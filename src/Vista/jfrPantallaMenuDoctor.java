package Vista;

public class jfrPantallaMenuDoctor extends javax.swing.JFrame {


    public jfrPantallaMenuDoctor() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPanelMenuNoDesplegado = new javax.swing.JPanel();
        btnMenuDesplegablePrincipal = new javax.swing.JButton();
        si = new javax.swing.JButton();
        btnMensajeria = new javax.swing.JButton();
        jpPanelInfo = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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
        cmbTipoSangre = new javax.swing.JComboBox<>();
        btnExpediente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 750));

        jpPanelMenuNoDesplegado.setBackground(new java.awt.Color(62, 68, 83));
        jpPanelMenuNoDesplegado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        jpPanelMenuNoDesplegado.setMinimumSize(new java.awt.Dimension(80, 750));
        jpPanelMenuNoDesplegado.setPreferredSize(new java.awt.Dimension(80, 750));
        jpPanelMenuNoDesplegado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMenuDesplegablePrincipal.setBackground(new java.awt.Color(62, 68, 83));
        btnMenuDesplegablePrincipal.setForeground(new java.awt.Color(62, 68, 83));
        btnMenuDesplegablePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu hamburgesa modo oscuro.png"))); // NOI18N
        btnMenuDesplegablePrincipal.setBorder(null);
        jpPanelMenuNoDesplegado.add(btnMenuDesplegablePrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        si.setBackground(new java.awt.Color(41, 72, 152));
        si.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/citas medicas modo oscuro.png"))); // NOI18N
        si.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        jpPanelMenuNoDesplegado.add(si, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 80, 70));

        btnMensajeria.setBackground(new java.awt.Color(62, 68, 83));
        btnMensajeria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono chat modo oscuro.png"))); // NOI18N
        btnMensajeria.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        btnMensajeria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMensajeriaActionPerformed(evt);
            }
        });
        jpPanelMenuNoDesplegado.add(btnMensajeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 80, 60));

        jpPanelInfo.setBackground(new java.awt.Color(50, 55, 69));
        jpPanelInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(62, 68, 83));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(156, 156, 156)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo isss modo oscuro sin desplegar.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Roboto", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Citas medicas");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        jpPanelInfo.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 110));

        jPanel5.setBackground(new java.awt.Color(73, 80, 96));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(156, 156, 156)));
        jPanel5.setMinimumSize(new java.awt.Dimension(400, 80));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Roboto", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Agendadas");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 25, 130, -1));

        jpPanelInfo.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 380, 80));

        jPanel6.setBackground(new java.awt.Color(73, 80, 96));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(156, 156, 156)));
        jPanel6.setMinimumSize(new java.awt.Dimension(400, 80));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Roboto", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Informacion de la cita medica");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 25, 350, -1));

        jpPanelInfo.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 740, 80));

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

        cmbTipoSangre.setFont(new java.awt.Font("Roboto", 2, 13)); // NOI18N
        cmbTipoSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", " AB-" }));
        jPanel7.add(cmbTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 150, 30));

        btnExpediente.setBackground(new java.awt.Color(41, 72, 152));
        btnExpediente.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnExpediente.setText("Expediente");
        btnExpediente.setBorder(null);
        jPanel7.add(btnExpediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 120, 40));

        jpPanelInfo.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 740, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpPanelMenuNoDesplegado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpPanelMenuNoDesplegado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMensajeriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMensajeriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMensajeriaActionPerformed

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
            java.util.logging.Logger.getLogger(jfrPantallaMenuDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaMenuDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaMenuDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaMenuDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrPantallaMenuDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExpediente;
    public javax.swing.JButton btnMensajeria;
    public javax.swing.JButton btnMenuDesplegablePrincipal;
    public javax.swing.JComboBox<String> cmbTipoSangre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jpPanelInfo;
    public javax.swing.JPanel jpPanelMenuNoDesplegado;
    private javax.swing.JButton si;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDUI;
    private javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtMotivoCita;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
