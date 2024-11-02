package Latihan;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator {
    double xd;
    double num1, num2, check;
    private JFrame frame;
    private JLabel lblNewLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Kalkulator window = new Kalkulator();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Kalkulator() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 451, 376);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setBounds(49, 38, 335, 38);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        // Display label on top of the background
        lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel.setBounds(10, 12, 315, 15);
        panel.add(lblNewLabel);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel.setBackground(Color.WHITE); // Set the background color to white
        lblNewLabel.setOpaque(true); // Make the background color visible
        lblNewLabel.setBounds(10, 12, 315, 15);
        panel.add(lblNewLabel);
        
        addNumberButtons();
        addOperationButtons();
    }


    private void addNumberButtons() {
        int xPos = 49, yPos = 87;
        String[] numbers = {"7", "8", "9", "4", "5", "6", "1", "2", "3", ".", "0", "C"};
        
        for (int i = 0; i < numbers.length; i++) {
            JButton button = new JButton(numbers[i]);
            button.setBounds(xPos, yPos, 48, 48);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    handleNumberButton(e);
                }
            });
            frame.getContentPane().add(button);
            
            xPos += 58;
            if ((i + 1) % 3 == 0) {
                xPos = 49;
                yPos += 59;
            }
        }
    }

    private void addOperationButtons() {
        String[] operations = {"+", "-", "*", "/", "=", "%", "B", "E"};
        int[] xPositions = {278, 336, 278, 336, 278, 336, 278, 336};
        int[] yPositions = {87, 87, 146, 146, 205, 205, 261, 261};

        for (int i = 0; i < operations.length; i++) {
            JButton button = new JButton(operations[i]);
            button.setBounds(xPositions[i], yPositions[i], 48, 48);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    handleOperationButton(e);
                }
            });
            frame.getContentPane().add(button);
        }
    }

    private void handleNumberButton(ActionEvent e) {
        String command = ((JButton) e.getSource()).getText();
        String currentText = lblNewLabel.getText();

        if (command.equals("C")) {
            num1 = num2 = check = xd = 0;
            lblNewLabel.setText("");
        } else if (command.equals(".")) {
            lblNewLabel.setText(currentText + ".");
        } else {
            lblNewLabel.setText(currentText + command);
        }
    }

    private void handleOperationButton(ActionEvent e) {
        String command = ((JButton) e.getSource()).getText();

        try {
            if (command.equals("=")) {
                num2 = Double.parseDouble(lblNewLabel.getText());
                calculateResult();
            } else if (command.equals("B")) {
                String text = lblNewLabel.getText();
                lblNewLabel.setText(text.length() > 0 ? text.substring(0, text.length() - 1) : "");
            } else {
                num1 = Double.parseDouble(lblNewLabel.getText());
                lblNewLabel.setText("");
                check = switch (command) {
                    case "+" -> 1;
                    case "-" -> 2;
                    case "*" -> 3;
                    case "/" -> 4;
                    case "%" -> 5;
                    default -> check;
                };
            }
        } catch (NumberFormatException ex) {
            lblNewLabel.setText("Invalid Format");
        }
    }

    private void calculateResult() {
        switch ((int) check) {
            case 1 -> xd = num1 + num2;
            case 2 -> xd = num1 - num2;
            case 3 -> xd = num1 * num2;
            case 4 -> xd = num1 / num2;
            case 5 -> xd = num1 % num2;
            default -> lblNewLabel.setText("Error");
        }
        lblNewLabel.setText(String.valueOf(xd));
    }
}