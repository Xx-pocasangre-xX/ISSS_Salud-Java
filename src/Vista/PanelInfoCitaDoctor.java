/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.ctrlPantallaMenuDoctor;

/**
 *
 * @author ricar
 */
public class PanelInfoCitaDoctor extends javax.swing.JPanel {

    /**
     * Creates new form PanelInfoCitaDoctor
     */
    public PanelInfoCitaDoctor() {
        initComponents();
    }
    
    public static void initPanelInfoCitaDoctor(){
            
        jfrPantallaMenuDoctor vista = new jfrPantallaMenuDoctor();
        PanelChatDoctoresSinDesplegar panel = new PanelChatDoctoresSinDesplegar();
        PanelCitasMedicasDoctor panel1 = new PanelCitasMedicasDoctor();
        PanelInfoCitaDoctor panel2 = new PanelInfoCitaDoctor();
        PanelExpedienteMedico panel3 = new PanelExpedienteMedico();
        
        ctrlPantallaMenuDoctor controlador = new ctrlPantallaMenuDoctor(vista, panel, panel1, panel2, panel3);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        btnExpediente = new javax.swing.JButton();
        txtTipoSangre = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(740, 560));
        setPreferredSize(new java.awt.Dimension(740, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(70, 76, 92));
        jPanel7.setMinimumSize(new java.awt.Dimension(740, 560));
        jPanel7.setName(""); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(740, 560));
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
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Correo");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 3, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Motivo de la cita");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 160, -1));

        txtDUI.setBackground(new java.awt.Color(70, 76, 92));
        txtDUI.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtDUI.setForeground(new java.awt.Color(255, 255, 255));
        txtDUI.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel7.add(txtDUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 150, 30));

        txtNombre.setBackground(new java.awt.Color(70, 76, 92));
        txtNombre.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel7.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 270, 30));

        txtDireccion.setBackground(new java.awt.Color(70, 76, 92));
        txtDireccion.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel7.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 270, 30));

        txtMotivoCita.setBackground(new java.awt.Color(70, 76, 92));
        txtMotivoCita.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtMotivoCita.setForeground(new java.awt.Color(255, 255, 255));
        txtMotivoCita.setToolTipText("");
        txtMotivoCita.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel7.add(txtMotivoCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 350, 100));

        txtCorreo.setBackground(new java.awt.Color(70, 76, 92));
        txtCorreo.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel7.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 270, 30));

        btnExpediente.setBackground(new java.awt.Color(41, 72, 152));
        btnExpediente.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnExpediente.setForeground(new java.awt.Color(255, 255, 255));
        btnExpediente.setText("Ver expediente");
        btnExpediente.setBorder(null);
        jPanel7.add(btnExpediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 120, 40));

        txtTipoSangre.setBackground(new java.awt.Color(70, 76, 92));
        txtTipoSangre.setFont(new java.awt.Font("Raleway Thin", 2, 13)); // NOI18N
        txtTipoSangre.setForeground(new java.awt.Color(255, 255, 255));
        txtTipoSangre.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(144, 148, 157)));
        jPanel7.add(txtTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 150, 30));

        add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 560));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExpediente;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDUI;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtMotivoCita;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTipoSangre;
    // End of variables declaration//GEN-END:variables
}
