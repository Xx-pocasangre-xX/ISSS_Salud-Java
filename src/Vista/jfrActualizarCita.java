/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author ricar
 */
public class jfrActualizarCita extends javax.swing.JFrame {

    /**
     * Creates new form jfrActualizarCita
     */
    public jfrActualizarCita() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        btnActualizarCita = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(760, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(70, 76, 92));
        jPanel1.setMinimumSize(new java.awt.Dimension(760, 560));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(70, 76, 92));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImagenBtnRegresarModoOscuro.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.setBorder(null);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        jLabel11.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Especialista");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 120, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nombre del doctor");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 180, -1));

        jLabel13.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Hora");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 140, -1));

        txtHora.setBackground(new java.awt.Color(70, 76, 92));
        txtHora.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtHora.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 270, 30));

        jLabel14.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Dia");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        txtDia.setBackground(new java.awt.Color(70, 76, 92));
        txtDia.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtDia.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel1.add(txtDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 270, 30));

        btnActualizarCita.setBackground(new java.awt.Color(41, 72, 152));
        btnActualizarCita.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnActualizarCita.setText("Guardar cambios");
        btnActualizarCita.setBorder(null);
        btnActualizarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCitaActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 160, 40));

        jComboBox1.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 270, 30));

        jComboBox2.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 270, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarCitaActionPerformed

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
            java.util.logging.Logger.getLogger(jfrActualizarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrActualizarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrActualizarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrActualizarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrActualizarCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarCita;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtDia;
    public javax.swing.JTextField txtHora;
    // End of variables declaration//GEN-END:variables
}
