package Modelo;

import Vista.PanelChatDoctoresSinDesplegar;
import Vista.PanelMensajesChat;
import Vista.jfrPantallaLogin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.SwingConstants;

public class Usuarios {
    
    @Override
public String toString() {
    return "Correo Electrónico: " + correo_electronico + ", Foto Usuario: " + foto_usuario;
}

    private int id_usuario;
    private String foto_usuario;
    private String correo_electronico;
    private static int idDoctor;
    private String mensaje;
    private String tipoRemitente;
    private String tipoDestinatario;
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getTipoRemitente() {
        return tipoRemitente;
    }

    public void setTipoRemitente(String tipoRemitente) {
        this.tipoRemitente = tipoRemitente;
    }
    
    public String getTipoDestinatario() {
        return tipoDestinatario;
    }

    public void setTipoDestinatario(String tipoDestinatario) {
        this.tipoDestinatario = tipoDestinatario;
    }

    public static int getIdDoctor() {
        return idDoctor;
    }

    public static void setIdDoctor(int idDoctor) {
        Usuarios.idDoctor = idDoctor;
    }
    
     public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
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
       String query = "SELECT DISTINCT U.id_usuario, U.foto_usuario, U.nombre_usuario FROM Usuarios U JOIN MensajesChat M ON U.id_usuario = M.id_remitente WHERE M.id_destinatario = ? AND M.tipo_remitente = 'PACIENTE'";
       
