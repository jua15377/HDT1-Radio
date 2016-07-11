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

    private Radio radio = new Radio();

    @org.junit.Test
    public void setEncendido() throws Exception {
        radio.setEncendido(false);
        boolean estado = radio.getEncendido();
        assertEquals(false, estado);
    }


    @org.junit.Test
    public void setFrecuencia() throws Exception {
        radio.setFrecuencia(true);
        boolean estado = radio.getFrecuencia();
        assertEquals(true, estado);

    }

    @org.junit.Test
    public void setEmisora() throws Exception {
        radio.setEmisora(94.9);
        double emisona = radio.getEmisora();
        assertEquals(emisona, 94.9, 0.000003);
    }

    @org.junit.Test
    public void saveEmisora() throws Exception {
        radio.saveEmisora(8,94.9);
        double emisora = radio.selectEmisora(8);
        assertEquals(emisora, 94.9,0.000003);
    }


}