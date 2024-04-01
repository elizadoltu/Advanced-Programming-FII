import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    private final MainFrame frame;
    private JLabel label;
    private JSpinner spinner;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        setLayout(new FlowLayout());
        add(label);
        add(spinner);
    }

    public int getGridSize() {
        return (int) spinner.getValue();
    }
}
