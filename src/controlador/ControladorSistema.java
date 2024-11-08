package controlador;

import vistas.VistaSistema;

public class ControladorSistema {

    public static VistaSistema vista = new VistaSistema();

    public static void mostrar() {

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    public static void ocultar(){
    vista.setVisible(false);
    }
    
    public static void iniciarLogin(){
        ControladorLogin.mostrar();

    }

    public static void iniciarVentas() {
        ControladorVentas.mostrar();
    }

    public static void iniciarUsuarios() {
        ControladorUsuarios.mostrar();
    }

    public static void iniciarBitacora() {
        ControladorBitacora.mostrar();

    }
    public static void iniciarProductos(){
        ControladorProductos.mostrar();
    }
    public static void cerrarSesion(){
        ocultar();
        ControladorLogin.limpiar();
    ControladorLogin.mostrar();
    }
    public static void Salir(){
    System.exit(0);
    }

    
    
}
