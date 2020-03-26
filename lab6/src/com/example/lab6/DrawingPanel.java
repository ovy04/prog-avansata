package com.example.lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W=800, H=600;
    BufferedImage image;
    Graphics2D graphics;
    public DrawingPanel(MainFrame frame) {
        this.frame=frame;
        createOffScreenImage();
        init();
    }
    private void createOffScreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,W,H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }
    private void drawShape(int x, int y) {
        Random rand = new Random();
        Random rand_float = new Random();
        int radius = rand.nextInt(100);
        int sides = frame.configPanel.getSides();
        Color color = new Color(rand_float.nextFloat(), rand_float.nextFloat(), rand_float.nextFloat(), 0);
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x,y,radius,sides));
    }
    public void sterge() {
        createOffScreenImage();
    }

    @Override
    public void update(Graphics g) {}

    @Override
    public void paintComponent (Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
