package Controlador;

import Modelo.Doctores;
import Modelo.EspecialidadDoctores;
import Modelo.JefesEnfermeria;
import Modelo.NoticiasMedicas;
import Modelo.UnidadesMedicas;
import Vista.jfrPantallaLogin;
import Vista.jfrPantallaMenuAdminDoctores;
import Vista.jfrPantallaMenuAdminJefesEnfermeria;
import Vista.jfrPantallaMenuAdminNoticias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ctrlPantallaMenuAdmin {

    private jfrPantallaMenuAdminDoctores vista;
    private EspecialidadDoctores modelo;
    private UnidadesMedicas modelo2;
    private Doctores modelo3;
    private jfrPantallaMenuAdminJefesEnfermeria vista2;
    private jfrPantallaMenuAdminNoticias vista3;
    private JefesEnfermeria modelo4;
    NoticiasMedicas modelo5;

    public ctrlPantallaMenuAdmin(jfrPantallaMenuAdminDoctores vista, EspecialidadDoctores modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.modelo.cargarEspecialidadesMedicas(vista.cbEspecialidadesMedicas);
    }

    public ctrlPantallaMenuAdmin(jfrPantallaMenuAdminDoctores vista, UnidadesMedicas modelo2) {
        this.vista = vista;
        this.modelo2 = modelo2;
        this.modelo2.cargarUnidadesMedicas(vista.cbUnidadesMedicas);
    }

    public ctrlPantallaMenuAdmin(jfrPantallaMenuAdminDoctores vista, Doctores modelo3, jfrPantallaMenuAdminJefesEnfermeria vista2, JefesEnfermeria modelo4, NoticiasMedicas modelo5) {
        this.vista = vista;
        this.modelo3 = modelo3;
        this.modelo4 = modelo4;
        this.modelo5 = modelo5;
        this.vista2 = vista2;
        this.modelo3.cargarCardsDoctores(vista.jpCardsDoctores, vista);
        
        this.vista.btnNoticias.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
            jfrPantallaMenuAdminNoticias pantallaNoticias = new jfrPantallaMenuAdminNoticias();
            pantallaNoticias.setVisible(true);
            pantallaNoticias.setLocationRelativeTo(null);
            modelo5.cargarCardsNoticiasMedicas(pantallaNoticias.jpCardsNoticias, pantallaNoticias);
            vista.dispose();
            
            pantallaNoticias.btnAgregarTrabajadores.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e){
                 jfrPantallaMenuAdminDoctores pantallaDoctores = new jfrPantallaMenuAdminDoctores();
                 pantallaDoctores.setVisible(true);
                 pantallaDoctores.setLocationRelativeTo(null);
                 pantallaNoticias.dispose();
               }
            });
            
            pantallaNoticias.btnAgregarNoticia.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                System.err.println("Cliced");
                modelo5.agregarNoticia(pantallaNoticias);
                modelo5.cargarCardsNoticiasMedicas(pantallaNoticias.jpCardsNoticias, pantallaNoticias);
              }
            });
            
            pantallaNoticias.btnActualizarNoticia.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                System.err.println("Clicked");
              }
            });
            
            pantallaNoticias.btnCargarImagenNoticia.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                System.err.println("Clicked");
                modelo5.cargarImagen(pantallaNoticias.imgNoticia, pantallaNoticias);
                
              }
            });
            
            pantallaNoticias.btnEliminarNoticia.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                System.err.println("Clicked");
              }
            });
            
            pantallaNoticias.btnLimpiarNoticia.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                System.err.println("Clicked");
                modelo5.limpiarCampos(pantallaNoticias);
              }
            });
            
            pantallaNoticias.btnCerrarSesion.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                  jfrPantallaLogin login = new jfrPantallaLogin();
                  login.setVisible(true);
                  login.setLocationRelativeTo(null);
                  pantallaNoticias.dispose();
              }
            });
          }
        });

        this.vista.btnJefes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrPantallaMenuAdminJefesEnfermeria pantallaJefes = new jfrPantallaMenuAdminJefesEnfermeria();
                pantallaJefes.setVisible(true);
                pantallaJefes.setLocationRelativeTo(null);
                modelo4.cargarCardsJefes(pantallaJefes.jpCardsJefes, pantallaJefes);
                vista.dispose();
                
                pantallaJefes.btnNoticiasJ.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e){
                    jfrPantallaMenuAdminNoticias pantallaNoticias = new jfrPantallaMenuAdminNoticias();
                    pantallaNoticias.setVisible(true);
                    pantallaNoticias.setLocationRelativeTo(null);
                    modelo5.cargarCardsNoticiasMedicas(pantallaNoticias.jpCardsNoticias, pantallaNoticias);
                    pantallaJefes.dispose();
                    
                    pantallaNoticias.btnAgregarTrabajadores.addActionListener(new ActionListener(){
                      @Override
                      public void actionPerformed(ActionEvent e){
                      jfrPantallaMenuAdminDoctores pantallaDoctores = new jfrPantallaMenuAdminDoctores();
                      pantallaDoctores.setVisible(true);
                      pantallaDoctores.setLocationRelativeTo(null);
                      pantallaNoticias.dispose();
                   }
                });
                    
             pantallaNoticias.btnAgregarNoticia.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                System.err.println("Cliced");
                modelo5.agregarNoticia(pantallaNoticias);
                modelo5.cargarCardsNoticiasMedicas(pantallaNoticias.jpCardsNoticias, pantallaNoticias);
              }
            });
            
            pantallaNoticias.btnActualizarNoticia.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                System.err.println("Clicked");
              }
            });
            
            pantallaNoticias.btnCargarImagenNoticia.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                System.err.println("Clicked");
                modelo5.cargarImagen(pantallaNoticias.imgNoticia, pantallaNoticias);
              }
            });
            
            pantallaNoticias.btnEliminarNoticia.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                System.err.println("Clicked");
              }
            });
            
            pantallaNoticias.btnCerrarSesion.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                  jfrPantallaLogin login = new jfrPantallaLogin();
                  login.setVisible(true);
                  login.setLocationRelativeTo(null);
                  pantallaNoticias.dispose();
              }
            });
            
            pantallaNoticias.btnLimpiarNoticia.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                System.err.println("Clicked");
                modelo5.limpiarCampos(pantallaNoticias);
              }
            });
                  }
                });

                pantallaJefes.btnDoctores.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jfrPantallaMenuAdminDoctores pantallaDoctores = new jfrPantallaMenuAdminDoctores();
                        pantallaDoctores.setVisible(true);
                        pantallaDoctores.setLocationRelativeTo(null);
                        pantallaJefes.dispose();
                    }
                });

                pantallaJefes.btnCargarImagenJefe.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        modelo4.cargarImagen(pantallaJefes.profileImageJefe, pantallaJefes);
                    }
                });

                pantallaJefes.btnAgregarJefe.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.err.println("Clic");
                        modelo4.agregarJefe(pantallaJefes);
                        modelo4.cargarCardsJefes(pantallaJefes.jpCardsJefes, pantallaJefes);
                    }
                });

                pantallaJefes.btnLimpiarJefe.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.err.println("Clic");
                        modelo4.limpiarCampos(pantallaJefes);
                    }
                });

                pantallaJefes.btnActualizarJefe.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int id_usuario = modelo4.getIdUsuario();
                        System.out.println("ID de usuario seleccionado: " + id_usuario);
                        String correo = pantallaJefes.txtCorreoJefe.getText();
                        String telefono = pantallaJefes.txtTelefonoJefe.getText();
                        
                        if(telefono.isEmpty() || correo.isEmpty()){
                          JOptionPane.showMessageDialog(null, "Selecciona una card en orden de actualizar");
                          return;
                        }
                        
                        if (!telefono.matches("\\d{4}-\\d{4}")) {
                        JOptionPane.showMessageDialog(null, "Teléfono inválido. Debe tener el formato 0000-0000.");
                        return;
                        }
                        
                        if (!correo.matches("^[\\w._%+-]+@gmail\\.com$")) {
                        JOptionPane.showMessageDialog(null, "Correo inválido. Solo se permiten correos que terminen en @gmail.com.");
                        return;
                       }

                        if (modelo4.actualizarJefe(id_usuario, correo, telefono, pantallaJefes)) {
                            JOptionPane.showMessageDialog(vista, "Actualización exitosa.");
                            modelo4.limpiarCampos(pantallaJefes);
                            modelo4.cargarCardsJefes(pantallaJefes.jpCardsJefes, pantallaJefes);
                        } else {
                            JOptionPane.showMessageDialog(vista, "Error al actualizar el jefe de enfermería");
                        }
                    }
                });

                pantallaJefes.btnEliminarJefe.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.err.println("Clic");
                        int id_usuario = modelo4.getIdUsuario();

                        int confirmar = JOptionPane.showConfirmDialog(vista, "Estas seguro de que deseas aliminar a este jefe de enfermería", "Confirmación", JOptionPane.YES_NO_OPTION);
                        if (confirmar == JOptionPane.YES_OPTION) {
                            if (modelo4.eliminarJefe(id_usuario, pantallaJefes)) {
                                JOptionPane.showMessageDialog(vista, "Jefe de enfermería elimando exitosamente.");
                                modelo4.cargarCardsJefes(pantallaJefes.jpCardsJefes, pantallaJefes);
                                modelo4.limpiarCampos(pantallaJefes);
                                vista.profileImage.setIcon(null);
                            } else {
                                JOptionPane.showMessageDialog(vista, "Error al eiminar el jefe enfermería, selecciona una card o elige otro jefe de enfermería");
                            }
                        }
                    }
                });
                
                pantallaJefes.btnCerrarSesion.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e){
                     jfrPantallaLogin login = new jfrPantallaLogin();
                     login.setVisible(true);
                     login.setLocationRelativeTo(null);
                     pantallaJefes.dispose();
                  }
                });

            }
        });
        
        this.vista.btnCerrarSesion.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
              jfrPantallaLogin login = new jfrPantallaLogin();
              login.setVisible(true);
              login.setLocationRelativeTo(null);
              vista.dispose();
           }
        });

        this.vista.btnCargarImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo3.cargarImagen(vista.profileImage, vista);
            }
        });

        this.vista.btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo3.agregarDoctor(vista.txtCorreoDoctor, vista.txtContrasenaDoctor, vista.txtNombreDoctor, vista.profileImage, vista.cbEspecialidadesMedicas, vista.cbUnidadesMedicas, vista);
                modelo3.cargarCardsDoctores(vista.jpCardsDoctores, vista);
            }
        });

        this.vista.btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idDoctor = modelo3.getIdDoctorActual();
                String correo = vista.txtCorreoDoctor.getText();
                String nombre = vista.txtNombreDoctor.getText();
                int idEspecialidad = vista.cbEspecialidadesMedicas.getSelectedIndex() + 1;
                int idUnidad = vista.cbUnidadesMedicas.getSelectedIndex() + 1;
                
                
                
                if(correo.isEmpty() || nombre.isEmpty()){
                          JOptionPane.showMessageDialog(null, "Selecciona una card en orden de actualizar");
                          return;
                        }
                
                if(!modelo3.validarNombre(nombre)){
                JOptionPane.showMessageDialog(vista, "Nombre de doctor inválido.");
                return;
                }
                
                if(!correo.contains("@isss") || !correo.contains(".gob.sv")){
               JOptionPane.showMessageDialog(vista, "Correo no válido. Ingresa un correo válido, ejemplo: ejemplo@isss.gob.sv");
               return;
                }

                if (modelo3.actualizarDoctor(idDoctor, correo, nombre, idEspecialidad, idUnidad)) {
                    JOptionPane.showMessageDialog(vista, "Actualización exitosa.");
                    vista.profileImage.setIcon(null);
                    modelo3.limpiarCampos(vista.txtCorreoDoctor, vista.txtContrasenaDoctor, vista.txtNombreDoctor, vista.cbEspecialidadesMedicas, vista.cbUnidadesMedicas, vista.profileImage);
                    modelo3.cargarCardsDoctores(vista.jpCardsDoctores, vista);
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al actualizar el doctor.");
                }
            }
        });

        this.vista.btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.txtContrasenaDoctor.setEnabled(true);
                vista.btnCargarImagen.setEnabled(true);
                modelo3.limpiarCampos(vista.txtCorreoDoctor, vista.txtContrasenaDoctor, vista.txtNombreDoctor, vista.cbEspecialidadesMedicas, vista.cbUnidadesMedicas, vista.profileImage);
            }

        });

        this.vista.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idDoctor = modelo3.getIdDoctorActual();

                int confirmar = JOptionPane.showConfirmDialog(vista, "Estas seguro de que deseas aliminar a este doctor", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmar == JOptionPane.YES_OPTION) {
                    if (modelo3.eliminarDoctor(idDoctor, vista)) {
                        JOptionPane.showMessageDialog(vista, "Doctor elimando exitosamente.");
                        modelo3.cargarCardsDoctores(vista.jpCardsDoctores, vista);
                        modelo3.limpiarCampos(vista.txtCorreoDoctor, vista.txtContrasenaDoctor, vista.txtNombreDoctor, vista.cbEspecialidadesMedicas, vista.cbUnidadesMedicas, vista.profileImage);
                        vista.profileImage.setIcon(null);
                    } else {
                        JOptionPane.showMessageDialog(vista, "Error al eiminar el doctor, Intenta seleccionar una card o selecciona otro doctor");
                    }
                }
            }

        });
    }
}
