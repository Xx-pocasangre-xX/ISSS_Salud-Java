package Controlador;

import Vista.PanelChatDoctoresSinDesplegar;
import Vista.PanelMenuMensajeriaSinDesplegar;
import Vista.jfrPantallaMenuDoctor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlPantallaMenuDoctor implements MouseListener {

    jfrPantallaMenuDoctor vista;
    //PanelChatDoctoresSinDesplegar panel;
    PanelMenuMensajeriaSinDesplegar panel;
    
    public ctrlPantallaMenuDoctor(jfrPantallaMenuDoctor Vista, PanelMenuMensajeriaSinDesplegar Panel ){
        this.vista = Vista;
        this.panel = Panel;
        
        
        vista.btnMensajeria.addMouseListener(this);
        vista.btnExpediente.addMouseListener(this);
        vista.btnMenuDesplegablePrincipal.addMouseListener(this);
        panel.btnCitasMedicas.addMouseListener(this);
        panel.btnMenuDesplegable.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnMensajeria){
            //1-Creo un objeto del panel que quiero mostrar
            PanelMenuMensajeriaSinDesplegar objMenu = new PanelMenuMensajeriaSinDesplegar();
            
            //2- Limpio el panel contendor (por si acaso)
            vista.jpPanelMenuNoDesplegado.removeAll();
            //3- muestro el panel que quiero
            vista.jpPanelMenuNoDesplegado.add(objMenu);
            
            //4- Refrescar todo
            vista.jpPanelMenuNoDesplegado.revalidate();
            vista.jpPanelMenuNoDesplegado.repaint();
        }
        
        if(e.getSource() == panel.btnCitasMedicas){
            jfrPantallaMenuDoctor objMenu = new jfrPantallaMenuDoctor();
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
