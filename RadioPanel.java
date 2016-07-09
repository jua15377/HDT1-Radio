import javax.swing.*;
import java.awt.*;

/**
 * Created by Eric on 9/07/2016.
 */
public class RadioPanel extends JPanel {
    private JPanel calendarPanel;

    public RadioPanel(){
        calendarPanel = new JPanel();
        calendarPanel.setMinimumSize(new Dimension(1000, 500));
        calendarPanel.setLayout(new BoxLayout(calendarPanel, BoxLayout.Y_AXIS));

        add(calendarPanel);
    }
}
