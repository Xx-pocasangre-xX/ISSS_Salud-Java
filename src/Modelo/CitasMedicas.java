package Modelo;

import Vista.PanelExpedienteMedico;
import Vista.PanelInfoCitaDoctor;
import Vista.jfrPantallaMenuDoctor;
import com.toedter.calendar.JDateChooser;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CitasMedicas {
    private String fecha_cita;
    private String hora_cita;
    private String foto_usuario;
    private String solicitante;
    private String doctor;
    private int idUsuario;

    public int getIdUsuario() {
    return idUsuario;
}

    public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
}
    
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
      String query = "SELECT cm.id_cita, cm.fecha_cita, cm.hora_cita, u.id_usuario, u.foto_usuario, u.correo_electronico AS solicitante, d.nombre_doctor AS doctor FROM CitasMedicas cm INNER JOIN Usuarios u ON cm.id_usuario = u.id_usuario INNER JOIN Doctores d ON cm.id_doctor = d.id_doctor";
      
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
            citasAgendadas.setIdUsuario(rs.getInt("id_usuario"));
            listaCitasMedicas.add(citasAgendadas);
          }
      }catch(SQLException e){
        e.printStackTrace();
      }
      
      return listaCitasMedicas;
    }
    
    public void cargarCardsCitasMedicas(JPanel jpCardsCitasAgendadas, jfrPantallaMenuDoctor vista, PanelInfoCitaDoctor panel2, PanelExpedienteMedico panel3, ExpedientesMedicos expedientes){
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
          JButton card = crearCard(citaAgendada, vista, panel2, panel3, expedientes);
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
    
    private JButton crearCard(CitasMedicas citasAgendadas, jfrPantallaMenuDoctor vista, PanelInfoCitaDoctor panel2, PanelExpedienteMedico panel3, ExpedientesMedicos expedientes){
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
       
       card.addActionListener((e) -> {
          System.out.println("Card clicked: " + citasAgendadas.getSolicitante());
          actualizarTextFieldsConDatos(citasAgendadas, panel2);
          mostrarDatosExpediente(citasAgendadas, panel3, expedientes);
          
          ImageIcon iconoPaciente = cargarImagen(citasAgendadas.getFoto_usuario());
          Image imgPaciente = iconoPaciente.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); 
          panel3.jlFotoPaciente.setIcon(new ImageIcon(imgPaciente));
       });
       
       return card;
    }
    
    private void actualizarTextFieldsConDatos(CitasMedicas citasAgendadas, PanelInfoCitaDoctor panel2){
       panel2.txtNombreDoctor.setText(citasAgendadas.getDoctor());
       panel2.txtCorreoPaciente.setText(citasAgendadas.getSolicitante());
       panel2.txtFechaCita.setText(citasAgendadas.getFecha_cita());
       panel2.txtHoraCita.setText(citasAgendadas.getHora_cita());
       
       String query = "SELECT u.sexo, u.dui, u.tipo_sangre FROM Usuarios u WHERE u.correo_electronico = ?";
       
       try(Connection conexion = ClaseConexion.getConexion();
           PreparedStatement stmt = conexion.prepareStatement(query)){
           stmt.setString(1, citasAgendadas.getSolicitante());
           ResultSet rs = stmt.executeQuery();
           
           if(rs.next()){
             panel2.txtSexoPaciente.setText(rs.getString("sexo"));
             panel2.txtDuiPaciente.setText(rs.getString("dui"));
             panel2.txtTipoSangrePaciente.setText(rs.getString("tipo_sangre"));
           }
       }catch(SQLException e){
         e.printStackTrace();
       }
}
    
    private void mostrarDatosExpediente(CitasMedicas citasAgendadas, PanelExpedienteMedico panel3, ExpedientesMedicos expedientes){
        
         System.out.println("Entrando a mostrarDatosExpediente");
          panel3.txtCorreoPaciente.setText(citasAgendadas.getSolicitante());

    String queryExpediente = "SELECT e.id_expediente, u.dui, u.sexo, u.telefono, u.correo_electronico, u.tipo_sangre, u.edad, e.antecedentes_familiares, e.problemas_salud_preexistentes, e.alergias, e.salud_actual, e.resultados_examenes_laboratorio, e.ficha_ingreso FROM ExpedientesMedicos e INNER JOIN Usuarios u ON e.id_usuario = u.id_usuario WHERE u.correo_electronico = ?";

    try (Connection conexion = ClaseConexion.getConexion();
         PreparedStatement stmt = conexion.prepareStatement(queryExpediente)) {
        stmt.setString(1, citasAgendadas.getSolicitante());
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            
            System.out.println("DUI recuperado: " + rs.getString("dui"));
            
            int idExpediente = rs.getInt("id_expediente");
            expedientes.setIdExpediente(idExpediente);
            
            expedientes.setDui(rs.getString("dui"));
            expedientes.setSexo(rs.getString("sexo"));
            expedientes.setTelefono(rs.getString("telefono"));
            expedientes.setTipo_sangre(rs.getString("tipo_sangre"));
            expedientes.setEdad(rs.getString("edad"));
            expedientes.setAntecedentes(rs.getString("antecedentes_familiares"));
            expedientes.setProblemasSalud(rs.getString("problemas_salud_preexistentes"));
            expedientes.setAlergias(rs.getString("alergias"));
            expedientes.setSaludActual(rs.getString("salud_actual"));
            expedientes.setResultadosLab(rs.getString("resultados_examenes_laboratorio"));
            expedientes.setFichaIngreso(rs.getString("ficha_ingreso"));

            
            panel3.txtDuiPaciente.setText(expedientes.getDui());
            panel3.txtSexoPaciente.setText(expedientes.getSexo());
            panel3.txtTelefonoPaciente.setText(expedientes.getTelefono());
            panel3.txtTipoSangrePaciente.setText(expedientes.getTipo_Sangre());
            panel3.txtEdadPaciente.setText(expedientes.getEdad());
            panel3.txtAntencedentesFamiliares.setText(expedientes.getAntecedentes());
            panel3.txtSaludPreexistentes.setText(expedientes.getProblemasSalud());
            panel3.txtAlergias.setText(expedientes.getAlergias());
            panel3.txtSaludActual.setText(expedientes.getSaludActual());
            panel3.txtExamenesDeLaboratotios.setText(expedientes.getResultadosLab());
            panel3.txtFichaIngreso.setText(expedientes.getFichaIngreso());
            
            panel3.txtDuiPaciente.setEditable(false);
            panel3.txtSexoPaciente.setEditable(false);
            panel3.txtTelefonoPaciente.setEditable(false);
            panel3.txtTipoSangrePaciente.setEditable(false);
            panel3.txtEdadPaciente.setEditable(false);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    }
    
    public void actualizarExpediente(CitasMedicas citasAgendadas, ExpedientesMedicos expedientes, String nuevoAntecedentes, String nuevoSaludPreexistentes, String nuevoAlergias, String nuevoSaludActual, String nuevoExamenesLab, String nuevoFichaIngreso) {
         String queryUpdate = "UPDATE ExpedientesMedicos SET antecedentes_familiares = ?, problemas_salud_preexistentes = ?, alergias = ?, salud_actual = ?, resultados_examenes_laboratorio = ?, ficha_ingreso = ? WHERE id_expediente = ?";
        
        try (Connection conexion = ClaseConexion.getConexion();
                PreparedStatement stmtUpdate = conexion.prepareStatement(queryUpdate)) {
            
           stmtUpdate.setString(1, nuevoAntecedentes);
        stmtUpdate.setString(2, nuevoSaludPreexistentes);
        stmtUpdate.setString(3, nuevoAlergias);
        stmtUpdate.setString(4, nuevoSaludActual);
        stmtUpdate.setString(5, nuevoExamenesLab);
        stmtUpdate.setString(6, nuevoFichaIngreso);
        stmtUpdate.setInt(7, expedientes.getIdExpediente());
        
            int filasActualizadas = stmtUpdate.executeUpdate();
            
            if (filasActualizadas > 0) {
            JOptionPane.showMessageDialog(null, "El expediente ha sido actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el expediente para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el expediente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    public void guardarCambiosExpediente(PanelExpedienteMedico panel3, CitasMedicas citasAgendadas, ExpedientesMedicos expedientes){
           // Obtén el texto actual de los JTextArea
    String antecedentesFamiliaresActual = panel3.txtAntencedentesFamiliares.getText();
    String saludPreexistentesActual = panel3.txtSaludPreexistentes.getText();
    String alergiasActual = panel3.txtAlergias.getText();
    String saludActual = panel3.txtSaludActual.getText();
    String examenesLaboratorioActual = panel3.txtExamenesDeLaboratotios.getText();
    String fichaIngresoActual = panel3.txtFichaIngreso.getText();

    // Obtén los valores nuevos
    String nuevoAntecedentesFamiliares = obtenerTextoNuevo(panel3.txtAntencedentesFamiliares, antecedentesFamiliaresActual);
    String nuevoSaludPreexistentes = obtenerTextoNuevo(panel3.txtSaludPreexistentes, saludPreexistentesActual);
    String nuevoAlergias = obtenerTextoNuevo(panel3.txtAlergias, alergiasActual);
    String nuevoSaludActual = obtenerTextoNuevo(panel3.txtSaludActual, saludActual);
    String nuevoExamenesLaboratorio = obtenerTextoNuevo(panel3.txtExamenesDeLaboratotios, examenesLaboratorioActual);
    String nuevoFichaIngreso = obtenerTextoNuevo(panel3.txtFichaIngreso, fichaIngresoActual);

    // Actualiza el texto de los JTextArea con el nuevo historial
    panel3.txtAntencedentesFamiliares.setText(antecedentesFamiliaresActual + "\n" + nuevoAntecedentesFamiliares);
    panel3.txtSaludPreexistentes.setText(saludPreexistentesActual + "\n" + nuevoSaludPreexistentes);
    panel3.txtAlergias.setText(alergiasActual + "\n" + nuevoAlergias);
    panel3.txtSaludActual.setText(saludActual + "\n" + nuevoSaludActual);
    panel3.txtExamenesDeLaboratotios.setText(examenesLaboratorioActual + "\n" + nuevoExamenesLaboratorio);
    panel3.txtFichaIngreso.setText(fichaIngresoActual + "\n" + nuevoFichaIngreso);
    
          actualizarExpediente(citasAgendadas, expedientes, panel3.txtAntencedentesFamiliares.getText(),
            panel3.txtSaludPreexistentes.getText(), panel3.txtAlergias.getText(),
            panel3.txtSaludActual.getText(), panel3.txtExamenesDeLaboratotios.getText(),
            panel3.txtFichaIngreso.getText());
    }
    
    private String obtenerTextoNuevo(JTextArea textArea, String textoActual){
      String textoCompleto = textArea.getText();
      if(textoCompleto.startsWith(textoActual)){
         return textoCompleto.substring(textoActual.length()).trim();
      }else{
        return textoCompleto.trim();
      }
    }
    
    public ArrayList<String> obtenerDoctores(){
      Connection conexion = ClaseConexion.getConexion();
      ArrayList<String> doctores = new ArrayList<>();
      String query = "SELECT nombre_doctor FROM Doctores";
      
      try(PreparedStatement stmt = conexion.prepareStatement(query);
              ResultSet rs = stmt.executeQuery()){
          
          while(rs.next()){
             doctores.add(rs.getString("nombre_doctor"));
          }
      }catch(SQLException e){
        e.printStackTrace();
      }
      
      return doctores;
    }
    
    public ArrayList<String> obtenerPacientes(){
      Connection conexion = ClaseConexion.getConexion();
      ArrayList<String> pacientes = new ArrayList<>();
      String query = "SELECT correo_electronico FROM Usuarios WHERE id_rol = 2";
      
      try(PreparedStatement stmt = conexion.prepareStatement(query);
           ResultSet rs = stmt.executeQuery()){
      
          while(rs.next()){
            pacientes.add(rs.getString("correo_electronico"));
          }
      }catch(SQLException e){
        e.printStackTrace();
      }
      
      return pacientes;
    }
    
    public void cargarDoctores(JComboBox cbDoctor){
      ArrayList<String> doctores = obtenerDoctores();
      cbDoctor.removeAllItems();
      for(String doctor2 : doctores){
        cbDoctor.addItem(doctor2);
      }
    }
    
    public void cargarPacientes(JComboBox cbPacientes){
      ArrayList<String> pacientes = obtenerPacientes();
      cbPacientes.removeAllItems();
      for(String paciente : pacientes){
        cbPacientes.addItem(paciente);
      }
    }
    
    public void insertarCitaMedica(JDateChooser jdcFechaCita, JTextField txtHoraCita, JComboBox<String> cbPacientes, JComboBox<String> cbDoctor){
      String query = "INSERT INTO CitasMedicas (fecha_cita, hora_cita, id_usuario, id_doctor) VALUES (?, ?, ?, ?)";
      
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fechaCita = sdf.format(jdcFechaCita.getDate());
        String horaCita = txtHoraCita.getText();
        
        java.util.Date fechaActual = new java.util.Date();
        if(jdcFechaCita.getDate().before(fechaActual)){
          JOptionPane.showMessageDialog(null, "La fecha seleccionada no puede ser anterior al día de hoy.", "Fecha inválida", JOptionPane.WARNING_MESSAGE);
          return;
        }
        
        int idUsuario2 = obtenerIdUsuario(cbPacientes.getSelectedItem().toString());
        int idDoctor = obtenerIdDoctor(cbDoctor.getSelectedItem().toString());
        
        if(fechaCita.isEmpty() || horaCita.isEmpty() || idUsuario == -1 || idDoctor == -1){
           JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos antes de guardar la cita.", "Advertencia", JOptionPane.WARNING_MESSAGE);
           return;
        }
        
        try(Connection conexion = ClaseConexion.getConexion(); 
                PreparedStatement stmt = conexion.prepareStatement(query)){
        
            stmt.setString(1, fechaCita);
            stmt.setString(2, horaCita);
            stmt.setInt(3, idUsuario2);
            stmt.setInt(4, idDoctor);
            
            int filasInsertadas = stmt.executeUpdate();
            
            if(filasInsertadas > 0){
              JOptionPane.showMessageDialog(null, "La cita médica ha sido registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }else{
              JOptionPane.showMessageDialog(null, "No se pudo registrar la cita médica.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Error al insertar la cita médica: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          e.printStackTrace();
        }
    }
    
    public int obtenerIdUsuario(String correo){
      int idUsuario2 = -1;
      String query = "SELECT id_usuario FROM Usuarios WHERE correo_electronico = ?";
      
      try(Connection conexion = ClaseConexion.getConexion();
          PreparedStatement stmt = conexion.prepareStatement(query)){
          
          stmt.setString(1, correo);
          ResultSet rs = stmt.executeQuery();
          
          if(rs.next()){
            idUsuario2 = rs.getInt("id_usuario");
          }
      }catch(SQLException e){
        e.printStackTrace();
      }
      
      return idUsuario2;
    }
    
    public int obtenerIdDoctor(String nombreDoctor){
      int idDoctor = -1;
      String query = "SELECT id_doctor FROM Doctores WHERE nombre_doctor = ?";
      
      try(Connection conexion = ClaseConexion.getConexion();
          PreparedStatement stmt = conexion.prepareStatement(query)){
      
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
    
}