package Modelo;

import Vista.PanelSolicitudesCitas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SolicitudCitas {
    private String nombre_usuario;
    private String telefono;
    private String correo_electronico;
    private String motivo_cita;
    private String dui;
    private String fecha_solicitud;
    private String foto_usuario;
    
    public String getNombreUsuario() {
      return nombre_usuario;
    }
    
    public void setNombreUsuario(String nombre_usuario) {
      this.nombre_usuario = nombre_usuario;
    }
    
    public String getFotoUsuario() {
      return foto_usuario;
    }
    
    public void setFotoUsuario(String foto_usuario) {
      this.foto_usuario = foto_usuario;
    }
    
    public String getTelefono() {
      return telefono;
    }
    
    public void setTelefono(String telefono) {
      this.telefono = telefono;
    }
    
    public String getCorreoElectronico3() {
      return correo_electronico;
    }
    
    public void setCorreoElectronico3(String correo_electronico) {
      this.correo_electronico = correo_electronico;
    }
    
    public String getMotivoCita() {
      return motivo_cita;
    }
    
    public void setMotivoCita(String motivo_cita) {
      this.motivo_cita = motivo_cita;
    }
    
    public String getDui2() {
      return dui;
    }
    
    public void setDui2(String dui) {
      this.dui = dui;
    }
    
    public String getFechaSolicitud() {
      return fecha_solicitud;
    }
    
    public void setFechaSolicitud(String fecha_solicitud) {
      this.fecha_solicitud = fecha_solicitud;
    }
    
    public List<SolicitudCitas> obtenerSolicitudCitas(){
      List<SolicitudCitas> listaSolicitudCitas = new ArrayList<>();
      String query = "SELECT * FROM (SELECT s.id_solicitud, u.telefono, u.nombre_usuario, u.correo_electronico, s.motivo_cita, u.dui, u.foto_usuario, s.fecha_solicitud FROM SolicitudCitas s INNER JOIN Usuarios u ON s.id_usuario = u.id_usuario ORDER BY s.id_solicitud DESC) WHERE ROWNUM <= 20";
      
      try(Connection conexion = ClaseConexion.getConexion();
          PreparedStatement stmt = conexion.prepareStatement(query);
          ResultSet rs = stmt.executeQuery()){
         
          while(rs.next()){
            SolicitudCitas solicitudCitas = new SolicitudCitas();
            solicitudCitas.setTelefono(rs.getString("telefono"));
            solicitudCitas.setNombreUsuario(rs.getString("nombre_usuario"));
            solicitudCitas.setCorreoElectronico3(rs.getString("correo_electronico"));
            solicitudCitas.setMotivoCita(rs.getString("motivo_cita"));
            solicitudCitas.setDui2(rs.getString("dui"));
            solicitudCitas.setFotoUsuario(rs.getString("foto_usuario"));
            solicitudCitas.setFechaSolicitud(rs.getString("fecha_solicitud"));
            listaSolicitudCitas.add(solicitudCitas);
          }
      }catch(SQLException e){
        e.printStackTrace();
      }
      
      return listaSolicitudCitas;
    }
    
    public void cargarCardsSolicitudCitas(JPanel jpCardsSolicitudCitas, PanelSolicitudesCitas panel){
       JPanel panelCards = new JPanel();
       panelCards.setLayout(new GridBagLayout());
       
       Color rgbColor = new Color(70, 76, 92);
       panelCards.setBackground(rgbColor);
       
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.insets = new Insets(10, 10, 10, 10);
       gbc.fill = GridBagConstraints.HORIZONTAL;
       gbc.weightx = 1.0;
       
       List<SolicitudCitas> solicitudCitas = obtenerSolicitudCitas();
       int row = 0;
       
       for(SolicitudCitas solicitudCita : solicitudCitas){
          JButton card = crearCard(solicitudCita, panel);
          gbc.gridy = row;
          panelCards.add(card, gbc);
        
          gbc.gridy = row + 1;
          panelCards.add(Box.createRigidArea(new Dimension(0, 20))); 
        
          row += 2;
       }
       
       jpCardsSolicitudCitas.removeAll();
       
       JScrollPane scrollPane = new JScrollPane(panelCards);
       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       
       jpCardsSolicitudCitas.setLayout(new BorderLayout());
       jpCardsSolicitudCitas.add(scrollPane, BorderLayout.CENTER);
       jpCardsSolicitudCitas.setBackground(rgbColor);
       
       jpCardsSolicitudCitas.revalidate();
       jpCardsSolicitudCitas.repaint();
    }
    
    public ImageIcon cargarImagen(String path){
       ImageIcon imagen = null;
       try{
        if(path.startsWith("http")){
          URL url = new URL(path);
          Image img = ImageIO.read(url);
          imagen = new ImageIcon(img);
        }else{
          imagen = new ImageIcon(path);
        }
      }catch(IOException e){
        System.out.println("No se pudo cargar la imagen: " + path + ", usando imagen por defecto.");
        imagen = new ImageIcon("Imagenes/profile.jpg");
      }
      return imagen;
    }
    
    private JButton crearCard(SolicitudCitas solicitudCitas, PanelSolicitudesCitas panel){
       JButton card = new JButton();
       card.setLayout(new BorderLayout(10, 10));
       card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       
       Color rgbColor = new Color(41, 72, 152);
       card.setBackground(rgbColor);
       
       ImageIcon iconoSolicitudCitas = cargarImagen(solicitudCitas.getFotoUsuario());
       Image img = iconoSolicitudCitas.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
       JLabel lblFoto = new JLabel(new ImageIcon(img));
       
       JPanel textPanel = new JPanel();
       textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
       textPanel.setBackground(rgbColor);
       
       JLabel lblNombreUsuario = new JLabel("Solicitante: " + solicitudCitas.getNombreUsuario());
       JLabel lblTelefono = new JLabel("Teléfono del solicitante: " + solicitudCitas.getTelefono());
       JLabel lblCorreoElectronico = new JLabel("Correo Electrónico: " + solicitudCitas.getCorreoElectronico3());
       JLabel lblMotivoCita = new JLabel("Motivo de la cita: " + solicitudCitas.getMotivoCita());
       JLabel lblDui = new JLabel("Dui del solicitante: " + solicitudCitas.getDui2());
       JLabel lblFechaSolicitud = new JLabel("Fecha de la solicitud: " + solicitudCitas.getFechaSolicitud());

       lblNombreUsuario.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblNombreUsuario.setForeground(Color.WHITE);
       lblTelefono.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblTelefono.setForeground(Color.WHITE);
       lblCorreoElectronico.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblCorreoElectronico.setForeground(Color.WHITE);
       lblMotivoCita.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblMotivoCita.setForeground(Color.WHITE);
       lblDui.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblDui.setForeground(Color.WHITE);
       lblFechaSolicitud.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblFechaSolicitud.setForeground(Color.WHITE);
       
       textPanel.add(lblNombreUsuario);
       textPanel.add(lblTelefono);
       textPanel.add(lblCorreoElectronico);
       textPanel.add(lblMotivoCita);
       textPanel.add(lblDui);
       textPanel.add(lblFechaSolicitud);
       
       card.add(lblFoto, BorderLayout.WEST);
       card.add(textPanel, BorderLayout.CENTER);
       
       card.setPreferredSize(new Dimension(350, 100));
       card.setMaximumSize(new Dimension(350, 100));
       card.setMinimumSize(new Dimension(350, 100));
       card.setFocusable(true);
       
       card.addActionListener((e) ->{
         actualizarTextFieldsConDatos(solicitudCitas, panel);
       });
       
       return card;
    }
    
    private void actualizarTextFieldsConDatos(SolicitudCitas solicitudCitas, PanelSolicitudesCitas panel){
      panel.txtNombreSolicitante.setText(solicitudCitas.getNombreUsuario());
      panel.txtTelefono.setText(solicitudCitas.getTelefono());
      panel.txtCorreo.setText(solicitudCitas.getCorreoElectronico3());
      panel.txtMotivoCita.setText(solicitudCitas.getMotivoCita());
      panel.txtDUI.setText(solicitudCitas.getDui2());
      panel.txtFechaSolicitud.setText(solicitudCitas.getFechaSolicitud());
    }
    
    public void bloquearTextFields(JTextField txtNombreSolicitante, JTextField txtTelefono, JTextField txtCorreo, JTextField txtMotivoCita, JTextField txtDUI, JTextField txtFechaSolicitud){
      txtNombreSolicitante.setEditable(false);
      txtTelefono.setEditable(false);
      txtCorreo.setEditable(false);
      txtMotivoCita.setEditable(false);
      txtDUI.setEditable(false);
      txtFechaSolicitud.setEditable(false);
    }
}