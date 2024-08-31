package Controlador;

import Modelo.CodigoRecu;
import Vista.jfrCodigoVerificacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlPantallaCodigoRecu implements ActionListener{
    
    private jfrCodigoVerificacion vista;
    private CodigoRecu modelo;
    
    public ctrlPantallaCodigoRecu (jfrCodigoVerificacion vista, CodigoRecu modelo){
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnConfirmarCod.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int codigoIngresado = Integer.parseInt(vista.txtNum1.getText());

        if (codigoIngresado == modelo.getCodRecu()) {
            JOptionPane.showMessageDialog(vista, "Código correcto. Puedes continuar.");

        } else {
            JOptionPane.showMessageDialog(vista, "Código incorrecto. Inténtalo nuevamente.");
        }
    }
}
