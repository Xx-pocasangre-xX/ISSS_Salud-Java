package Controlador;

import Modelo.Doctores;
import Modelo.EspecialidadDoctores;
import Modelo.JefesEnfermeria;
import Modelo.UnidadesMedicas;
import Vista.jfrPantallaLogin;
import Vista.jfrPantallaMenuAdminDoctores;
import Vista.jfrPantallaMenuAdminJefesEnfermeria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlPantallaMenuAdmin {

    private jfrPantallaMenuAdminDoctores vista;
    private EspecialidadDoctores modelo;
    private UnidadesMedicas modelo2;
    private Doctores modelo3;
    private jfrPantallaMenuAdminJefesEnfermeria vista2;
    private JefesEnfermeria modelo4;

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

    public ctrlPantallaMenuAdmin(jfrPantallaMenuAdminDoctores vista, Doctores modelo3, jfrPantallaMenuAdminJefesEnfermeria vista2, JefesEnfermeria modelo4) {
        this.vista = vista;
        this.modelo3 = modelo3;
        this.modelo4 = modelo4;
        this.vista2 = vista2;
        this.modelo3.cargarCardsDoctores(vista.jpCardsDoctores, vista);

        this.vista.btnJefes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrPantallaMenuAdminJefesEnfermeria pantallaJefes = new jfrPantallaMenuAdminJefesEnfermeria();
                pantallaJefes.setVisible(true);
                pantallaJefes.setLocationRelativeTo(null);
                modelo4.cargarCardsJefes(pantallaJefes.jpCardsJefes, pantallaJefes);
                vista.dispose();

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
                                JOptionPane.showMessageDialog(vista, "Error al eiminar el doctor");
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
                        JOptionPane.showMessageDialog(vista, "Error al eiminar el doctor");
                    }
                }
            }

        });
    }
}
