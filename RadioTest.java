import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Esta clase es la base del objeto radio, el cual implementa la interfaz RadioInterface
 * @author Eric Mendoza 15002;
 * @author Jonnathan Juarez 15377;
 * @author Javier Jo 14343
 * @since 09/07/2016
 * @version 1.0
 */


public class RadioTest {

    private Radio radio = new RadioCarro();

    @Test
    public void setEncendido() throws Exception {
        radio.setEncendido(true);
        boolean estado = radio.getEncendido();
        assertEquals(false, estado);
        System.out.println("Test setEncendido");
    }


    @org.junit.Test
    public void setFrecuencia() throws Exception {
        radio.setFrecuencia(false);
        boolean estado = radio.getFrecuencia();
        assertEquals(true, estado);
        System.out.println("Test setFrecuencia");

    }

    @org.junit.Test
    public void setEmisora() throws Exception {
        radio.setEmisora(94.9);
        double emisona = radio.getEmisora();
        assertEquals(emisona, 90.9, 0.000003);
        System.out.println("Test setEmisora");
    }

    @org.junit.Test
    public void saveEmisora() throws Exception {
        radio.saveEmisora(8,94.9);
        double emisora = radio.selectEmisora(8);
        assertEquals(emisora, 90.9,0.000003);
        System.out.println("Test saveEmisora");
    }
}