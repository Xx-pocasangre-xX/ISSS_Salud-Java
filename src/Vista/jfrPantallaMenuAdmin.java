package Vista;

import Controlador.ctrlPantallaMenuAdmin;
import Modelo.Doctores;
import Modelo.EspecialidadDoctores;
import Modelo.UnidadesMedicas;
import java.awt.Image;
import javax.swing.ImageIcon;

public class jfrPantallaMenuAdmin extends javax.swing.JFrame {

    public jfrPantallaMenuAdmin() {
        initComponents();
        
        
        EspecialidadDoctores modelo = new EspecialidadDoctores();
        UnidadesMedicas modelo2 = new UnidadesMedicas();
        Doctores modelo3 = new Doctores();
        ctrlPantallaMenuAdmin Controlador = new ctrlPantallaMenuAdmin(this, modelo);
        ctrlPantallaMenuAdmin Controlador2 = new ctrlPantallaMenuAdmin(this, modelo2);
        ctrlPantallaMenuAdmin Controlador3 = new ctrlPantallaMenuAdmin(this, modelo3);
        
        int width = profileImage.getWidth();
        int height = profileImage.getHeight();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/profile.jpg"));
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        profileImage.setIcon(new ImageIcon(scaledImage));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jpCardsDoctores = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNombreDoctor = new javax.swing.JTextField();
        txtCorreoDoctor = new javax.swing.JTextField();
        btnCargarImagen = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        cbEspecialidadesMedicas = new javax.swing.JComboBox<>();
        cbUnidadesMedicas = new javax.swing.JComboBox<>();
        profileImage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtContrasenaDoctor = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 750));
        setPreferredSize(new java.awt.Dimension(1200, 750));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(62, 68, 83));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(41, 72, 152));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/administrador modo oscuro.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 80, 70));

        jButton1.setBackground(new java.awt.Color(62, 68, 83));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu hamburgesa modo oscuro.png"))); // NOI18N
        jButton1.setBorder(null);
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

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
        jLabel4.setText("Doctores");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 110));

        jpCardsDoctores.setBackground(new java.awt.Color(70, 76, 92));
        jpCardsDoctores.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(156, 156, 156)));
        jpCardsDoctores.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jpCardsDoctores, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 480, 640));

        jLabel5.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Foto del doctor");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre del doctor");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 180, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Correo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Unidad Medica");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        txtNombreDoctor.setBackground(new java.awt.Color(50, 55, 65));
        txtNombreDoctor.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        txtNombreDoctor.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreDoctor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(132, 135, 143)));
        txtNombreDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreDoctorActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 290, 30));

        txtCorreoDoctor.setBackground(new java.awt.Color(50, 55, 65));
        txtCorreoDoctor.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        txtCorreoDoctor.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreoDoctor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(132, 135, 143)));
        txtCorreoDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoDoctorActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreoDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 290, 30));

        btnCargarImagen.setBackground(new java.awt.Color(41, 72, 152));
        btnCargarImagen.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnCargarImagen.setForeground(new java.awt.Color(255, 255, 255));
        btnCargarImagen.setText("Cargar Imagen");
        btnCargarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImagenActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 140, 50));

        btnAgregar.setBackground(new java.awt.Color(41, 72, 152));
        btnAgregar.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, 120, 50));

        btnActualizar.setBackground(new java.awt.Color(41, 72, 152));
        btnActualizar.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 660, 120, 50));

        cbEspecialidadesMedicas.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        cbEspecialidadesMedicas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEspecialidadesMedicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecialidadesMedicasActionPerformed(evt);
            }
        });
        jPanel1.add(cbEspecialidadesMedicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 290, 30));

        cbUnidadesMedicas.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        cbUnidadesMedicas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbUnidadesMedicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUnidadesMedicasActionPerformed(evt);
            }
        });
        jPanel1.add(cbUnidadesMedicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 290, 30));

        profileImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/profile.jpg"))); // NOI18N
        jPanel1.add(profileImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 200, 200));

        jLabel9.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Especialidad");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        btnLimpiar.setBackground(new java.awt.Color(41, 72, 152));
        btnLimpiar.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 660, 120, 50));

        btnEliminar.setBackground(new java.awt.Color(41, 72, 152));
        btnEliminar.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 660, 120, 50));

        txtContrasenaDoctor.setBackground(new java.awt.Color(50, 55, 65));
        txtContrasenaDoctor.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        txtContrasenaDoctor.setForeground(new java.awt.Color(255, 255, 255));
        txtContrasenaDoctor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(132, 135, 143)));
        jPanel1.add(txtContrasenaDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 290, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreDoctorActionPerformed

    private void txtCorreoDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoDoctorActionPerformed

    private void cbUnidadesMedicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUnidadesMedicasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbUnidadesMedicasActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cbEspecialidadesMedicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecialidadesMedicasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEspecialidadesMedicasActionPerformed

    private void btnCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCargarImagenActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(jfrPantallaMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrPantallaMenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCargarImagen;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JComboBox<String> cbEspecialidadesMedicas;
    public javax.swing.JComboBox<String> cbUnidadesMedicas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jpCardsDoctores;
    public javax.swing.JLabel profileImage;
    public javax.swing.JPasswordField txtContrasenaDoctor;
    public javax.swing.JTextField txtCorreoDoctor;
    public javax.swing.JTextField txtNombreDoctor;
    // End of variables declaration//GEN-END:variables
}
