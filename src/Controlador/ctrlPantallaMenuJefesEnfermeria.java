package Controlador;

import Modelo.CitasMedicas;
import Modelo.CitasMedicasJefes;
import Modelo.EspecialidadDoctores;
import Modelo.SolicitudCitas;
import Modelo.Usuarios;
import Vista.PanelCitasAgendadasJefeEnfermeria;
import Vista.PanelExpedienteMedico;
import Vista.PanelInfoCitaDoctor;
import Vista.PanelSolicitudesCitas;
import java.sql.SQLException;
import Vista.jfrActualizarCita;
import static Vista.jfrActualizarCita.initjfrActualizarCita;
import Vista.jfrAgendarCitasJefesEnfermeria;
import static Vista.jfrAgendarCitasJefesEnfermeria.initjfrAgendarCitasJefesEnfermeria;
import Vista.jfrPantallaLogin;
import Vista.jfrPantallaMenuJefesEnfermeria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlPantallaMenuJefesEnfermeria implements MouseListener {
    
    jfrPantallaMenuJefesEnfermeria vista;
    PanelSolicitudesCitas panel;
    PanelCitasAgendadasJefeEnfermeria panel1;
    jfrActualizarCita miniPanel2;
    jfrAgendarCitasJefesEnfermeria miniPanel1;
    SolicitudCitas modelo;
    private CitasMedicas modelo2;
    private CitasMedicasJefes modelo3;
    private EspecialidadDoctores modelo4;
    Usuarios modelo5;
    
    public ctrlPantallaMenuJefesEnfermeria(jfrPantallaMenuJefesEnfermeria Vista, PanelSolicitudesCitas Panel, PanelCitasAgendadasJefeEnfermeria Panel1, jfrActualizarCita MiniPanel2, jfrAgendarCitasJefesEnfermeria MiniPanel1, SolicitudCitas modelo, CitasMedicas modelo2, CitasMedicasJefes modelo3, EspecialidadDoctores modelo4,  Usuarios modelo5){
        this.vista = Vista;
        this.panel = Panel;
        this.panel1 = Panel1;
        this.miniPanel1 = MiniPanel1;
        this.miniPanel2 = MiniPanel2;
        this.modelo = modelo;
        this.modelo2 = modelo2;
        this.modelo3 = modelo3;
        this.modelo4 = modelo4;
        this.modelo5 = modelo5;
        this.modelo.cargarCardsSolicitudCitas(panel.jpCardsSolicitudCitas, panel);
        this.modelo.bloquearTextFields(panel.txtNombreSolicitante, panel.txtTelefono, panel.txtCorreo, panel.txtMotivoCita, panel.txtDUI, panel.txtFechaSolicitud);
        this.modelo2.cargarDoctores(miniPanel1.cbDoctor);
        this.modelo2.cargarPacientes(miniPanel1.cbPacientes);
        this.modelo4.cargarEspecialidadesMedicas2(MiniPanel1.cbEspecialidadDoctor, MiniPanel1.cbDoctor);
        this.modelo4.cargarEspecialidadesMedicas2(MiniPanel2.cbEspecialidadDoctor, MiniPanel2.cbDoctor);
        this.modelo2.cargarDoctores2(miniPanel2.cbDoctor);
        this.modelo3.cargarCardsCitasMedicas(panel1.jpCardsCitasAgendadas2, panel1, miniPanel2);
        
        vista.btnSolicitudes.addMouseListener(this);
        vista.btnAgendadas.addMouseListener(this);
        vista.btnCerrarSesion.addMouseListener(this);
        panel.btnAgendarCita.addMouseListener(this);
        miniPanel1.btnAsignarDatosCita.addMouseListener(this);
        panel1.btnActualizarCita.addMouseListener(this);
        miniPanel1.btnRegresar.addMouseListener(this);
        miniPanel2.btnGuardarCambios.addMouseListener(this);
        miniPanel2.btnRegresar.addMouseListener(this);
        
        vista.jPanelInfoJefes.removeAll();
        vista.jPanelInfoJefes.add(panel);
        vista.revalidate();
        vista.repaint(); 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnCerrarSesion){
           jfrPantallaLogin login = new jfrPantallaLogin();
           login.setVisible(true);
           login.setLocationRelativeTo(null);
           vista.dispose();
           
           login.btnVerContrasena.addActionListener(new ActionListener(){
                     @Override
                     public void actionPerformed(ActionEvent e){
                       modelo5.togglePasswordVisibility(login);
                     }
                  });
        }
        
        if(e.getSource() == vista.btnAgendadas){
            //1-Creo un objeto del panel que quiero mostrar
            PanelCitasAgendadasJefeEnfermeria objMenu = new PanelCitasAgendadasJefeEnfermeria();
            vista.btnSolicitudes.setBackground(new java.awt.Color(183, 184, 187));
            vista.btnAgendadas.setBackground(new java.awt.Color(41, 72, 152));
            modelo3.cargarCardsCitasMedicas(objMenu.jpCardsCitasAgendadas2, objMenu, miniPanel2);
            
            
            //2- Limpio el panel contendor (por si acaso)
            vista.jPanelInfoJefes.removeAll();
            //3- muestro el panel que quiero
            vista.jPanelInfoJefes.add(objMenu);
            
            //4- Refrescar todo
            vista.jPanelInfoJefes.revalidate();
            vista.jPanelInfoJefes.repaint();
            
            objMenu.btnActualizarCita.addMouseListener(new MouseListener(){
              @Override
              public void mouseClicked(MouseEvent e){
                if (miniPanel2 == null) {
                
                miniPanel2 = new jfrActualizarCita();
                initjfrActualizarCita();  
            }
            miniPanel2.setVisible(true); 
            miniPanel2.setLocationRelativeTo(null);
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
            });
        }
        
        if(e.getSource() == panel.btnAgendarCita){
            if (miniPanel1 == null || !miniPanel1.isVisible()) {
            miniPanel1 = new jfrAgendarCitasJefesEnfermeria(); 
            initjfrAgendarCitasJefesEnfermeria(); 
    }
        }
        
        if(e.getSource() == miniPanel1.btnAsignarDatosCita){
            modelo2.insertarCitaMedica(miniPanel1.jdcFechaCita, miniPanel1.txtHoraCita, miniPanel1.cbPacientes, miniPanel1.cbDoctor);
            modelo3.cargarCardsCitasMedicas(panel1.jpCardsCitasAgendadas2, panel1, miniPanel2);
        }
        
        if(e.getSource() == miniPanel1.btnRegresar){
            miniPanel1.dispose();
        }
        
        if(e.getSource() == miniPanel2.btnRegresar){
           miniPanel2.dispose();
        }
        
        if(e.getSource() == vista.btnSolicitudes){
            //1-Creo un objeto del panel que quiero mostrar
            PanelSolicitudesCitas objMenu = new PanelSolicitudesCitas();
            
            this.modelo.cargarCardsSolicitudCitas(objMenu.jpCardsSolicitudCitas, objMenu);
            this.modelo.bloquearTextFields(objMenu.txtNombreSolicitante, objMenu.txtTelefono, objMenu.txtCorreo, objMenu.txtMotivoCita, objMenu.txtDUI, objMenu.txtFechaSolicitud);
            vista.btnAgendadas.setBackground(new java.awt.Color(183, 184, 187));
            vista.btnSolicitudes.setBackground(new java.awt.Color(41, 72, 152));
            
            //2- Limpio el panel contendor (por si acaso)
            vista.jPanelInfoJefes.removeAll();
            //3- muestro el panel que quiero
            vista.jPanelInfoJefes.add(objMenu);
            
            //4- Refrescar todo
            vista.jPanelInfoJefes.revalidate();
            vista.jPanelInfoJefes.repaint();
            
            objMenu.btnAgendarCita.addMouseListener(new MouseListener(){
               @Override
               public void mouseClicked(MouseEvent e){
                 initjfrAgendarCitasJefesEnfermeria();
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
            });
        }
        if(e.getSource() == miniPanel2.btnGuardarCambios){
                System.err.println("Clicked");
    
                
    // Recolectar los datos del formulario
    java.util.Date fechaSeleccionada = miniPanel2.jdcFechaActualizada.getDate();
    String horaCita = miniPanel2.txtHoraActualizada.getText();
    String nombreDoctor = (String) miniPanel2.cbDoctor.getSelectedItem();

    int idCita = modelo3.getIdCita(); // Obtener el ID de la cita a actualizar

    // Llamar al método del modelo que realiza la actualización y validaciones
    modelo3.actualizarCita(idCita, fechaSeleccionada, horaCita, nombreDoctor, miniPanel2);
    modelo3.cargarCardsCitasMedicas(panel1.jpCardsCitasAgendadas2, panel1, miniPanel2);
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
