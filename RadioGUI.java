import javax.swing.*;
import java.awt.*;

/**
 * Esta clase arma la gui, llama al contenedor RadioPanel para mostrar en pantalla la aplicacion
 * @author Eric Mendoza 15002; Jonnathan Juarez 15377; Javier Jo 14343
 * @since 09/07/2016
 * @version 1.1
 */
public class RadioGUI {
    /**
     * Contructor del GUI.
     */
    public RadioGUI(){
        //Panel a utilizar
        RadioPanel radioPanel = new RadioPanel();

        // Crear Marco
        JFrame marcoGUI = new JFrame();
        marcoGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoGUI.setMinimumSize(new Dimension(750, 300));

        // Lienzo para panel
        Container lienzo = marcoGUI.getContentPane();

        // Formato para ingresar panel
        lienzo.setLayout(new BoxLayout(lienzo, BoxLayout.Y_AXIS));
        radioPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lienzo.add(radioPanel);

        // Empacar
        marcoGUI.pack();

        // Volverlo visible
        marcoGUI.setVisible(true);
    }
}
