package Controlador;

import Vista.PanelSolicitudesCitas;
import Vista.jfrPantallaMenuJefesEnfermeria;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlPantallaMenuJefesEnfermeria implements MouseListener {
    
    jfrPantallaMenuJefesEnfermeria vista;
    PanelSolicitudesCitas panel;
    
    public ctrlPantallaMenuJefesEnfermeria(jfrPantallaMenuJefesEnfermeria Vista, PanelSolicitudesCitas Panel ){
        this.vista = Vista;
        this.panel = Panel;
        
        vista.btnSolicitudes.addMouseListener(this);
        vista.btnAgendadas.addMouseListener(this);
        panel.btnAgendarCita.addMouseListener(this);
        
        PanelSolicitudesCitas panel = new PanelSolicitudesCitas();
        vista.jPanelInfoJefes.add(panel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnAgendadas){
            
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
