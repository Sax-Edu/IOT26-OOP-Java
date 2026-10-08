package Lektion5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyLogBook extends JFrame {
    private JTextField inputField;
    private JTextArea logArea;
    private JButton addButton;

    public MyLogBook() {
        setTitle("Min loggbok");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        inputField = new JTextField(15);
        addButton = new JButton("Lägg till");

        bottomPanel.add(inputField);
        bottomPanel.add(addButton);
        add(bottomPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addLogEntry());

        inputField.addActionListener(e -> addLogEntry());
    }

    private void addLogEntry() {
        String text = inputField.getText().trim();

        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Skriv in en text innan du klickar", "Varning", JOptionPane.WARNING_MESSAGE);
            inputField.setText("");
            inputField.requestFocus();
            return;
        }
        logArea.append(text +"\n");

        inputField.setText("");
        inputField.requestFocus();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyLogBook().setVisible(true));
    }

}

