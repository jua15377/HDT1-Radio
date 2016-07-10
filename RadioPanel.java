import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Esta clase contiene los siguientes componentes:
 * @author Eric Mendoza 15002; Jonnathan Juarez 15377; Javier Jo
 * @since 09/07/2016
 * @version 1.0
 */
public class RadioPanel extends JPanel {
    private JPanel radioPanel;
    private Radio radio = new Radio();
    private JLabel actualFrec;
    private JButton f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,fm, aumentarFrec, disminuirFrec;


    private int contadorSegundos;

    private int actualButton;
    private Timer timerEstaciones;
    DecimalFormat aprox = new DecimalFormat("#.#"); //Para eliminar ceros inecesarios


    public RadioPanel(){
        radioPanel = new JPanel();
        radioPanel.setMinimumSize(new Dimension(1000, 500));
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));

        //Botones
        JButton encendido = new JButton("OFF");
        EnciendeRadio enciendeRadio = new EnciendeRadio();
        encendido.addActionListener(enciendeRadio);

        fm = new JButton("FM");
        CambiaFrecuencia cambiaFrecuencia = new CambiaFrecuencia();
        fm.addActionListener(cambiaFrecuencia);

        aumentarFrec = new JButton(">");
        AumentaEmisora aumentaEmisora = new AumentaEmisora();
        aumentarFrec.addActionListener(aumentaEmisora);


        disminuirFrec = new JButton("<");
        DisminuyeEmisora disminuyeEmisora = new DisminuyeEmisora();
        disminuirFrec.addActionListener(disminuyeEmisora);

        //Listener para estaciones guardadas
        TimerListener timerListener = new TimerListener();
        timerEstaciones = new Timer(500, timerListener);
        EscuchaEmisoraGuardada escuchaEmisoraGuardada = new EscuchaEmisoraGuardada();
        CambiaBotonActual cambiaBotonActual = new CambiaBotonActual();

        f1 = new JButton("1");
        f1.addActionListener(cambiaBotonActual);
        ButtonModel bf1 = f1.getModel();
        bf1.addChangeListener(escuchaEmisoraGuardada);

        f2 = new JButton("2");
        f2.addActionListener(cambiaBotonActual);
        ButtonModel bf2 = f2.getModel();
        bf2.addChangeListener(escuchaEmisoraGuardada);

        f3 = new JButton("3");
        f3.addActionListener(cambiaBotonActual);
        ButtonModel bf3 = f3.getModel();
        bf3.addChangeListener(escuchaEmisoraGuardada);

        f4 = new JButton("4");
        f4.addActionListener(cambiaBotonActual);
        ButtonModel bf4 = f4.getModel();
        bf4.addChangeListener(escuchaEmisoraGuardada);

        f5 = new JButton("5");
        f5.addActionListener(cambiaBotonActual);
        ButtonModel bf5 = f5.getModel();
        bf5.addChangeListener(escuchaEmisoraGuardada);

        f6 = new JButton("6");
        f6.addActionListener(cambiaBotonActual);
        ButtonModel bf6 = f6.getModel();
        bf6.addChangeListener(escuchaEmisoraGuardada);

        f7 = new JButton("7");
        f7.addActionListener(cambiaBotonActual);
        ButtonModel bf7 = f7.getModel();
        bf7.addChangeListener(escuchaEmisoraGuardada);

        f8 = new JButton("8");
        f8.addActionListener(cambiaBotonActual);
        ButtonModel bf8 = f8.getModel();
        bf8.addChangeListener(escuchaEmisoraGuardada);

        f9 = new JButton("9");
        f9.addActionListener(cambiaBotonActual);
        ButtonModel bf9 = f9.getModel();
        bf9.addChangeListener(escuchaEmisoraGuardada);

        f10 = new JButton("10");
        f10.addActionListener(cambiaBotonActual);
        ButtonModel bf10 = f10.getModel();
        bf10.addChangeListener(escuchaEmisoraGuardada);

        f11 = new JButton("11");
        f11.addActionListener(cambiaBotonActual);
        ButtonModel bf11 = f11.getModel();
        bf11.addChangeListener(escuchaEmisoraGuardada);

        f12 = new JButton("12");
        f12.addActionListener(cambiaBotonActual);
        ButtonModel bf12 = f12.getModel();
        bf12.addChangeListener(escuchaEmisoraGuardada);

        //Iniciar apagados
        f1.setEnabled(false);
        f2.setEnabled(false);
        f3.setEnabled(false);
        f4.setEnabled(false);
        f5.setEnabled(false);
        f6.setEnabled(false);
        f7.setEnabled(false);
        f8.setEnabled(false);
        f9.setEnabled(false);
        f10.setEnabled(false);
        f11.setEnabled(false);
        f12.setEnabled(false);
        fm.setEnabled(false);
        disminuirFrec.setEnabled(false);
        aumentarFrec.setEnabled(false);

        actualFrec = new JLabel("OFF");

        //Agregado de componentes a GUI
        radioPanel.add(encendido);
        radioPanel.add(Box.createHorizontalStrut(25));

        //Agregar componentes del centro a Boxes para mejor orden
            Box botonesCentro = Box.createVerticalBox();
                //Sub box para primeras 6 frecuencias
                Box botoncesFrec1 = Box.createHorizontalBox();
                botoncesFrec1.add(f1);
                botoncesFrec1.add(f2);
                botoncesFrec1.add(f3);
                botoncesFrec1.add(f4);
                botoncesFrec1.add(f5);
                botoncesFrec1.add(f6);

                //Sub box para ultimas 6 frecuencias
                Box botoncesFrec2 = Box.createHorizontalBox();
                botoncesFrec2.add(f7);
                botoncesFrec2.add(f8);
                botoncesFrec2.add(f9);
                botoncesFrec2.add(f10);
                botoncesFrec2.add(f11);
                botoncesFrec2.add(f12);

                //Sub box para cambio de frec
                Box botoncesCambioFrec = Box.createHorizontalBox();
                botoncesCambioFrec.add(disminuirFrec);
                botoncesCambioFrec.add(aumentarFrec);
            botonesCentro.add(actualFrec);
            botonesCentro.add(Box.createVerticalStrut(25));
            botonesCentro.add(botoncesFrec1);
            botonesCentro.add(botoncesFrec2);
            botonesCentro.add(Box.createVerticalStrut(25));
            botonesCentro.add(botoncesCambioFrec);

        radioPanel.add(botonesCentro);
        radioPanel.add(Box.createHorizontalStrut(25));

            //Agregar botones am y fm a una Box
            Box botonesDerecha = Box.createVerticalBox();
            botonesDerecha.add(fm);

        radioPanel.add(botonesDerecha);
        JOptionPane.showMessageDialog(null, "Para guardar estación, dejar presionado boton por 3 segundos.");
        add(radioPanel);
    }

    public class EnciendeRadio implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean estado = radio.getEncendido();
            if (estado){
                ((JButton) e.getSource()).setText("OFF");
                actualFrec.setEnabled(false);
                radio.setEncendido(false);
                f1.setEnabled(false);
                f2.setEnabled(false);
                f3.setEnabled(false);
                f4.setEnabled(false);
                f5.setEnabled(false);
                f6.setEnabled(false);
                f7.setEnabled(false);
                f8.setEnabled(false);
                f9.setEnabled(false);
                f10.setEnabled(false);
                f11.setEnabled(false);
                f12.setEnabled(false);
                fm.setEnabled(false);
                disminuirFrec.setEnabled(false);
                aumentarFrec.setEnabled(false);
            }
            else {
                ((JButton) e.getSource()).setText("ON");
                radio.setEncendido(true);
                actualFrec.setEnabled(true);
                setActualFrec(String.valueOf((radio.getEmisora())));
                f1.setEnabled(true);
                f2.setEnabled(true);
                f3.setEnabled(true);
                f4.setEnabled(true);
                f5.setEnabled(true);
                f6.setEnabled(true);
                f7.setEnabled(true);
                f8.setEnabled(true);
                f9.setEnabled(true);
                f10.setEnabled(true);
                f11.setEnabled(true);
                f12.setEnabled(true);
                fm.setEnabled(true);
                disminuirFrec.setEnabled(true);
                aumentarFrec.setEnabled(true);
            }
        }
    }

    private class CambiaFrecuencia implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean frecuencia = radio.getFrecuencia();
            if (frecuencia){
                ((JButton) e.getSource()).setText("AM");
                radio.setFrecuencia(false);
                radio.setEmisora(530.0);
                setActualFrec("530.0");

            }
            else {
                ((JButton) e.getSource()).setText("FM");
                radio.setFrecuencia(true);
                radio.setEmisora(87.9);
                setActualFrec("87.9");
            }
        }
    }

    private class AumentaEmisora implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean tipoFrecuencia = radio.getFrecuencia();
            double aumento, emiNueva, inicio, fin;

            //Se el tipo de aumento, segun el tipo de frecuencia
            if (tipoFrecuencia){
                aumento = 0.2;
                inicio = 87.9;
                fin = 107.9;
            } else {
                aumento = 10;
                inicio = 530;
                fin = 1610;
            }

            emiNueva = radio.getEmisora() + aumento;
            if (emiNueva > fin){
                emiNueva = inicio;
            }
            emiNueva = Double.parseDouble(aprox.format(emiNueva));

            radio.setEmisora(emiNueva);
            setActualFrec(String.valueOf(emiNueva));
            setContadorSegundos(0);

        }
    }

    private class DisminuyeEmisora implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean tipoFrecuencia = radio.getFrecuencia();
            double aumento, emiNueva, inicio, fin;

            //Se el tipo de aumento, segun el tipo de frecuencia
            if (tipoFrecuencia){
                aumento = -0.2;
                inicio = 87.9;
                fin = 107.9;
            } else {
                aumento = -10;
                inicio = 530;
                fin = 1610;
            }

            emiNueva = radio.getEmisora() + aumento;
            if (emiNueva < inicio){
                emiNueva = fin;
            }
            emiNueva = Double.parseDouble(aprox.format(emiNueva));

            radio.setEmisora(emiNueva);
            setActualFrec(String.valueOf(emiNueva));
            setContadorSegundos(0);
        }


    }

    private class EscuchaEmisoraGuardada implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            ButtonModel source = ((ButtonModel) e.getSource());
            int segundos;
            // Mientras esta presionado un contador inicia
            if (source.isPressed() && !timerEstaciones.isRunning()){
                timerEstaciones.start();
            } else if (!source.isPressed() && timerEstaciones.isRunning()){
                timerEstaciones.stop();
                segundos = getContadorSegundos();
                if (segundos >= 3){
                    //Guardar estacion actual en dicho boton
                    double estacionActual = Double.parseDouble(getActualFrec());
                    radio.saveEmisora(getActualButton(),estacionActual);
                    JOptionPane.showMessageDialog(null, "Estacion guardada con exito!");
                    setContadorSegundos(0);

                } else {
                    //Cargar estacion guardada en boton
                    double frecuencia = radio.selectEmisora(getActualButton());
                    setActualFrec(String.valueOf(frecuencia));
                    radio.setEmisora(frecuencia);
                }
            }
        }
    }

    private class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int contador = getContadorSegundos();
            setContadorSegundos(contador + 1);
        }
    }

    private class CambiaBotonActual implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            int actual = Integer.parseInt(source.getText());
            setActualButton(actual);
        }
    }

    //Setters
    public String getActualFrec() {
        return actualFrec.getText();
    }

    public void setActualFrec(String actualFrec) {
        this.actualFrec.setText(actualFrec);
        double actualFrec2 = Double.parseDouble(actualFrec);
        if (actualFrec2 > 108){
            radio.setFrecuencia(false);
            fm.setText("AM");
        } else {
            radio.setFrecuencia(true);
            fm.setText("FM");
        }
    }

    public int getContadorSegundos() {
        return contadorSegundos;
    }

    public void setContadorSegundos(int contadorSegundos) {
        this.contadorSegundos = contadorSegundos;
    }

    public int getActualButton() {
        return actualButton;
    }

    public void setActualButton(int actualButton) {
        this.actualButton = actualButton;
    }
}
