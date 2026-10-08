package Lektion5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MySwingApp extends JFrame {

    public MySwingApp() {
        setTitle("En liten test-app");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        /*JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panel.setBackground(Color.GREEN);*/

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBackground(Color.GREEN);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.setBackground(Color.BLACK);
        //bottomPanel.setPreferredSize(new Dimension(400,100));

        JLabel label = new JLabel("Antal:"); //Etikett (Text på skärmen)
        label.setForeground(Color.WHITE);

        //Textfält (Inmatning från användaren)
        JTextField inputField = new JTextField(5); // Plats för ca 5 tecken
        inputField.setText("1");

        JTextField displayField = new JTextField(15); //Låst textfält (Visar bara valt objekt)
        displayField.setEditable(false);

        JButton myButton = new JButton("Klicka här"); // 4. Knapp

        myButton.addActionListener(event -> {
            System.out.println("knappen klickades");
            try {
                int quantity = Integer.parseInt(inputField.getText().trim());
                if (quantity <= 0) {
                    JOptionPane.showMessageDialog(this, "Antal måste vara större än 0!", "Varning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                displayField.setText("Du skrev " + quantity);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Skriv ett giltigt tal i antal!", "Fel", JOptionPane.ERROR_MESSAGE);
            }
        });

        JTextArea receiptArea = new JTextArea();
        receiptArea.setEditable(false);

        //kvitto-layout: Alla tecken tar lika mycket plats!
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(receiptArea); // Lägg i ScrollPane - kan rulla om kvittot blir långt
        scrollPane.setPreferredSize(new Dimension(300, 0));

        String produkt = "Kaffe";
        int antal = 2;
        double pris = 45.50;
        double total = antal * pris;

        String produkt2 = "Flaggstång";
        int antal2 = 3;
        double pris2 = 149.0;
        double total2 = antal2 * pris2;

        String rad = String.format("%-14s %2d * %7.2f = %7.2f", produkt, antal, pris, total);
        String rad2 = String.format("%-14s %2d * %7.2f = %7.2f", produkt2, antal2, pris2, total2);
        // %-20s  = Vänsterjusterad sträng (20 tecken bredd)
        // %2d    = Heltal (2 tecken bredd)
        // %7.2f  = Decimaltal (7 tecken bredd, 2 decimaler)

        receiptArea.append(rad + "\n");
        receiptArea.append(rad2 +"\n");


        bottomPanel.add(label);
        bottomPanel.add(inputField);
        bottomPanel.add(displayField);
        bottomPanel.add(myButton);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        add(scrollPane, BorderLayout.EAST);


    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MySwingApp().setVisible(true);
        });

    }
}
