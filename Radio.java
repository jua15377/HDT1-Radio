/**
 * Esta clase es la base del objeto radio, el cual implementa la interfaz RadioInterface
 * @author Eric Mendoza 15002; Jonnathan Juarez 15377; Javier Jo
 * @since 09/07/2016
 * @version 1.0
 */
public class Radio implements RadioInterface{
    //Atributos
    private boolean encendido, frecuencia;
    private double emisora;
    private double[] frecsGuardadas = {87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9};

    //Metodos
    public Radio(){
        this.encendido = false;
        this.frecuencia = true;
        this.emisora = 87.9;
    }

    @Override
    public void setEncendido(boolean estado) {
        this.encendido = estado;
    }

    @Override
    public void setFrecuencia(boolean frecuencia) {
        this.frecuencia = frecuencia;
    }

    @Override
    public void setEmisora(double emisora) {
        this.emisora = emisora;
    }

    @Override
    public void saveEmisora(int btn, double emisora) {
        this.frecsGuardadas[btn-1] = emisora;
    }

    @Override
    public double selectEmisora(int btn) {
        return this.frecsGuardadas[btn];
    }

    @Override
    public boolean getEncendido() {
        return this.encendido;
    }

    @Override
    public boolean getFrecuencia() {
        return this.frecuencia;
    }

    @Override
    public double getEmisora() {
        return this.emisora;
    }
}
