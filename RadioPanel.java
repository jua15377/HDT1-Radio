import javax.swing.*;
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
    DecimalFormat aprox = new DecimalFormat("#.#"); //Para eliminar ceros inecesarios


    public RadioPanel(){
        radioPanel = new JPanel();
        radioPanel.setMinimumSize(new Dimension(1000, 500));
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));

        //Botones
        JButton encendido = new JButton("OFF");
        EnciendeRadio enciendeRadio = new EnciendeRadio();
        encendido.addActionListener(enciendeRadio);

        JButton fm = new JButton("FM");
        CambiaFrecuencia cambiaFrecuencia = new CambiaFrecuencia();
        fm.addActionListener(cambiaFrecuencia);

        JButton aumentarFrec = new JButton(">");
        AumentaEmisora aumentaEmisora = new AumentaEmisora();
        aumentarFrec.addActionListener(aumentaEmisora);

        JButton disminuirFrec = new JButton("<");
        DisminuyeEmisora disminuyeEmisora = new DisminuyeEmisora();
        disminuirFrec.addActionListener(disminuyeEmisora);

        JButton f1 = new JButton("1");
        JButton f2 = new JButton("2");
        JButton f3 = new JButton("3");
        JButton f4 = new JButton("4");
        JButton f5 = new JButton("5");
        JButton f6 = new JButton("6");

        JButton f7 = new JButton("7");
        JButton f8 = new JButton("8");
        JButton f9 = new JButton("9");
        JButton f10 = new JButton("10");
        JButton f11 = new JButton("11");
        JButton f12 = new JButton("12");

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

        add(radioPanel);
    }

    public class EnciendeRadio implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean estado = radio.getEncendido();
            if (estado){
                ((JButton) e.getSource()).setText("OFF");
                radio.setEncendido(false);
                setActualFrec("OFF");
            }
            else {
                ((JButton) e.getSource()).setText("ON");
                radio.setEncendido(true);
                setActualFrec(String.valueOf((radio.getEmisora())));

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
            double aumento, emiNueva;

            //Se el tipo de aumento, segun el tipo de frecuencia
            if (tipoFrecuencia){
                aumento = 0.2;
            } else {
                aumento = 10;
            }

            emiNueva = radio.getEmisora() + aumento;
            emiNueva = Double.parseDouble(aprox.format(emiNueva));

            radio.setEmisora(emiNueva);
            setActualFrec(String.valueOf(emiNueva));


        }
    }

    private class DisminuyeEmisora implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean tipoFrecuencia = radio.getFrecuencia();
            double aumento, emiNueva;

            //Se el tipo de aumento, segun el tipo de frecuencia
            if (tipoFrecuencia){
                aumento = -0.2;
            } else {
                aumento = -10;
            }

            emiNueva = radio.getEmisora() + aumento;
            emiNueva = Double.parseDouble(aprox.format(emiNueva));

            radio.setEmisora(emiNueva);
            setActualFrec(String.valueOf(emiNueva));
        }
    }

    //Setters
    public String getActualFrec() {
        return actualFrec.getText();
    }

    public void setActualFrec(String actualFrec) {
        this.actualFrec.setText(actualFrec);
    }
}
