package com.mazurek.gui;

import com.mazurek.controller.ButtonActionController;
import com.mazurek.generated.Flota;
import com.mazurek.service.FleetService;
import com.mazurek.utils.FleetReportValidator;
import com.mazurek.service.impl.FleetServiceImpl;
import com.mazurek.utils.FleetMapper;
import com.mazurek.utils.FleetProperties;
import com.mazurek.service.impl.XmlFleetReportGeneratorImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JButton button1;
    private JPanel mainPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

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
                buttonActionController.generateXmlButton(positionCount, carCount, driverCount);
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
