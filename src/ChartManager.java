import javax.swing.*;
import java.awt.*;

public class ChartManager {

    public static void showChart() {

        JFrame frame = new JFrame("Spam Detection Chart");
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.RED);
                g.fillRect(80, 180, 80, 80);

                g.setColor(Color.GREEN);
                g.fillRect(220, 120, 80, 140);

                g.setColor(Color.BLACK);
                g.drawString("SPAM", 95, 275);
                g.drawString("SAFE", 235, 275);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
}