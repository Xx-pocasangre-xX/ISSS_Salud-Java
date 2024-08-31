package Modelo;

import Vista.jfrPantallaMenuAdmin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Doctores {
    
    private String foto;
    private String correo;
    private String nombre;
    private String especialidad;
    private String unidadMedica;
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public String getUnidadMedica(){
       return unidadMedica;
    }
    
    public void setUnidadMedica(String unidadMedica){
       this.unidadMedica = unidadMedica;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public boolean agregarDoctor(String correo, String contrasena, String nombre, String foto, int idEspecialidad, int idUnidad){
       Connection conexion = ClaseConexion.getConexion();
       String query = "INSERT INTO Doctores(correo_doctor, contrasena_doctor, nombre_doctor, foto_doctor, id_especialidad, id_unidad) VALUES(?,?,?,?,?,?)";
       
       try(PreparedStatement ps = conexion.prepareStatement(query)){
          ps.setString(1, correo);
          ps.setString(2, encriptarContrasena(contrasena));
          ps.setString(3, nombre);
          ps.setString(4, foto);
          ps.setInt(5, idEspecialidad);
          ps.setInt(6, idUnidad);
          
          return ps.executeUpdate() > 0;
       }catch(SQLException e){
         e.printStackTrace();
         return false;
       }
    }
    
    private String encriptarContrasena(String contrasena){
      try{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(contrasena.getBytes());
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for(byte b: hash){
          String hex = Integer.toHexString(0xff & b);
          if(hex.length() == 1){
            hexString.append('0');
          }
          hexString.append(hex);
        }
        return hexString.toString();
      }catch(NoSuchAlgorithmException e){
        throw new RuntimeException(e);
      }
    }
    
    public void cargarImagen(JLabel profileImage, jfrPantallaMenuAdmin vista){
      JFileChooser fileChooser = new JFileChooser();
      int result = fileChooser.showOpenDialog(vista);
      if(result == JFileChooser.APPROVE_OPTION){
        File selectedFile = fileChooser.getSelectedFile();
        
        ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
        
        int width = vista.profileImage.getWidth();
        int height = vista.profileImage.getHeight();
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        vista.profileImage.setIcon(new ImageIcon(scaledImage));
        vista.profileImage.setText(selectedFile.getAbsolutePath());
      }
    }
    
    public void agregarDoctor(JTextField txtCorreoDoctor, JPasswordField txtContrasenaDoctor, JTextField txtNombreDoctor, JLabel profileImage, JComboBox cbEspecialidadesMedicas, JComboBox cbUnidadesMedicas, jfrPantallaMenuAdmin vista){
      String correo = txtCorreoDoctor.getText();
      String contrasena = new String(txtContrasenaDoctor.getPassword());
      String nombre = txtNombreDoctor.getText();
      String foto = profileImage.getText();
      int idEspecialidad = cbEspecialidadesMedicas.getSelectedIndex() + 1;
      int idUnidad = cbUnidadesMedicas.getSelectedIndex() + 1;
      
      if(agregarDoctor(correo, contrasena, nombre, foto, idEspecialidad, idUnidad)){
        JOptionPane.showMessageDialog(vista, "Doctor agregado exitosamente.");
        limpiarCampos(txtCorreoDoctor, txtContrasenaDoctor, txtNombreDoctor, cbEspecialidadesMedicas, cbUnidadesMedicas);
      }else{
        JOptionPane.showMessageDialog(vista, "Error al agregar el doctor");
      }
    }
    
     public void limpiarCampos(JTextField txtCorreoDoctor, JPasswordField txtContrasenaDoctor, JTextField txtNombreDoctor, JComboBox cbEspecialidadesMedicas, JComboBox cbUnidadesMedicas) {
        txtCorreoDoctor.setText("");
        txtContrasenaDoctor.setText("");
        txtNombreDoctor.setText("");
        cbEspecialidadesMedicas.setSelectedIndex(0);
        cbUnidadesMedicas.setSelectedIndex(0);
    }
     
    public List <Doctores> obtenerDoctores() {
        List<Doctores> listaDoctores = new ArrayList<>();
        String sql = "SELECT d.id_doctor, d.foto_doctor, d.correo_doctor, d.nombre_doctor, ed.especialidad_doctor AS Especialidad_Medica, um.nombre_unidad AS Unidad_Medica FROM Doctores d INNER JOIN EspecialidadDoctores ed ON d.id_especialidad = ed.id_especialidad INNER JOIN UnidadesMedicas um ON d.id_unidad = um.id_unidad";

        try (Connection conexion = ClaseConexion.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Doctores doctor = new Doctores();
                doctor.setFoto(rs.getString("foto_doctor"));
                doctor.setCorreo(rs.getString("correo_doctor"));
                doctor.setNombre(rs.getString("nombre_doctor"));
                doctor.setEspecialidad(rs.getString("Especialidad_Medica"));
                doctor.setUnidadMedica(rs.getString("Unidad_Medica"));
                System.out.println("Doctor: " + getNombre() + ", Correo: " + getCorreo());
                listaDoctores.add(doctor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaDoctores;
    }
    
    public void cargarCardsDoctores(JPanel jpCardsDoctores, jfrPantallaMenuAdmin vista) { 
    JPanel panelCards = new JPanel();
    panelCards.setLayout(new GridBagLayout()); 
    
    Color rgbColor = new Color(70, 76, 92);
    panelCards.setBackground(rgbColor);
    
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 1.0;
        
    List<Doctores> doctores = obtenerDoctores(); 
    int row = 0;

    for (Doctores doctor : doctores) {
        JButton card = crearCard(doctor, vista);
        gbc.gridy = row;
        panelCards.add(card, gbc);
        
        gbc.gridy = row + 1;
        panelCards.add(Box.createRigidArea(new Dimension(0, 20))); 
        
        row += 2;
    }
    
    jpCardsDoctores.removeAll();
    
    JScrollPane scrollPane = new JScrollPane(panelCards);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    jpCardsDoctores.setLayout(new BorderLayout());
    jpCardsDoctores.add(scrollPane, BorderLayout.CENTER);
    jpCardsDoctores.setBackground(rgbColor);
    
    jpCardsDoctores.revalidate();
    jpCardsDoctores.repaint();
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
    
    private JButton crearCard(Doctores doctor, jfrPantallaMenuAdmin vista) {
    JButton card = new JButton();
    card.setLayout(new BorderLayout(10, 10));
    card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
    Color rgbColor = new Color(41, 72, 152);
    card.setBackground(rgbColor);
    
    ImageIcon iconoDoctor = cargarImagen(doctor.getFoto());
    Image img = iconoDoctor.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
    JLabel lblFoto = new JLabel(new ImageIcon(img));
    
    JPanel textPanel = new JPanel();
    textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
    textPanel.setBackground(rgbColor);

    JLabel lblNombre = new JLabel("Dr(a): " + doctor.getNombre());
    JLabel lblCorreo = new JLabel("Correo: " + doctor.getCorreo());
    JLabel lblEspecialidad = new JLabel("Especialidad: " + doctor.getEspecialidad());
    JLabel lblUnidadMedica = new JLabel("Unidad médica: " + doctor.getUnidadMedica());
    
    lblNombre.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    lblNombre.setForeground(Color.WHITE);
    lblCorreo.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    lblCorreo.setForeground(Color.WHITE);
    lblEspecialidad.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    lblEspecialidad.setForeground(Color.WHITE);
    lblUnidadMedica.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    lblUnidadMedica.setForeground(Color.WHITE);
    
    textPanel.add(lblNombre);
    textPanel.add(lblCorreo);
    textPanel.add(lblEspecialidad);
    textPanel.add(lblUnidadMedica);
    
    card.add(lblFoto, BorderLayout.WEST);
    card.add(textPanel, BorderLayout.CENTER);
    
    card.setPreferredSize(new Dimension(350, 100));
    card.setMaximumSize(new Dimension(350, 100));
    card.setMinimumSize(new Dimension(350, 100));
    card.setFocusable(true);
    
    card.addActionListener(new ActionListener(){
        @Override
       public void actionPerformed(ActionEvent e){
           System.out.println("Card clicked: " + doctor.getNombre());
           actualizarCampos(doctor, vista);
    } 
    });
    
    return card;
}
    
    private void actualizarCampos(Doctores doctor, jfrPantallaMenuAdmin vista){
      vista.txtNombreDoctor.setText(doctor.getNombre());
      vista.txtCorreoDoctor.setText(doctor.getCorreo());
      
      JComboBox<String> cbEspecialidades = vista.cbEspecialidadesMedicas;
      for(int i = 0; i < cbEspecialidades.getItemCount(); i++){
        if(cbEspecialidades.getItemAt(i).equals(doctor.getEspecialidad())){
          cbEspecialidades.setSelectedIndex(i);
          break;
        }
      }
      
      JComboBox<String> cbUnidades = vista.cbUnidadesMedicas;
      for(int i = 0; i < cbUnidades.getItemCount(); i++){
        if(cbUnidades.getItemAt(i).equals(doctor.getUnidadMedica())){
          cbUnidades.setSelectedIndex(i);
          break;
        }
      }
      
      ImageIcon iconoFoto = cargarImagen(doctor.getFoto());
      Image imgFoto = iconoFoto.getImage().getScaledInstance(vista.profileImage.getWidth(), vista.profileImage.getHeight(), Image.SCALE_SMOOTH);
      vista.profileImage.setIcon(new ImageIcon(imgFoto));
    }
}