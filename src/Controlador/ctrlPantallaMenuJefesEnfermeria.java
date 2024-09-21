package Controlador;

import Vista.PanelCitasAgendadasJefeEnfermeria;
import Vista.PanelSolicitudesCitas;
import Vista.jfrActualizarCita;
import Vista.jfrAgendarCitasJefesEnfermeria;
import Vista.jfrPantallaMenuJefesEnfermeria;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlPantallaMenuJefesEnfermeria implements MouseListener {
    
    jfrPantallaMenuJefesEnfermeria vista;
    PanelSolicitudesCitas panel;
    PanelCitasAgendadasJefeEnfermeria panel1;
    jfrActualizarCita miniPanel2;
    jfrAgendarCitasJefesEnfermeria miniPanel1;
    
    public ctrlPantallaMenuJefesEnfermeria(jfrPantallaMenuJefesEnfermeria Vista, PanelSolicitudesCitas Panel, PanelCitasAgendadasJefeEnfermeria Panel1, jfrActualizarCita MiniPanel2, jfrAgendarCitasJefesEnfermeria MiniPanel1){
        this.vista = Vista;
        this.panel = Panel;
        this.panel1 = Panel1;
        this.miniPanel1 = MiniPanel1;
        this.miniPanel2 = MiniPanel2;
        
        vista.btnSolicitudes.addMouseListener(this);
        vista.btnAgendadas.addMouseListener(this);
        panel.btnAgendarCita.addMouseListener(this);
        miniPanel1.btnAsignarDatosCita.addMouseListener(this);
        panel1.btnActualizarCita.addMouseListener(this);
        miniPanel2.btnGuardarCambios.addMouseListener(this);
        
        
        vista.jPanelInfoJefes.add(panel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnAgendadas){
            //1-Creo un objeto del panel que quiero mostrar
            PanelCitasAgendadasJefeEnfermeria objMenu = new PanelCitasAgendadasJefeEnfermeria();
            vista.btnSolicitudes.setBackground(new java.awt.Color(183, 184, 187));
            vista.btnAgendadas.setBackground(new java.awt.Color(41, 72, 152));
            
            //2- Limpio el panel contendor (por si acaso)
            vista.jPanelInfoJefes.removeAll();
            //3- muestro el panel que quiero
            vista.jPanelInfoJefes.add(objMenu);
            
            //4- Refrescar todo
            vista.jPanelInfoJefes.revalidate();
            vista.jPanelInfoJefes.repaint();
        }
        if(e.getSource() == panel.btnAgendarCita){
            //1-Creo un objeto del panel que quiero mostrar
            jfrAgendarCitasJefesEnfermeria objMenu = new jfrAgendarCitasJefesEnfermeria();
            
            vista.add(objMenu);
            vista.revalidate();
            vista.repaint();
        }
        
        if(e.getSource() == miniPanel1.btnAsignarDatosCita){
            //validar campos y hacer el insert con una alerta de que los datos si se asignaron
        }
        
        if(e.getSource() == miniPanel1.btnRegresar){
            //1-Creo un objeto del panel que quiero mostrar
            jfrAgendarCitasJefesEnfermeria objMenu = new jfrAgendarCitasJefesEnfermeria();
            
            vista.remove(objMenu);
            vista.revalidate();
            vista.repaint();
        }
        
        if(e.getSource() == vista.btnSolicitudes){
            //1-Creo un objeto del panel que quiero mostrar
            PanelSolicitudesCitas objMenu = new PanelSolicitudesCitas();
            vista.btnAgendadas.setBackground(new java.awt.Color(183, 184, 187));
            vista.btnSolicitudes.setBackground(new java.awt.Color(41, 72, 152));
            
            //2- Limpio el panel contendor (por si acaso)
            vista.jPanelInfoJefes.removeAll();
            //3- muestro el panel que quiero
            vista.jPanelInfoJefes.add(objMenu);
            
            //4- Refrescar todo
            vista.jPanelInfoJefes.revalidate();
            vista.jPanelInfoJefes.repaint();
        }
        if(e.getSource() == miniPanel2.btnGuardarCambios){
            //validar campos y hacer el update con una alerta de que los datos si se actualizaron
        }
        
        if(e.getSource() == miniPanel2.btnRegresar){
            //1-Creo un objeto del panel que quiero mostrar
            jfrActualizarCita objMenu = new jfrActualizarCita();
            
            vista.remove(objMenu);
            vista.revalidate();
            vista.repaint();
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
