package Modelo;

public class CorreoUsuario {
    private static String correo;

    public static String getCorreo() {
        return correo;
    }

    public static void setCorreo(String correo) {
        CorreoUsuario.correo = correo;
    }
}
