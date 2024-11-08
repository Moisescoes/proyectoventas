
package controlador;

import vistas.VistaProductos;

public class ControladorProductos {
    public static VistaProductos vista= new VistaProductos();
     
        public static void mostrar() {

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
}
