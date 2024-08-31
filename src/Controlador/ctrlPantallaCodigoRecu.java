package Controlador;

import Modelo.CodigoRecuperacion;
import Vista.jfrCambioContra;
import Vista.jfrCodigoVerificacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlPantallaCodigoRecu{
    
    private jfrCodigoVerificacion vista;
    
    public ctrlPantallaCodigoRecu(jfrCodigoVerificacion vista){
      this.vista = vista;
      this.vista.btnConfirmarCod.addActionListener(new ActionListener(){
          @Override
        public void actionPerformed(ActionEvent e){
          verificarCodigo(vista.txtNum1.getText().trim(),  vista.txtNum2.getText().trim(), vista.txtNum3.getText().trim(), vista.txtNum4.getText().trim(), vista.txtNum5.getText().trim(), vista.txtNum6.getText().trim());
        }
      });
    }
    
    public void verificarCodigo(String txtNum1, String txtNum2, String txtNum3, String txtNum4, String txtNum5, String txtNum6){
        
      String codigoIngresado = txtNum1 + txtNum2 + txtNum3 + txtNum4 + txtNum5 + txtNum6;
      System.out.println("Código ingresado: " + codigoIngresado);
      System.out.println("Código esperado: " + CodigoRecuperacion.getCodigoRecuperacion());
      
      if(codigoIngresado.equals(String.valueOf(CodigoRecuperacion.getCodigoRecuperacion()))){
        JOptionPane.showMessageDialog(null, "Código correcto. Procediendo a la actualización de contrasena.");
        
       jfrCambioContra actualizacionContrasena = new jfrCambioContra();
       actualizacionContrasena.setVisible(true);
       actualizacionContrasena.setLocationRelativeTo(null);
       vista.dispose();
      }else{
        JOptionPane.showMessageDialog(null, "Código incorrecto. Por favor, inténtelo de nuevo.");
      }
    }
}
