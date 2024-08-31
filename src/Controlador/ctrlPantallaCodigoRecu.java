package Controlador;

import Modelo.CodigoRecuperacion;
import Vista.jfrCambioContra;
import Vista.jfrCodigoVerificacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlPantallaCodigoRecu{
    
    private jfrCodigoVerificacion vista;
    private CodigoRecuperacion modelo;
    
    public ctrlPantallaCodigoRecu(jfrCodigoVerificacion vista, CodigoRecuperacion modelo){
      this.vista = vista;
      this.modelo = modelo;
      this.vista.btnConfirmarCod.addActionListener(new ActionListener(){
          @Override
        public void actionPerformed(ActionEvent e){
          modelo.verificarCodigo(vista.txtNum1.getText().trim(),  vista.txtNum2.getText().trim(), vista.txtNum3.getText().trim(), vista.txtNum4.getText().trim(), vista.txtNum5.getText().trim(), vista.txtNum6.getText().trim(), vista);
        }
      });
    }
    
    
}
