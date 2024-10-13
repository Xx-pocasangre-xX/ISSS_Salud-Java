package Modelo;

import Vista.PanelBienvenidaChat;
import Vista.PanelChatDoctoresSinDesplegar;
import Vista.PanelMensajesChat;
import Vista.jfrPantallaMenuDoctor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

public class Usuarios {
    
    @Override
public String toString() {
    return "Correo Electrónico: " + correo_electronico + ", Foto Usuario: " + foto_usuario;
}
    
    private String foto_usuario;
    private String correo_electronico;
    private static int idDoctor;

    public static int getIdDoctor() {
        return idDoctor;
    }

    public static void setIdDoctor(int idDoctor) {
        Usuarios.idDoctor = idDoctor;
    }
    
    public String getFoto_usuario2() {
        
       return foto_usuario;
    
    }

    public void setFoto_Usuario2(String foto_usuario) {
        
       this.foto_usuario = foto_usuario;
    
    }
    
    public String getCorreo_Electronico2() {
        
       return correo_electronico;
    
    }

    public void setCorreo_Electronico2(String correo_electronico) {
        
       this.correo_electronico = correo_electronico;
    
    }
    
    public int validarCredenciales(String correo, String contrasena){
       String query = "SELECT id_rol FROM Usuarios WHERE correo_electronico = ? AND contrasena = ?";
       try(Connection conexion = ClaseConexion.getConexion();
          PreparedStatement pst = conexion.prepareStatement(query)){
         pst.setString(1, correo);
         pst.setString(2, contrasena);
         try(ResultSet rs = pst.executeQuery()){
           if(rs.next()){
              return rs.getInt("id_rol");
           }
         }
       }catch(SQLException e){
         e.printStackTrace();
       }
       return -1;
       }
    
