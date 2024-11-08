
package controlador;

import vistas.VistaBitacora;

public class ControladorBitacora {
    public static VistaBitacora vista= new VistaBitacora();
     
        public static void mostrar() {

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
