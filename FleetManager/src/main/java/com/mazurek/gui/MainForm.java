package com.mazurek.gui;

import com.mazurek.controller.ButtonActionController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainForm {
    private JButton button1;
    private JPanel mainPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button2;
    private JCheckBox checkBox1;
    private JFileChooser fileChooser;

    private ButtonActionController buttonActionController = new ButtonActionController();

    public MainForm() {
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Integer positionCount = null;
                Integer carCount = null;
                Integer driverCount= null;

                //read document parameters
                try {
                     positionCount = Integer.parseInt(textField1.getText());
                     carCount = Integer.parseInt(textField2.getText());
                     driverCount = Integer.parseInt(textField3.getText());
                } catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Input values are not correct");
                    return;
                }
                buttonActionController.handleGenerateXmlButton(positionCount, carCount, driverCount);
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(mainPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    boolean isValidationEnabled = checkBox1.isEnabled();

                    buttonActionController.handleLoadXMLButton(selectedFile, isValidationEnabled);
                }
            }
        });


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FleetManager");
        frame.setContentPane(new MainForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
