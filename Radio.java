/**
 * Esta clase es la base del objeto radio, el cual implementa la interfaz RadioInterface
 * @author Eric Mendoza 15002; Jonnathan Juarez 15377; Javier Jo
 * @since 09/07/2016
 * @version 1.0
 */
public class Radio implements RadioInterface{
    public Radio(){}

    @Override
    public void setEncendido(boolean estado) {

    }

    @Override
    public void setFrecuencia(boolean frecuencia) {

    }

    @Override
    public void setEmisora(double emisora) {

    }

    @Override
    public void saveEmisora(int btn, double emisora) {

    }

    @Override
    public double selectEmisora(int btn) {
        return 0;
    }

    @Override
    public boolean getEncendido() {
        return false;
    }

    @Override
    public boolean getFrecuencia() {
        return false;
    }

    @Override
    public double getEmisora() {
        return 0;
    }
}
