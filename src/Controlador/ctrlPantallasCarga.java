package Controlador;

import Vista.jfrPantallaCarga;
import Vista.jfrPantallaMain;

public class ctrlPantallasCarga {
    private jfrPantallaCarga pantallaCarga;
    private jfrPantallaMain pantallaMain;
    
    public ctrlPantallasCarga (jfrPantallaCarga pantallaCarga, jfrPantallaMain pantallaMain){
        this.pantallaCarga = pantallaCarga;
        this.pantallaMain = pantallaMain;
    }
    
    public void mostrarPantallaCarga(){
      pantallaCarga.setVisible(true);
      
      new Thread(() -> {
        try{
          Thread.sleep(3000);
        }catch(InterruptedException e){
          e.printStackTrace();
        }
        
        pantallaCarga.dispose();
        pantallaMain.setVisible(true);
      }).start();
    }
}
