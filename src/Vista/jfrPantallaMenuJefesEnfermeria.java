/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ctrlPantallaMenuJefesEnfermeria;

/**
 *
 * @author ricar
 */
public class jfrPantallaMenuJefesEnfermeria extends javax.swing.JFrame {

    /**
     * Creates new form jfrPantallaMenuJefesEnfermeria
     */
    public jfrPantallaMenuJefesEnfermeria() {
        initComponents();
    }
    
    public static void initjfrPantallaMenuJefesEnfermeria(){
        jfrPantallaMenuJefesEnfermeria vista = new jfrPantallaMenuJefesEnfermeria();
        PanelSolicitudesCitas panel = new PanelSolicitudesCitas() ;
        ctrlPantallaMenuJefesEnfermeria controlador = new ctrlPantallaMenuJefesEnfermeria(vista, panel);
        vista.setVisible(true);
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSolicitudes = new javax.swing.JButton();
        btnAgendadas = new javax.swing.JButton();
        jPanelInfoJefes = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnMenuDesplegablePrincipal = new javax.swing.JButton();
        btnCitasMedicasE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 750));

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

        btnSolicitudes.setBackground(new java.awt.Color(41, 72, 152));
        btnSolicitudes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnSolicitudes.setText("Solicitudes");
        jPanel3.add(btnSolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 35, 110, 40));

        btnAgendadas.setBackground(new java.awt.Color(183, 184, 187));
        btnAgendadas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAgendadas.setForeground(new java.awt.Color(61, 61, 61));
        btnAgendadas.setText("Agendadas");
        jPanel3.add(btnAgendadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 35, 110, 40));

        jPanelInfoJefes.setBackground(new java.awt.Color(50, 55, 69));
        jPanelInfoJefes.setMaximumSize(new java.awt.Dimension(1120, 640));
        jPanelInfoJefes.setMinimumSize(new java.awt.Dimension(1120, 640));
        jPanelInfoJefes.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(62, 68, 83));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        jPanel2.setMinimumSize(new java.awt.Dimension(80, 750));
        jPanel2.setPreferredSize(new java.awt.Dimension(80, 750));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMenuDesplegablePrincipal.setBackground(new java.awt.Color(62, 68, 83));
        btnMenuDesplegablePrincipal.setForeground(new java.awt.Color(62, 68, 83));
        btnMenuDesplegablePrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu hamburgesa modo oscuro.png"))); // NOI18N
        btnMenuDesplegablePrincipal.setBorder(null);
        jPanel2.add(btnMenuDesplegablePrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        btnCitasMedicasE.setBackground(new java.awt.Color(41, 72, 152));
        btnCitasMedicasE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/citas medicas modo oscuro.png"))); // NOI18N
        btnCitasMedicasE.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        jPanel2.add(btnCitasMedicasE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 80, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1120, Short.MAX_VALUE)
                    .addComponent(jPanelInfoJefes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelInfoJefes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(jfrPantallaMenuJefesEnfermeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaMenuJefesEnfermeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaMenuJefesEnfermeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaMenuJefesEnfermeria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initjfrPantallaMenuJefesEnfermeria();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgendadas;
    public javax.swing.JButton btnCitasMedicasE;
    public javax.swing.JButton btnMenuDesplegablePrincipal;
    public javax.swing.JButton btnSolicitudes;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanelInfoJefes;
    // End of variables declaration//GEN-END:variables
}
