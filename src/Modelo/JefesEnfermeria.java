package Modelo;

import Vista.PanelSolicitudesCitas;
import Vista.jfrPantallaMenuAdminDoctores;
import Vista.jfrPantallaMenuAdminJefesEnfermeria;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JefesEnfermeria {
    private int id_usuario;
    private String dui;
    private String tipo_sangre;
    private String telefono;
    private String correo_electronico;
    private String sexo;
    private String edad;
    private String pathImagenJefe; 
    
    public int getIdUsuario() {
    return id_usuario;
    }
    
    public void setIdUsuario(int id_usuario) {
    this.id_usuario = id_usuario;
    }
    
    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }
    
    public String getTipoSangre() {
        return tipo_sangre;
    }

    public void setTipoSangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getCorreoElectronico() {
        return correo_electronico;
    }

    public void setCorreoElectronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    public String getPathImagenJefe() {
        return pathImagenJefe;
    }

    public void setPathImagenJefe(String pathImagenJefe) {
        this.pathImagenJefe = pathImagenJefe;
    }
    
        public void agregarJefe(jfrPantallaMenuAdminJefesEnfermeria vista) {
        String insertSQL = "INSERT INTO Usuarios (dui, tipo_sangre, telefono, foto_usuario, correo_electronico, contrasena, sexo, edad, id_rol) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 3)";
    
    try (Connection conexion = ClaseConexion.getConexion(); 
            PreparedStatement pstmt = conexion.prepareStatement(insertSQL)) {
        
        String dui = vista.txtDuiJefe.getText();
        String tipoSangre = vista.cbTipoSangre.getSelectedItem().toString();
        String telefono = vista.txtTelefonoJefe.getText();
        String correoElectronico = vista.txtCorreoJefe.getText();
        String contrasena = new String(vista.txtContrasenaJefe.getPassword());
        String contrasenaEncriptada = encriptarContrasena(contrasena);
        String sexo = vista.cbSexoJefe.getSelectedItem().toString();
        
        if (!dui.matches("\\d{8}-\\d{1}")) {
            JOptionPane.showMessageDialog(null, "DUI inválido. Debe tener el formato 00000000-0.");
            return;
        }
        
        if (!telefono.matches("\\d{4}-\\d{4}")) {
            JOptionPane.showMessageDialog(null, "Teléfono inválido. Debe tener el formato 0000-0000.");
            return;
        }
        
        if (!correoElectronico.matches("^[\\w._%+-]+@gmail\\.com$")) {
            JOptionPane.showMessageDialog(null, "Correo inválido. Solo se permiten correos que terminen en @gmail.com.");
            return;
        }
        
        if (dui.isEmpty() || telefono.isEmpty() || correoElectronico.isEmpty() || contrasena.isEmpty() || sexo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
            return;
        }
        
        if (vista.jdcEdadJefe.getDate() == null) {
        JOptionPane.showMessageDialog(null, "Por favor, elige una fecha", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
        if (vista.jdcEdadJefe.getDate() == null) {
        JOptionPane.showMessageDialog(null, "Por favor, llena todas las casillas", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }
        
        java.util.Date fechaNacimientoDate = vista.jdcEdadJefe.getDate();
        LocalDate fechaNacimiento = fechaNacimientoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaActual = LocalDate.now();

        // Calcular la edad
        int edad = Period.between(fechaNacimiento, fechaActual).getYears();
        if (edad < 18) {
            JOptionPane.showMessageDialog(null, "El jefe de enfermería debe ser mayor de 18 años.");
            return;
        }
        
       SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
       sdf.setLenient(false); // Desactivar interpretación flexible de fechas
       String fechaCita;
      try {
        fechaCita = sdf.format(vista.jdcEdadJefe.getDate());
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Fecha inválida. Por favor, usa el formato dd-MM-yyyy.", "Fecha inválida", JOptionPane.WARNING_MESSAGE);
        return;
      }

        // Usa pathImagenJefe para la ruta de la imagen
        String rutaImagen = this.getPathImagenJefe(); 
        
        if (rutaImagen == null || rutaImagen.trim().isEmpty()) {
        JOptionPane.showMessageDialog(vista, "Debe subir una foto para agregar un doctor.");
        return;
         }
        
        pstmt.setString(1, dui);
        pstmt.setString(2, tipoSangre);
        pstmt.setString(3, telefono);
        pstmt.setString(4, rutaImagen);  // Guarda la ruta de la imagen
        pstmt.setString(5, correoElectronico);
        pstmt.setString(6, contrasenaEncriptada);
        pstmt.setString(7, sexo);
        pstmt.setString(8, fechaCita);
        
        // Ejecutar la consulta
        int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "Jefe de enfermería agregado exitosamente.");
            limpiarCampos(vista);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al agregar jefe de enfermería.");
    }
    
    }
    
    private String encriptarContrasena(String contrasena) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(contrasena.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
    
    public void cargarImagen(JLabel profileImageJefe, jfrPantallaMenuAdminJefesEnfermeria vista){
      JFileChooser fileChooser = new JFileChooser();

    fileChooser.setAcceptAllFileFilterUsed(false);
    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif", "bmp"));

    int result = fileChooser.showOpenDialog(vista);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        if (validarArchivoImagen(selectedFile)) {
            ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
            int width = profileImageJefe.getWidth();
            int height = profileImageJefe.getHeight();
            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

            profileImageJefe.setIcon(new ImageIcon(scaledImage));
            profileImageJefe.setText("");  // Elimina cualquier texto en el JLabel

            // Guarda la ruta de la imagen seleccionada
            this.pathImagenJefe = selectedFile.getAbsolutePath();  
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, seleccione un archivo de imagen válido (jpg, jpeg, png, gif, bmp).", "Archivo no válido", JOptionPane.ERROR_MESSAGE);
        }
    }
    }
    
    private boolean validarArchivoImagen(File file){
      String[] extensionesValidas = {"jpg", "jpeg", "png", "gif", "bmp"};
      String nombreArchivo = file.getName().toLowerCase();
      
      for(String ext : extensionesValidas){
        if(nombreArchivo.endsWith("." + ext)){
           return true;
        }
      }
      
      return false;
    }
    
    public void limpiarCampos(jfrPantallaMenuAdminJefesEnfermeria vista) {
        vista.txtDuiJefe.setText("");
        vista.profileImageJefe.setIcon(null);
        vista.txtTelefonoJefe.setText("");
        vista.txtCorreoJefe.setText("");
        vista.txtContrasenaJefe.setText("");
        vista.cbTipoSangre.setSelectedIndex(0);
        vista.cbSexoJefe.setSelectedIndex(0);
        vista.jdcEdadJefe.setDate(null);
        vista.cbTipoSangre.setEnabled(true);
        vista.jdcEdadJefe.setEnabled(true);
        vista.cbSexoJefe.setEnabled(true);
        vista.txtDuiJefe.setEditable(true);
       vista.txtContrasenaJefe.setEditable(true);
       vista.btnCargarImagenJefe.setEnabled(true);
        
        String defaultImageUrl = "https://i.pinimg.com/236x/2a/2e/7f/2a2e7f0f60b750dfb36c15c268d0118d.jpg";
        
     try {
        ImageIcon icon = new ImageIcon(new URL(defaultImageUrl));
        Image img = icon.getImage().getScaledInstance(vista.profileImageJefe.getWidth(), vista.profileImageJefe.getHeight(), Image.SCALE_SMOOTH);
        vista.profileImageJefe.setIcon(new ImageIcon(img));
    } catch (IOException e) {
        e.printStackTrace();
    }  
    }
    
    public List<JefesEnfermeria> obtenerJefes(){
       List<JefesEnfermeria> listaJefes = new ArrayList<>();
       String query = "SELECT * FROM (SELECT id_usuario, dui, tipo_sangre, telefono, foto_usuario, correo_electronico, sexo, edad FROM Usuarios WHERE id_rol = 3 ORDER BY id_usuario DESC) WHERE ROWNUM <= 20";
       
       try(Connection conexion = ClaseConexion.getConexion();
           PreparedStatement stmt = conexion.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){
           
               while(rs.next()){
                 JefesEnfermeria jefes = new JefesEnfermeria();
                 jefes.setIdUsuario(rs.getInt("id_usuario"));
                 jefes.setDui(rs.getString("dui"));
                 jefes.setTipoSangre(rs.getString("tipo_sangre"));
                 jefes.setTelefono(rs.getString("telefono"));
                 jefes.setPathImagenJefe(rs.getString("foto_usuario"));
                 jefes.setSexo(rs.getString("sexo"));
                 jefes.setEdad(rs.getString("edad"));
                 jefes.setCorreoElectronico(rs.getString("correo_electronico"));
                 
                 listaJefes.add(jefes);
                 System.err.println("id_usuario: " + jefes.getIdUsuario());

               }
            }catch(SQLException e){
              e.printStackTrace();
            }
       return listaJefes;
    }
    
    public void cargarCardsJefes(JPanel jpCardsJefes, jfrPantallaMenuAdminJefesEnfermeria vista){
       JPanel panelCards = new JPanel();
       panelCards.setLayout(new GridBagLayout());
       
       Color rgbColor = new Color(70, 76, 92);
       panelCards.setBackground(rgbColor);
       
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.insets = new Insets(10, 10, 10, 10);
       gbc.fill = GridBagConstraints.HORIZONTAL;
       gbc.weightx = 1.0;
       
       List<JefesEnfermeria> jefes = obtenerJefes();
       int row = 0;
       
       for(JefesEnfermeria jefe : jefes){
          JButton card = crearCard(jefe, vista);
          gbc.gridy = row;
          panelCards.add(card, gbc);
        
          gbc.gridy = row + 1;
          panelCards.add(Box.createRigidArea(new Dimension(0, 20))); 
        
          row += 2;
       }
       
       jpCardsJefes.removeAll();
       
       JScrollPane scrollPane = new JScrollPane(panelCards);
       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       
       jpCardsJefes.setLayout(new BorderLayout());
       jpCardsJefes.add(scrollPane, BorderLayout.CENTER);
       jpCardsJefes.setBackground(rgbColor);
       
       jpCardsJefes.revalidate();
       jpCardsJefes.repaint();
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
    
    private JButton crearCard(JefesEnfermeria jefesEnfermeria, jfrPantallaMenuAdminJefesEnfermeria vista){
      JButton card = new JButton();
       card.setLayout(new BorderLayout(10, 10));
       card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       
       Color rgbColor = new Color(41, 72, 152);
       card.setBackground(rgbColor);
       
       ImageIcon iconoJefes = cargarImagen(jefesEnfermeria.getPathImagenJefe());
       Image img = iconoJefes.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
       JLabel lblFoto = new JLabel(new ImageIcon(img));
       
       JPanel textPanel = new JPanel();
       textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
       textPanel.setBackground(rgbColor);
       
       JLabel lblDui = new JLabel("DUI: " + jefesEnfermeria.getDui());
       JLabel lblTipoSangre = new JLabel("Tipo de sangre: " + jefesEnfermeria.getTipoSangre());
       JLabel lblTelefono = new JLabel("Teléfono" + jefesEnfermeria.getTelefono());
       JLabel lblCorreo = new JLabel("Correo electrónico: " + jefesEnfermeria.getCorreoElectronico());
       JLabel lblSexo = new JLabel("Sexo: " + jefesEnfermeria.getSexo());
       JLabel lblEdad = new JLabel("Edad: " + jefesEnfermeria.getEdad());
       
       lblDui.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblDui.setForeground(Color.WHITE);
       lblTipoSangre.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblTipoSangre.setForeground(Color.WHITE);
       lblTelefono.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblTelefono.setForeground(Color.WHITE);
       lblCorreo.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblCorreo.setForeground(Color.WHITE);
       lblSexo.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblSexo.setForeground(Color.WHITE);
       lblEdad.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblEdad.setForeground(Color.WHITE);
       
       textPanel.add(lblDui);
       textPanel.add(lblTipoSangre);
       textPanel.add(lblTelefono);
       textPanel.add(lblCorreo);
       textPanel.add(lblSexo);
       textPanel.add(lblEdad);
       
       card.add(lblFoto, BorderLayout.WEST);
       card.add(textPanel, BorderLayout.CENTER);
       
       card.setPreferredSize(new Dimension(300, 120));
       card.setMaximumSize(new Dimension(300, 120));
       card.setMinimumSize(new Dimension(00, 120));
       card.setFocusable(true);
       
       card.addActionListener(new ActionListener(){
        @Override
       public void actionPerformed(ActionEvent e){
           System.out.println("Card clicked");
           actualizarTextFieldsConDatos(jefesEnfermeria, vista);
    } 
    });
       
       return card;
    }
    
    private void actualizarTextFieldsConDatos(JefesEnfermeria jefesEnfermeria, jfrPantallaMenuAdminJefesEnfermeria vista){
        
      setIdUsuario(jefesEnfermeria.getIdUsuario());
        
      vista.txtDuiJefe.setText(jefesEnfermeria.getDui());
      vista.txtTelefonoJefe.setText(jefesEnfermeria.getTelefono());
      vista.txtCorreoJefe.setText(jefesEnfermeria.getCorreoElectronico());
      
      vista.txtDuiJefe.setEditable(false);
      vista.txtContrasenaJefe.setEditable(false);
      vista.cbTipoSangre.setEnabled(false);
      vista.jdcEdadJefe.setEnabled(false);
      vista.cbSexoJefe.setEnabled(false);
      vista.btnCargarImagenJefe.setEnabled(false);
      
      String fechaString = jefesEnfermeria.getEdad();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    try {
        // Convertir la cadena a java.util.Date
        java.util.Date fechaDate = sdf.parse(fechaString);
        
        // Convertir java.util.Date a java.sql.Date
        java.sql.Date fechaSqlDate = new java.sql.Date(fechaDate.getTime());
        vista.jdcEdadJefe.setDate(fechaSqlDate);
    } catch (ParseException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(vista, "Error al convertir la fecha: " + e.getMessage(), "Error de fecha", JOptionPane.ERROR_MESSAGE);
    }
      
      JComboBox<String> cbTipoSangreJefe = vista.cbTipoSangre;
      for(int i = 0; i < cbTipoSangreJefe.getItemCount(); i++){
        if(cbTipoSangreJefe.getItemAt(i).equals(jefesEnfermeria.getTipoSangre())){
          cbTipoSangreJefe.setSelectedIndex(i);
          break;
        }
      }
      
      JComboBox<String> cbSexoJefe = vista.cbSexoJefe;
      for(int i = 0; i < cbSexoJefe.getItemCount(); i++){
        if(cbSexoJefe.getItemAt(i).equals(jefesEnfermeria.getSexo())){
          cbSexoJefe.setSelectedIndex(i);
          break;
        }
      }
      
      ImageIcon iconoFoto = cargarImagen(jefesEnfermeria.getPathImagenJefe());
      Image imgFoto = iconoFoto.getImage().getScaledInstance(vista.profileImageJefe.getWidth(), vista.profileImageJefe.getHeight(), Image.SCALE_SMOOTH);
      vista.profileImageJefe.setIcon(new ImageIcon(imgFoto));
    }
    
    public boolean actualizarJefe(int id_usuario, String correo, String telefono, jfrPantallaMenuAdminJefesEnfermeria vista){
      Connection conexion = ClaseConexion.getConexion();
      String query = "UPDATE Usuarios set correo_electronico = ?, telefono = ? WHERE id_usuario = ?";
      
      try(PreparedStatement ps = conexion.prepareStatement(query)){
         ps.setString(1, correo);
         ps.setString(2, telefono);
         ps.setInt(3, id_usuario);
         
         return ps.executeUpdate() > 0;
      }catch(SQLException e){
        e.printStackTrace();
        return false;
      }
    }
    
    public boolean eliminarJefe(int id_usuario, jfrPantallaMenuAdminJefesEnfermeria vista){
      Connection conexion = ClaseConexion.getConexion();
      String query = "DELETE FROM Usuarios WHERE id_usuario = ?";
      
      try(PreparedStatement ps = conexion.prepareStatement(query)){
        ps.setInt(1, id_usuario);
        return ps.executeUpdate() > 0;
      }catch(SQLIntegrityConstraintViolationException e){
         JOptionPane.showMessageDialog(vista, "No se pudo eliminar al doctor debido a que tiene un historial", "Error", JOptionPane.ERROR_MESSAGE);
         return false;
      }catch(SQLException e){
        e.printStackTrace();
        return false;
      }
    }
}