    public int obtenerIdDoctor(String correo, String contrasena) {
    String query = "SELECT id_doctor FROM Doctores WHERE correo_doctor = ? AND contrasena_doctor = ?";
    try (Connection conexion = ClaseConexion.getConexion();
         PreparedStatement pst = conexion.prepareStatement(query)) {
        pst.setString(1, correo);
        pst.setString(2, contrasena);
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id_doctor");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error en la consulta SQL: " + e.getMessage());
        e.printStackTrace();
    }
    return -1;  // Retorna -1 si no se encuentra el doctor
}
    
    public String encryptPassword(String password){
      try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash){
          sb.append(String.format("%02x", b));
        }
        return sb.toString();
      }catch(NoSuchAlgorithmException ex){
        throw new RuntimeException("Error al encriptar la contrasena", ex);
      }
    }
    
    public boolean existeCorreo(String correo){
      String query = "SELECT COUNT(*) FROM Usuarios WHERE correo_electronico = ?";
      try(Connection conexion = ClaseConexion.getConexion();
              PreparedStatement pst = conexion.prepareStatement(query)){
         pst.setString(1, correo);
         try(ResultSet rs = pst.executeQuery()){
           if(rs.next()){
             return rs.getInt(1) > 0;
           }
         }
      }catch(SQLException e){
        e.printStackTrace();
      }
      return false;
    }
    
    public boolean actualizarContrasena(String correo, String nuevaContrasenaEncriptada){
       String query = "UPDATE Usuarios SET contrasena = ? WHERE correo_electronico = ?";
       try(Connection conexion = ClaseConexion.getConexion();
               PreparedStatement pst = conexion.prepareStatement(query)){
         pst.setString(1, nuevaContrasenaEncriptada);
         pst.setString(2, correo);
         int filasAfectadas = pst.executeUpdate();
         
         return filasAfectadas > 0;
       }catch(SQLException e){
         e.printStackTrace();
       }
       return false;
    }
    
    public List<Usuarios> obtenerPacientes(){
       List<Usuarios> listaPacientes = new ArrayList<>();
       String query = "SELECT foto_usuario, correo_electronico from Usuarios WHERE id_rol = 2";
       
       try(Connection conexion = ClaseConexion.getConexion();
           PreparedStatement stmt = conexion.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){
           
               while(rs.next()){
                 Usuarios pacientes = new Usuarios();
                 pacientes.setFoto_Usuario2(rs.getString("foto_usuario"));
                 pacientes.setCorreo_Electronico2(rs.getString("correo_electronico"));
                 listaPacientes.add(pacientes);
                 System.err.println("Esta es la lista de pacientes:" + listaPacientes);
               }
            }catch(SQLException e){
              e.printStackTrace();
            }
       return listaPacientes;
    }
    
    public void cargarCardsPacientes(JPanel jPanelChatsDoctores, PanelChatDoctoresSinDesplegar objMenu){
       JPanel panelCards = new JPanel();
       panelCards.setLayout(new GridBagLayout());
       
       Color rgbColor = new Color(70, 76, 92);
       panelCards.setBackground(rgbColor);
       
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.insets = new Insets(10, 10, 10, 10);
       gbc.fill = GridBagConstraints.HORIZONTAL;
       gbc.weightx = 1.0;
       
       List<Usuarios> pacientes = obtenerPacientes();
       int row = 0;
       
       for(Usuarios paciente : pacientes){
          JButton card = crearCard(paciente, objMenu);
          gbc.gridy = row;
          panelCards.add(card, gbc);
        
          gbc.gridy = row + 1;
          panelCards.add(Box.createRigidArea(new Dimension(0, 20))); 
        
          row += 2;
       }
       
       jPanelChatsDoctores.removeAll();
       
       JScrollPane scrollPane = new JScrollPane(panelCards);
       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       
       jPanelChatsDoctores.setLayout(new BorderLayout());
       jPanelChatsDoctores.add(scrollPane, BorderLayout.CENTER);
       jPanelChatsDoctores.setBackground(rgbColor);
       
       jPanelChatsDoctores.revalidate();
       jPanelChatsDoctores.repaint();
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
    
    private JButton crearCard(Usuarios pacientes, PanelChatDoctoresSinDesplegar objMenu){
      JButton card = new JButton();
       card.setLayout(new BorderLayout(10, 10));
       card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       
       Color rgbColor = new Color(41, 72, 152);
       card.setBackground(rgbColor);
       
       ImageIcon iconoPacientes = cargarImagen(pacientes.getFoto_usuario2());
       Image img = iconoPacientes.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
       JLabel lblFoto = new JLabel(new ImageIcon(img));
       
       JPanel textPanel = new JPanel();
       textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
       textPanel.setBackground(rgbColor);
       
       JLabel lblNombrePaciente = new JLabel(pacientes.getCorreo_Electronico2());
       
       lblNombrePaciente.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblNombrePaciente.setForeground(Color.WHITE);
       
       textPanel.add(lblNombrePaciente);
       
       card.add(lblFoto, BorderLayout.WEST);
       card.add(textPanel, BorderLayout.CENTER);
       
       card.setPreferredSize(new Dimension(300, 80));
       card.setMaximumSize(new Dimension(300, 80));
       card.setMinimumSize(new Dimension(300, 80));
       card.setFocusable(true);
       
       card.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
             PanelMensajesChat panelMensajes = new PanelMensajesChat();
             System.err.println("Clicked");
      
             JPanel jpChatsBienvenida = objMenu.jpChatsBienvenida; 

             jpChatsBienvenida.removeAll();
 

             jpChatsBienvenida.add(panelMensajes);

             jpChatsBienvenida.revalidate();
             jpChatsBienvenida.repaint();
         }
       });
       
       return card;
    }
    
    public boolean validarCorreo(String correo){
       String regex = "^[\\w._%+-]+@(gmail\\.com|isss\\.gob\\.sv)$";
       return correo.matches(regex);
    }
}
