/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ctrlPantallaMenuJefesEnfermeria;
import Modelo.SolicitudCitas;

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
    
    public static void initjfrActualizarCita(){
        jfrPantallaMenuJefesEnfermeria vista = new jfrPantallaMenuJefesEnfermeria();
        PanelSolicitudesCitas panel = new PanelSolicitudesCitas() ;
        PanelCitasAgendadasJefeEnfermeria Panel1 = new PanelCitasAgendadasJefeEnfermeria();
        jfrActualizarCita MiniPanel2 = new jfrActualizarCita();
        jfrAgendarCitasJefesEnfermeria MiniPanel1 = new jfrAgendarCitasJefesEnfermeria();
        SolicitudCitas modelo = new SolicitudCitas();
        ctrlPantallaMenuJefesEnfermeria controlador = new ctrlPantallaMenuJefesEnfermeria(vista, panel, Panel1, MiniPanel2, MiniPanel1, modelo);
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

        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        btnGuardarCambios = new javax.swing.JButton();
        cmbNombreDoctor = new javax.swing.JComboBox<>();
        cmbEspecialista = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(760, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(70, 76, 92));
        jPanel1.setMinimumSize(new java.awt.Dimension(760, 560));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setBackground(new java.awt.Color(70, 76, 92));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImagenBtnRegresarModoOscuro.png"))); // NOI18N
        btnRegresar.setToolTipText("");
        btnRegresar.setBorder(null);
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

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

        btnGuardarCambios.setBackground(new java.awt.Color(41, 72, 152));
        btnGuardarCambios.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnGuardarCambios.setText("Guardar cambios");
        btnGuardarCambios.setBorder(null);
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 160, 40));

        cmbNombreDoctor.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        cmbNombreDoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbNombreDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 270, 30));

        cmbEspecialista.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        cmbEspecialista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbEspecialista, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 270, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

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
                initjfrActualizarCita();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardarCambios;
    public javax.swing.JButton btnRegresar;
    public javax.swing.JComboBox<String> cmbEspecialista;
    public javax.swing.JComboBox<String> cmbNombreDoctor;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtDia;
    public javax.swing.JTextField txtHora;
    // End of variables declaration//GEN-END:variables
}
