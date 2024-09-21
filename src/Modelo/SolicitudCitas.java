package Modelo;

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

public class SolicitudCitas {
    private String nombre_solicitante;
    private String telefono;
    private String correo_electronico;
    private String motivo_cita;
    private String dui;
    private String fecha_solicitud;
    private String foto_usuario;
    
    public String getNombresolicitante() {
      return nombre_solicitante;
    }
    
    public void setNombreSolicitante(String nombre_solicitante) {
      this.nombre_solicitante = nombre_solicitante;
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
      String query = "SELECT s.nombre_solicitante, u.telefono, u.correo_electronico, s.motivo_cita, u.dui, u.foto_usuario, s.fecha_solicitud FROM SolicitudCitas s INNER JOIN Usuarios u ON s.id_usuario = u.id_usuario";
      
      try(Connection conexion = ClaseConexion.getConexion();
          PreparedStatement stmt = conexion.prepareStatement(query);
          ResultSet rs = stmt.executeQuery()){
         
          while(rs.next()){
            SolicitudCitas solicitudCitas = new SolicitudCitas();
            solicitudCitas.setNombreSolicitante(rs.getString("nombre_solicitante"));
            solicitudCitas.setTelefono(rs.getString("telefono"));
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
    
    public void cargarCardsSolicitudCitas(JPanel jpCardsSolicitudCitas){
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
          JButton card = crearCard(solicitudCita);
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
    
    private JButton crearCard(SolicitudCitas solicitudCitas){
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
       
       JLabel lblNombreSolicitante = new JLabel("Solicitante: " + solicitudCitas.getNombresolicitante());
       JLabel lblTelefono = new JLabel("Teléfono del solicitante: " + solicitudCitas.getTelefono());
       JLabel lblCorreoElectronico = new JLabel("Correo Electrónico: " + solicitudCitas.getCorreoElectronico3());
       JLabel lblMotivoCita = new JLabel("Motivo de la cita: " + solicitudCitas.getMotivoCita());
       JLabel lblDui = new JLabel("Dui del solicitante: " + solicitudCitas.getDui2());
       JLabel lblFechaSolicitud = new JLabel("Fecha de la solicitud: " + solicitudCitas.getFechaSolicitud());
       
       lblNombreSolicitante.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblNombreSolicitante.setForeground(Color.WHITE);
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
       
       textPanel.add(lblNombreSolicitante);
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
       
       return card;
    }
}