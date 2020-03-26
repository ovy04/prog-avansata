package com.example.lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveButton = new JButton("Save");
    JButton loadButton = new JButton("Load");
    JButton resetButton = new JButton("Reset");
    JButton exitButton = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame=frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        add(saveButton);
        add(loadButton);
        add(resetButton);
        add(exitButton);
        saveButton.addActionListener(this::save);
        loadButton.addActionListener(this::load);
        resetButton.addActionListener(this::reset);
        exitButton.addActionListener(this::exit);
    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/Java/test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    private void load(ActionEvent e) {
        try {
            frame.canvas.image = ImageIO.read(new File("d:/Java/test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    private void reset (ActionEvent e) {
        frame.canvas.sterge();
    }
    private void exit (ActionEvent e) {
        frame.dispose();
    }
}
