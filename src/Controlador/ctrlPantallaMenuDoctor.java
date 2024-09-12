package Controlador;

import Vista.PanelChatDoctoresSinDesplegar;
import Vista.PanelCitasMedicasDoctor;
import Vista.PanelExpedienteMedico;
import Vista.PanelInfoCitaDoctor;
import Vista.jfrPantallaMenuDoctor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlPantallaMenuDoctor implements MouseListener {

    jfrPantallaMenuDoctor vista;
    PanelChatDoctoresSinDesplegar panel;
    PanelCitasMedicasDoctor panel1;
    PanelInfoCitaDoctor panel2;
    PanelExpedienteMedico panel3;
    
    
    public ctrlPantallaMenuDoctor(jfrPantallaMenuDoctor Vista, PanelChatDoctoresSinDesplegar Panel, PanelCitasMedicasDoctor Panel1, PanelInfoCitaDoctor Panel2, PanelExpedienteMedico Panel3){
        this.vista = Vista;
        this.panel = Panel;
        this.panel1 = Panel1;
        this.panel2 = Panel2;
        this.panel3 = Panel3;
        
        vista.btnMensajeria.addMouseListener(this);
        vista.btnMenuDesplegablePrincipal.addMouseListener(this);
        vista.btnCitasMedicas.addMouseListener(this);
        panel2.btnExpediente.addMouseListener(this);
        panel3.btnRegresar.addMouseListener(this);
        panel3.btnEditarActualizarExpediente.addMouseListener(this);
        
        vista.jpPanelInfo.removeAll();
        panel1.jPanelInformacionCitaDoctor.removeAll();
        vista.jpPanelInfo.add(panel1);
        panel1.jPanelInformacionCitaDoctor.add(panel2);
        vista.revalidate();
        vista.repaint(); 
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
            vista.btnMensajeria.setBackground(new java.awt.Color(62, 68, 83));
            vista.btnCitasMedicas.setBackground(new java.awt.Color(41, 72, 152));
            
            vista.jpPanelInfo.removeAll();
            panel1.jPanelInformacionCitaDoctor.removeAll();
            vista.jpPanelInfo.add(panel1);
            panel1.jPanelInformacionCitaDoctor.add(panel2);
            vista.revalidate();
            vista.repaint(); 
        }
        if(e.getSource() == panel2.btnExpediente){
            
            panel1.jPanelInformacionCitaDoctor.removeAll();
            panel1.jPanelInformacionCitaDoctor.add(panel3);
            panel2.initPanelInfoCitaDoctor();
            panel1.revalidate();
            panel1.repaint();
            
            if (panel1.jPanelInformacionCitaDoctor.getComponentCount() > 0 && panel1.jPanelInformacionCitaDoctor.getComponent(0) == panel3) {
                System.out.println("PanelExpedienteMedico agregado correctamente.");
            } else {
                System.out.println("Error: No se pudo agregar PanelExpedienteMedico.");
            }
        }
        if(e.getSource() == panel3.btnRegresar){
            
            panel1.jPanelInformacionCitaDoctor.removeAll();
            panel1.jPanelInformacionCitaDoctor.add(panel2);
            panel3.initPanelExpedienteMedico();
            panel1.revalidate();
            panel1.repaint();
        }
        if(e.getSource() == panel3.btnEditarActualizarExpediente){
            
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
