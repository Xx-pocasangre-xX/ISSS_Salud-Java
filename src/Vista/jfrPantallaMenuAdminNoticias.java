/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author ricar
 */
public class jfrPantallaMenuAdminNoticias extends javax.swing.JFrame {

    /**
     * Creates new form jfrPantallaMenuAdminNoticias
     */
    public jfrPantallaMenuAdminNoticias() {
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

        jPanel2 = new javax.swing.JPanel();
        btnAgregarTrabajadores = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnAgregarJefes = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jpCardsNoticias = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTituloNoticia = new javax.swing.JTextField();
        btnCargarImagenNoticia = new javax.swing.JButton();
        btnAgregarNoticia = new javax.swing.JButton();
        btnActualizarNoticia = new javax.swing.JButton();
        imgNoticia = new javax.swing.JLabel();
        btnLimpiarNoticia = new javax.swing.JButton();
        btnEliminarNoticia = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcionNoticia = new javax.swing.JTextArea();
        jdFechaPublicacion = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 750));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(62, 68, 83));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarTrabajadores.setBackground(new java.awt.Color(62, 68, 83));
        btnAgregarTrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AgregarJefesEnfermeria.png"))); // NOI18N
        btnAgregarTrabajadores.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        btnAgregarTrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTrabajadoresActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarTrabajadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 80, 70));

        jButton1.setBackground(new java.awt.Color(62, 68, 83));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu hamburgesa modo oscuro.png"))); // NOI18N
        jButton1.setBorder(null);
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        btnAgregarJefes.setBackground(new java.awt.Color(41, 72, 152));
        btnAgregarJefes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNoticiasModoOscuro.png"))); // NOI18N
        btnAgregarJefes.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        jPanel2.add(btnAgregarJefes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 80, 70));

        btnCerrarSesion.setBackground(new java.awt.Color(62, 68, 83));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida 1.png"))); // NOI18N
        btnCerrarSesion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        jPanel2.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 80, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 750));

        jPanel1.setBackground(new java.awt.Color(50, 55, 69));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(62, 68, 83));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(156, 156, 156)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo isss modo oscuro sin desplegar.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Roboto", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Noticias");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 110));

        jpCardsNoticias.setBackground(new java.awt.Color(70, 76, 92));
        jpCardsNoticias.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(156, 156, 156)));
        jpCardsNoticias.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jpCardsNoticias, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 480, 640));

        jLabel5.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de publicación");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Foto de la noticia");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Titulo de la noticia");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 260, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Descripción");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        txtTituloNoticia.setBackground(new java.awt.Color(50, 55, 65));
        txtTituloNoticia.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        txtTituloNoticia.setForeground(new java.awt.Color(255, 255, 255));
        txtTituloNoticia.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(132, 135, 143)));
        txtTituloNoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloNoticiaActionPerformed(evt);
            }
        });
        jPanel1.add(txtTituloNoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 290, 30));

        btnCargarImagenNoticia.setBackground(new java.awt.Color(41, 72, 152));
        btnCargarImagenNoticia.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnCargarImagenNoticia.setForeground(new java.awt.Color(255, 255, 255));
        btnCargarImagenNoticia.setText("Cargar Imagen");
        btnCargarImagenNoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImagenNoticiaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarImagenNoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 265, 150, 40));

        btnAgregarNoticia.setBackground(new java.awt.Color(41, 72, 152));
        btnAgregarNoticia.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnAgregarNoticia.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarNoticia.setText("Agregar");
        btnAgregarNoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNoticiaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarNoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 120, 50));

        btnActualizarNoticia.setBackground(new java.awt.Color(41, 72, 152));
        btnActualizarNoticia.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnActualizarNoticia.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarNoticia.setText("Actualizar");
        jPanel1.add(btnActualizarNoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 660, 120, 50));

        imgNoticia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/profile.jpg"))); // NOI18N
        jPanel1.add(imgNoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 550, 100));

        btnLimpiarNoticia.setBackground(new java.awt.Color(41, 72, 152));
        btnLimpiarNoticia.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnLimpiarNoticia.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarNoticia.setText("Limpiar");
        btnLimpiarNoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarNoticiaActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarNoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 660, 120, 50));

        btnEliminarNoticia.setBackground(new java.awt.Color(41, 72, 152));
        btnEliminarNoticia.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnEliminarNoticia.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarNoticia.setText("Eliminar");
        btnEliminarNoticia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarNoticiaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarNoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 660, 120, 50));

        txtDescripcionNoticia.setBackground(new java.awt.Color(50, 55, 65));
        txtDescripcionNoticia.setColumns(20);
        txtDescripcionNoticia.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        txtDescripcionNoticia.setRows(5);
        jScrollPane1.setViewportView(txtDescripcionNoticia);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 550, 120));

        jdFechaPublicacion.setBackground(new java.awt.Color(255, 255, 255));
        jdFechaPublicacion.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jdFechaPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 370, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 1122, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarTrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTrabajadoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarTrabajadoresActionPerformed

    private void txtTituloNoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloNoticiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloNoticiaActionPerformed

    private void btnCargarImagenNoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImagenNoticiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCargarImagenNoticiaActionPerformed

    private void btnAgregarNoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNoticiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarNoticiaActionPerformed

    private void btnLimpiarNoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarNoticiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarNoticiaActionPerformed

    private void btnEliminarNoticiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarNoticiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarNoticiaActionPerformed

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
            java.util.logging.Logger.getLogger(jfrPantallaMenuAdminNoticias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaMenuAdminNoticias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaMenuAdminNoticias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaMenuAdminNoticias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrPantallaMenuAdminNoticias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarNoticia;
    public javax.swing.JButton btnAgregarJefes;
    public javax.swing.JButton btnAgregarNoticia;
    public javax.swing.JButton btnAgregarTrabajadores;
    public javax.swing.JButton btnCargarImagenNoticia;
    public javax.swing.JButton btnCerrarSesion;
    public javax.swing.JButton btnEliminarNoticia;
    public javax.swing.JButton btnLimpiarNoticia;
    public javax.swing.JLabel imgNoticia;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public com.toedter.calendar.JDateChooser jdFechaPublicacion;
    public javax.swing.JPanel jpCardsNoticias;
    public javax.swing.JTextArea txtDescripcionNoticia;
    public javax.swing.JTextField txtTituloNoticia;
    // End of variables declaration//GEN-END:variables
}