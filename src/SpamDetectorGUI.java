import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpamDetectorGUI extends JFrame {

    JTextField subjectField;
    JTextArea messageArea;
    JLabel resultLabel;
    JLabel scoreLabel;
    JLabel dateLabel;
    JProgressBar progressBar;
    JButton checkButton;
    JButton clearButton;
    JButton historyButton;
    JButton chartButton;
    JButton exitButton;

    public SpamDetectorGUI() {

        setTitle("Email Spam Detector");
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("EMAIL SPAM DETECTOR");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(140,20,350,30);
        panel.add(title);

        dateLabel = new JLabel(new java.util.Date().toString());
dateLabel.setBounds(120, 50, 350, 20);
panel.add(dateLabel);

        JLabel subjectLabel = new JLabel("Email Subject:");
        subjectLabel.setBounds(40,70,120,25);
        panel.add(subjectLabel);

        subjectField = new JTextField();
        subjectField.setBounds(170,70,350,25);
        panel.add(subjectField);

        JLabel messageLabel = new JLabel("Email Message:");
        messageLabel.setBounds(40,110,120,25);
        panel.add(messageLabel);

        messageArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(messageArea);
        scroll.setBounds(170,110,350,150);
        panel.add(scroll);

        checkButton = new JButton("Check Email");
        checkButton.setBounds(80,280,130,35);
        panel.add(checkButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(230,280,100,35);
        panel.add(clearButton);

        historyButton = new JButton("History");
        historyButton.setBounds(350,280,120,35);
        panel.add(historyButton);

        chartButton = new JButton("Charts");
chartButton.setBounds(480, 280, 90, 35);
panel.add(chartButton);

        exitButton = new JButton("Exit");
exitButton.setBounds(490, 280, 80, 35);
panel.add(exitButton);

        resultLabel = new JLabel("Result : ");
        resultLabel.setBounds(40,340,300,25);
        panel.add(resultLabel);

        scoreLabel = new JLabel("Spam Score : ");
        scoreLabel.setBounds(40,370,300,25);
        panel.add(scoreLabel);

        progressBar = new JProgressBar(0,100);
        progressBar.setBounds(170, 400, 250, 25);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        panel.add(progressBar);

        add(panel);
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String subject = subjectField.getText();
                String message = messageArea.getText();

                Email email = new Email(subject, message);

                boolean spam = SpamDetector.isSpam(
                        email.getSubject() + " " + email.getMessage());

                int spamScore = spam ? 90 : 10;

                if (spam) {
                    resultLabel.setText("Result : SPAM EMAIL");
                } else {
                    resultLabel.setText("Result : SAFE EMAIL");
                }

                scoreLabel.setText("Spam Score : " + spamScore + "%");
                progressBar.setValue(spamScore);


                ReportManager.saveReport(subject, message, spam, spamScore);
                HistoryManager.saveHistory(subject, message, spam);

                JOptionPane.showMessageDialog(null,
                        "Report Saved Successfully!");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                subjectField.setText("");
                messageArea.setText("");
                resultLabel.setText("Result : ");
                scoreLabel.setText("Spam Score : ");
                progressBar.setValue(0);
            }
        });

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HistoryManager.showHistory();
            }
        });

chartButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        ChartManager.showChart();
    }
});
        
        exitButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
});
        setVisible(true);
    }
}