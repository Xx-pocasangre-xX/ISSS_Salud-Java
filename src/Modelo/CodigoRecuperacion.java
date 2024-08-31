package Modelo;

import Vista.jfrCambioContra;
import Vista.jfrCodigoVerificacion;
import javax.swing.JOptionPane;

public class CodigoRecuperacion {
    private static int codigoRecuperacion;

    public static void setCodigoRecuperacion(int codigo) {
        codigoRecuperacion = codigo;
    }

    public static int getCodigoRecuperacion() {
        return codigoRecuperacion;
    }
    
    public void verificarCodigo(String txtNum1, String txtNum2, String txtNum3, String txtNum4, String txtNum5, String txtNum6, jfrCodigoVerificacion vista){
        
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
