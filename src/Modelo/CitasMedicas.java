package Modelo;

import Vista.jfrPantallaMenuDoctor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CitasMedicas {
    private String fecha_cita;
    private String hora_cita;
    private String foto_usuario;
    private String solicitante;
    private String doctor;
    
    public String getFecha_cita() {
      return fecha_cita;
    }
    
    public void setFecha_cita(String fecha_cita) {
      this.fecha_cita = fecha_cita;
    }
    
    public String getHora_cita(){
      return hora_cita;
    }
    
    public void setHora_cita(String hora_cita){
      this.hora_cita = hora_cita;
    }
    
    public String getFoto_usuario(){
      return foto_usuario;
    }
    
    public void setFoto_usuario(String foto_usuario){
      this.foto_usuario = foto_usuario;
    }
    
    public String getSolicitante(){
      return solicitante;
    }
    
    public void setSolicitante(String solicitante){
      this.solicitante = solicitante;
    }
    
    public String getDoctor(){
      return doctor;
    }
    
    public void setDoctor(String doctor){
      this.doctor = doctor;
    }
    
    public List<CitasMedicas> obtenerCitasMedicas(){
      List<CitasMedicas> listaCitasMedicas = new ArrayList<>();
      String query = "SELECT cm.id_cita, cm.fecha_cita, cm.hora_cita, u.foto_usuario, u.correo_electronico AS solicitante, d.nombre_doctor AS doctor FROM CitasMedicas cm INNER JOIN Usuarios u ON cm.id_usuario = u.id_usuario INNER JOIN Doctores d ON cm.id_doctor = d.id_doctor";
      
      try(Connection conexion = ClaseConexion.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){
            
          while(rs.next()){
            CitasMedicas citasAgendadas = new CitasMedicas();
            citasAgendadas.setFecha_cita(rs.getString("fecha_cita"));
            citasAgendadas.setHora_cita(rs.getString("hora_cita"));
            citasAgendadas.setFoto_usuario(rs.getString("foto_usuario"));
            citasAgendadas.setSolicitante(rs.getString("solicitante"));
            citasAgendadas.setDoctor(rs.getString("doctor"));
            listaCitasMedicas.add(citasAgendadas);
          }
      }catch(SQLException e){
        e.printStackTrace();
      }
      
      return listaCitasMedicas;
    }
    
    public void cargarCardsCitasMedicas(JPanel jpCardsCitasAgendadas, jfrPantallaMenuDoctor vista){
       JPanel panelCards = new JPanel();
       panelCards.setLayout(new GridBagLayout());
       
       Color rgbColor = new Color(70, 76, 92);
       panelCards.setBackground(rgbColor);
    
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.insets = new Insets(10, 10, 10, 10);
       gbc.fill = GridBagConstraints.HORIZONTAL;
       gbc.weightx = 1.0;
       
       List<CitasMedicas> citasAgendadas = obtenerCitasMedicas();
       int row = 0;
       
       for(CitasMedicas citaAgendada : citasAgendadas){
          JButton card = crearCard(citaAgendada, vista);
          gbc.gridy = row;
          panelCards.add(card, gbc);
        
          gbc.gridy = row + 1;
          panelCards.add(Box.createRigidArea(new Dimension(0, 20))); 
        
          row += 2;
       }
       
       jpCardsCitasAgendadas.removeAll();
       
       JScrollPane scrollPane = new JScrollPane(panelCards);
       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       
       jpCardsCitasAgendadas.setLayout(new BorderLayout());
       jpCardsCitasAgendadas.add(scrollPane, BorderLayout.CENTER);
       jpCardsCitasAgendadas.setBackground(rgbColor);
       
       jpCardsCitasAgendadas.revalidate();
       jpCardsCitasAgendadas.repaint();
    }
    
    private ImageIcon cargarImagen(String path){
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
    
    private JButton crearCard(CitasMedicas citasAgendadas, jfrPantallaMenuDoctor vista){
       JButton card = new JButton();
       card.setLayout(new BorderLayout(10, 10));
       card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       
       Color rgbColor = new Color(41, 72, 152);
       card.setBackground(rgbColor);
       
       ImageIcon iconoCitasMedicas = cargarImagen(citasAgendadas.getFoto_usuario());
       Image img = iconoCitasMedicas.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
       JLabel lblFoto = new JLabel(new ImageIcon(img));
       
       JPanel textPanel = new JPanel();
       textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
       textPanel.setBackground(rgbColor);
       
       JLabel lblFechaCita = new JLabel("Fecha de la cita: " + citasAgendadas.getFecha_cita());
       JLabel lblHoraCita = new JLabel("Hora de la cita: " + citasAgendadas.getHora_cita());
       JLabel lblSolicitante = new JLabel("Solicitante: " + citasAgendadas.getSolicitante());
       JLabel lblDoctor = new JLabel("Doctor designado: " + citasAgendadas.getDoctor());
       
       lblFechaCita.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblFechaCita.setForeground(Color.WHITE);
       lblHoraCita.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblHoraCita.setForeground(Color.WHITE);
       lblSolicitante.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblSolicitante.setForeground(Color.WHITE);
       lblDoctor.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblDoctor.setForeground(Color.WHITE);
       
       textPanel.add(lblFechaCita);
       textPanel.add(lblHoraCita);
       textPanel.add(lblSolicitante);
       textPanel.add(lblDoctor);
       
       card.add(lblFoto, BorderLayout.WEST);
       card.add(textPanel, BorderLayout.CENTER);
       
       card.setPreferredSize(new Dimension(350, 100));
       card.setMaximumSize(new Dimension(350, 100));
       card.setMinimumSize(new Dimension(350, 100));
       card.setFocusable(true);
       
       return card;
    }
}
