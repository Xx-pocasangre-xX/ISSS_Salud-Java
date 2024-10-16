/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ctrlPantallaCodigoRecu;
import Modelo.CodigoRecuperacion;

/**
 *
 * @author ricar
 */
public class jfrCodigoVerificacion extends javax.swing.JFrame {
    
    public jfrCodigoVerificacion() {
        
        initComponents();
        CodigoRecuperacion modelo = new CodigoRecuperacion();
        ctrlPantallaCodigoRecu Controlador = new ctrlPantallaCodigoRecu(this, modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNum6 = new javax.swing.JTextField();
        txtNum1 = new javax.swing.JTextField();
        txtNum2 = new javax.swing.JTextField();
        txtNum3 = new javax.swing.JTextField();
        txtNum4 = new javax.swing.JTextField();
        txtNum5 = new javax.swing.JTextField();
        btnConfirmarCod = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 640));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(50, 55, 69));
        jPanel2.setMinimumSize(new java.awt.Dimension(960, 640));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fotoprueba.PNG"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 145, -1, 333));

        jPanel1.setBackground(new java.awt.Color(31, 38, 76));
        jPanel1.setMinimumSize(new java.awt.Dimension(430, 480));
        jPanel1.setPreferredSize(new java.awt.Dimension(430, 480));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 3, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Verifique su código");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("su correo electrónico");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingrese correctamente el código que ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("se le ha enviado con anterioridad a");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 230, -1));

        txtNum6.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        txtNum6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNum6.setMinimumSize(new java.awt.Dimension(50, 70));
        txtNum6.setPreferredSize(new java.awt.Dimension(50, 70));
        jPanel1.add(txtNum6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 50, 70));

        txtNum1.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        txtNum1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNum1.setMinimumSize(new java.awt.Dimension(50, 70));
        txtNum1.setPreferredSize(new java.awt.Dimension(50, 70));
        txtNum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNum1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtNum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 50, 70));

        txtNum2.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        txtNum2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNum2.setMinimumSize(new java.awt.Dimension(50, 70));
        txtNum2.setPreferredSize(new java.awt.Dimension(50, 70));
        jPanel1.add(txtNum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 50, 70));

        txtNum3.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        txtNum3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNum3.setMinimumSize(new java.awt.Dimension(50, 70));
        txtNum3.setPreferredSize(new java.awt.Dimension(50, 70));
        jPanel1.add(txtNum3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 50, 70));

        txtNum4.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        txtNum4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNum4.setMinimumSize(new java.awt.Dimension(50, 70));
        txtNum4.setPreferredSize(new java.awt.Dimension(50, 70));
        jPanel1.add(txtNum4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 50, 70));

        txtNum5.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        txtNum5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNum5.setMinimumSize(new java.awt.Dimension(50, 70));
        txtNum5.setPreferredSize(new java.awt.Dimension(50, 70));
        jPanel1.add(txtNum5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 50, 70));

        btnConfirmarCod.setBackground(new java.awt.Color(144, 188, 255));
        btnConfirmarCod.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        btnConfirmarCod.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmarCod.setText("Confirmar");
        btnConfirmarCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarCodActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmarCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 300, 40));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 430, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarCodActionPerformed

    private void txtNum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNum1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNum1ActionPerformed

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
            java.util.logging.Logger.getLogger(jfrCodigoVerificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrCodigoVerificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrCodigoVerificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrCodigoVerificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrCodigoVerificacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnConfirmarCod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtNum1;
    public javax.swing.JTextField txtNum2;
    public javax.swing.JTextField txtNum3;
    public javax.swing.JTextField txtNum4;
    public javax.swing.JTextField txtNum5;
    public javax.swing.JTextField txtNum6;
    // End of variables declaration//GEN-END:variables
}
