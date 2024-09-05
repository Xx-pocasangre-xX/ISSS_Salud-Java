package Controlador;

import Vista.PanelChatDoctoresSinDesplegar;
import Vista.PanelCitasMedicasDoctor;
import Vista.jfrPantallaMenuDoctor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlPantallaMenuDoctor implements MouseListener {

    jfrPantallaMenuDoctor vista;
    PanelChatDoctoresSinDesplegar panel;
    PanelCitasMedicasDoctor panel1;
    
    
    public ctrlPantallaMenuDoctor(jfrPantallaMenuDoctor Vista, PanelChatDoctoresSinDesplegar Panel, PanelCitasMedicasDoctor Panel1){
        this.vista = Vista;
        this.panel = Panel;
        this.panel1 = Panel1;
        
        vista.btnMensajeria.addMouseListener(this);
        vista.btnMenuDesplegablePrincipal.addMouseListener(this);
        vista.btnCitasMedicas.addMouseListener(this);
        
        
        PanelCitasMedicasDoctor objMenu = new PanelCitasMedicasDoctor();
        vista.jpPanelInfo.add(objMenu);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnMensajeria){
            //1-Creo un objeto del panel que quiero mostrar
            PanelChatDoctoresSinDesplegar objMenu = new PanelChatDoctoresSinDesplegar();
            vista.btnMensajeria.setBackground(new java.awt.Color(41, 72, 152));
            vista.btnCitasMedicas.setBackground(new java.awt.Color(62, 68, 83));
            
            //2- Limpio el panel contendor (por si acaso)
            vista.jpPanelInfo.removeAll();
            //3- muestro el panel que quiero
            vista.jpPanelInfo.add(objMenu);
            
            //4- Refrescar todo
            vista.jpPanelInfo.revalidate();
            vista.jpPanelInfo.repaint();
        }
        
        if(e.getSource() == vista.btnCitasMedicas){
            PanelCitasMedicasDoctor objMenu = new PanelCitasMedicasDoctor();
            vista.btnMensajeria.setBackground(new java.awt.Color(62, 68, 83));
            vista.btnCitasMedicas.setBackground(new java.awt.Color(41, 72, 152));
            
            vista.jpPanelInfo.removeAll();
            vista.jpPanelInfo.add(objMenu);
            vista.jpPanelInfo.revalidate();
            vista.jpPanelInfo.repaint();
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
