import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private final MainFrame frame;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");

        setLayout(new GridLayout(1, 3));
        add(loadButton);
        add(saveButton);
        add(exitButton);

        exitButton.addActionListener(e -> frame.dispose());
    }
}
