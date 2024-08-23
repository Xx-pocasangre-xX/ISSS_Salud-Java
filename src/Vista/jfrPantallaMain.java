package Vista;

import Controlador.ctrlPantallaMain;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicButtonUI;


public class jfrPantallaMain extends javax.swing.JFrame {
    
    public jfrPantallaMain() {
        initComponents();
        
        btnBienvenida.setUI(new RoundedButtonUI());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBienvenida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(50, 55, 69));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(951, 631));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fotoprueba.PNG"))); // NOI18N

        btnBienvenida.setBackground(new java.awt.Color(255, 255, 255));
        btnBienvenida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBienvenida.setForeground(new java.awt.Color(41, 72, 152));
        btnBienvenida.setText("Iniciar Sesión");
        btnBienvenida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBienvenidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(374, 374, 374))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(btnBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBienvenidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBienvenidaActionPerformed

                
    }//GEN-LAST:event_btnBienvenidaActionPerformed
    
    public static void main(String args[]) {
       
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBienvenida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

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
}