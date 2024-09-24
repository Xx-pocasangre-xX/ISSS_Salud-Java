package Vista;

import Controlador.ctrlPantallaLogin;
import Modelo.Usuarios;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicButtonUI;

public class jfrPantallaLogin extends javax.swing.JFrame {
    
    public jfrPantallaLogin() {
        initComponents();
        
        Usuarios modelo = new Usuarios();
        ctrlPantallaLogin Controlador = new ctrlPantallaLogin(this, modelo);
        
        int width = btnVerContrasena.getWidth();
        int height = btnVerContrasena.getHeight();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/no_ver_password.png"));
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        btnVerContrasena.setIcon(new ImageIcon(scaledImage));
        
        
        RoundedPanel roundedPanel = new RoundedPanel();
        roundedPanel.setBackground(jpFondoAzul.getBackground());
        roundedPanel.setBounds(jpFondoAzul.getBounds());
        
        BienvenidoLabel.setBounds(65, 30, 300, 50);
        roundedPanel.add(BienvenidoLabel);
        
        BienvenidoLabel1.setBounds(60, 70, 300, 50);
        roundedPanel.add(BienvenidoLabel1);
        
        btnIniciarSesion.setBounds(25, 390, 370, 40);
        roundedPanel.add(btnIniciarSesion);
        btnIniciarSesion.setUI(new jfrPantallaLogin.RoundedButtonUI());
        
        txtEmail = new CustomTextField("Email");
        txtEmail.setBounds(35, 180, 350, 40);
        ((CustomTextField) txtEmail).setHintVerticalOffset(10);
        roundedPanel.add(txtEmail);
        txtEmail.setLayout(null);
        
        txtContrasena = new CustomPasswordField("Contraseña");
        txtContrasena.setBounds(35, 250, 350, 40);
        ((CustomPasswordField) txtContrasena).setHintVerticalOffset(10);
        roundedPanel.add(txtContrasena);
        txtContrasena.setLayout(null);
        
        roundedPanel.add(btnVerContrasena);
        btnVerContrasena.setLayout(null);
        
        btnOlvidasteContra.setBounds(125, 400, 200, 100);
        roundedPanel.add(btnOlvidasteContra);
        btnOlvidasteContra.setUI(new jfrPantallaLogin.RoundedButtonUI());
        
        jPanel1.remove(jpFondoAzul);
        jPanel1.add(roundedPanel);
        jpFondoAzul = roundedPanel;
    }
    
