/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

/**
 *
 * @author ricar
 */
public class PanelChatDoctoresSinDesplegar extends javax.swing.JPanel {

    /**
     * Creates new form PanelChatDoctores
     */
    public PanelChatDoctoresSinDesplegar() {
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

        jPanelMensajeriaDoctores = new javax.swing.JPanel();
        imgLogoIsss = new javax.swing.JLabel();
        MensajeriaDoctores = new javax.swing.JLabel();
        jPanelChat = new javax.swing.JPanel();
        chat = new javax.swing.JLabel();
        jPanelChatsDoctores = new javax.swing.JPanel();
        JpCardsPacientes = new javax.swing.JPanel();
        jpChatsBienvenida = new javax.swing.JPanel();

        setBackground(new java.awt.Color(62, 68, 83));
        setMinimumSize(new java.awt.Dimension(1120, 750));
        setPreferredSize(new java.awt.Dimension(1120, 750));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMensajeriaDoctores.setBackground(new java.awt.Color(62, 68, 83));
        jPanelMensajeriaDoctores.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(156, 156, 156)));
        jPanelMensajeriaDoctores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgLogoIsss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo isss modo oscuro sin desplegar.png"))); // NOI18N
        jPanelMensajeriaDoctores.add(imgLogoIsss, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        MensajeriaDoctores.setBackground(new java.awt.Color(255, 255, 255));
        MensajeriaDoctores.setFont(new java.awt.Font("Roboto", 3, 36)); // NOI18N
        MensajeriaDoctores.setForeground(new java.awt.Color(255, 255, 255));
        MensajeriaDoctores.setText("Mensajeria");
        jPanelMensajeriaDoctores.add(MensajeriaDoctores, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        add(jPanelMensajeriaDoctores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 110));

        jPanelChat.setBackground(new java.awt.Color(73, 80, 96));
        jPanelChat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(156, 156, 156)));
        jPanelChat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chat.setBackground(new java.awt.Color(255, 255, 255));
        chat.setFont(new java.awt.Font("Roboto", 3, 30)); // NOI18N
        chat.setForeground(new java.awt.Color(255, 255, 255));
        chat.setText("Chat");
        jPanelChat.add(chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 25, 70, -1));

        add(jPanelChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 340, 80));

        jPanelChatsDoctores.setBackground(new java.awt.Color(76, 82, 99));
        jPanelChatsDoctores.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(156, 156, 156)));
        jPanelChatsDoctores.setLayout(new java.awt.BorderLayout());

        JpCardsPacientes.setBackground(new java.awt.Color(76, 82, 99));
        JpCardsPacientes.setLayout(new java.awt.BorderLayout());
        jPanelChatsDoctores.add(JpCardsPacientes, java.awt.BorderLayout.CENTER);

        add(jPanelChatsDoctores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 340, 560));

        jpChatsBienvenida.setBackground(new java.awt.Color(62, 68, 83));
        jpChatsBienvenida.setLayout(new java.awt.BorderLayout());
        add(jpChatsBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 780, 640));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel JpCardsPacientes;
    public javax.swing.JLabel MensajeriaDoctores;
    public javax.swing.JLabel chat;
    public javax.swing.JLabel imgLogoIsss;
    public javax.swing.JPanel jPanelChat;
    public javax.swing.JPanel jPanelChatsDoctores;
    public javax.swing.JPanel jPanelMensajeriaDoctores;
    public javax.swing.JPanel jpChatsBienvenida;
    // End of variables declaration//GEN-END:variables
}
