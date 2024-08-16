package Controlador;

import Vista.jfrPantallaCarga;
import Vista.jfrPantallaMain;
import javax.swing.SwingUtilities;

public class ctrlPantallasCarga {
    private jfrPantallaCarga pantallaCarga;
    private jfrPantallaMain pantallaMain;
    
    public ctrlPantallasCarga (jfrPantallaCarga pantallaCarga, jfrPantallaMain pantallaMain){
        this.pantallaCarga = pantallaCarga;
        this.pantallaMain = pantallaMain;
    }
    
    public void mostrarPantallaCarga(){
      pantallaCarga.setVisible(true);
      pantallaCarga.setLocationRelativeTo(null);
      
      new Thread(() -> {
        try{
          Thread.sleep(3000);
        }catch(InterruptedException e){
          e.printStackTrace();
        }
        
         SwingUtilities.invokeLater(() -> {
                pantallaCarga.dispose();
                pantallaMain.setLocationRelativeTo(null);
                pantallaMain.setVisible(true);
            });
      }).start();
    }
}
