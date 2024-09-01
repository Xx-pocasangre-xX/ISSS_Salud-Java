package Controlador;

import Modelo.CodigoRecuperacion;
import Modelo.EnvioCorreo;
import Modelo.CredencialesCorreo;
import Modelo.Usuarios;
import Vista.jfrCodigoVerificacion;
import Vista.jfrRecuperacionContra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

public class ctrlPantallaRecuperacionContra implements ActionListener {
    
    private CredencialesCorreo modelo;
    private jfrRecuperacionContra vista;
    private Usuarios modelo2;
    
    public ctrlPantallaRecuperacionContra(CredencialesCorreo modelo, jfrRecuperacionContra vista, Usuarios modelo2){
       this.modelo = modelo;
       this.vista = vista;
       this.modelo2 = modelo2;
       this.vista.btnEnviarCorreo.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.btnEnviarCorreo){
            String recipient = vista.txtCorreoRec.getText();
        
            if(recipient.isEmpty()){
            JOptionPane.showMessageDialog(vista, "Ingrese su correo");
            }

            else if(!recipient.contains("@") || !recipient.contains(".com")){
                    JOptionPane.showMessageDialog(vista, "Correo inválido");
            }
            else {
               if(modelo2.existeCorreo(recipient)){
                String subject = "Recuperacion de contraseña";
                Random random = new Random();
                int codigoRecuperacion = 100000 + random.nextInt(999999);
                CodigoRecuperacion.setCodigoRecuperacion(codigoRecuperacion);
                String content = "Este es el codigo de recuperacion: " + codigoRecuperacion;

                EnvioCorreo.envioCorreo(recipient, subject, content);
                JOptionPane.showMessageDialog(vista, "Correo enviado exitosamente.");
                jfrCodigoVerificacion pantallaCod = new jfrCodigoVerificacion();
                pantallaCod.setVisible(true);
                pantallaCod.setLocationRelativeTo(null);
                vista.dispose();
               }else{
                  JOptionPane.showMessageDialog(vista, "El correo no existe en la base de datos. Intente de nuevo con otro correo.");
               }
            }  
        }
    }
}
