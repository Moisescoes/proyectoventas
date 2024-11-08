package controlador;

import javax.swing.JOptionPane;
import modelo.UsuarioDAO;
import modelo.Usuario;
import vistas.VistaUsuarios;

public class ControladorUsuarios {

    public static VistaUsuarios vista = new VistaUsuarios();

    public static void mostrar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        System.out.println(getUsuarioById(1000));
        System.out.println(getUsuarioById(1001));
        System.out.println(getUsuarioById(1002));

    }

    public static Usuario getUsuarioById(int id) {
        return new UsuarioDAO().getUsuarioById(id);
    }

    public static void registrar() {
        var errores = new StringBuilder();
        var usuario = new Usuario();
        if (vista.getTxtUsuariosNombre().getText().trim().length() > 0) {
            usuario.setNombre(vista.getTxtUsuariosNombre().getText().trim());
        } else {
            errores.append("El campo nombre no debe ser vacio\n");
        }
        if (!vista.getTxtUsuariosApellidoPaterno().getText().trim().equals("")) {
            usuario.setApellidoPaterno(vista.getTxtUsuariosApellidoPaterno().getText().trim());
        } else {
            errores.append("El campo apellido paterno no debe ser vacio\n");
        }
        if (!vista.getTxtUsuariosApellidoMaterno().getText().trim().equals("")) {
            usuario.setApellidoMaterno(vista.getTxtUsuariosApellidoMaterno().getText());
        } else {
            errores.append("El campo apellido materno no debe ser vacio\n");
        }
        if (!vista.getTxtUsuariosUsuario().getText().trim().equals("")) {
            usuario.setUsuario(vista.getTxtUsuariosUsuario().getText());
        } else {
            errores.append("El campo usuario no debe ser vacio\n");
        }
        if (!vista.getTxtUsuariosContrasena().getText().trim().equals("")) {
            usuario.setContrasena(vista.getTxtUsuariosContrasena().getText());
        } else {
            errores.append("El campo contraseña no debe ser vacio");
        }

        if (errores.length() > 0) {
            JOptionPane.showMessageDialog(
                    null,
                    errores.toString(),
                    "Errores de validación",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            switch (new UsuarioDAO().registrar(usuario)) {
                case 1:
                    System.out.println("Todo bien");
                    JOptionPane.showMessageDialog(null,
                            "El registro fue exitoso",
                            "Registro exitoso",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "El usuario ya existe en el sistema",
                            "Registro fallido",
                            JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Contacte al administrado del sistema",
                            "Algo ocurrio",
                            JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }

    }

    public static void limpiar() {
        vista.getTxtUsuariosId().setText("");
        vista.getTxtUsuariosNombre().setText("");
        vista.getTxtUsuariosApellidoPaterno().setText("");
        vista.getTxtUsuariosApellidoMaterno().setText("");
        vista.getTxtUsuariosUsuario().setText("");
        vista.getTxtUsuariosContrasena().setText("");
        vista.getTxtUsuariosEstado().setText("");
    }

    public static void modificar() {
    }

    public static void activarDesactivar() {
    }
}
