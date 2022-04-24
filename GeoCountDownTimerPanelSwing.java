package project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Write a description  here.
 */
public class GeoCountDownTimerPanelSwing extends JPanel {

    private GeoCountDownTimer watch;
    private GeoCountDownTimer game;
    private Timer javaTimer;
    private JFrame GUI1024;

    private JButton startButton, stopButton, suspendButton;
    private JTextField yearsField, monthsField, daysField, newStringField, newDateField, addDaysField, daysToGoField, subtractDaysField, newField, daysInFutureField;
    private JButton addButton, subtractButton, loadButton, saveButton, daysInFutureButton, daysToGoButton, newButton, newDateButton, stringInputButton, continueButton;

    private JLabel lblTime;

    public GeoCountDownTimerPanelSwing() {

        // create the game object as well as the GUI1024 Frame

        watch = new GeoCountDownTimer();
        javaTimer = new Timer(1000, new TimerListener());

        setLayout(new GridLayout(15, 2));
        setBackground(Color.lightGray);

        yearsField = new JTextField("2022", 3);
        add(yearsField);

        add(new JLabel("Years:"));

        monthsField = new JTextField("1", 3);
        add(monthsField);
        add(new JLabel("Months:"));

        daysField = new JTextField("1", 3);

        add(daysField);
        add(new JLabel("Days:"));

        stopButton = new JButton("Stop");
        add(stopButton);

        startButton = new JButton("Start");
        add(startButton);

        loadButton = new JButton("Load");
        add(loadButton);

        saveButton = new JButton("Save");
        add(saveButton);

        daysToGoButton = new JButton("Days To Go");
        add(daysToGoButton);

        daysInFutureButton = new JButton("Days in Future");
        add(daysInFutureButton);

        addButton = new JButton("Add");
        add(addButton);

        addDaysField = new JTextField("0");
        add(addDaysField);

        subtractButton = new JButton("Subtract");
        add(subtractButton);

        subtractDaysField = new JTextField("0");
        add(subtractDaysField);

        newButton = new JButton("New");
        add(newButton);

        newField = new JTextField("1/1/2022");
        add(newField);


        continueButton = new JButton("Continue");
        add(continueButton);

        add(new JLabel(" "));

        lblTime = new JLabel();
        lblTime.setText(watch.toString());
        add(lblTime);

        add(new JLabel("   Date "));
        add(new JLabel("   Days to go: "));
        add(new JLabel("   Days in future: "));
        daysToGoField = new JTextField("");
        add(daysToGoField);
        daysInFutureField = new JTextField("");
        add(daysInFutureField);


        stopButton.addActionListener(new ButtonListener());
        startButton.addActionListener(new ButtonListener());
        addButton.addActionListener(new ButtonListener());
        continueButton.addActionListener(new ButtonListener());
        loadButton.addActionListener(new ButtonListener());
        daysInFutureButton.addActionListener(new ButtonListener());
        saveButton.addActionListener(new ButtonListener());
        daysToGoButton.addActionListener(new ButtonListener());
        newButton.addActionListener(new ButtonListener());
        subtractButton.addActionListener(new ButtonListener());


    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            int mins, sec, milli, p;

            if (event.getSource() == stopButton) {
                try {
                    mins = Integer.parseInt(yearsField.getText());
                    sec = Integer.parseInt(monthsField.getText());
                    milli = Integer.parseInt(daysField.getText());
                    watch = new GeoCountDownTimer(mins, sec, milli);
                    javaTimer.stop();
                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            if (event.getSource() == startButton) {
                try {
                    mins = Integer.parseInt(yearsField.getText());
                    sec = Integer.parseInt(monthsField.getText());
                    milli = Integer.parseInt(daysField.getText());
                    watch = new GeoCountDownTimer(mins, sec, milli);
                    javaTimer.start();
                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }


            if (event.getSource() == daysToGoButton) {
                String s = String.valueOf(watch.daysToGo(newField.getText()));
                daysToGoField.setText(s);
            }

            if (event.getSource() == daysInFutureButton) {
                int n;


            }

            if (event.getSource() == startButton) javaTimer.start();

            if (event.getSource() == subtractButton) watch.dec(Integer.parseInt(subtractDaysField.getText()));

            if (event.getSource() == addButton) watch.inc(Integer.parseInt(addDaysField.getText()));


            if (event.getSource() == stopButton) javaTimer.stop();

            if (event.getSource() == loadButton) watch.load("file1");

            if (event.getSource() == stringInputButton) watch = new GeoCountDownTimer(newStringField.getText());

            if (event.getSource() == continueButton) javaTimer.start();


            lblTime.setText(watch.toString());
        }

    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                watch.dec(1);
                lblTime.setText(watch.toString());
            } catch (Exception exception) {

            }
        }
    }
}