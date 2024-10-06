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
       
       JComboBox<String> cbDoctor = vista.cmbNombreDoctorAct;
        for(int i = 0; i < cbDoctor.getItemCount(); i++){
        if(cbDoctor.getItemAt(i).equals(citasAgendadas.getDoctor())){
          cbDoctor.setSelectedIndex(i);
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
}
