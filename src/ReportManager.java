import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReportManager {

    public static void saveReport(String subject, String message, boolean spam, int score) {

        try {
            FileWriter writer = new FileWriter("../reports/report.txt", true);

            writer.write("=====================================\n");
            writer.write("Date : " + LocalDateTime.now() + "\n");
            writer.write("Date : " + new java.util.Date() + "\n");
            writer.write("Subject : " + subject + "\n");
            writer.write("Message : " + message + "\n");
            writer.write("Result : " + (spam ? "SPAM" : "SAFE") + "\n");
            writer.write("Spam Score : " + score + "%\n");
            writer.write("=====================================\n\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}