       try(Connection conexion = ClaseConexion.getConexion();
           PreparedStatement stmt = conexion.prepareStatement(query)){
               
          stmt.setInt(1, getIdDoctor());
             
             try(ResultSet rs = stmt.executeQuery()){
           
               while(rs.next()){
                 Usuarios pacientes = new Usuarios();
                 pacientes.setIdUsuario(rs.getInt("id_usuario"));
                 pacientes.setFoto_Usuario2(rs.getString("foto_usuario"));
                 pacientes.setCorreo_Electronico2(rs.getString("nombre_usuario"));
                 listaPacientes.add(pacientes);
               }
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
        ActualizarCampos(pacientes, panelMensajes);
        
        JPanel jpChatsBienvenida = objMenu.jpChatsBienvenida; 
        jpChatsBienvenida.removeAll();
        
        jpChatsBienvenida.add(panelMensajes);
        
        jpChatsBienvenida.revalidate();
        jpChatsBienvenida.repaint();
        
        // Call cargarMensajes here
        cargarMensajes(panelMensajes.jpCardsMensajes);
        
        panelMensajes.btnEnviarMensaje.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.err.println("Clicked");
                
                String textoMensaje = panelMensajes.txtMensaje.getText();
                if (textoMensaje == null || textoMensaje.trim().isEmpty()) {
                    System.out.println("El mensaje no puede estar vacío");
                    return;
                }
                
                // Asumiendo que 'pacientes' es un objeto que representa al destinatario
                Usuarios mensaje = new Usuarios();
                mensaje.setIdUsuario(getIdUsuario());  // El destinatario es el paciente
                mensaje.setMensaje(textoMensaje);  // El mensaje es el texto del TextField
                
                // Insertar el mensaje en la base de datos
                insertarMensaje(mensaje);
                
                // Actualizar el panel de mensajes con el nuevo mensaje
                actualizarPanelMensajes(getIdDoctor(), getIdUsuario(), textoMensaje, "DOCTOR", "PACIENTE", panelMensajes.jpCardsMensajes);
                
                // Limpiar el campo de texto después de enviar
                panelMensajes.txtMensaje.setText("");
            }
        });
    }
});
       
       return card;
    } 

    public boolean validarCorreo(String correo){
       String regex = "^[\\w._%+-]+@(gmail\\.com|isss\\.gob\\.sv)$";
       return correo.matches(regex);
    }
    
    private void ActualizarCampos(Usuarios usuario, PanelMensajesChat panelMensajes){
        setIdUsuario(usuario.getIdUsuario());
        panelMensajes.lblNombrePaciente.setText(usuario.getCorreo_Electronico2());
        
        ImageIcon iconoFoto = cargarImagen(usuario.getFoto_usuario2());
        Image image = iconoFoto.getImage();

        int width = panelMensajes.jlFotoPaciente.getWidth();
        int height = panelMensajes.jlFotoPaciente.getHeight();

        if (width == 0 || height == 0) {
          width = 60;
          height = 50;
        }

        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        double aspectRatio = (double) imageWidth / imageHeight;

        if (width / height > aspectRatio) {
          width = (int) (height * aspectRatio);
        } else {
          height = (int) (width / aspectRatio);
        }

        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        panelMensajes.jlFotoPaciente.setIcon(new ImageIcon(scaledImage));
        
        System.err.println("ID: " + getIdUsuario());
        System.err.println("ID DEL DOCTOR: " + getIdDoctor());
    }
    
    public void insertarMensaje(Usuarios mensaje){
      
      if (mensaje.getMensaje() == null || mensaje.getMensaje().trim().isEmpty()) {
        System.out.println("El mensaje no puede estar vacío");
        return;  // Evita la inserción si el mensaje es nulo o vacío
    }
        
      String query = "INSERT INTO MensajesChat (id_remitente, tipo_remitente, id_destinatario, tipo_destinatario, mensaje) VALUES (?, 'DOCTOR', ?, 'PACIENTE', ?)";
      
      try(Connection conexion = ClaseConexion.getConexion();
              PreparedStatement stmt = conexion.prepareStatement(query)){
          stmt.setInt(1, mensaje.getIdUsuario());
          stmt.setInt(2, getIdDoctor());
          stmt.setString(3, mensaje.getMensaje());
          
          stmt.executeUpdate();
      }catch(SQLException e){
        e.printStackTrace();
      }
    }
    
    private void actualizarPanelMensajes(int idRemitente, int idDestinatario, String mensaje, String tipoRemitente, String tipoDestinatario, JPanel jpCardsMensajes){
        
    jpCardsMensajes.setLayout(new BoxLayout(jpCardsMensajes, BoxLayout.Y_AXIS));
    
    // Crear un botón que contendrá el mensaje
    JButton btnMensaje = new JButton(mensaje);
    btnMensaje.setFocusPainted(false);  // Evitar el borde de selección de los botones
    
    // Establecer colores y alineación según el tipo de remitente
    if (tipoRemitente.equals("DOCTOR")) {
        btnMensaje.setBackground(Color.BLACK);  // Azul para el doctor
        btnMensaje.setForeground(Color.WHITE);             // Texto blanco
        btnMensaje.setHorizontalAlignment(SwingConstants.LEFT); // Alineación a la derecha
    } else {
        btnMensaje.setBackground(Color.WHITE);   // Gris oscuro para el paciente
        btnMensaje.setForeground(Color.BLACK);  
        btnMensaje.setHorizontalAlignment(SwingConstants.RIGHT);  // Alineación del texto a la derecha
        btnMensaje.setAlignmentX(Component.RIGHT_ALIGNMENT);// Texto blanco
          // Alineación a la izquierda
    }
    // Ajustar tamaño del botón
    btnMensaje.setPreferredSize(new Dimension(350, 50));  // Tamaño del botón
    btnMensaje.setMaximumSize(new Dimension(350, 50));    // Evitar que crezca más
    btnMensaje.setMinimumSize(new Dimension(350, 50));    // Evitar que sea más pequeño
    // Añadir el botón al panel de mensajes
    jpCardsMensajes.add(btnMensaje);
    
    // Espacio entre mensajes
    jpCardsMensajes.add(Box.createRigidArea(new Dimension(0, 10)));
    // Refrescar el panel
    jpCardsMensajes.revalidate();
    jpCardsMensajes.repaint();
    }
    
    public void cargarMensajes(JPanel jpCardsMensajes){
       String query = "SELECT * FROM MensajesChat WHERE (id_remitente = ? AND id_destinatario = ?) OR (id_remitente = ? AND id_destinatario = ?) ORDER BY id_mensaje ASC";
       
       try(Connection conexion = ClaseConexion.getConexion();
               PreparedStatement stmt = conexion.prepareStatement(query)){
          stmt.setInt(1, getIdDoctor());
          stmt.setInt(2, getIdUsuario());
          stmt.setInt(3, getIdUsuario());
          stmt.setInt(4, getIdDoctor());
          
          ResultSet rs = stmt.executeQuery();
               
          while(rs.next()){
              
            int idRemitente = rs.getInt("id_remitente");
            int idDestinatario = rs.getInt("id_destinatario");
            String mensaje2 = rs.getString("mensaje");
            String tipoRemitente2 = rs.getString("tipo_remitente");
            String tipoDestinatario2 = rs.getString("tipo_destinatario");
           
            actualizarPanelMensajes(idRemitente, idDestinatario, mensaje2, tipoRemitente2, tipoDestinatario2, jpCardsMensajes);
          }
          
          jpCardsMensajes.revalidate();
          jpCardsMensajes.repaint();
        
       }catch(SQLException e){
         e.printStackTrace();
       }
    }
    
    private boolean passwordVisible = false;

    public void togglePasswordVisibility(jfrPantallaLogin vista) {
        // Obtener las dimensiones del botón
        int width = vista.btnVerContrasena.getWidth();
        int height = vista.btnVerContrasena.getHeight();

        if (passwordVisible) {
            // Si la contraseña está visible, ocultarla
            vista.txtContrasena.setEchoChar('•'); // Mostrar los puntos negros (ocultar la contraseña)

            // Cambiar el icono a "no ver contraseña"
            ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/no_ver_password.png"));
            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            vista.btnVerContrasena.setIcon(new ImageIcon(scaledImage));
        } else {
            // Si la contraseña está oculta, mostrarla
            vista.txtContrasena.setEchoChar((char) 0); // Mostrar el texto de la contraseña

            // Cambiar el icono a "ver contraseña"
            ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/ver_password.png"));
            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            vista.btnVerContrasena.setIcon(new ImageIcon(scaledImage));
        }

        // Cambiar el estado de passwordVisible
        passwordVisible = !passwordVisible;
    }
}