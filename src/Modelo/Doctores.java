package Modelo;

import Vista.jfrPantallaMenuAdmin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
    
    public void cargarCardsDoctores(JPanel jpCardsDoctores) {
    List<Doctores> doctores = obtenerDoctores(); 
    jpCardsDoctores.setLayout(new GridLayout(0, 1, 10, 10)); 

    for (Doctores doctor : doctores) {
        JPanel card = crearCard(doctor);
        jpCardsDoctores.add(card);
    }

    jpCardsDoctores.revalidate();
    jpCardsDoctores.repaint();
}
    
    private JPanel crearCard(Doctores doctor) {
    JPanel card = new JPanel();
    card.setLayout(new BorderLayout());
    card.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    JLabel lblNombre = new JLabel(doctor.getNombre());
    lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
    card.add(lblNombre, BorderLayout.CENTER);

    
    return card;
}
}