    public static void initJfrPantallaMenuAdmin(){
      
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
        jLabel1 = new javax.swing.JLabel();
        jpFondoAzul = new javax.swing.JPanel();
        BienvenidoLabel = new javax.swing.JLabel();
        BienvenidoLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        btnVerContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        btnOlvidasteContra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 640));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(50, 55, 69));
        jPanel1.setMinimumSize(new java.awt.Dimension(960, 640));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 640));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fotoprueba.PNG"))); // NOI18N

        jpFondoAzul.setBackground(new java.awt.Color(31, 38, 76));
        jpFondoAzul.setMaximumSize(new java.awt.Dimension(440, 480));
        jpFondoAzul.setMinimumSize(new java.awt.Dimension(440, 480));
        jpFondoAzul.setPreferredSize(new java.awt.Dimension(440, 480));

        BienvenidoLabel.setFont(new java.awt.Font("Roboto", 3, 36)); // NOI18N
        BienvenidoLabel.setForeground(new java.awt.Color(255, 255, 255));
        BienvenidoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BienvenidoLabel.setText("Bienvenido a ");

        BienvenidoLabel1.setFont(new java.awt.Font("Roboto", 3, 36)); // NOI18N
        BienvenidoLabel1.setForeground(new java.awt.Color(255, 255, 255));
        BienvenidoLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BienvenidoLabel1.setText("ISSS Salud");

        txtEmail.setFont(new java.awt.Font("Roboto", 2, 11)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btnIniciarSesion.setBackground(new java.awt.Color(41, 72, 152));
        btnIniciarSesion.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.setActionCommand("");
        btnIniciarSesion.setBorder(null);
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        btnVerContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/no_ver_password.png"))); // NOI18N
        btnVerContrasena.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVerContrasena.setMaximumSize(new java.awt.Dimension(30, 30));
        btnVerContrasena.setMinimumSize(new java.awt.Dimension(30, 30));
        btnVerContrasena.setPreferredSize(new java.awt.Dimension(30, 30));

        txtContrasena.setFont(new java.awt.Font("Roboto", 2, 11)); // NOI18N

        btnOlvidasteContra.setBackground(new java.awt.Color(31, 38, 76));
        btnOlvidasteContra.setFont(new java.awt.Font("Roboto", 3, 14)); // NOI18N
        btnOlvidasteContra.setForeground(new java.awt.Color(138, 210, 255));
        btnOlvidasteContra.setText("¿olvidaste tu contraseña?");
        btnOlvidasteContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOlvidasteContraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFondoAzulLayout = new javax.swing.GroupLayout(jpFondoAzul);
        jpFondoAzul.setLayout(jpFondoAzulLayout);
        jpFondoAzulLayout.setHorizontalGroup(
            jpFondoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoAzulLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFondoAzulLayout.createSequentialGroup()
                .addGap(0, 48, Short.MAX_VALUE)
                .addGroup(jpFondoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFondoAzulLayout.createSequentialGroup()
                        .addGroup(jpFondoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpFondoAzulLayout.createSequentialGroup()
                                .addComponent(btnOlvidasteContra)
                                .addGap(94, 94, 94)))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFondoAzulLayout.createSequentialGroup()
                        .addGroup(jpFondoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpFondoAzulLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(BienvenidoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BienvenidoLabel))
                        .addGap(101, 101, 101))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFondoAzulLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jpFondoAzulLayout.setVerticalGroup(
            jpFondoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoAzulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BienvenidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BienvenidoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnVerContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOlvidasteContra)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jpFondoAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jpFondoAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed


    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnOlvidasteContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOlvidasteContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOlvidasteContraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(jfrPantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrPantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel BienvenidoLabel;
    public javax.swing.JLabel BienvenidoLabel1;
    public javax.swing.JButton btnIniciarSesion;
    public javax.swing.JButton btnOlvidasteContra;
    public javax.swing.JLabel btnVerContrasena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jpFondoAzul;
    public javax.swing.JPasswordField txtContrasena;
    public javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
   public class RoundedPanel extends JPanel{
     private int cornerRadius = 20;
     
     public RoundedPanel(){
       super();
       setOpaque(false);
       setLayout(null);
     }
     
     @Override
     protected void paintComponent(Graphics g){
       super.paintComponent(g);
       Graphics2D g2 = (Graphics2D) g;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       g2.setColor(getBackground());
       g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
     }
   }
   
   public class CustomTextField extends JTextField{
       
       private String hint;
       private boolean showingHint;
       private int hintVerticalOffset;
       
     public CustomTextField(String hint){
       super();
       this.hint = hint;
       this.showingHint = true;
       this.hintVerticalOffset = 0;
       setOpaque(false);
       setForeground(Color.WHITE);
       setFont(new Font("Arial", Font.ITALIC, 16));
       setCaretColor(Color.WHITE);
       getDocument().addDocumentListener(new DocumentListener(){
         @Override
         public void insertUpdate(DocumentEvent e){
            updateHint();
         }
         
         @Override
         public void removeUpdate(DocumentEvent e) {
                updateHint();
            }   

        @Override
         public void changedUpdate(DocumentEvent e) {
                
            }       
       });
     }
     
     @Override
     protected void paintComponent(Graphics g){
       super.paintComponent(g);
       Graphics2D g2 = (Graphics2D) g.create();
       
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0, getHeight() - 2, getWidth(), 2);
        
     
        if(showingHint) {
        FontMetrics metrics = g2.getFontMetrics(getFont());
            int x = getInsets().left;
            int y = getInsets().top + metrics.getAscent() + hintVerticalOffset; 
            g2.drawString(hint, x, y);
        }
     }
     
     private void updateHint(){
       showingHint = getDocument().getLength() == 0;
       repaint();
     }
     
     public void setHintVerticalOffset(int offset){
       this.hintVerticalOffset = offset;
       repaint();
     }
     
     @Override
     protected void paintBorder(Graphics g){
     
     }
   }
   
   private static class RoundedButtonUI extends BasicButtonUI {
       @Override 
       public void installUI(JComponent c){
         super.installUI(c);
         ((AbstractButton) c).setOpaque(false);
         ((AbstractButton) c).setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
       }
       
       @Override
       public void paint(Graphics g, JComponent c){
          AbstractButton b = (AbstractButton) c;
          Graphics2D g2 = (Graphics2D) g;
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          
          g2.setColor(b.getBackground());
          g2.fill(new RoundRectangle2D.Float(0, 0, b.getWidth(), b.getHeight(), 50, 50));
          
          g2.setColor(b.getForeground());
          FontMetrics fm = g.getFontMetrics();
          g2.drawString(b.getText(), (b.getWidth() - fm.stringWidth(b.getText())) / 2,
                    (b.getHeight() + fm.getAscent()) / 2 - 2);
          
          g2.dispose();
       }
    }
   
   private class CustomPasswordField extends JPasswordField{
      private String hint;
    private boolean showingHint;
    private int hintVerticalOffset;
    
    public CustomPasswordField(String hint) {
        super();
        this.hint = hint;
        this.showingHint = true;
        this.hintVerticalOffset = 0;
        setOpaque(false);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.ITALIC, 16));
        setCaretColor(Color.WHITE);
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateHint();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateHint();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No implementation needed
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0, getHeight() - 2, getWidth(), 2);

        if (showingHint) {
            FontMetrics metrics = g2.getFontMetrics(getFont());
            int x = getInsets().left;
            int y = getInsets().top + metrics.getAscent() + hintVerticalOffset;
            g2.drawString(hint, x, y);
        }
    }
    
    private void updateHint() {
        showingHint = getDocument().getLength() == 0;
        repaint();
    }

    public void setHintVerticalOffset(int offset) {
        this.hintVerticalOffset = offset;
        repaint();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No border painting
    }
}
   }