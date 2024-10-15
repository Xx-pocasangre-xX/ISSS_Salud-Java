package Modelo;

import Vista.jfrPantallaMenuAdminJefesEnfermeria;
import Vista.jfrPantallaMenuAdminNoticias;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.security.auth.callback.Callback;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NoticiasMedicas {

    public int getId_noticia() {
        return id_noticia;
    }

    public void setId_noticia(int id_noticia) {
        this.id_noticia = id_noticia;
    }

    public String getImagen_noticia() {
        return imagen_noticia;
    }

    public void setImagen_noticia(String imagen_noticia) {
        this.imagen_noticia = imagen_noticia;
    }

    public String getTitulo_noticia() {
        return titulo_noticia;
    }

    public void setTitulo_noticia(String titulo_noticia) {
        this.titulo_noticia = titulo_noticia;
    }

    public String getDescripcion_noticia() {
        return descripcion_noticia;
    }

    public void setDescripcion_noticia(String descripcion_noticia) {
        this.descripcion_noticia = descripcion_noticia;
    }

    public String getFecha_noticia() {
        return fecha_noticia;
    }

    public void setFecha_noticia(String fecha_noticia) {
        this.fecha_noticia = fecha_noticia;
    }
    private int id_noticia;
    private String imagen_noticia;
    private String titulo_noticia;
    private String descripcion_noticia;
    private String fecha_noticia; 
    
    public List<NoticiasMedicas> obtenerNoticias() {
        List<NoticiasMedicas> listaNoticias = new ArrayList<>();
        String query = "SELECT id_noticia, imagen_noticia, titulo_noticia, descripcion_noticia, fecha_noticia FROM NoticiasMedicas";

        try (Connection conexion = ClaseConexion.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    NoticiasMedicas noticiasMedicas = new NoticiasMedicas();
                    noticiasMedicas.setId_noticia(rs.getInt("id_noticia"));
                    noticiasMedicas.setImagen_noticia(rs.getString("imagen_noticia"));
                    noticiasMedicas.setTitulo_noticia(rs.getString("titulo_noticia"));
                    noticiasMedicas.setDescripcion_noticia(rs.getString("descripcion_noticia"));
                    noticiasMedicas.setFecha_noticia(rs.getString("fecha_noticia"));
                    listaNoticias.add(noticiasMedicas);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaNoticias;
    }
    
    public void cargarCardsNoticiasMedicas(JPanel jpCardsNoticias, jfrPantallaMenuAdminNoticias vista){
       JPanel panelCards = new JPanel();
       panelCards.setLayout(new GridBagLayout());
       
       Color rgbColor = new Color(70, 76, 92);
       panelCards.setBackground(rgbColor);
    
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.insets = new Insets(10, 10, 10, 10);
       gbc.fill = GridBagConstraints.HORIZONTAL;
       gbc.weightx = 1.0;
       
       List<NoticiasMedicas> noticias = obtenerNoticias();
       int row = 0;
       
       for(NoticiasMedicas noticia : noticias){
          JButton card = crearCard(noticia, vista);
          gbc.gridy = row;
          panelCards.add(card, gbc);
        
          gbc.gridy = row + 1;
          panelCards.add(Box.createRigidArea(new Dimension(0, 20))); 
        
          row += 2;
       }
       
       jpCardsNoticias.removeAll();
       
       JScrollPane scrollPane = new JScrollPane(panelCards);
       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       
       jpCardsNoticias.setLayout(new BorderLayout());
       jpCardsNoticias.add(scrollPane, BorderLayout.CENTER);
       jpCardsNoticias.setBackground(rgbColor);
       
       jpCardsNoticias.revalidate();
       jpCardsNoticias.repaint();
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
    
    private JButton crearCard(NoticiasMedicas noticias, jfrPantallaMenuAdminNoticias vista){
       JButton card = new JButton();
       card.setLayout(new BorderLayout(10, 10));
       card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       
       Color rgbColor = new Color(41, 72, 152);
       card.setBackground(rgbColor);
       
       ImageIcon iconoCitasMedicas = cargarImagen(noticias.getImagen_noticia());
       Image img = iconoCitasMedicas.getImage().getScaledInstance(110, 80, Image.SCALE_SMOOTH);
       JLabel lblFoto = new JLabel(new ImageIcon(img));
       
       JPanel textPanel = new JPanel();
       textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
       textPanel.setBackground(rgbColor);
       
       JLabel lblTituloNoticia = new JLabel("Título de la noticia: " + noticias.getTitulo_noticia());
       JLabel lblFechaNoticia = new JLabel("Fecha de publicación: " + noticias.getFecha_noticia());
       
       lblTituloNoticia.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblTituloNoticia.setForeground(Color.WHITE);
       lblFechaNoticia.setAlignmentX(JLabel.LEFT_ALIGNMENT);
       lblFechaNoticia.setForeground(Color.WHITE);
       
       textPanel.add(lblTituloNoticia);
       textPanel.add(lblFechaNoticia);
       
       card.add(lblFoto, BorderLayout.WEST);
       card.add(textPanel, BorderLayout.CENTER);
       
       card.setPreferredSize(new Dimension(250, 80));
       card.setMaximumSize(new Dimension(250, 80));
       card.setMinimumSize(new Dimension(250, 80));
       card.setFocusable(true);
       
       card.addActionListener((e) -> {
          ActualizarCampos(noticias, vista);
       });
       
       return card;
    }
    
    private void ActualizarCampos(NoticiasMedicas noticias, jfrPantallaMenuAdminNoticias vista){
       this.setId_noticia(noticias.getId_noticia());
       
       vista.txtTituloNoticia.setText(noticias.getTitulo_noticia());
       vista.txtDescripcionNoticia.setText(noticias.getDescripcion_noticia());
       vista.btnCargarImagenNoticia.setEnabled(false);
       vista.jdFechaPublicacion.setEnabled(false);
       
       String fechaString = noticias.getFecha_noticia();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // Formato para incluir la hora


try {
    // Imprimir para verificar el formato de la fecha
    System.out.println("Fecha recibida: " + fechaString);
    
    // Convertir la cadena a java.util.Date
    java.util.Date fechaDate = sdf.parse(fechaString);
    
    // Convertir java.util.Date a java.sql.Date
    java.sql.Date fechaSqlDate = new java.sql.Date(fechaDate.getTime());
    vista.jdFechaPublicacion.setDate(fechaSqlDate);
} catch (ParseException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(vista, "Error al convertir la fecha: " + e.getMessage(), "Error de fecha", JOptionPane.ERROR_MESSAGE);
}
      ImageIcon iconoFoto = cargarImagen(noticias.getImagen_noticia());
      Image imgFoto = iconoFoto.getImage().getScaledInstance(vista.imgNoticia.getWidth(), vista.imgNoticia.getHeight(), Image.SCALE_SMOOTH);
      vista.imgNoticia.setIcon(new ImageIcon(imgFoto));
    }
    
    public void agregarNoticia(jfrPantallaMenuAdminNoticias vista){
      String query = "INSERT INTO NoticiasMedicas (imagen_noticia, titulo_noticia, descripcion_noticia, fecha_noticia) VALUES (?, ?, ?, ?)";
      
      try (Connection conexion = ClaseConexion.getConexion(); 
            PreparedStatement pstmt = conexion.prepareStatement(query)) {
         
          String rutaImagen = this.getImagen_noticia(); 
        
        if (rutaImagen == null || rutaImagen.trim().isEmpty()) {
        JOptionPane.showMessageDialog(vista, "Debe subir una foto para agregar una noticia.");
        return;
         }
        
        String titulo = vista.txtTituloNoticia.getText();
        String descripcion = vista.txtDescripcionNoticia.getText();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
       sdf.setLenient(false); // Desactivar interpretación flexible de fechas
       String fechaNoticia;
      try {
        fechaNoticia = sdf.format(vista.jdFechaPublicacion.getDate());
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Fecha inválida. Por favor, usa el formato dd-MM-yyyy.", "Fecha inválida", JOptionPane.WARNING_MESSAGE);
        return;
      }
      
      pstmt.setString(1, rutaImagen);
      pstmt.setString(2, titulo);
      pstmt.setString(3, descripcion);
      pstmt.setString(4, fechaNoticia);
      
      int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "Noticia agregada exitosamente.");
            limpiarCampos(vista);
        }
      }catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al agregar jefe de enfermería.");
    }
    }
    
    public void cargarImagen(JLabel imgNoticia, jfrPantallaMenuAdminNoticias vista){
      JFileChooser fileChooser = new JFileChooser();

    fileChooser.setAcceptAllFileFilterUsed(false);
    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif", "bmp"));

    int result = fileChooser.showOpenDialog(vista);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        if (validarArchivoImagen(selectedFile)) {
            ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
            int width = imgNoticia.getWidth();
            int height = imgNoticia.getHeight();
            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

            imgNoticia.setIcon(new ImageIcon(scaledImage));
            imgNoticia.setText("");  // Elimina cualquier texto en el JLabel

            // Guarda la ruta de la imagen seleccionada
            this.imagen_noticia = selectedFile.getAbsolutePath();  
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
    
    public void limpiarCampos(jfrPantallaMenuAdminNoticias vista){
       vista.txtTituloNoticia.setText("");
       vista.txtDescripcionNoticia.setText("");
       vista.jdFechaPublicacion.setDate(null);
       vista.imgNoticia.setIcon(null);
       vista.btnCargarImagenNoticia.setEnabled(true);
       vista.jdFechaPublicacion.setEnabled(true);
       
       String defaultImageUrl = "https://www.shutterstock.com/image-vector/default-ui-image-placeholder-wireframes-600nw-1037719192.jpg";
        
     try {
        ImageIcon icon = new ImageIcon(new URL(defaultImageUrl));
        Image img = icon.getImage().getScaledInstance(vista.imgNoticia.getWidth(), vista.imgNoticia.getHeight(), Image.SCALE_SMOOTH);
        vista.imgNoticia.setIcon(new ImageIcon(img));
    } catch (IOException e) {
        e.printStackTrace();
    }  
    }
    
    public boolean actulizarNoticia(int id_noticia, String titulo, String descripcion, jfrPantallaMenuAdminNoticias vista){
      Connection conexion = ClaseConexion.getConexion();
      String query = "UPDATE NoticiasMedicas SET titulo_noticia = ?, descripcion_noticia = ? WHERE id_noticia = ?";
      
      try(PreparedStatement ps = conexion.prepareStatement(query)){
         ps.setString(1, titulo);
         ps.setString(2, descripcion);
         ps.setInt(3, id_noticia);
         
         return ps.executeUpdate() > 0;
      }catch(SQLException e){
        e.printStackTrace();
        return false;
      }
    }
}