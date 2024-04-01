import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    private int gridSize;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        this.gridSize = frame.configPanel.getGridSize();
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int cellSize = Math.min(width, height) / gridSize;

        // Draw grid lines
        g.setColor(Color.BLACK);
        for (int i = 0; i <= gridSize; i++) {
            int x = i * cellSize;
            g.drawLine(x, 0, x, height);
            int y = i * cellSize;
            g.drawLine(0, y, width, y);
        }
    }
}
