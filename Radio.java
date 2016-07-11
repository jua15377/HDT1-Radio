/**
 * Esta clase es la base del objeto radio, el cual implementa la interfaz RadioInterface
 * @author Eric Mendoza 15002;
 * @author Jonnathan Juarez 15377;
 * @author Javier Jo 14343
 * @since 09/07/2016
 * @version 1.0
 */
public class Radio implements RadioInterface{
    //Atributos
    private boolean encendido, frecuencia;
    private double emisora;
    private double[] frecsGuardadas = {87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9,87.9};

    //Metodos
    /**
        Constructor: Inicializa los atributos con los siguientes datos:
            - Encendido: false
            - Frecuencia: fm
            - Emisora: 87.9
     */
    public Radio(){
        this.encendido = false;
        this.frecuencia = true;
        this.emisora = 87.9;
    }

    /**
     * setEncencido cambia si el radio esta encendido o apagado
     * @param estado, define el estado de apagado/encendido
     */
    @Override
    public void setEncendido(boolean estado) {
        this.encendido = estado;
    }

    /**
     * setFrecuencia cambia entre AM y FM.
     * @param frecuencia, AM es false y FM es true
    True -> FM
     */
    @Override
    public void setFrecuencia(boolean frecuencia) {
        this.frecuencia = frecuencia;
    }

    /**
     * setEmisora se utiliza para cambiar la emisora que se escucha actualmente
     * @param emisora, define la emisora que se esta "escuchando"
     */
    @Override
    public void setEmisora(double emisora) {
        this.emisora = emisora;
    }

    /**
     * saveEmisora se utiliza para almacenar una emisora en alguno de los botones disponibles
     * @param btn, es el boton en el que se quiere guardar la emisora
     * @param emisora, es la frecuencia de la emisora que se quiere almacenar
     */
    @Override
    public void saveEmisora(int btn, double emisora) {
        this.frecsGuardadas[btn-1] = emisora;
    }

    /**
     * selectEmisora se utiliza para seleccionar una de las emisoras que se habia guardado con anterioridad
     * @param btn, contiene el ID del boton que se quiere cargar
     * @return frecsGuardadas, devuelve la frecuencia de la emisora que se pidio.
     */
    @Override
    public double selectEmisora(int btn) {
        return this.frecsGuardadas[btn-1];
    }

    /**
     * getEncendido se utiliza para verificar si la radio esta encendida o apagada
     * @return encendido, true para encendido y false para apagado
     */
    @Override
    public boolean getEncendido() {
        return this.encendido;
    }

    /**
     * getFrecuencia se utiliza para obtener el tipo de frecuencia que se utiliza actualemte
     * @return frecuencia, false para am y true para fm.
     */
    @Override
    public boolean getFrecuencia() {
        return this.frecuencia;
    }

    /**
     * getEmisora se utiliza para obtener la frecuencia de la emisora que se escucha
     * @return emisora, valor double de la emisora
     */
    @Override
    public double getEmisora() {
        return this.emisora;
    }
}
