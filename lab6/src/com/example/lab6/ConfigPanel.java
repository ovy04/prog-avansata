package com.example.lab6;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame)  {
        this.frame=frame;
        init();
    }
    private void init() {
        sidesLabel = new JLabel("Number of sides: ");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);
        String[] culori = {"Random", "Black"};
        colorCombo = new JComboBox(culori);
        add(sidesLabel);
        add(sidesField);
        add(new JLabel("Colours: "));
        add(colorCombo);
    }

    public int getSides() {
        return (int) sidesField.getValue();
    }
}
