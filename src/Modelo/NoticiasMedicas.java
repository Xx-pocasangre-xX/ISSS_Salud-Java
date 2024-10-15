package Modelo;

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
    
    public void cargarCardsNoticiasMedicas(JPanel jpCardsNoticias){
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
          JButton card = crearCard(noticia);
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
    
    private JButton crearCard(NoticiasMedicas noticias){
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
          
       });
       
       return card;
    }
}
