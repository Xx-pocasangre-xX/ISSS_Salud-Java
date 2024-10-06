package Modelo;

import Vista.PanelCitasAgendadasJefeEnfermeria;
import Vista.jfrActualizarCita;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CitasMedicasJefes {
       private int idCita;
    private String fechaCita;
    private String horaCita;
    private String fotoUsuario;
    private String solicitante;
    private String doctor;

    // Getters y Setters
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(String fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    // Método para obtener todas las citas médicas (sin WHERE)
    public List<CitasMedicasJefes> obtenerCitasMedicas() {
        List<CitasMedicasJefes> listaCitasMedicas = new ArrayList<>();
        String query = "SELECT cm.id_cita, cm.fecha_cita, cm.hora_cita, u.foto_usuario, u.nombre_usuario AS solicitante, d.nombre_doctor AS doctor FROM CitasMedicas cm INNER JOIN Usuarios u ON cm.id_usuario = u.id_usuario INNER JOIN Doctores d ON cm.id_doctor = d.id_doctor";

        try (Connection conexion = ClaseConexion.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    CitasMedicasJefes citasAgendadas = new CitasMedicasJefes();
                    citasAgendadas.setIdCita(rs.getInt("id_cita"));
                    citasAgendadas.setFechaCita(rs.getString("fecha_cita"));
                    citasAgendadas.setHoraCita(rs.getString("hora_cita"));
                    citasAgendadas.setFotoUsuario(rs.getString("foto_usuario"));
                    citasAgendadas.setSolicitante(rs.getString("solicitante"));
                    citasAgendadas.setDoctor(rs.getString("doctor"));
                    listaCitasMedicas.add(citasAgendadas);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaCitasMedicas;
    }

 public void cargarCardsCitasMedicas(JPanel jpCardsCitasAgendadas2, PanelCitasAgendadasJefeEnfermeria vista, jfrActualizarCita vista2){
       JPanel panelCards = new JPanel();
       panelCards.setLayout(new GridBagLayout());
       
       Color rgbColor = new Color(70, 76, 92);
       panelCards.setBackground(rgbColor);
    
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.insets = new Insets(10, 10, 10, 10);
       gbc.fill = GridBagConstraints.HORIZONTAL;
       gbc.weightx = 1.0;
       
       List<CitasMedicasJefes> citasAgendadas = obtenerCitasMedicas();
       int row = 0;
       
       for(CitasMedicasJefes citaAgendada : citasAgendadas){
          JButton card = crearCard(citaAgendada, vista, vista2);
          gbc.gridy = row;
          panelCards.add(card, gbc);
        
          gbc.gridy = row + 1;
          panelCards.add(Box.createRigidArea(new Dimension(0, 20))); 
        
          row += 2;
       }
       
       jpCardsCitasAgendadas2.removeAll();
       
       JScrollPane scrollPane = new JScrollPane(panelCards);
       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       
       jpCardsCitasAgendadas2.setLayout(new BorderLayout());
       jpCardsCitasAgendadas2.add(scrollPane, BorderLayout.CENTER);
       jpCardsCitasAgendadas2.setBackground(rgbColor);
       
       jpCardsCitasAgendadas2.revalidate();
       jpCardsCitasAgendadas2.repaint();
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
    
        private JButton crearCard(CitasMedicasJefes citasAgendadas, PanelCitasAgendadasJefeEnfermeria vista, jfrActualizarCita vista2){
       JButton card = new JButton();
       card.setLayout(new BorderLayout(10, 10));
       card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       
       Color rgbColor = new Color(41, 72, 152);
       card.setBackground(rgbColor);
       
       ImageIcon iconoCitasMedicas = cargarImagen(citasAgendadas.getFotoUsuario());
       Image img = iconoCitasMedicas.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
       JLabel lblFoto = new JLabel(new ImageIcon(img));
       
       JPanel textPanel = new JPanel();
       textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
       textPanel.setBackground(rgbColor);
       
       JLabel lblFechaCita = new JLabel("Fecha de la cita: " + citasAgendadas.getFechaCita());
       JLabel lblHoraCita = new JLabel("Hora de la cita: " + citasAgendadas.getHoraCita());
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
       
       card.addActionListener((e) -> {
          ActualizarTextFields(citasAgendadas, vista);
          Actualizar2(citasAgendadas, vista2);
       });
       
       return card;
    }
        
     private void ActualizarTextFields(CitasMedicasJefes citasAgendadas, PanelCitasAgendadasJefeEnfermeria vista){
        vista.txtNombreDoctor.setText(citasAgendadas.getDoctor());
        vista.txtHora.setText(citasAgendadas.getHoraCita());
        vista.txtDia.setText(citasAgendadas.getFechaCita());
        vista.txtNombrePaciente.setText(citasAgendadas.getSolicitante());
        
        this.setIdCita(citasAgendadas.getIdCita());
        
        vista.txtNombreDoctor.setEditable(false);
        vista.txtHora.setEditable(false);
        vista.txtDia.setEditable(false);
        vista.txtNombrePaciente.setEditable(false);
        vista.txtSexo.setEditable(false);
        vista.txtDUI.setEditable(false);
        vista.txtTIpoSangre.setEditable(false);
        vista.txtTelefono.setEditable(false);
        
        String query = "SELECT u.sexo, u.dui, u.telefono, u.tipo_sangre FROM Usuarios u WHERE u.nombre_usuario = ?";
       
       try(Connection conexion = ClaseConexion.getConexion();
           PreparedStatement stmt = conexion.prepareStatement(query)){
           stmt.setString(1, citasAgendadas.getSolicitante());
           ResultSet rs = stmt.executeQuery();
           
           if(rs.next()){
             vista.txtSexo.setText(rs.getString("sexo"));
             vista.txtDUI.setText(rs.getString("dui"));
             vista.txtTIpoSangre.setText(rs.getString("tipo_sangre"));
             vista.txtTelefono.setText(rs.getNString("telefono"));
           }
       }catch(SQLException e){
         e.printStackTrace();
       }
    }
     
     private void Actualizar2(CitasMedicasJefes citasAgendadas, jfrActualizarCita vista){
       vista.txtHoraActualizada.setText(citasAgendadas.getHoraCita());
       
       this.setIdCita(citasAgendadas.getIdCita());
       
       JComboBox<String> cbDoctor = vista.cbDoctor;
       JComboBox<String> cbEspecialidad = vista.cbEspecialidadDoctor;
       
        for(int i = 0; i < cbDoctor.getItemCount(); i++) {
        if(cbDoctor.getItemAt(i).equals(citasAgendadas.getDoctor())) {
        cbDoctor.setSelectedIndex(i);
        break;
    }
      }
        
        String especialidad = obtenerEspecialidadPorDoctor(citasAgendadas.getDoctor());
        
        for(int i = 0; i < cbEspecialidad.getItemCount(); i++){
          if(cbEspecialidad.getItemAt(i).equals(especialidad)){
            cbEspecialidad.setSelectedIndex(i);
            break;
          }
        }
       
       String fechaString = citasAgendadas.getFechaCita();
       fechaString = fechaString.split(" ")[0];  // Obtener solo la parte de la fecha (antes del espacio)

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Ajusta el formato a 'yyyy-MM-dd' para que coincida con la fecha obtenida
      try {
    // Convertir la cadena a java.util.Date
         java.util.Date fechaDate = sdf.parse(fechaString);
    
    // Convertir java.util.Date a java.sql.Date
        java.sql.Date fechaSqlDate = new java.sql.Date(fechaDate.getTime());
    
        vista.jdcFechaActualizada.setDate(fechaSqlDate);
    } catch (ParseException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(vista, "Error al convertir la fecha: " + e.getMessage(), "Error de fecha", JOptionPane.ERROR_MESSAGE);
}
    }
     
     public String obtenerEspecialidadPorDoctor(String doctor){
    Connection conexion = ClaseConexion.getConexion();
    String especialidad = "";
    String query = "SELECT especialidad_doctor FROM EspecialidadDoctores ed JOIN Doctores d ON ed.id_especialidad = d.id_especialidad WHERE d.nombre_doctor = ?";
    
    try(PreparedStatement stmt = conexion.prepareStatement(query)){
        stmt.setString(1, doctor);
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            especialidad = rs.getString("especialidad_doctor");
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    
    return especialidad;
}
     
     public int obtenerIdDoctorPorNombre(String nombreDoctor){
        Connection conexion = ClaseConexion.getConexion();
        int idDoctor = -1;
        String query = "SELECT id_doctor FROM Doctores WHERE nombre_doctor = ?";
        
        try(PreparedStatement stmt = conexion.prepareStatement(query)){
          stmt.setString(1, nombreDoctor);
          ResultSet rs = stmt.executeQuery();
          
          if(rs.next()){
            idDoctor = rs.getInt("id_doctor");
          }
        }catch(SQLException e){
          e.printStackTrace();
        }
        
        return idDoctor;
     }
     
     public void actualizarCita(int idCita, java.util.Date fechaSeleccionada, String horaCita, String nombreDoctor, jfrActualizarCita miniPanel2){
        java.util.Date fechaActual = new java.util.Date();
    if (fechaSeleccionada.before(fechaActual)) {
        JOptionPane.showMessageDialog(null, "Seleccione una fecha válida. No puede ser una fecha pasada.", "Fecha inválida", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Validar formato de la hora
    if (!horaCita.matches("^(0[1-9]|1[0-2]):([0-5][0-9])\\s?(A\\.M\\.|P\\.M\\.)$")) {
        JOptionPane.showMessageDialog(null, "Por favor, ingresa una hora válida en formato 12 horas (ej. 10:30 A.M. o 02:45 P.M.).", "Hora inválida", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Validar que el doctor sea válido
    int idDoctor = obtenerIdDoctorPorNombre(nombreDoctor);
    if (idDoctor == -1) {
        JOptionPane.showMessageDialog(null, "Seleccione un doctor válido.", "Doctor inválido", JOptionPane.WARNING_MESSAGE);
        return;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String fechaFormateada = sdf.format(fechaSeleccionada);
    miniPanel2.txtHoraActualizada.setText(fechaFormateada);
    java.sql.Date fechaSqlDate = new java.sql.Date(fechaSeleccionada.getTime());
    
    System.out.println("ID Cita: " + getIdCita());
    System.out.println("Fecha SQL: " + fechaSqlDate);
    System.out.println("Hora: " + horaCita);
    System.out.println("ID Doctor: " + idDoctor);

    // Conexión y actualización en la base de datos
    Connection conexion = ClaseConexion.getConexion();
    String query = "UPDATE CitasMedicas SET fecha_cita = ?, hora_cita = ?, id_doctor = ? WHERE id_cita = ?";

    try (PreparedStatement stmt = conexion.prepareStatement(query)) {
        stmt.setDate(1, fechaSqlDate);
        stmt.setString(2, horaCita);
        stmt.setInt(3, idDoctor);
        stmt.setInt(4, idCita);

        int filasActualizadas = stmt.executeUpdate();
        System.out.println("Filas actualizadas: " + filasActualizadas);

        if (filasActualizadas > 0) {
            miniPanel2.txtHoraActualizada.setText("");
            miniPanel2.jdcFechaActualizada.setDate(null);
            JOptionPane.showMessageDialog(null, "La cita ha sido actualizada con éxito.", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la cita. Verifique los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al actualizar la cita: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
}