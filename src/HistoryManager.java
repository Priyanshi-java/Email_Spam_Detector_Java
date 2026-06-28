import java.io.*;
import javax.swing.*;

public class HistoryManager {

    public static void saveHistory(String subject, String message, boolean spam) {

        try {
            FileWriter writer = new FileWriter("../reports/history.txt", true);

            writer.write("====================================\n");
            writer.write("Subject : " + subject + "\n");
            writer.write("Message : " + message + "\n");
            writer.write("Status  : " + (spam ? "SPAM" : "SAFE") + "\n");
            writer.write("====================================\n\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showHistory() {

        try {

            File file = new File("../reports/history.txt");

            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "No History Found!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            StringBuilder history = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                history.append(line).append("\n");
            }

            reader.close();

            JTextArea area = new JTextArea(history.toString());
            area.setEditable(false);

            JScrollPane scroll = new JScrollPane(area);
            scroll.setPreferredSize(new java.awt.Dimension(500, 400));

            JOptionPane.showMessageDialog(null, scroll, "History",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
