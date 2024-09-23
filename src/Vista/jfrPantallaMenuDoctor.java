package Vista;

import Controlador.ctrlPantallaMenuDoctor;
import Modelo.CitasMedicas;
import Modelo.ExpedientesMedicos;
import Modelo.Usuarios;

public class jfrPantallaMenuDoctor extends javax.swing.JFrame {


    public jfrPantallaMenuDoctor() {
        initComponents();
        
    }
    
    public static void initjfrPantallaMenuDoctor(){
        jfrPantallaMenuDoctor vista = new jfrPantallaMenuDoctor();
        PanelChatDoctoresSinDesplegar panel = new PanelChatDoctoresSinDesplegar();
        PanelCitasMedicasDoctor panel1 = new PanelCitasMedicasDoctor();
        PanelInfoCitaDoctor panel2 = new PanelInfoCitaDoctor();
        PanelExpedienteMedico panel3 = new PanelExpedienteMedico();
        CitasMedicas modelo = new CitasMedicas();
        ExpedientesMedicos modelo2 = new ExpedientesMedicos();
        Usuarios modelo3 = new Usuarios();
        
        ctrlPantallaMenuDoctor controlador = new ctrlPantallaMenuDoctor(vista, panel, panel1, panel2, panel3, modelo, modelo2, modelo3);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    } 

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPanelMenuNoDesplegado = new javax.swing.JPanel();
        btnMenuDesplegablePrincipal = new javax.swing.JButton();
        btnCitasMedicas = new javax.swing.JButton();
        btnMensajeria = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jpPanelInfo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 750));
        setResizable(false);

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

        btnCitasMedicas.setBackground(new java.awt.Color(41, 72, 152));
        btnCitasMedicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/citas medicas modo oscuro.png"))); // NOI18N
        btnCitasMedicas.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        jpPanelMenuNoDesplegado.add(btnCitasMedicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 80, 70));

        btnMensajeria.setBackground(new java.awt.Color(62, 68, 83));
        btnMensajeria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono chat modo oscuro.png"))); // NOI18N
        btnMensajeria.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        btnMensajeria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMensajeriaActionPerformed(evt);
            }
        });
        jpPanelMenuNoDesplegado.add(btnMensajeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 80, 70));

        btnCerrarSesion.setBackground(new java.awt.Color(62, 68, 83));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida 1.png"))); // NOI18N
        btnCerrarSesion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jpPanelMenuNoDesplegado.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 80, 70));

        jpPanelInfo.setBackground(new java.awt.Color(50, 55, 69));
        jpPanelInfo.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpPanelMenuNoDesplegado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 1120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpPanelMenuNoDesplegado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMensajeriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMensajeriaActionPerformed
        
    }//GEN-LAST:event_btnMensajeriaActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

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
                initjfrPantallaMenuDoctor();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCerrarSesion;
    public javax.swing.JButton btnCitasMedicas;
    public javax.swing.JButton btnMensajeria;
    public javax.swing.JButton btnMenuDesplegablePrincipal;
    public javax.swing.JPanel jpPanelInfo;
    public javax.swing.JPanel jpPanelMenuNoDesplegado;
    // End of variables declaration//GEN-END:variables
}
